package com.teofilo.vote.repositories;

import com.teofilo.vote.entities.VoteSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IVoteSessionRepository extends JpaRepository<VoteSession, Long> {
    List<VoteSession> findByDiscussionId(Long id);
}
