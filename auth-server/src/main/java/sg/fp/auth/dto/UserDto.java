package sg.fp.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String token;
    private String id;
    private String email;
    private String accountId;
    private String accountPw;
    private String accountName;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqProfileUpdate {
        public String accountId;
        public String accountName;
    }
}
