package com.shariharan.jobboard.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.shariharan.jobboard.model.company.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
	public List<Company> findByName(String name);
	public List<Company> findByNameRegex(String firstname);
}