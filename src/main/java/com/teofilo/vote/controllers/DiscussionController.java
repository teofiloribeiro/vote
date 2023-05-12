package com.teofilo.vote.controllers;

import com.teofilo.vote.dto.DiscussionDto;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.services.IDiscussionService;
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
@RequestMapping(value = "/discussion")
public class DiscussionController {
    @Autowired
    private IDiscussionService discussionService;
    @ApiOperation(value = "Returns a discussion by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a discussion"),
            @ApiResponse(code = 404, message = "Discussion not found")
    })
    @GetMapping(path = "/{id}")
    public DiscussionDto findById (@PathVariable Long id){
        try{
            return discussionService.findById(id);
        }catch (DataNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Returns a list of discussion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of discussion")
    })
    @GetMapping
    public List<DiscussionDto> findAll(){
        return discussionService.findAll();
    }

    @ApiOperation(value = "Create a new discussion")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Discussion created successfully")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiscussionDto insert (@RequestBody @Valid DiscussionDto discussionDto){
        return discussionService.insert(discussionDto);
    }

    @ApiOperation(value = "Update a existent discussion")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Discussion updated successfully")
    })
    @PutMapping(path = "/{id}")
    public DiscussionDto update (@RequestBody @Valid DiscussionDto discussionDto, @PathVariable Long id){
        try {
            return discussionService.update(id, discussionDto);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        }
    }
}
