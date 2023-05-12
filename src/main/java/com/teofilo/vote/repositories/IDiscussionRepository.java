package com.teofilo.vote.repositories;

import com.teofilo.vote.entities.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDiscussionRepository extends JpaRepository <Discussion, Long> {
}
