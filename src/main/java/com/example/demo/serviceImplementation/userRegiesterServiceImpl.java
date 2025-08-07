package com.example.demo.serviceImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Exception.CustomRuntimeException;
import com.example.demo.ServiceInterface.userRegiesterService;
import com.example.demo.dao.userRegiesterRepositoryImpl;
import com.example.demo.dto.userRegiesterDto;
import com.example.demo.model.userRegiesterEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class userRegiesterServiceImpl implements userRegiesterService {

	private final userRegiesterRepositoryImpl repo;

	public userRegiesterServiceImpl(userRegiesterRepositoryImpl repo) {
		super();
		this.repo = repo;
	}

	@Override
	public userRegiesterEntity saveRegiesterUser(userRegiesterDto dto) {

		try {
			if (dto.getUser_id() != null) {

				Optional<userRegiesterEntity> model = repo.findById(dto.getUser_id());

				if (model.isPresent()) {
					userRegiesterEntity obj = model.get();

					obj.setUsername(dto.getUsername());
					obj.setPassword(dto.getPassword());
					obj.setEmail(dto.getEmail());
					obj.setCreated_at(dto.getCreated_at());
					obj.setStatus(dto.getStatus());
					obj.setLast_timeStrap(dto.getLast_timeStrap());
					obj.setRole(dto.getRole());
					obj.setTerms_accepted(dto.isTerms_accepted());

					log.info("Update from userRegiesterData");
					userRegiesterEntity entity = repo.save(obj);
					return entity;

				}

			}

		} catch (Exception ex) {
			log.error("Error while saving user data", ex);
			throw new CustomRuntimeException("Failed to Update Processing user: " + ex.getMessage());
		}

		try {
			log.info("saveData from userRegiesterData");

			if (dto.getUsername() == null || dto.getPassword() == null) {
				log.error("userRegiesterDto is null");
				throw new CustomRuntimeException("Invalid userDto data from username && password");
			}

			final userRegiesterEntity obj = new userRegiesterEntity();
			obj.setUsername(dto.getUsername());
			obj.setPassword(dto.getPassword());
			obj.setEmail(dto.getEmail());
			obj.setCreated_at(dto.getCreated_at());
			obj.setStatus(dto.getStatus());
			obj.setLast_timeStrap(dto.getLast_timeStrap());
			obj.setRole(dto.getRole());
			obj.setTerms_accepted(dto.isTerms_accepted());

			userRegiesterEntity model = repo.save(obj);
			return model;

		} catch (Exception ex) {
			log.error("Error while saving user data", ex);
			throw new CustomRuntimeException("Failed to save user: " + ex.getMessage());

		}

	}

	@Override
	public List<userRegiesterEntity> getRegiesterData() {

		try {

			log.info("Data is get Sucessing processing");
			List<userRegiesterEntity> obj = new ArrayList<>();

			repo.findAll().forEach(x -> obj.add(x));

			log.info("data is successfull handling");

			return obj;

		} catch (Exception ex) {
			log.error("Error while saving user data", ex);
			throw new CustomRuntimeException("Failed to Get Data user: " + ex.getMessage());

		}

	}

	@Override
	public Optional<userRegiesterEntity> getIdRegiesterData(Long id) {
		try {

			Optional<userRegiesterEntity> object = repo.findById(id);

			log.info("Data is processing from userRegister process getbyId" + repo.findById(id));

			if (object.isEmpty()) {
				throw new CustomRuntimeException("Failed to GetId  Data user");

			}

			return object;
		} catch (Exception ex) {
			log.error("Error while getId  user data", ex);
			throw new CustomRuntimeException("Failed to Get Data user: " + ex.getMessage());

		}

	}

	@Override
	public boolean deleteRegisterData(Long id) {

		log.info("Deleting UserData with ID: {}", id);
		try {
			final Optional<userRegiesterEntity> delete = repo.findById(id);
			if (delete.isPresent()) {
				repo.deleteById(id);
				return true;
			} else {
				log.warn("UserRegiesterData with ID {} not found", id);
				return false;
			}
		} catch (Exception e) {
			log.error("Error deleting UserId with ID {}: {}", id, e.getMessage());
			throw new CustomRuntimeException("Failed to delete Data user: " + e.getMessage());
		}
	}

}
