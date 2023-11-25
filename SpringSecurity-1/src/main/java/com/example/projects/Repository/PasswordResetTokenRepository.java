package com.example.projects.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projects.Entity.PasswordResestToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResestToken, Long> 
{

	PasswordResestToken findByToken(String token);

}
