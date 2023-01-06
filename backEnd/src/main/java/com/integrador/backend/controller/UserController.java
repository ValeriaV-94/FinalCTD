package com.integrador.backend.controller;

import com.integrador.backend.exceptions.BadRequestException;
import com.integrador.backend.exceptions.ResourcesNotFoundException;
import com.integrador.backend.model.User;
import com.integrador.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Crear nuevo usuario.
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws BadRequestException {
        try {
            User saveUser = userService.saveUser(user);
            return ResponseEntity.ok(saveUser);
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    //Buscar todos los usuarios.
    @GetMapping("/all")
    public ResponseEntity<List<User>> searchAllUsers() {
        return ResponseEntity.ok(userService.searchAllUsers());
    }

    //Buscar usuario por id.
    @GetMapping("/search/{id}")
    public ResponseEntity<User> searchUserById(@PathVariable("id") Long id) throws ResourcesNotFoundException {
        Optional<User> searchUser = userService.searchUserById(id);
        if (searchUser.isPresent()) {
            return ResponseEntity.ok(searchUser.get());
        } else {
            throw new ResourcesNotFoundException("No se encontró el usuario con id =" + id);
        }
    }

    //Actualizar usuario
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        Optional<User> userToUpdate = userService.searchUserById(user.getId());
        if(userToUpdate.isPresent()){
            return ResponseEntity.ok(userService.updateUser(user));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Borrar usuario.
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id) throws ResourcesNotFoundException{
        Optional<User> userToDelete = userService.searchUserById(id);
        if (userToDelete.isPresent()){
            userService.deleteUser(id);
            return ResponseEntity.ok("Se eliminó el usuario con id = " + id);
        } else {
            throw new ResourcesNotFoundException("No se encontró el usuario con id = " + id);
        }
    }

}
