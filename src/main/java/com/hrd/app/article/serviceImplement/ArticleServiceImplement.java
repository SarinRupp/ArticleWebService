package com.hrd.app.article.serviceImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hrd.app.article.entities.Article;
import com.hrd.app.article.service.ArticleService;
import com.hrd.app.article.utilities.Utilities;

@Repository
public class ArticleServiceImplement implements ArticleService {

	@Autowired
	DataSource dataSource;
	
	Connection con;
	
	public ArrayList<Article> getArticle(int limit, int offset) {
		
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,title,description,pub_date,image,enabled,userid FROM tbArticle ORDER BY id DESC LIMIT ? OFFSET ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, limit);
			ps.setInt(2, Utilities.offset(limit, offset));
			ResultSet rs = ps.executeQuery();
			ArrayList<Article> articles = new ArrayList<Article>();
			Article article = null;
			while(rs.next()){
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDescription(rs.getString("description"));
				article.setPublishDate(rs.getDate("pub_date"));
				article.setImage(rs.getString("image"));
				article.setEnabled(rs.getBoolean("enabled"));
				article.setUserId(rs.getInt("userid"));
				articles.add(article);
			}
			return articles;
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

	public Article detail(int id) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,title,description,pub_date,image,enabled,userid FROM tbArticle WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			Article article = null;
			while(rs.next()){
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDescription(rs.getString("description"));
				article.setPublishDate(rs.getDate("pub_date"));
				article.setImage(rs.getString("image"));
				article.setEnabled(rs.getBoolean("enabled"));
				article.setUserId(rs.getInt("userid"));
			}
			return article;
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

	public boolean insert(Article article) {
		try {
			con = dataSource.getConnection();
			String sql = "INSERT INTO tbArticle(title,description,pub_date,image,enabled,userid) VALUES(?,?,now(),?,true,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getDescription());
			ps.setString(3, article.getImage());
			ps.setInt(4, article.getUserId());
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

	public boolean update(Article article) {
		try {
			con = dataSource.getConnection();
			String sql = "UPDATE tbArticle SET title=?,description=?,image=?,enabled=?,userid=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, article.getTitle());
			ps.setString(2, article.getDescription());
			ps.setString(3, article.getImage());
			ps.setBoolean(4, article.isEnabled());
			ps.setInt(5, article.getUserId());
			ps.setInt(6, article.getId());
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
			String sql = "DELETE FROM tbArticle WHERE id=?";
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

	public ArrayList<Article> search(String title, int limit, int offset) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,title,description,pub_date,image,enabled,userid FROM tbArticle WHERE LOWER(title) LIKE LOWER(?) ORDER BY title LIMIT ? OFFSET ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ps.setInt(2, limit);
			ps.setInt(3, Utilities.offset(limit, offset));
			ResultSet rs = ps.executeQuery();
			ArrayList<Article> articles = new ArrayList<Article>();
			Article article = null;
			while(rs.next()){
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDescription(rs.getString("description"));
				article.setPublishDate(rs.getDate("pub_date"));
				article.setImage(rs.getString("image"));
				article.setEnabled(rs.getBoolean("enabled"));
				article.setUserId(rs.getInt("userid"));
				articles.add(article);
			}
			return articles;
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

	public ArrayList<Article> getArticleByUser(int id, int limit, int offset) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT id,title,description,pub_date,image,enabled,userid FROM tbArticle WHERE userid=? ORDER BY pub_date LIMIT ? OFFSET ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, limit);
			ps.setInt(3, Utilities.offset(limit, offset));
			ResultSet rs = ps.executeQuery();
			ArrayList<Article> articles = new ArrayList<Article>();
			Article article = null;
			while(rs.next()){
				article = new Article();
				article.setId(rs.getInt("id"));
				article.setTitle(rs.getString("title"));
				article.setDescription(rs.getString("description"));
				article.setPublishDate(rs.getDate("pub_date"));
				article.setImage(rs.getString("image"));
				article.setEnabled(rs.getBoolean("enabled"));
				article.setUserId(rs.getInt("userid"));
				articles.add(article);
			}
			return articles;
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
			String sql = "SELECT COUNT(id) AS total FROM tbArticle";
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

	public int totalSearchRecord(String title) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(id) AS total FROM tbArticle WHERE LOWER(title) LIKE LOWER(?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
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

	public int totalUserRecord(int id) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT COUNT(id) AS total FROM tbArticle WHERE userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
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

	public String getArticleImage(int id) {
		try {
			con = dataSource.getConnection();
			String sql = "SELECT image FROM tbArticle WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			String photo = null;
			while(rs.next()){
				photo = rs.getString("image");
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
			String sql = "UPDATE tbArticle SET enabled = NOT enabled WHERE id=?";
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
