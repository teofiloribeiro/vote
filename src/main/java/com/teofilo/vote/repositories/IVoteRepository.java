package com.teofilo.vote.repositories;

import com.teofilo.vote.entities.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVoteRepository extends JpaRepository<Vote, Long> {
    Vote findFirstByUserIdAndVoteSessionId(Long userId, Long voteSessionId);
}
