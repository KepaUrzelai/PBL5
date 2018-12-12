package vehicles.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoVehiclesItemMySQL implements DaoVehiclesItem{

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "warehouse";
	String url = "jdbc:mysql://";
	String username = "root";
	String password = "";
	String connectionString = null;
	
	public DaoVehiclesItemMySQL(){
		this.connectionString = url + serverName + "/" + dataBaseName;
	}
	
	private void connect() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionString,
					username, password);
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {

			System.out.println("Connection Driver Error");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Could Not Connect to DB ");
		}
	}

	private void disconnect() {

		try {

			if (statement != null) {

				statement.clearWarnings();
				statement.close();
			}

			if (connection != null) {

				connection.clearWarnings();
				connection.close();
			}
		} catch (SQLException e) {

			System.out.println("Error disconnecting");
		}
	}
}


