package com.hrd.app.article.service;

import java.util.ArrayList;

import com.hrd.app.article.entities.Article;

public interface ArticleService {
	
	public ArrayList<Article> getArticle(int offset, int limit);
	public Article detail(int id);
	public boolean insert(Article article);
	public boolean update(Article article);
	public boolean delete(int id);
	public boolean enable(int id);
	public ArrayList<Article> search(String title, int offset, int limit);
	public ArrayList<Article> getArticleByUser(int id, int offset, int limit);
	public int totalRecord();
	public int totalSearchRecord(String title);
	public int totalUserRecord(int id);
	public String getArticleImage(int id);
	
}
