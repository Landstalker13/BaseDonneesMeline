
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.*;

public class PlayersDB {


	public void printAllData()
	{
		System.out.println("-------- MySQL JDBC Connection Testing ------------");


		Connection connection = null;

		try {
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/nemox", "root", "");

		} catch (SQLException e) {
			for(Throwable ex : e) {
				System.err.println("Error occurred " + ex);
			}
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("Connected to database!");
		} else {
			System.out.println("Failed to make connection!");
		}

		try {
			Statement stmt = (Statement) connection.createStatement();
			String query = "select * from player ;";
			//person is the table name
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String id = rs.getObject(1).toString();
				String capacity = rs.getObject(2).toString();
				String name = rs.getObject(3).toString();
				System.out.println(id +"	"+  name + "	\t" + capacity);
				//Person table has name and gender column

			}
		} catch (SQLException e) {
			e.printStackTrace();
			for(Throwable ex : e) {
				System.err.println("Error occurred " + ex);
			}
			System.out.println("Error in fetching data");
		}





	}

	public static void main(String[] args) {
		PlayersDB db = new PlayersDB();
		db.printAllData();

	}

}
