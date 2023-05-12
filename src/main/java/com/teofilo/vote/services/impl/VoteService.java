package com.teofilo.vote.services.impl;

import com.teofilo.vote.dto.UserDto;
import com.teofilo.vote.dto.VoteDto;
import com.teofilo.vote.entities.User;
import com.teofilo.vote.entities.Vote;
import com.teofilo.vote.entities.VoteSession;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.exceptions.InvalidVoteException;
import com.teofilo.vote.repositories.IVoteRepository;
import com.teofilo.vote.services.IUserService;
import com.teofilo.vote.services.IVoteService;
import com.teofilo.vote.services.IVoteSessionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteService implements IVoteService {
    @Autowired
    private IVoteRepository voteRepository;
    @Autowired
    private IUserService userService;
    @Autowired 
    private IVoteSessionService voteSessionService;
    @Autowired
    private ModelMapper modelMapper;

    public Vote findVote (Long userId, Long sessionId){
        Vote vote = voteRepository.findFirstByUserIdAndVoteSessionId(userId, sessionId);
        return vote;
    }

    public VoteDto vote (VoteDto voteDto) throws DataNotFoundException, InvalidVoteException {
        if(!this.voteSessionService.isSessionOpen(voteDto.getSessionId()))
            throw new InvalidVoteException("The session is not active.");
        UserDto user = userService.findById(voteDto.getUserId());
        Vote vote = this.findVote(user.getId(), voteDto.getSessionId());
        if(vote != null)
            throw new InvalidVoteException("The user has already voted");
        Vote newVote = this.voteConverter(voteDto);
        this.voteRepository.save(newVote);
        return this.voteConverter(newVote);
    }

    private Vote voteConverter (VoteDto voteDto){
        User user = new User();
        VoteSession voteSession = new VoteSession();
        user.setId(voteDto.getUserId());
        voteSession.setId(voteDto.getSessionId());
        return new Vote(voteDto.isAnswer(), user, voteSession);
    }

    private VoteDto voteConverter (Vote vote){
        VoteDto voteDto = modelMapper.map(vote, VoteDto.class);
        voteDto.setAnswer(vote.getVote());
        return voteDto;
    }

}
