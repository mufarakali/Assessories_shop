package com.java.util.client;

import java.util.Scanner;

import com.java.util.service.shopservice;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("MHD Electronics");
		System.out.println("******1.Logitech Mouse********");
		System.out.println("******2.Keyboards********");
		System.out.println("******3.Sandisk 16 GB*******");
		System.out.println("********4.Pendrive 32 GB*******");
        System.out.println("*******5.Canon Digital Cameras********");
        System.out.println("********6.Zebronic Speakers*******");
        shopservice obj=new shopservice();
        Scanner sc=new Scanner(System.in);
        
        
        while(true)
        	
        {    
        	 System.out.println("choice 1--->to add a product\n" );
    	     System.out.println("choice 2-->to show all the products\n");
    	     System.out.println("choice 3--->to delete a product\n");
    	     System.out.println("choice 4-->to place an order or to buy a new product\n");
    	    System.out.println("choice 5--->to show all the orders\n");    	   
    	    
    	   
    	    System.out.println("Enter your choice\n");
    	    int choice=sc.nextInt();
    	    if(choice==1)
    	    {
    	      obj.addProducts();
    		}
    	    else if(choice==2)
    	    {
    	    	obj.allProducts();
    	    }
    	    else if(choice==3)
    	    {
    	    	 obj.delProducts();	  
    	    	
    	    }
    	    else if(choice==4)
    	    {
    	    	obj.buyProduct();    	
    	    }
    	    else if(choice==5)
    	    {
    	    	obj.allOrders();
    	    }
    	    else
    	    {
    	       System.out.println("Invalid choice");
    	    }
        }
	}
}