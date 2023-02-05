package s3.feed.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import s3.feed.entity.PostEntity;


import java.util.List;

public class UserDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ResMypage {
        public String accountName;
        public String accountId;
        public String profileImage;
        public int followingCount;
        public int followCount;
        public int postCount;
        public List<UserDto.ReqMypagePostDto> mypagePostDtos;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class
    ReqMypagePostDto {
        public String storedUrl;
        public Long postId;
        public boolean isMultyImage;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResPostListDto {
        public String name;
        public List<PostEntity> postList;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqProfileUpdate {
        public String accountId;
        public String accountName;
    }

}


/* @Data
    @Node
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqFollowUserDto {
        @Id
        @GeneratedValue
        public Long id;
        public String accountId;
        public String profileImage;
        public List<UserDto.ReqFollowStoryDto> StoryDtoList;
        public List<UserDto.ReqPostDto> PostDtoList;

        public ReqFollowUserDto(String accountId, String profileImage, List<ReqFollowStoryDto> storyDtoList, List<ReqPostDto> postDtoList) {
            this.accountId = accountId;
            this.profileImage = profileImage;
            StoryDtoList = storyDtoList;
            PostDtoList = postDtoList;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqPostDto {
        public String accountId;
        public String content;
        public String profileImage;
        public List<MediaEntity> mediaEntityList;
        public LocalDateTime createdDt;
        public LocalDateTime modifiedDt;
        public int likeCount;
        public int commnetCount;

    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReqFollowStoryDto {
    public String accountId;
    public String profileImage;
    }
*/