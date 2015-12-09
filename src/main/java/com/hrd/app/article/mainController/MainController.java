package com.hrd.app.article.mainController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hrd.app.article.service.UserService;

@Controller
public class MainController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = { "/", "/home" })
	public String articlePage() {
		return "article";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public String userPage() {
		return "user";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/help")
	public String help() {
		return "help";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = { "/api/document" })
	public String api(ModelMap model) {
		model.addAttribute("title", "API Document");
		return "api";
	}
	
	@RequestMapping(value = "/login")
	public ResponseEntity<Map<String, Object>> login() {
				
		Map<String, Object> map = new HashMap<String, Object>();		
			map.put("STATUS", false);
			map.put("MESSAGE", "Not Allow A som ki elit");				
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}	

}
