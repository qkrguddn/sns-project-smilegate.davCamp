package s3.feed.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.CommentEntity;


public interface CommentRepository extends Neo4jRepository<CommentEntity, Long> {
    CommentEntity findByAccountId(String accountId);
}
