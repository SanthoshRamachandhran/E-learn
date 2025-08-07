package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.Enum.Role;
import com.example.demo.Enum.Status;

import lombok.Data;

@Data
public class userRegiesterDto {

	private Long user_id;
	private String Username;
	private String email;
	private String password;
	private Role role;
	private Status status;
	private boolean terms_accepted;
	private LocalDateTime created_at;
	private LocalDateTime last_timeStrap;

}
