package test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestH2JDBC {

    public   static   void  main(String[] a)throws  Exception {  
	    Class.forName("com.mysql.jdbc.Driver" );  
	    Connection conn = DriverManager.  
	    getConnection("jdbc:mysql://localhost:3306/auction" ,  "root" ,  "root" );  
	    // add application code here
	    System.out.println(conn);
    }  
 
}
