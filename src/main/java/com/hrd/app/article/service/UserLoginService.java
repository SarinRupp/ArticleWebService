package com.hrd.app.article.service;

import com.hrd.app.article.entities.User;

public interface UserLoginService {

	public User userLogin(String username, String password);
	
}
