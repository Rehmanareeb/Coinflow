package com.coinflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coinflow.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
