package com.example.demo.ServiceInterface;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.userRegiesterDto;
import com.example.demo.model.userRegiesterEntity;

public interface userRegiesterService {

	userRegiesterEntity saveRegiesterUser(userRegiesterDto dto);

	List<userRegiesterEntity> getRegiesterData();

	Optional<userRegiesterEntity> getIdRegiesterData(Long id);

	

	boolean deleteRegisterData(Long id);

//	Optional<userRegiesterEntity> deleteIdRegiesterData(Long id);

}
