package com.springrest.wallet.resources;

public class CustomerWallet {
	private Integer custId;
	private Double Balance;
	
	public CustomerWallet(Integer custId, Double balance) {
		super();
		this.custId = custId;
		this.Balance = balance;
	}
	
	public CustomerWallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "CustomerWallet [custId=" + custId + ", Balance=" + Balance + "]";
	}

	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	public Double getBalance() {
		return Balance;
	}

	public void setBalance(Double balance) {
		this.Balance = balance;
	}

	
}