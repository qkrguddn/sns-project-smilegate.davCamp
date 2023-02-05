package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.StoryEntity;

public interface StoryRepository extends Neo4jRepository<StoryEntity, Long> {
}
