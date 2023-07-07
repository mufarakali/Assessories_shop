package com.java.util.service;

import java.util.Scanner;

import com.java.util.dao.shopdao;
import com.java.util.model.shop;

public class shopservice {

	   Scanner sc;
	   public shopdao sdao;
	   public shop s;
	   public shopservice()
	   {
		   s=new shop();
		   sc=new Scanner(System.in);
		   sdao=new shopdao();
	   }
	   
	   
	   public void addProducts()
	    {
	    	    System.out.println("Enter the product id");
		    	int pid=sc.nextInt();
		    	System.out.println("Enter the product name");
		    	sc.nextLine();
		    	String pname=sc.nextLine();
		    	System.out.println("Enter the quantity");
		    	int q =sc.nextInt();
		    	System.out.println("Enter the rate");
		    	int perunitrate=sc.nextInt();
		    	shop s=new shop();
		    	s.setPid(pid);
		    	s.setPname(pname);
		        s.setQuantity(q);
		        s.setPerunitrate(perunitrate);
		        sdao.insertProduct(s);
	    }
	   
	   
	   public void allProducts()
	   {
		   sdao.viewAllproducts();
	   }
	     
	   
	   public void delProducts()
	    {
	    	 System.out.println("enter the product name you want to delete");
	    	 String nm2=sc.nextLine();
	    	 sdao.deleteProduct(nm2); 	
	    }
	   
	   
	   public void buyProduct()
	    {
	    	
	    	sdao.addTocart(s);
	    }
	   
	   
	    public void allOrders()
	   {
		   sdao.viewAllorders();
	   }
	  
  }	    	
	    
	
	    	
	    	
	    
