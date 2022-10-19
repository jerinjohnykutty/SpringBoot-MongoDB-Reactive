package online.perfomatix.reactiveMongo.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import online.perfomatix.reactiveMongo.dao.User;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User,UUID>{}
