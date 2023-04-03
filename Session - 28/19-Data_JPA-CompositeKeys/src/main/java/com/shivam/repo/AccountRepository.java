package com.shivam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivam.entity.Account;
import com.shivam.entity.AccountPK;

public interface AccountRepository extends JpaRepository<Account, AccountPK>  {

}
