package com.equeue.controller;

import com.equeue.dto.UserDTO;
import com.equeue.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@Api(value = "User Controller")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "Registers new user")
    @ResponseStatus(ACCEPTED)
    @PostMapping("/register")
    public void register(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }

}
