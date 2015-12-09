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

import com.hrd.app.article.entities.Pagination;
import com.hrd.app.article.entities.User;
import com.hrd.app.article.service.UserService;
import com.hrd.app.article.utilities.Utilities;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//chhoin add this function
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_cu001")
	public ResponseEntity<Map<String, Object>> countUser() {
		Integer user=userService.totalRecord();
		Map<String, Object> map = new HashMap<String, Object>();
		if (user < 1) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD EMPTY");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", user);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	//chhoin addd it
	@RequestMapping(method = RequestMethod.POST, value = "/user/searchCount/{username}")
	public ResponseEntity<Map<String, Object>> searchUserCount(@PathVariable("username") String username) {
		Integer users =userService.totalSearchRecord(username);
		Map<String, Object> map = new HashMap<String, Object>();
		if (users < 1) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD EMPTY");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", users);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_r001", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> getUserList(@RequestBody Pagination page) {
		List<User> user = userService.getUser(page.getRow(), page.getPageCount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (user.isEmpty()) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", userService.totalRecord());
		map.put("RES_DATA", user);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_c001", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if (userService.isExistUser(user.getUsername())!=null) {
			map.put("MESSAGE", "USER NAME ALREADY EXIST");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		if(user.getPhoto()=="" || user.getPhoto()==null){
			user.setPhoto("resources/image/user-image/default.jpg");
		}
		
		if (userService.insert(user)) {
			map.put("MESSAGE", "USER HAS BEEN INSERTED");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "USER HAS NOT BEEN INSERTED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_u001")
	public ResponseEntity<Map<String, Object>> updateUser(@RequestBody User user) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		//chhoin edite it
		/*if (userService.isExistUser(user.getUsername())!=null) {
			map.put("MESSAGE", "USER NAME ALREADY EXIST");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}*/
		
		if(user.getPhoto()=="" || user.getPhoto()==null){
			user.setPhoto(userService.getUserPhoto(user.getId()));
		}
		
		if (userService.update(user)) {
			map.put("MESSAGE", "USER HAS BEEN UPDATED");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "USER HAS NOT BEEN UPDATED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_d001")
	public ResponseEntity<Map<String, Object>> deleteUser(@RequestBody User user, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		String photo = userService.getUserPhoto(user.getId());
		if (userService.delete(user.getId())) {
			
			if(!photo.equals("resources/image/user-image/default.jpg")){
				Utilities.deleteFile(request.getSession().getServletContext().getRealPath("/") + photo);
			}
			
			map.put("MESSAGE", "USER HAS BEEN DELETED.");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "USER HAS NOT BEEN DELETED.");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_e001")
	public ResponseEntity<Map<String, Object>> enableUser(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (userService.enable(user.getId())) {
			map.put("MESSAGE", "OPERATION SUCCESS");
			map.put("STATUS", true);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "OPERATION FAIL");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/hrd_det001")
	public ResponseEntity<Map<String, Object>> detailUser(@RequestBody User u) {
		User user = userService.detail(u.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		if (user==null) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("RES_DATA", user);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/search/{username}")
	public ResponseEntity<Map<String, Object>> searchUser(@RequestBody Pagination page, @PathVariable("username") String username) {
		List<User> users = userService.search(username, page.getRow(), page.getPageCount());
		Map<String, Object> map = new HashMap<String, Object>();
		if (users.isEmpty()) {
			map.put("STATUS", false);
			map.put("MESSAGE", "RECORD NOT FOUND");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		map.put("STATUS", true);
		map.put("MESSAGE", "RECORD FOUND");
		map.put("TOTAL_REC", userService.totalSearchRecord(username));
		map.put("RES_DATA", users);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/upload_image")
	public ResponseEntity<Map<String, Object>> insertPhoto(@RequestParam("USR_IMG") MultipartFile file, HttpServletRequest request) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String filename = file.getOriginalFilename();
		String userPhoto = "";
		
		if (!file.isEmpty()) {
			
			try {

				String filenameGen = UUID.randomUUID() + ".jpg";
				
				byte[] bytes = file.getBytes();

				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/resources/image/user-image/");
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

				userPhoto = "resources/image/user-image/" + filenameGen;

			} catch (Exception e) {
				System.out.println("You are failed to upload " + filename + " => " + e.getMessage());
			}
		} else {
			System.out.println("You are failed to upload " + filename + " because the file was empty!");
		}
		
		if (userPhoto != "") {
			map.put("STATUS", true);
			map.put("MESSAGE", "IMAGE HAS BEEN INSERTED");
			map.put("USR_IMG", userPhoto);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("STATUS", false);
			map.put("MESSAGE", "IMAGE HAS NOT BEEN INSERTED");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user/update_image/{id}")
	public ResponseEntity<Map<String, Object>> updatePhoto(@RequestParam("USR_IMG") MultipartFile file,
			HttpServletRequest request, @PathVariable("id") int id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String userPhoto = userService.getUserPhoto(id);
		String filename = file.getOriginalFilename();
		String photo = "";
		
		if (!file.isEmpty()) {
			try {

				String filenameGen = UUID.randomUUID() + ".jpg";
				byte[] bytes = file.getBytes();

				// creating the directory to store file
				String savePath = request.getSession().getServletContext().getRealPath("/resources/image/user-image/");
				System.out.println(savePath);
				File path = new File(savePath);
				
				if (!path.exists()) {
					path.mkdir();
				}
				
				// creating the file on server
				File serverFile = null;
				if(!userPhoto.equals("resources/image/user-image/default.jpg")){
					String getPath = request.getSession().getServletContext().getRealPath("/");
					Utilities.deleteFile(getPath + userPhoto);
					filenameGen = userPhoto;
					serverFile = new File(getPath + userPhoto);
				}else{
					serverFile = new File(savePath + File.separator + filenameGen);
					filenameGen = "resources/image/user-image/" + filenameGen;
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
			map.put("USR_IMG", photo);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		} else {
			map.put("MESSAGE", "IMAGE HAS NOT BEEN UPDATED");
			map.put("STATUS", false);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
	}
	
}
