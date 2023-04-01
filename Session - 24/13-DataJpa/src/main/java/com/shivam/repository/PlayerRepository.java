package com.shivam.repository;

import org.springframework.data.repository.CrudRepository;


import com.shivam.entity.Player;
//@Repository -> optional
public interface PlayerRepository extends CrudRepository<Player, Integer>{
	
	
}
