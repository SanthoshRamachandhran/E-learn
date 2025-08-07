package com.example.demo.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ServiceInterface.CourseRegisterService;
import com.example.demo.dto.courseRegisterDto;
import com.example.demo.model.CourseRegisterEntity;
import com.example.demo.util.ResponseMessage;
import com.example.demo.util.ResponseUnit;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	private final CourseRegisterService service;

	public CourseController(CourseRegisterService service) {
	
		this.service = service;
	}
	
	
	@PostMapping("/post")
	
	public ResponseEntity<Map<String,Object>>saveOrUpdate(@RequestBody courseRegisterDto dto){
		
		if (dto == null || dto.getId() == null || dto.getCourseId().isEmpty()) {
			return ResponseUnit.generateResponse("Invalid CourseDetails Processing", HttpStatus.BAD_REQUEST);
		}

		final CourseRegisterEntity obj = service.saveRegiesterUser(dto);

		return obj != null ? ResponseUnit.generateResponse(ResponseMessage.SUCCESS, HttpStatus.OK)
				: ResponseUnit.generateResponse(ResponseMessage.FAILED, HttpStatus.BAD_REQUEST);
	}
	
		
	

}
