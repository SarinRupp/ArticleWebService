package com.hrd.app.article.restController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hrd.app.article.entities.User;
import com.hrd.app.article.service.UserLoginService;

@RestController
@RequestMapping("/api")
public class UserLoginController {

	@Autowired
	UserLoginService userLoginService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login", headers = "Accept=application/json")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		String username = user.getUsername();
		String password = user.getPassword();
		System.out.println(username + " " + password);
		User userdata = userLoginService.userLogin(username,password);
		if(userdata==null){
			map.put("STATUS", false);
			map.put("MESSAGE", "LOGIN FAIL");
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
		map.put("STATUS", true);
		map.put("MESSAGE", "LOGIN SUCCESS");
		map.put("RES_DATA", userdata);
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		
	}
	
}
