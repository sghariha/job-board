package com.shariharan.jobboard.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.shariharan.jobboard.model.user.PosterUser;

@Repository
public interface PosterUserRepository extends MongoRepository<PosterUser, String> {
    public List<PosterUser> findByEmail(String email);
	public List<PosterUser> findByLastName(String lastName);
}