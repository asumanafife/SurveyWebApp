package com.aydinsurveyapp.survey.controller;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aydinsurveyapp.survey.dto.UserDTO;
import com.aydinsurveyapp.survey.dto.UserEditDTO;
import com.aydinsurveyapp.survey.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId) {
        UserDTO userDTO = userService.getById(userId);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> userDTOs = userService.findAll();
        return new ResponseEntity<>(userDTOs, HttpStatusCode.valueOf(200));
    }


    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserEditDTO userEditDTO) {
        UserDTO userDTO = userService.create(userEditDTO);
        return new ResponseEntity<>(userDTO, HttpStatusCode.valueOf(201));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserEditDTO userEditDTO, @PathVariable Integer userId) {
        UserDTO userDTO = userService.update(userEditDTO, userId);
        return new ResponseEntity<>(userDTO, HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Boolean>  deleteUser(@PathVariable Integer userId) {
        userService.delete(userId);
        return new ResponseEntity<>(true, HttpStatusCode.valueOf(200));
    }
}
