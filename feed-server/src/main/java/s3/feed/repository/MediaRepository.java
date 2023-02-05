package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.MediaEntity;

public interface MediaRepository extends Neo4jRepository<MediaEntity, Long> {
}
