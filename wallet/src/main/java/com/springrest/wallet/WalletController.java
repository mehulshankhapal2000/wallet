package com.springrest.wallet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.wallet.resources.CustomerWallet;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RestController
public class WalletController {
	
	ArrayList<CustomerWallet> wallet = new ArrayList<CustomerWallet>();
	
	
	@PostMapping("/addBalance")
	public HttpStatus addBalance(@RequestBody CustomerWallet customer)
	{
		for(CustomerWallet cust : wallet)
		{
			if(cust.getCustId().intValue() == customer.getCustId().intValue())
			{
				cust.setBalance(cust.getBalance() + customer.getBalance());
				return HttpStatus.CREATED;
			}
		}
		return HttpStatus.GONE;
	}
	
	@PostMapping("/deductBalance")
	public HttpStatus deductBalance(@RequestBody CustomerWallet customer)
	{
		for(CustomerWallet cust : wallet)
		{
			if(cust.getCustId().intValue() == customer.getCustId().intValue())
			{
				if(cust.getBalance() < customer.getBalance())
					return HttpStatus.GONE;
				cust.setBalance(cust.getBalance() - customer.getBalance());
				return HttpStatus.CREATED;
			}
		}
		return HttpStatus.GONE;
	}
	
	@GetMapping("/balance/{num}")
	public CustomerWallet balance(@PathVariable Integer num)
	{
		for(CustomerWallet cust : wallet)
		{
			if(cust.getCustId().intValue() == num)
			{
				return cust;
			}
		}
		return null;
	}
	
	@PostMapping("/reInitialize")
	public HttpStatus reInitialize() throws FileNotFoundException
	{	
		File myFile = new File("D:\\Documents\\IISc\\Courses\\Principles of Distributed Software\\Programming\\Spring Project\\wallet\\initialData.txt");
		Scanner s1 = null;
		try 
		{
			s1 = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Scanner s2 = new Scanner(myFile);
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		String str1 = s2.nextLine();
		Double bal = Double.parseDouble(str1);
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
			CustomerWallet cust = new CustomerWallet(Integer.parseInt(str), bal);
			wallet.add(cust);
		}

		return HttpStatus.CREATED;	
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public HttpStatus StartUp() throws FileNotFoundException
	{
		File myFile = new File("D:\\Documents\\IISc\\Courses\\Principles of Distributed Software\\Programming\\Spring Project\\wallet\\initialData.txt");
		Scanner s1 = null;
		try 
		{
			s1 = new Scanner(myFile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		Scanner s2 = new Scanner(myFile);
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s2.hasNextLine()) {
			String str = s2.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		String str1 = s2.nextLine();
		Double bal = Double.parseDouble(str1);
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}	
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
		}
		
		while(s1.hasNextLine()) {
			String str = s1.nextLine();
			if(str.charAt(0) == '*') {
				break;
			}
			CustomerWallet cust = new CustomerWallet(Integer.parseInt(str), bal);
			wallet.add(cust);
		}

		return HttpStatus.CREATED;
	}
	
	@GetMapping("/showData")
	public ArrayList<CustomerWallet> showData()
	{
		return wallet;
	}

	@PostMapping("/addData")
	public HttpStatus addData(@RequestBody CustomerWallet customer)
	{
		wallet.add(customer);
		return HttpStatus.CREATED;
	}
}
