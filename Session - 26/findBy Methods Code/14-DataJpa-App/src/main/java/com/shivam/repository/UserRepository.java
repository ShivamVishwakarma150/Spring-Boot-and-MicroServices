package com.shivam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shivam.entity.User;

public interface UserRepository extends  CrudRepository<User, Integer>{
	
	// select * from user_master where user_country=?;
	public List<User> findByCountry(String cname);
	
	// select * from user_master where user_age=?;
	public List<User> findByAge(Integer cage);
	
	// select * from user_master where user_age >= ?;
	public List<User> findByAgeGreaterThanEqual(Integer age);
	
	//select * from user_master where user_country in (?,?,? ...);
	public List<User> findByCountryIn(List<String> cname);
	
	// select * from user_master where user_country='India' and user_age=25;
	public List<User> findByCountryAndAge(String cname,Integer age);
	
	
	public List<User> findByCountryAndGender(String cname,String gender);
	
	// select * from user_master where user_country='India' and user_age=25 and user_gender='Male';
	public List<User> findByCountryAndAgeAndGender(String cname,Integer age,String gender);
	
	
}
