package com.hrd.app.article.restController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrd.app.article.entities.Article;
import com.hrd.app.article.entities.Pagination;
import com.hrd.app.article.service.ArticleService;
import com.hrd.app.article.utilities.Utilities;

@RestController
@RequestMapping("/api")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	//chhoin add this function
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_cr001")
	public ResponseEntity<Map<String, Object>> countArtile() {
		
		Integer article =articleService.totalRecord();
		Map<String, Object> map = new HashMap<String, Object>();
		if (article < 1  ) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD EMPTY");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", article);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	//chhoin add this function
	@RequestMapping(method = RequestMethod.POST, value = "/article/searchCount/{title}")
	public ResponseEntity<Map<String, Object>> countSearch(@PathVariable("title") String title) {
		Integer articles = articleService.totalSearchRecord(title);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		if (articles <1) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD EMPTY");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", articles);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_r001", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> getArticleList(@RequestBody Pagination page) {
		List<Article> article = articleService.getArticle(page.getRow(), page.getPageCount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (article.isEmpty()) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", articleService.totalRecord());
		map.put("RES_DATA", article);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_c001", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> insertArticle(@RequestBody Article article) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(article.getImage()==null || article.getImage()==""){
			article.setImage("resources/image/article-image/default.jpg");
		}
		
		if (articleService.insert(article)) {
			map.put("MESSAGE", "ARTICLE HAS BEEN INSERTED");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "ARTICLE HAS NOT BEEN INSERTED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_u001", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> updateArticle(@RequestBody Article article) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(article.getImage()==null || article.getImage()==""){
			article.setImage(articleService.getArticleImage(article.getId()));
		}
		
		if (articleService.update(article)) {
			map.put("MESSAGE", "ARTICLE HAS BEEN UPDATED");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "ARTICLE HAS NOT BEEN UPDATED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_d001")
	public ResponseEntity<Map<String, Object>> deleteArticle(@RequestBody Article article, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String photo = articleService.getArticleImage(article.getId());
		if (articleService.delete(article.getId())) {
			if(!photo.equals("resources/image/article-image/default.jpg")){
				Utilities.deleteFile(request.getSession().getServletContext().getRealPath("/") + photo);
			}
			map.put("MESSAGE", "ARTICLE HAS BEEN DELETED.");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "ARTICLE HAS NOT BEEN DELETED.");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_e001")
	public ResponseEntity<Map<String, Object>> deleteArticle(@RequestBody Article article) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (articleService.enable(article.getId())) {
			map.put("MESSAGE", "OPERATION SUCCESS");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "OPERATION FAIL");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/hrd_det001")
	public ResponseEntity<Map<String, Object>> detailArticle(@RequestBody Article art) {
		Article article = articleService.detail(art.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if (article==null) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("RES_DATA", article);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/search/{title}")
	public ResponseEntity<Map<String, Object>> searchArticle(@RequestBody Pagination page, @PathVariable("title") String title) {
		List<Article> articles = articleService.search(title, page.getRow(), page.getPageCount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (articles.isEmpty()) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", articleService.totalSearchRecord(title));
		map.put("RES_DATA", articles);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/user/{id}")
	public ResponseEntity<Map<String, Object>> getArticleByUser(@PathVariable("id") int id, @RequestBody Pagination page) {
		List<Article> articles = articleService.getArticleByUser(id, page.getRow(), page.getPageCount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (articles.isEmpty()) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", articleService.totalUserRecord(id));
		map.put("RES_DATA", articles);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/upload_image")
	public ResponseEntity<Map<String, Object>> insertPhoto(@RequestParam("ART_IMG") MultipartFile file, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String filename = file.getOriginalFilename();
		String articlePhoto = "";
		
		if (!file.isEmpty()) {
			
			try {

				String filenameGen = UUID.randomUUID() + ".jpg";
				
				byte[] bytes = file.getBytes();

				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/resources/image/article-image/");
				System.out.println(savePath);
				File path = new File(savePath);
				if (!path.exists()) {
					path.mkdir();
				}
				// creating the file on server
				File serverFile = new File(savePath + File.separator + filenameGen);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				System.out.println(serverFile.getAbsolutePath());
				
				System.out.println("You are successfully uploaded file " + filename);

				articlePhoto = "resources/image/article-image/" + filenameGen;

			} catch (Exception e) {
				System.out.println("You are failed to upload " + filename + " => " + e.getMessage());
			}
		} else {
			System.out.println("You are failed to upload " + filename + " because the file was empty!");
		}
		
		if (articlePhoto != "") {
			map.put("STATUS", true);
			map.put("MESSAGE", "IMAGE HAS BEEN INSERTED");
			map.put("ART_IMG", articlePhoto);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("STATUS", false);
			map.put("MESSAGE", "IMAGE HAS NOT BEEN INSERTED");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/article/update_image/{id}")
	public ResponseEntity<Map<String, Object>> updatePhoto(@RequestParam("ART_IMG") MultipartFile file,
			HttpServletRequest request, @PathVariable("id") int id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String articlePhoto = articleService.getArticleImage(id);
		String filename = file.getOriginalFilename();
		String photo = "";
		
		if (!file.isEmpty()) {
			try {

				String filenameGen = UUID.randomUUID() + ".jpg";
				byte[] bytes = file.getBytes();

				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/resources/image/article-image/");
				System.out.println(savePath);
				File path = new File(savePath);
				
				if (!path.exists()) {
					path.mkdir();
				}

				// creating the file on server
				File serverFile = null;
				if(!articlePhoto.equals("resources/image/article-image/default.jpg")){
					String getPath = request.getSession().getServletContext().getRealPath("/");
					Utilities.deleteFile(getPath + articlePhoto);
					filenameGen = articlePhoto;
					serverFile = new File(getPath + articlePhoto);
				}else{
					serverFile = new File(savePath + File.separator + filenameGen);
					filenameGen = "resources/image/article-image/" + filenameGen;
				}
				
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println(serverFile.getAbsolutePath());
				System.out.println("You are successfully uploaded file " + filename);

				photo = filenameGen;

			} catch (Exception e) {
				System.out.println("You are failed to upload " + filename + " => " + e.getMessage());
			}
		} else {
			System.out.println("You are failed to upload " + filename + " because the file was empty!");
		}
		
		if (photo != "") {
			map.put("MESSAGE", "IMAGE HAS BEEN UPDATED");
			map.put("STATUS", true);
			map.put("ART_IMG", photo);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "IMAGE HAS NOT BEEN UPDATED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
}
