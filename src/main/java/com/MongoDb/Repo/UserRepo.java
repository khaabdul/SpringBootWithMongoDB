package com.MongoDb.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.MongoDb.Entity.UserBean;

public interface UserRepo extends MongoRepository<UserBean, Integer> {
	public Optional<UserBean> findByNumber(long number);
}
