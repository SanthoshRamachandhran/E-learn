package com.example.demo.ServiceInterface;

import com.example.demo.dto.courseRegisterDto;
import com.example.demo.model.CourseRegisterEntity;

public interface CourseRegisterService {

	CourseRegisterEntity saveRegiesterUser(courseRegisterDto dto);

}
