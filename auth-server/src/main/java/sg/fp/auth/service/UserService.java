package sg.fp.auth.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sg.fp.auth.dto.UserDto;
import sg.fp.auth.entity.UserEntity;
import sg.fp.auth.repository.UserRepository;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //1. 회원가입
    public UserEntity create(final UserEntity userEntity){
        //validation
        if(userEntity==null || userEntity.getAccountId()==null){
            throw new RuntimeException("Invalid argument");
        }

        final String accountId = userEntity.getAccountId();
        if(userRepository.existsByaccountId(accountId)){
            log.warn("AccountId already exists {}", accountId);
            throw new RuntimeException("AccountId already exists");
        }

        return userRepository.save(userEntity);
    }

    //2. 로그인
    public UserEntity getByCredentials(final String accountId, final String accountPw, final PasswordEncoder encoder){
        final UserEntity originalUser = userRepository.findByaccountId(accountId);

        if(originalUser!=null && encoder.matches(accountPw, originalUser.getAccountPw())) return originalUser;

        return null;
    }
    @Transactional
    public void updateMypage(String accountId, String updateName, String updateId) {
        UserEntity userEntity = userRepository.findByaccountId(accountId);

        System.out.println("받은 정보: "+ updateId+"  "+ updateName);
        if(updateId!=null&&updateName!=null) {
            userEntity.updateAllUser(updateName,updateId);
        }
        else if(updateId!=null&&updateName==null) {
            userEntity.updateAccountId(updateId);
        }
        else if(updateId==null&&updateName!=null) {
            userEntity.updateName(updateName);
        }

    }
}
