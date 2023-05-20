package com.shivam.model;

/**
 * This class serving as model to hold data
 * @author Shivam
 *
 */
public class Customer {

	private Integer customerId;
	private String customerName;
	private String customerEmail;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param customerId
	 * @param customerName
	 * @param customerEmail
	 */
	public Customer(Integer customerId, String customerName, String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + "]";
	}

}
