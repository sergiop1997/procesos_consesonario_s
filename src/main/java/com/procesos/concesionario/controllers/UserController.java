package com.procesos.concesionario.controllers;

import com.procesos.concesionario.models.User;
import com.procesos.concesionario.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;
    @GetMapping(value = "/user/{id}")
    public ResponseEntity getById(@PathVariable(name = "id")Long id) {
        Map response = new HashMap<>();
        try{
            response.put("message", "Se encontro el usuario");
            response.put("data",userServiceImp.getUserById(id));
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            response.put("message", "No se encontro el usuario");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping(value = "/user")
    public ResponseEntity createUser(@RequestBody User user){
        Map response = new HashMap<>();
        try{
            response.put("message", "Se guardo el usuario");
            response.put("data",userServiceImp.createUser(user));
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e) {
            response.put("message", "No se guardo el usuario");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);

        }

    }
    @GetMapping(value = "/user/list")
    public ResponseEntity listar() {
        Map response = new HashMap<>();
        try{
            response.put("message", "Lista de usuarios");
            response.put("data",userServiceImp.allUser());
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }catch (Exception e){
            response.put("message", "Lista de usuarios");
            response.put("data", e.getMessage());
            return new ResponseEntity(response, HttpStatus.ACCEPTED);
        }

    }

}
