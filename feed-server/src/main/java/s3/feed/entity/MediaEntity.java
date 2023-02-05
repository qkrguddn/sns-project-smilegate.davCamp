package s3.feed.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Getter
@Node
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MediaEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String image;

    public MediaEntity(String image) {
        this.image = image;

    }
}
