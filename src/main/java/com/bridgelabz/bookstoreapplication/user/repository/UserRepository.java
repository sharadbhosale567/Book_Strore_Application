package com.bridgelabz.bookstoreapplication.user.repository;

import com.bridgelabz.bookstoreapplication.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findByEmailId(String emailId);
}
