package br.com.ph23.usuarios.usuarios.controller;

import br.com.ph23.usuarios.usuarios.model.UserModel;
import br.com.ph23.usuarios.usuarios.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getAllUsers(){
        var users = userService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel model){
        var users = userService.create(model);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel model, @PathVariable Long id){
        var users = userService.update(id, model);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
