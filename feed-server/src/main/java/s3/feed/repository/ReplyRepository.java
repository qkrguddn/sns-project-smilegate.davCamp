package s3.feed.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.ReplyEntity;

public interface ReplyRepository extends Neo4jRepository<ReplyEntity, Long> {
}
