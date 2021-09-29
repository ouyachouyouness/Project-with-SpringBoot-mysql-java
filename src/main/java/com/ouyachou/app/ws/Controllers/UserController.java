package com.ouyachou.app.ws.Controllers;

import com.ouyachou.app.ws.Entites.UserEntity;
import com.ouyachou.app.ws.request.UserRequest;
import com.ouyachou.app.ws.responses.UserResponse;
import com.ouyachou.app.ws.services.UserService;
import com.ouyachou.app.ws.repositories.UserRepository;
import com.ouyachou.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;


	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest ) {




		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto createUser = userService.createUser(userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(createUser, userResponse);
		return userResponse;
	}

	@GetMapping(path = "/{id}")
	public String getUser(@PathVariable String id) {

		return " user was get it"+ id;

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
