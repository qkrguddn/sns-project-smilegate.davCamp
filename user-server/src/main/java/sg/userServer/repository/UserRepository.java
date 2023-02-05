package sg.userServer.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import sg.userServer.domain.UserEntity;

import java.util.List;


public interface UserRepository extends Neo4jRepository<UserEntity,Long> {
//    List<UserEntity> findByUserFeild1(String userFeild1);
}
