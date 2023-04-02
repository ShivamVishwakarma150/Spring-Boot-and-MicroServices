package com.shivam.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import com.shivam.entity.User;

public interface UserRepository extends  JpaRepository<User, Integer>{
		

}
