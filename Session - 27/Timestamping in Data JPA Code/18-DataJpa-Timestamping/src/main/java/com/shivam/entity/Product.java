package com.shivam.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT_MASTER")
public class Product {
	
	@Id
	@Column(name="PRODUCT_ID")
	private int pid;
	
	@Column(name="PRODUCT_NAME")
	private String pname;
	
	@Column(name="PRODUCT_PRICE")
	private Double price;
	
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable=false)
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable=false)
	private LocalDateTime updatedDate;
}
