package com.shariharan.jobboard.db;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.shariharan.jobboard.model.user.SeekerUser;

@Repository
public interface SeekerUserRepository extends MongoRepository<SeekerUser, String> {
	public List<SeekerUser> findByEmail(String email);
	public List<SeekerUser> findByLastName(String lastName);
}