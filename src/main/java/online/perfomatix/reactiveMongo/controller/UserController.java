package online.perfomatix.reactiveMongo.controller;

import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.perfomatix.reactiveMongo.dao.User;
import online.perfomatix.reactiveMongo.dto.UserDTO;
import online.perfomatix.reactiveMongo.service.UserService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/all",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<List<User>> getAllCustomers(){
        return userService.getAllUsers().onErrorReturn(null).collectList();
    }

    @PostMapping(value = "/add")
    public Mono<User> addUser(@RequestBody UserDTO userDTO){

        System.out.println(userDTO);
        return userService.addUser(userDTO);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<String> userDeleteById(@PathVariable UUID id){
        userService.deleteUserById(id);
        return Mono.just("success");
    }
}
