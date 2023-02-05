package s3.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
//@Setter
@Node
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private String accountId;
    private String profileImage;
    private LocalDateTime createdDt;

    private LocalDateTime modifiedDt;

    private int likeCount;
    private int commentCount;
    private boolean isMultyImage;

    private boolean isLikesCheck;

    @Relationship(type = "post-media")
    private List<MediaEntity> mediaEntityList = new ArrayList<>();

    @Relationship(type = "post-comment")
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @JsonBackReference
    private UserEntity userEntity;

    public void addPost(List<MediaEntity>mediaEntityList,String accountId,String profileImage ,LocalDateTime createdDt,LocalDateTime modifiedDt, int likeCount, int commentCount, boolean isMultyImage ){
        this.mediaEntityList=mediaEntityList;
        this.accountId=accountId;
        this.profileImage=profileImage;
        this.createdDt = createdDt;
        this.modifiedDt = modifiedDt;
        this.likeCount = likeCount;
        this.commentCount=commentCount;
        this.isMultyImage = isMultyImage;
    }

    public PostEntity(String content) {
        this.content = content;
    }

    public void updatePost(String content, LocalDateTime modifiedDt){
        this.content = content;
        this.modifiedDt=modifiedDt;
    }
    public void upCommentCount(int commentCount){
        this.commentCount= commentCount++;
    }
}


