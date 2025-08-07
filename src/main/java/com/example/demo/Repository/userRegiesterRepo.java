package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.userRegiesterEntity;
@Repository
public interface userRegiesterRepo extends JpaRepository<userRegiesterEntity,Long> {

	

}
