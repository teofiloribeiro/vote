package com.teofilo.vote.services.impl;

import com.teofilo.vote.dto.VoteSessionDetailDto;
import com.teofilo.vote.dto.VoteSessionDto;
import com.teofilo.vote.entities.Discussion;
import com.teofilo.vote.entities.VoteSession;
import com.teofilo.vote.exceptions.DataNotFoundException;
import com.teofilo.vote.repositories.IVoteSessionRepository;
import com.teofilo.vote.services.IVoteSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class VoteSessionService implements IVoteSessionService {
    @Autowired
    private IVoteSessionRepository voteSessionRepository;

    public VoteSessionDto insert(VoteSessionDto voteSessionDto) throws IllegalArgumentException {
        voteSessionDto.setId(null);
        if(voteSessionDto.getMinutesActive() == null) voteSessionDto.setMinutesActive(1);
        if(voteSessionDto.getMinutesActive() < 0) throw new IllegalArgumentException();

        Date sessionEndDate = addMinutesToDate(voteSessionDto.getMinutesActive(), new Date());

        Discussion discussion = new Discussion();
        discussion.setId(voteSessionDto.getDiscussionId());
        VoteSession voteSession = new VoteSession(discussion, new Date(), sessionEndDate);

        voteSessionRepository.save(voteSession);
        voteSessionDto.setId(voteSession.getId());
        return voteSessionDto;
    }

    public VoteSessionDetailDto getSessionDetail (Long sessionId) throws DataNotFoundException {
        VoteSession voteSession = this.voteSessionRepository.findById(sessionId).orElseThrow(()-> new DataNotFoundException("Session not found"));
        long totalVotes = voteSession.getVotes().size();
        long positiveVotes = voteSession.getVotes().stream().filter((vote) -> vote.getVote()).count();
        boolean isActive = voteSession.getEndDate().after(new Date());

        return new VoteSessionDetailDto(sessionId, isActive, positiveVotes, totalVotes - positiveVotes, totalVotes);
    }

    public boolean isSessionOpen (Long sessionId) throws DataNotFoundException {
        VoteSession voteSession = voteSessionRepository.findById(sessionId).orElseThrow(() -> new DataNotFoundException("Session not found"));
        return voteSession.getEndDate().after(new Date());
    }
    private Date addMinutesToDate(int minutes, Date date) {
        long timeInMs = date.getTime();
        Date newDate = new Date(timeInMs + (minutes * 60000));
        return newDate;
    }
}
