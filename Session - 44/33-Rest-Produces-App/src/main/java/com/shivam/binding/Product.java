package com.shivam.binding;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Product {
	private Integer pid;
	private String pname;
	private Double price;
}
