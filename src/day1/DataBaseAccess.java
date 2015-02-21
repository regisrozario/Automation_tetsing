package day1;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseAccess {

	public static void main(String[] args) {
	
		try{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// C:\\databaseFileName.accdb" - location of your database 
		String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + "E:\\New folder\\Contact_Info.accdb";

		// specify url, username, pasword - make sure these are valid 
		Connection conn = DriverManager.getConnection(url, "username", "password");
		
		Statement s = conn.createStatement();
		String queryStatement = "SELECT * FROM Emp_info WHERE Company='Wipro'";
		s.executeQuery(queryStatement);
		ResultSet result = s.getResultSet();
		ResultSetMetaData rsmd = result.getMetaData();

		while(result.next()){
		System.out.println(result.getRow());
		System.out.println(rsmd.getColumnCount());
		
		for (int i=1; i<=rsmd.getColumnCount(); i++){
			System.out.println(result.getString(i));
		}
		}
		} catch (Exception e) {
		System.err.println("Got an exception! ");
		System.err.println(e.getMessage());
		}

}
}
