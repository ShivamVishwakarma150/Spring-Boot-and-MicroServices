package com.shivam.repository;

import org.springframework.data.repository.CrudRepository;

import com.shivam.entity.User;

public interface UserRepository extends  CrudRepository<User, Integer>{

}
