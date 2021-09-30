package com.factorit.crypto.crypto.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.factorit.crypto.crypto.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByUserName(String user);

}