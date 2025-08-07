package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.Enum.CourseStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class CourseRegisterEntity {

	@Id
	@Column(name = "course_id", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "course_RollNo", nullable = false, unique = true)
	private String courseId;
	@Column(name = "title", nullable = false)
	private String title;
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id", nullable = false)
	private userRegiesterEntity instructorId;

	@Column(name = "price", nullable = false)
	private BigDecimal price;
	@Column(name = "discount", nullable = false)
	private BigDecimal discount;
	@Column(name = "thumbnail", nullable = false)
	private String thumbnail;
	@Column(name = "Status", nullable = false)
	private CourseStatus status; // draft, published, archived
	@Column(name = "verified")
	private boolean verified;
	@Column(name = "published")
	private boolean published;
	@Column(name = "createAt")
	private LocalDateTime createdAt;
	

}
