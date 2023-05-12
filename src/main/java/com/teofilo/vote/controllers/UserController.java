package com.teofilo.vote.controllers;

import com.teofilo.vote.dto.UserDto;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.services.IUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @ApiOperation(value = "Returns a user by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @GetMapping(path = "/{id}")
    public UserDto findById (@PathVariable Long id){
        try{
            return userService.findById(id);
        }catch (DataNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Returns a list of user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of user")
    })

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @ApiOperation(value = "Create a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User created successfully")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto insert (@RequestBody @Valid UserDto userDto){
        return userService.insert(userDto);
    }

    @ApiOperation(value = "Update a existent user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User updated successfully")
    })

    @PutMapping(path = "/{id}")
    public UserDto update (@RequestBody @Valid UserDto userDto, @PathVariable Long id){
        try {
            return userService.update(id, userDto);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        }
    }
}
