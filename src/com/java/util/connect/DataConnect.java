package com.java.util.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {

	private static Connection con;
    public DataConnect()
    {
 	   try
 	   {
 	     Class.forName("com.mysql.jdbc.Driver");   
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebuy","root","Y1012Jqkhkp");
         System.out.print("done");
       }
 	   catch(Exception m)
 	   {
 		System.out.print(m.getMessage());   
 	   }
 	   }
public static Connection getConnection()
{
	 DataConnect d=new DataConnect();
	 return(con);
}

}


