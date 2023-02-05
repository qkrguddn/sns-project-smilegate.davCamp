package s3.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Node
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    private String accountId;

    private LocalDateTime createdDt;

    private int likeCount;

    private String profileImage;
    @Relationship(type = "comment-reply")
    private List<ReplyEntity> replyEntityList = new ArrayList<>();

    @JsonBackReference
    private UserEntity userEntity;
    @JsonBackReference
    private PostEntity postEntity;

    public CommentEntity(String comment, String accountId, LocalDateTime createdDt, int likeCount, String profileImage){
        this.comment =comment;
        this.accountId =accountId;
        this.createdDt =createdDt;
        this.likeCount =likeCount;
        this.profileImage =profileImage;
}

}
