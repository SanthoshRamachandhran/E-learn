package com.example.demo.serviceImplementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.CustomRuntimeException;
import com.example.demo.ServiceInterface.CourseRegisterService;
import com.example.demo.dao.CourseRegisterRepositoryImpl;
import com.example.demo.dto.courseRegisterDto;
import com.example.demo.model.CourseRegisterEntity;

import lombok.extern.slf4j.Slf4j;

@Service

@Slf4j
public class CourseRegisterServiceImpl implements CourseRegisterService {

	private final CourseRegisterRepositoryImpl repo;

	public CourseRegisterServiceImpl(CourseRegisterRepositoryImpl repo) {

		this.repo = repo;
	}

	@Override
	public CourseRegisterEntity saveRegiesterUser(courseRegisterDto dto) {

		try {
			if (dto.getId() != null) {

				Optional<CourseRegisterEntity> object = repo.findById(dto.getId());

				if (object.isPresent()) {

					CourseRegisterEntity entity = object.get();
					log.info("Updating existing course with ID: {}", dto.getId());
					entity.setCourseId(dto.getCourseId());
					entity.setTitle(dto.getTitle());
					entity.setDescription(dto.getDescription());
					entity.setInstructorId(dto.getInstructorId());
					entity.setPrice(dto.getPrice());
					entity.setDiscount(dto.getDiscount());
					entity.setThumbnail(dto.getThumbnail());
					entity.setStatus(dto.getStatus());
					entity.setVerified(dto.isVerified());
					entity.setPublished(dto.isPublished());
					entity.setCreatedAt(dto.getCreatedAt());
					
					return repo.save(entity);
				}
				
			if(object.isEmpty()) {
				throw new  CustomRuntimeException("Dto id is Empty check");
			}

			} 

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		CourseRegisterEntity entity=new CourseRegisterEntity();
//		entity.setCourseId(dto.getCourseId());
//		entity.setTitle(dto.getTitle());
//		entity.setDescription(dto.getDescription());
//		entity.setInstructorId(dto.getInstructorId());
//		entity.setPrice(dto.getPrice());
//		entity.setDiscount(dto.getDiscount());
//		entity.setThumbnail(dto.getThumbnail());
//		entity.setStatus(dto.getStatus());
//		entity.setVerified(dto.isVerified());
//		entity.setPublished(dto.isPublished());
//		entity.setCreatedAt(dto.getCreatedAt());
//	
		
		 log.info("Creating new course.");

		return repo.save(entity);
	}

}
