package online.perfomatix.reactiveMongo.service.impl;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import online.perfomatix.reactiveMongo.dao.User;
import online.perfomatix.reactiveMongo.dto.UserDTO;
import online.perfomatix.reactiveMongo.repository.UserRepository;
import online.perfomatix.reactiveMongo.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> addUser(UserDTO userDTO) {
        User user = new User();
        user.setAge(userDTO.getAge());
        user.setName(userDTO.getName());
        user.setId(UUID.randomUUID());

        return userRepository.save(user);
    }
    
    @Override
    public Mono deleteUserById(UUID id){
        return userRepository.deleteById(id);
    }
}
