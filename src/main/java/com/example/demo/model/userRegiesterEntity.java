package com.example.demo.model;

import java.time.LocalDateTime;

import com.example.demo.Enum.Role;
import com.example.demo.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "UserRegiesterData")
public class userRegiesterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", nullable = false, unique = true)
	private Long user_id;
	@Column(name = "userName", nullable = false)
	private String Username;
	@Column(name = "email", nullable = false)
	private String email;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Status status;
	@Column(name = "acceptency", nullable = false)
	private boolean terms_accepted;
	@Column(name = "LoginData", nullable = false)
	private LocalDateTime created_at;
	@Column(name = "LastLoginData", nullable = false)
	private LocalDateTime last_timeStrap;

}
