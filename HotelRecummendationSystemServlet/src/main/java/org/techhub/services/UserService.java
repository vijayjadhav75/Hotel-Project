package org.techhub.services;

import org.techhub.model.LoginModel;
import org.techhub.model.RegisterModel;
import org.techhub.repository.UserRepository;

public class UserService {
	UserRepository userRepo =new UserRepository();
	public boolean isRegisterUser(RegisterModel model) {
		return userRepo.isRegisterUser(model);
	}
	public int validateUser(LoginModel model) {
		return userRepo.validateUser(model);
	}
	public RegisterModel getUserProfile(int userId) {
		return userRepo.getUserProfile(userId);
	}
}