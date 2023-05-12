package com.teofilo.vote.services;

import com.teofilo.vote.dto.VoteSessionDetailDto;
import com.teofilo.vote.dto.VoteSessionDto;
import com.teofilo.vote.exceptions.DataNotFoundException;

public interface IVoteSessionService {
    VoteSessionDto insert(VoteSessionDto voteSessionDto) throws IllegalArgumentException;
    boolean isSessionOpen (Long sessionId) throws DataNotFoundException;
    VoteSessionDetailDto getSessionDetail (Long sessionId) throws DataNotFoundException;
}
