package com.ouyachou.app.ws.Controllers;

import com.ouyachou.app.ws.request.UserRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {



	@PostMapping
	public String createUser(@RequestBody UserRequest userRequest ) {

		return userRequest.getEmail();
	}

	@GetMapping
	public String getUser() {

		return " user was get it";

	}

	@PutMapping
	public String updateUser() {
		return "update user was called";
	}

	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
