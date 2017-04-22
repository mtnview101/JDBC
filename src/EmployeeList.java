// Class EmployeeList displays Employees from the table EMP 
// using JDBC drivers of type 4

import java.sql.*;

public class EmployeeList {

  public static void main(String argv[]) {
   Connection conn=null;
   Statement stmt=null;
   ResultSet rs=null;
   

   try {
    // Load the JDBC driver  
	// This can be skipped for Derby, but derbyclient.jar has to be in the CLASSPATH   
    // Class.forName("org.apache.derby.jdbc.ClientDriver");
 
	conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/db_test","root","m249");
	  // conn = DriverManager.getConnection( "jdbc:derby://localhost:1527/Lesson22");
    //conn = DriverManager.getConnection( "jdbc:derby:Lesson22"); 

    // Build an SQL String 
    //String sqlQuery = "SELECT * from Country"; 
	String sqlQuery = "show tables"; 
    // Create a Statement object
    stmt = conn.createStatement(); 

    // Execute SQL and get obtain the ResultSet object
    rs = stmt.executeQuery(sqlQuery);
    System.out.println("Tables_in_db_test");
    System.out.println("-----------------");
    while (rs.next()){ 
    	System.out.println(rs.getString("Tables_in_db_test"));
    }

    // Process the result set - print Employees
/*    while (rs.next()){ 
    	 int empNo = rs.getInt("EMPNO");
       	 String eName = rs.getString("ENAME");
         String job = rs.getString("JOB_TITLE");
   	 int empNo = rs.getInt("Population");
   	 String eName = rs.getString("Name");
     String job = rs.getString("Code");
	     System.out.println(""+ empNo + ", " + eName + ", " + job ); 
    }*/

   } catch( SQLException se ) {
      System.out.println ("SQLError: " + se.getMessage ()
           + " code: " + se.getErrorCode ());

   } catch( Exception e ) {
      System.out.println(e.getMessage()); 
      e.printStackTrace(); 
   } finally{
       // clean up the system resources
       try{
	   rs.close();     
	   stmt.close(); 
	   conn.close();  
       } catch(Exception e){
           e.printStackTrace();
       } 
   }
}
}
