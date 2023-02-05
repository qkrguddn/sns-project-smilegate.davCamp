package s3.feed.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import s3.feed.entity.UserEntity;

import java.util.List;

public interface UserRepository extends Neo4jRepository<UserEntity, Long> {
    UserEntity findByAccountId(String accountId);
    UserEntity findByAccountName(String accountName);
    List<UserEntity> findByAccountIdContaining(String accountId);
}

