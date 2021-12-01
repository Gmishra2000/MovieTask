
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class TheMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DbConnection.connect();
//		insert("Benson", "Karue", "benson@test.com",2011, "myPassword");
		insert(" The Lord of the Rings","Elijah Wood","Angela Bassett",2003,"Peter Jackson");
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

}
