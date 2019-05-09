package com.demo.demo_proj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.demo_proj.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
}
