package com.teofilo.vote.services;

import com.teofilo.vote.dto.VoteDto;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.exceptions.InvalidVoteException;

public interface IVoteService {
    VoteDto vote (VoteDto voteDto) throws DataNotFoundException, InvalidVoteException;
}
