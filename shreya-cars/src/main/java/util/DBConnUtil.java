/*package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
	
	public static Connection getConnection(String connectionString) {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}*/



package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnUtil 
{
	public static Connection getConnection(String connString)
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Loaded..");
		con=DriverManager.getConnection(connString);
		//System.out.println(connString);
		
			//con=DriverManager.getConnection(("jdbc:mysql://localhost:3306/crimereportingsystem?user=root&password=anshu@6377"));
			System.out.println("Connected...");
		}catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Driver Loading Failed");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			System.out.println("Not Connected to Database");
		}
		return con;
	}
	public static void main(String[] args) 
	{
		String connString=DBPropertyUtil.getConnectionString("db.Properties");
		Connection con=getConnection(connString);
		System.out.print(con);
		//Connection con=getDBConn("jdbc:mysql://localhost:3306/crimereportingsystem?user=root&password=anshu@6377");
		//System.out.println(con);
	}
}
