package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.PostEntity;

public interface PostRepository extends Neo4jRepository<PostEntity, Long> {
}
