package com.example.demo.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUnit {
	
	public static final String MESSAGE = "message";
	public static final String STATUS = "status";
	public static final String TIMESTAMP = "timestamp";

	public static ResponseEntity<Map<String, Object>> generateResponse(String message, HttpStatus status) {
		Map<String, Object> genResponse = new HashMap<>();
		genResponse.put(MESSAGE, message);
		genResponse.put(STATUS, status);
		genResponse.put(TIMESTAMP, new Date());
		return new ResponseEntity<>(genResponse, HttpStatus.OK);
	}

}
