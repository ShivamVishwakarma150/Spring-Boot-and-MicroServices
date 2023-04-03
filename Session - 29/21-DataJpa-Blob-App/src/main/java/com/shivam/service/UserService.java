package com.shivam.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.entity.User;
import com.shivam.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public void saveUser() throws IOException {
		String imagePath="D:\\user.png";
		User user= new User();
		user.setUserName("Suresh");
		user.setUserEmail("Suresh@gmail.com");
		long size=Files.size(Paths.get(imagePath));
		System.out.println(size);
		byte[] arr=new byte[(int)size];
		FileInputStream fis =new FileInputStream(new File(imagePath));
		
		fis.read(arr);
		fis.close();
		
		user.setUserImage(arr);
	
		
		userRepo.save(user);
	}
}
