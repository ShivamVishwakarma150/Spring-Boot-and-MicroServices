package com.shivam.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shivam.entity.Account;
import com.shivam.entity.AccountPK;
import com.shivam.repo.AccountRepository;

@Service
public class AccountService {
	private AccountRepository accRepo;
	
	public AccountService(AccountRepository accRepo) {
		this.accRepo = accRepo;
	}
	public void getDataUsingPK() {

		AccountPK pk = new AccountPK(); 

		pk.setAccId(104);
		pk.setAccType("SAVINGS");
		pk.setHolderName("IBM");

		Optional<Account> findById = accRepo.findById(pk); 

		if (findById.isPresent()) {
			System.out.println(findById.get());
		}

	}
	public void saveAccData() {
		AccountPK pk = new AccountPK();
		
		pk.setAccId(104);
		pk.setAccType("SAVINGS");
		pk.setHolderName("IBM");
		
		Account acc = new Account();
		acc.setMinBal(4000.00);
		acc.setBranchName("Mumbai");
		
		acc.setAccPk(pk); // setting pk class obj to entity obj
		
		accRepo.save(acc);
	}
}
