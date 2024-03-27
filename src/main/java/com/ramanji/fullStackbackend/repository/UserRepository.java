package com.ramanji.fullStackbackend.repository;

import com.ramanji.fullStackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
