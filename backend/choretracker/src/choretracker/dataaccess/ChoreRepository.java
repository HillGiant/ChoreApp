package choretracker.dataaccess;

import choretracker.dataaccess.records.ChoreRecord;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ChoreRepository {
	// JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5432/ChoreTracker";
   static final String USER = "Service";
   static final String PASS = "TacoSoup";
   
   public List<ChoreRecord> GetChores()
   {
	   Connection conn = null;
	   Statement stmt = null;
	   
	   try{
		      Class.forName(JDBC_DRIVER);
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * FROM \"Chore\"";
		      ResultSet rs = stmt.executeQuery(sql);
		      
		      ArrayList<ChoreRecord> records = new ArrayList<ChoreRecord>();
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("ChoreId");
		         String title = rs.getString("Title");
		         Date dueBy = rs.getDate("DueBy");
		         records.add( new ChoreRecord(id, title, dueBy));
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		      return records;
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	   return null;
   }
}
