package com.example.projects.Service;

import java.util.Optional;

import com.example.projects.Entity.User;
import com.example.projects.Entity.VerificationToken;
import com.example.projects.Model.UserModel;

public interface UserService {

	User registerUser(UserModel userModel);

	void saveVerificationTokenForUser(String token, User user);

	String validateVerificationToken(String token);

	VerificationToken generateNewVerificationToken(String oldToken);

	User findUserByEmail(String email);

	void createPasswordResestTokenForUser(User user, String token);

	String validatePasswordResestToken(String token);

	Optional<User> getUserPasswordResetToken(String token);

	void changePassword(User user, String newPassword);

	boolean checkIfValidOldPassword(User user, String oldPassword);

}
