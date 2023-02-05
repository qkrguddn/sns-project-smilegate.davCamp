package sg.userServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sg.userServer.domain.UserEntity;
import sg.userServer.repository.UserRepository;
import sg.userServer.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @GetMapping("test")
    public String userServer() {
        return "user server ok";
    }

    @PostMapping("")
    public void createUser(@RequestParam String accountName ,@RequestParam String accountId) {
        UserEntity userEntity = new UserEntity(accountName, accountId);
        userService.saveUser(userEntity);
    
    }

}