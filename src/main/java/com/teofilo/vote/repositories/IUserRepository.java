package com.teofilo.vote.repositories;

import com.teofilo.vote.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Long> {
}
