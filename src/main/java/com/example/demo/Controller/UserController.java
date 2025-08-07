package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceInterface.userRegiesterService;
import com.example.demo.dto.userRegiesterDto;
import com.example.demo.model.userRegiesterEntity;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.ResponseUnit;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/Regiester")
@CrossOrigin
public class UserController {

	private final userRegiesterService service;

	public UserController(userRegiesterService service) {
		super();
		this.service = service;
	}

	@PostMapping("/post")
	public ResponseEntity<Map<String, Object>> saveRegisterData(@RequestBody userRegiesterDto dto) {

		if (dto == null || dto.getUsername() == null || dto.getUsername().isEmpty()) {
			return ResponseUnit.generateResponse("Invalid userDetails Processing", HttpStatus.BAD_REQUEST);
		}

		final userRegiesterEntity obj = service.saveRegiesterUser(dto);

		return obj != null ? ResponseUnit.generateResponse(ResponseMessage.SUCCESS, HttpStatus.OK)
				: ResponseUnit.generateResponse(ResponseMessage.FAILED, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/get")
	public ResponseEntity<List<userRegiesterEntity>> getRegisterData() {

		log.info("fetch all userDetails Information");

		final List<userRegiesterEntity> obj = service.getRegiesterData();

		return new ResponseEntity<>(obj, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")

	public ResponseEntity<Optional<userRegiesterEntity>> getIdRegiester(@PathVariable Long id) {

		log.info("fetch Id from userDetails Information");

		final Optional<userRegiesterEntity> obj = service.getIdRegiesterData(id);

		return new ResponseEntity<>(obj, HttpStatus.OK);

	}



	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> deleteBranch(@PathVariable Long id) {
		log.debug("deleteBranch - ID: {}", id);
		if (id == null || id <= 0) {
			return ResponseUnit.generateResponse(ResponseMessage.FAILED, HttpStatus.BAD_REQUEST);
		}
		final boolean isDeleted = service.deleteRegisterData(id);
		return isDeleted ? ResponseUnit.generateResponse(ResponseMessage.SUCCESS, HttpStatus.OK)
				: ResponseUnit.generateResponse(ResponseMessage.FAILED, HttpStatus.BAD_REQUEST);
	}

}
