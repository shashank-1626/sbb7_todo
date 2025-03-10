package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {

	static Connection con;
	public static Connection getConn() throws Exception {
		// load JDBC driver
		Class.forName("com.mysql.jdbc.Driver");
		// establish Connection to DB
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sbb7_todo", "root", "");
		return con;
	}
}
