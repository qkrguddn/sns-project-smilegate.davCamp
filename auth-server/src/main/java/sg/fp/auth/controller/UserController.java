package sg.fp.auth.controller;

import org.springframework.web.bind.annotation.*;
import sg.fp.auth.dto.ResponseDTO;
import sg.fp.auth.dto.UserDto;
import sg.fp.auth.entity.UserEntity;
import sg.fp.auth.feign.FeignWithFeed;
import sg.fp.auth.security.TokenProvider;
import sg.fp.auth.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private FeignWithFeed feignWithFeed;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @GetMapping("")
    public String authServer() {
        return  "auth server ok";
    }

    @PostMapping("/mypage/{accountId}")
    public void updateMyPage(@PathVariable("accountId")String id, @RequestParam String accountName, @RequestParam String accountId){
        System.out.println("controlloer: "+id+" "+accountName+" "+accountId);
        userService.updateMypage(id, accountName, accountId);

    }
    //1. 회원가입
    @PostMapping("/signup")
    public ResponseEntity<?> resgisterUser(@RequestBody UserDto userDTO){
        try{//validation
            if(userDTO==null || userDTO.getAccountPw()==null){
                throw new RuntimeException("Invalid Password value.");
            }
            feignWithFeed.createUser(userDTO.getAccountName(), userDTO.getAccountId());
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .accountId(userDTO.getAccountId())
                    .accountPw(passwordEncoder.encode(userDTO.getAccountPw()))
                    .accountName(userDTO.getAccountName())
                    .build();

            UserEntity registerdUser = userService.create(user);

            UserDto responseUserDTO = UserDto.builder()
                    .id(registerdUser.uuidToString(registerdUser.getId()))
                    .accountId(registerdUser.getAccountId())
                    .accountName(registerdUser.getAccountName())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        }catch(Exception e){
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    //2. 로그인
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDTO){
        UserEntity user = userService.getByCredentials(userDTO.getAccountId(), userDTO.getAccountPw(), passwordEncoder);

        if(user!=null){
            final String token = tokenProvider.create(user);
            final UserDto responseUserDTO = UserDto.builder()
                    .accountId(user.getAccountId())
                    .id(user.uuidToString(user.getId()))
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } else{
            ResponseDTO responseDTO = ResponseDTO.builder().error("Login failed.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

}
