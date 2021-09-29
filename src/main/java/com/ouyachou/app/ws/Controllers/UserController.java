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
	public UserResponse getUser(@PathVariable String id) {

		UserDto userDto = userService.getUserByUserId(id);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userDto,userResponse);

		return userResponse;

	}

	@PutMapping(path = "/{id}")
	public UserResponse updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = userService.updateUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return userResponse;
	}

	@DeleteMapping(path = "/{id}")
	public String deleteUser(@PathVariable String id) {

		userService.deleteUser(id);

		return "delete user was called";
	}
}
