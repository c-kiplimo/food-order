package com.collicode.foodorderback.controller;


import com.collicode.foodorderback.dto.LoginDTO;
import com.collicode.foodorderback.model.Login;
import com.collicode.foodorderback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class LoginController {
	
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/welcomeTest", method = RequestMethod.GET)
	public String welcome() {
		return "test!!!";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginDTO> generateToken(@RequestBody Login login) throws Exception{
		LoginDTO loginDTO = userService.generateToken(login);
		return new ResponseEntity<LoginDTO>(loginDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ResponseEntity<String> Logout() throws Exception{
		String responseToClient = userService.isValidLogout();
		
		return new ResponseEntity<String>(responseToClient, HttpStatus.OK);
	}
}