package com.ouyachou.app.ws.Controllers;

import com.ouyachou.app.ws.Entites.UserEntity;
import com.ouyachou.app.ws.exception.UserException;
import com.ouyachou.app.ws.request.UserRequest;
import com.ouyachou.app.ws.responses.ErrorMessages;
import com.ouyachou.app.ws.responses.UserResponse;
import com.ouyachou.app.ws.services.UserService;
import com.ouyachou.app.ws.repositories.UserRepository;
import com.ouyachou.app.ws.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users") // localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;


	@PostMapping
	public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest ) throws Exception {

		if(userRequest.getFirstName().isEmpty()) throw new UserException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());



		//UserDto userDto = new UserDto();
		ModelMapper modelMapper = new ModelMapper();

		UserDto userDto = modelMapper.map(userRequest, UserDto.class);


		//BeanUtils.copyProperties(userRequest, userDto);

		UserDto createUser = userService.createUser(userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(createUser, userResponse);
		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.CREATED);
	}

	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<UserResponse> getAllUsers(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "limit", defaultValue = "15") int limit){

		List<UserResponse> userResponse  = new ArrayList<>();

		List<UserDto> users = userService.getUsers(page, limit);

		for(UserDto userDto: users){
			UserResponse user = new UserResponse();
			BeanUtils.copyProperties(userDto, user);
			userResponse.add(user);
		}

		return userResponse;

	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {

		UserDto userDto = userService.getUserByUserId(id);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userDto,userResponse);

		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.OK);

	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = userService.updateUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse,HttpStatus.ACCEPTED);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {

		userService.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
