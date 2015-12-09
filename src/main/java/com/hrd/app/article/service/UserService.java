package com.hrd.app.article.service;

import java.util.ArrayList;

import com.hrd.app.article.entities.User;

public interface UserService {

	public ArrayList<User> getUser(int offset, int limit);
	public User detail(int id);
	public boolean insert(User user);
	public boolean update(User user);
	public boolean delete(int id);
	public boolean enable(int id);
	public ArrayList<User> search(String username, int offset, int limit);
	public int totalRecord();
	public int totalSearchRecord(String username);
	public String isExistUser(String username);
	public String getUserPhoto(int id);
	
}
