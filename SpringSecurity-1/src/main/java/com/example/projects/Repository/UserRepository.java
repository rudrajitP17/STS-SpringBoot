package com.example.projects.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projects.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> 
{

	User findByEmail(String email);

}
