package com.teofilo.vote.controllers;

import com.teofilo.vote.dto.*;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.exceptions.InvalidVoteException;
import com.teofilo.vote.services.IVoteService;
import com.teofilo.vote.services.IVoteSessionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/session")
public class VoteSessionController {
    @Autowired
    private IVoteSessionService voteSessionService;
    @Autowired
    private IVoteService voteService;

    @ApiOperation(value = "Create a new vote session")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Vote Session created successfully")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VoteSessionDto insert (@RequestBody @Valid VoteSessionDto voteSessionDto){
        return voteSessionService.insert(voteSessionDto);
    }

    @ApiOperation(value = "Insert a new vote")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Vote inserted successfully")
    })
    @PostMapping(value = "/vote")
    @ResponseStatus(HttpStatus.CREATED)
    public VoteDto vote (@RequestBody @Valid VoteDto voteDto){
        try {
            return voteService.vote(voteDto);
        } catch (DataNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        } catch (InvalidVoteException e) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN,e.getMessage(), e);
        }
    }

    @ApiOperation(value = "Returns session datails by its id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a vote session detail"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @GetMapping(path = "/{id}")
    public VoteSessionDetailDto findById (@PathVariable Long id){
        try{
            return voteSessionService.getSessionDetail(id);
        }catch (DataNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage(), e);
        }
    }
}
