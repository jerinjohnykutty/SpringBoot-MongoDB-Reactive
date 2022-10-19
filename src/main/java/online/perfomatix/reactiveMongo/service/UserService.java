package online.perfomatix.reactiveMongo.service;

import java.security.PublicKey;
import java.util.UUID;

import online.perfomatix.reactiveMongo.dao.User;
import online.perfomatix.reactiveMongo.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    
    public Flux<User> getAllUsers();
    public Mono<User> addUser(UserDTO user);
    public Mono deleteUserById(UUID id);
}
