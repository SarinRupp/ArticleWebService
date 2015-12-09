package com.hrd.app.article.serviceImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.app.article.entities.User;
import com.hrd.app.article.service.UserLoginService;

@Repository
public class UserLoginServiceImplement implements UserLoginService {

	@Autowired
	DataSource dataSource;
	
	Connection con;
	
	public User userLogin(String username, String password) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,username,password,roles,enabled,photo,register_date FROM tbUser WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRoles(rs.getString("roles"));
				user.setEnabled(rs.getBoolean("enabled"));
				user.setPhoto(rs.getString("photo"));
				user.setRegisterDate(rs.getDate("register_date"));
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return null;
	}

}
