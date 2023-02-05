package s3.feed.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.time.LocalDateTime;

@Getter
@Node
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyEntity {
    @Id
    @GeneratedValue
    private Long id;

    private  String reply;

    private String accountId;

    private LocalDateTime createdDt;

    private int likeCount;

    private String profileImage;

    @JsonBackReference
    private UserEntity userEntity;

    public ReplyEntity(String reply, String accountId, LocalDateTime createdDt, int likeCount, String profileImage) {
        this.reply = reply;
        this.accountId=accountId;
        this.createdDt = createdDt;
        this.likeCount = likeCount;
        this.profileImage=profileImage;
    }
}
