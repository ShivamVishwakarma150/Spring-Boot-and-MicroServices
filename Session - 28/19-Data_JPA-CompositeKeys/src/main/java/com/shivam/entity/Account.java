package com.shivam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="BANK_ACCOUNTS")
public class Account {
	
	@Column(name="BRANCH_NAME")
	private String branchName;
	
	@Column(name="MIN_BAL")
	private Double minBal;
	
	@EmbeddedId
	private AccountPK accPk;
}
