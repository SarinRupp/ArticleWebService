package com.hrd.app.article.serviceImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.app.article.entities.User;
import com.hrd.app.article.service.UserService;
import com.hrd.app.article.utilities.Utilities;

@Repository
public class UserServiceImplement implements UserService {
	
	@Autowired
	DataSource dataSource;
	
	Connection con;

	public ArrayList<User> getUser(int limit, int offset) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,username,password,roles,enabled,photo,register_date FROM tbUser ORDER BY id DESC LIMIT ? OFFSET ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setInt(2, Utilities.offset(limit, offset));
			ResultSet rs = ps.executeQuery();
			ArrayList<User> users = new ArrayList<User>();
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
				users.add(user);
			}
			return users;
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

	public User detail(int id) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,username,password,roles,enabled,photo,register_date FROM tbUser WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
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

	public boolean insert(User user) {
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO tbUser(username,password,roles,enabled,photo,register_date) VALUES(?,?,?,true,?,now())";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRoles());
			ps.setString(4, user.getPhoto());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return false;
	}

	public boolean update(User user) {
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE tbUser SET username=?,password=?,roles=?,enabled=?,photo=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRoles());
			ps.setBoolean(4, user.isEnabled());
			ps.setString(5, user.getPhoto());
			ps.setInt(6, user.getId());
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return false;
	}

	public boolean delete(int id) {
		
		try {
			con = dataSource.getConnection();
			String sql = "DELETE FROM tbUser WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return false;
	}

	public ArrayList<User> search(String username, int limit, int offset) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,username,password,roles,enabled,photo,register_date FROM tbUser WHERE LOWER(username) LIKE LOWER(?) ORDER BY username LIMIT ? OFFSET ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + username + "%");
			ps.setInt(2, limit);
			ps.setInt(3, Utilities.offset(limit, offset));
			ResultSet rs = ps.executeQuery();
			ArrayList<User> users = new ArrayList<User>();
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
				users.add(user);
			}
			return users;
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

	public int totalRecord() {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(id) AS total FROM tbUser";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int total = 0;
			while(rs.next()){
				total = rs.getInt("total");
			}
			return total;
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		return 0;
	}

	public String isExistUser(String username) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT username FROM tbUser WHERE username=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			String user = null;
			while(rs.next()){
				user = rs.getString("username");
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

	public int totalSearchRecord(String username) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(id) AS total FROM tbUser WHERE LOWER(username) LIKE LOWER(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + username + "%"); 
			ResultSet rs = ps.executeQuery();
			int total = 0;
			while(rs.next()){
				total = rs.getInt("total");
			}
			return total;
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return 0;
	}

	public String getUserPhoto(int id) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT photo FROM tbUser WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			String photo = null;
			while(rs.next()){
				photo = rs.getString("photo");
			}
			return photo;
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

	public boolean enable(int id) {
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE tbUser SET enabled = NOT enabled WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			if(ps.executeUpdate()>0){
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return false;
	}

}
