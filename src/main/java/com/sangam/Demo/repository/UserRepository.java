package com.sangam.Demo.repository;

import com.sangam.Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository provides built-in methods like save, findById, findAll, etc.
	User findByEmail(String email); 
	User findByResetToken(String resetToken);
}
