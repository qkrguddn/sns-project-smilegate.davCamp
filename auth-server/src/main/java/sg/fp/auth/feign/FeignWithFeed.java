package sg.fp.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user-server")
public interface FeignWithFeed {
    @RequestMapping(method= RequestMethod.POST, value="/user")
    public void createUser(@RequestParam("accountName") String accountName, @RequestParam("accountId")String accountId);
}

