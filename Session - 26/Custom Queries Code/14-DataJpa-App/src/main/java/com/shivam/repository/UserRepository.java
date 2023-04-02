package com.shivam.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shivam.entity.User;

public interface UserRepository extends  CrudRepository<User, Integer>{
	
	@Query(value="From User")
	public List<User> getAllUsersHql();
	
	@Query(value="select * from user_master",nativeQuery=true)
	public List<User> getAllUsersSql();
	
	@Query(value="From User where country=:cname")
	public List<User> getAllUsersByCountry(String cname);
	
	@Query(value="From User where country=:cname and age=:age")
	public List<User> getAllUsersByCountryAndAge(String cname,Integer age);
	
}
