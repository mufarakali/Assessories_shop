package com.java.util.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.java.util.connect.DataConnect;
import com.java.util.model.shop;

public class shopdao {

	 Connection con;
	 PreparedStatement stat;
	 ResultSet rs1;
	 ResultSet rs2;
	 Scanner in=new Scanner(System.in);
	  public shopdao()
	  {
		  con=DataConnect.getConnection();
		  
	  }
	  public void insertProduct(shop s)
	  {
		  try
		  {
		   stat=con.prepareStatement("insert into products3 values(?,?,?,?)");
		   stat.setInt(1, s.getPid());
		   stat.setString(2,s.getPname());
		   stat.setInt(3,s.getQuantity());
		   stat.setInt(4,s.getPerunitrate());
		   
		   stat.executeUpdate();
		   System.out.print("record inserted successfully\n");
		  }
		  catch(Exception n)
		  {
			  System.out.print(n.getMessage());		  
		  }
		  
	  }
	  
	  
	  public void viewAllproducts()
	  {
		  try
		   {
			   stat=con.prepareStatement("select*from products3");
			   rs1=stat.executeQuery();
			   while(rs1.next())
			   {
				   System.out.println("product id:"+rs1.getInt(1));
				   System.out.println("product name:"+rs1.getString(2));
				   System.out.println("Available pieces:"+rs1.getInt(3));
				   System.out.println("perunitrate:"+rs1.getInt(4));
				   System.out.println(" ");
			   }
		   }
		      catch(Exception e)
		   
		         {
		    	  System.out.println(e.getMessage());
		    	  
		       }
	   }
	  
	  
	  public void deleteProduct(String nm2)
	    {
	  	  try
	  	  {
	  		  stat=con.prepareStatement("select pname from products3");
	            rs1=stat.executeQuery();
	  		  boolean flag=false;
	  		  while(rs1.next())
	  		  {
	  			 if(rs1.getString(1).equals(nm2)) 
	  			 {
	  				 flag=true;
	  			 }
	  			 stat=con.prepareStatement("delete from products3 where pname=?");
	  			 stat.setString(1,nm2);
	  			 stat.executeUpdate();
	  			 System.out.println("product removed successfully");
	  		  } 
	  		 if(flag==false)
	  		 {
	  			 System.out.println("product not found");			
	  		  }
	  	  }
	         catch(Exception m)
	         {
	      	   System.out.println(m.getMessage());
	         }
	    }
	  
	  
	  public void addTocart(shop s)
	  {
		        	
					System.out.println("Enter user name");
					String nm1=in.nextLine();
					System.out.println("Enter product Name:");
					String nm2=in.nextLine();
					System.out.println("Enter product id");
					int pid=in.nextInt();
					try
					{
						stat=con.prepareStatement("select pname from products3");
						rs1=stat.executeQuery();
						boolean flag=false;
						while(rs1.next())
						{
							if(rs1.getString(1).equals(nm2))
							{	
								flag=true;
								System.out.println("Enter how much Quantity you want:");
								int q=in.nextInt();
								
								stat=con.prepareStatement("select availablepieces from products3 where pname=?");
								stat.setString(1, nm2);
								ResultSet rs1=stat.executeQuery();
								boolean f=false;
								
								while(rs1.next())
								{
									if(q<=rs1.getInt(1))
									{
										f=true;
										System.out.println("Stock Availble ..");
										System.out.println("PRESS 1 to confirm order OR PRESS 2 to cancel:");
										int ch=in.nextInt();
										if(ch==1)
										{
											stat=con.prepareStatement("update products3 set availablepieces=availablepieces-? where pname=?");
											stat.setInt(1, q);
											stat.setString(2, nm2);
											stat.executeUpdate();
											
											stat=con.prepareStatement("select perunitrate from products3 where pname=?");
											stat.setString(1, nm2);
											ResultSet priceRS=stat.executeQuery();
											
											while(priceRS.next())
											{
												int priceperunit=priceRS.getInt(1);
												int totalprice=q*priceperunit;
												s.setUname(nm1);
										    	s.setPid(pid);
										    	s.setPname(nm2);
										        s.setQuantity(q);
										    	s.setTotalprice(totalprice);
												stat=con.prepareStatement("insert into orders3 values(?,?,?,?,?)");
											    stat.setString(1,s.getUname());
											    stat.setInt(2, s.getPid());
											    stat.setString(3,s.getPname());
											    stat.setInt(4,s.getQuantity());
											    stat.setInt(5,s.getTotalprice());
											    stat.executeUpdate();
											    System.out.print("order placed successfully");
											}
											
											
										}
										else if(ch==2)
										{
											System.out.println("Cancelled");
										}
										
									}
								}
								if(f==false)
								{
									System.out.println("electronics Out of Stock....");
								}
							}
						}
						if(flag==false)
						{
							System.out.println("electronic Not Found");
						}
					}
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
	  }
	  
	  
	  
    public void viewAllorders()
    {
  	  try
		   {
			   stat=con.prepareStatement("select*from orders3");
			   rs2=stat.executeQuery();
			   while(rs2.next())
			   {
				   System.out.println("user name"+rs2.getString(1));
				   System.out.println("product id:"+rs2.getInt(2));
				   System.out.println("product name:"+rs2.getString(3));
				   System.out.println("ordered pieces"+rs2.getInt(4));
				   System.out.println("Totalamount"+rs2.getInt(5));
			   }
			  
				  System.out.println("no order placed");
		   }
  	  
		      catch(Exception e)
		   
		         {
		    	  System.out.println(e.getMessage());
		         }
    }
}




