
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class TheMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DbConnection.connect();

//		insert(" The Lord of the Rings","Elijah Wood","Angela Bassett",2003,"Peter Jackson");
		readAllData();
	}
	
	private static void insert(String movieName, String leadActor, String actressName,int yearOfRelease, String directorName) {
		  Connection con = DbConnection.connect();
		  PreparedStatement ps = null; 
		  try {
		    String sql = "INSERT INTO movies(movieName, leadActor,actressName,yearOfRelease, directorName) VALUES(?,?,?,?,?) ";
		    ps = con.prepareStatement(sql);
		    ps.setString(1, movieName);
		    ps.setString(2, leadActor);
		    ps.setString(3, actressName);
		    ps.setInt(4, yearOfRelease);
		    ps.setString(5, directorName);
		    ps.execute();
		    System.out.println("Data has been inserted!");
		  } catch(SQLException e) {
		    System.out.println(e.toString());
		    // always remember to close database connections
		  } finally {
		    try{
		      ps.close();
		      con.close();
		    } catch(SQLException e) {
		      System.out.println(e.toString());
		    }
		    
		  }
		}

	
	private static void readAllData() {
	    Connection con = DbConnection.connect(); 
	    PreparedStatement ps = null; 
	    ResultSet rs = null; 
	    
	    try {
	      String sql = "SELECT * FROM movies";
	      ps = con.prepareStatement(sql); 
	      rs = ps.executeQuery();
	      System.out.println("ALL TOP MOVIES\n");
	      while(rs.next()) {
	        String movieName = rs.getString("movieName"); 
	        String leadActor = rs.getString("leadActor"); 
	        String actressName = rs.getString("actressName"); 
	        int yearOfRelease = rs.getInt("yearOfRelease"); 
	        String directorName = rs.getString("directorName");
	        
	        
	        System.out.println("Movie Name: "+movieName);
	        System.out.println("Lead Actor: "+leadActor);
	        System.out.println("Actress Name: "+actressName);
	        System.out.println("Year Of Release: "+yearOfRelease);
	        System.out.println("Director Name: " +directorName+"\n\n");
	        
	      }
	    } catch(SQLException e) {
	      System.out.println(e.toString());
	    } finally {
	      try {
	        rs.close();
	        ps.close();
	        con.close(); 
	      } catch(SQLException e) {
	        System.out.println(e.toString());
	      }
	    }
	    
	    
	  }
}
