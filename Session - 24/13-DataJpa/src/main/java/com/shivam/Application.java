package com.shivam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.shivam.entity.Player;
import com.shivam.repository.PlayerRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
ConfigurableApplicationContext context =   SpringApplication.run(Application.class, args);
		
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
		
		
		Player p1 = new Player();
		p1.setPlayerId(102);
		p1.setPlayerName("Santosh");
		p1.setPlayerAge(54);
		p1.setLocation("Renukoot");
		
		playerRepository.save(p1);// upsert method
		System.out.println("Record Inserted....");
	}

}
