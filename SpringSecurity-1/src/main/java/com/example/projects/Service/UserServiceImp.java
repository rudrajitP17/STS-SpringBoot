package com.example.projects.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.projects.Entity.PasswordResestToken;
import com.example.projects.Entity.User;
import com.example.projects.Entity.VerificationToken;
import com.example.projects.Model.UserModel;
import com.example.projects.Repository.PasswordResetTokenRepository;
import com.example.projects.Repository.UserRepository;
import com.example.projects.Repository.VerificationTokenRepository;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository verificationTokenRepository;

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User registerUser(UserModel userModel) {
		User user = new User();
		user.setEmail(userModel.getEmail());
		user.setFirstName(userModel.getFirstName());
		user.setLastName(userModel.getLastName());
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(userModel.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public void saveVerificationTokenForUser(String token, User user) {
		VerificationToken verificationToken = new VerificationToken(user, token);
		verificationTokenRepository.save(verificationToken);
	}

	@Autowired
	VerificationTokenRepository vtr;

	@Override
	public String validateVerificationToken(String token) {
		VerificationToken verificationToken = vtr.findByToken(token);

		if (verificationToken == null)
			return "invalid";

		User user = verificationToken.getUser();
		Calendar cal = Calendar.getInstance();

		if ((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
			verificationTokenRepository.delete(verificationToken);
			return "expired";
		}
		user.setEnabled(true);
		userRepository.save(user);
		return "valid";
	}

	@Override
	public VerificationToken generateNewVerificationToken(String oldToken) {
		VerificationToken verificationToken = vtr.findByToken(oldToken);
		verificationToken.setToken(UUID.randomUUID().toString());
		vtr.save(verificationToken);
		return verificationToken;
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void createPasswordResestTokenForUser(User user, String token) {
		PasswordResestToken passwordResestToken = new PasswordResestToken(user, token);
		passwordResetTokenRepository.save(passwordResestToken);
	}

	@Override
	public String validatePasswordResestToken(String token) {
		PasswordResestToken passwordResestToken = passwordResetTokenRepository.findByToken(token);

		if (passwordResestToken == null)
			return "invalid";

		Calendar cal = Calendar.getInstance();

		if ((passwordResestToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0) {
			passwordResetTokenRepository.delete(passwordResestToken);
			return "expired";
		}
		return "valid";
	}

	@Override
	public Optional<User> getUserPasswordResetToken(String token) 
	{
		return Optional.ofNullable(passwordResetTokenRepository.findByToken(token).getUser());
	}

	@Override
	public void changePassword(User user, String newPassword)
	{
		user.setPassword(passwordEncoder.encode(newPassword));
		userRepository.save(user);
	}

	@Override
	public boolean checkIfValidOldPassword(User user, String oldPassword)
	{
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}
}
