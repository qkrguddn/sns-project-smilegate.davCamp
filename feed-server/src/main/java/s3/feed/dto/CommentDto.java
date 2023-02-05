package s3.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommentDto {


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqCommentDto {
        public String comment;

    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqReplyDto {
        public String reply;

    }
}
