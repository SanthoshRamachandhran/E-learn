package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.Enum.CourseStatus;
import com.example.demo.model.userRegiesterEntity;

import lombok.Data;

@Data
public class courseRegisterDto {
	
	private Long id;
    private String courseId;
    private String title;
    private String description;
    private userRegiesterEntity instructorId;
    private BigDecimal price;
    private BigDecimal discount;
    private String thumbnail;
    private CourseStatus status; // draft, published, archived
    private boolean verified;
    private boolean published;
    private LocalDateTime createdAt;

}
