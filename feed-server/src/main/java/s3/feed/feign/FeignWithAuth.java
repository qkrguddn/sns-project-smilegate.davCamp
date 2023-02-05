package s3.feed.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import s3.feed.dto.UserDto;

//@Component
@FeignClient("auth-server")
public interface FeignWithAuth {
    @RequestMapping(method= RequestMethod.POST, value="/auth/mypage/{accountId}")
    public void updateUser(@PathVariable("accountId")String id,@RequestParam("accountName") String accountName, @RequestParam("accountId")String accountId);



}

