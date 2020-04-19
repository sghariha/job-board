package com.shariharan.jobboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shariharan.jobboard.db.SeekerUserRepository;

@SpringBootApplication
public class JobBoardApplication {

	@Autowired
	private SeekerUserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JobBoardApplication.class, args);	
	}
}
