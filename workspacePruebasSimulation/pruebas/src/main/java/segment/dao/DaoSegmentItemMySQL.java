package segment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import clases.Line;
import clases.Parking;
import clases.Segment;
import clases.Workstation;

public class DaoSegmentItemMySQL implements DaoSegmentItem{

	Connection connection = null;
	Statement statement = null;
	String serverName = "localhost";
	String dataBaseName = "warehouse";
	String url = "jdbc:mysql://";
	String zonaValue = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	String username = "root";
	String password = "";
	String connectionString = null;
	
	public DaoSegmentItemMySQL(){
		this.connectionString = url + serverName + "/" + dataBaseName+zonaValue;
	}
	
	private void connect() {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
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

	public Segment findSegmentByID() {//not done
		connect();
		
		
		disconnect();
		return null;
	}

	public boolean saveSegment(Segment segment) {//not done
		boolean ret=false;
		if(segment.getClass().equals(Workstation.class)) ret=saveWorkstation((Workstation)segment);
		else if(segment.getClass().equals(Parking.class)) ret=saveParking((Parking)segment);
		else ret=saveLine((Line)segment);				
		return ret;
	}
	
	private boolean saveLine(Line segment) {
		boolean ret = false;
		String sqlQuery = "INSERT INTO segment (segmentId,state,NextlineId,Nextline2Id,role) "+
		"VALUES("
		+ "'"+segment.getID()+"',"
		+ "'"+0+"',"
		+ "'"+segment.getNextSegment()+"',"
		+ "'"+segment.getNextSegment2()+"',"
		+ "'"+0+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;			
	}
	private boolean saveWorkstation(Workstation segment) {
		boolean ret = false;
		String sqlQuery = "INSERT INTO segment (segmentId,state,correspondentLineId,name,role) "+
		"VALUES("
		+ "'"+segment.getID()+"',"
		+ "'"+0+"',"
		+ "'"+segment.getCorrespondientLineId()+"',"
		+ "'"+segment.getName()+"',"
		+ "'"+1+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;			
	}
	private boolean saveParking(Parking segment) {
		boolean ret = false;
		String sqlQuery = "INSERT INTO segment (segmentId,state, correspondentLineId, name, role) "+
		"VALUES("
		+ "'"+segment.getID()+"',"
		+ "'"+0+"',"
		+ "'"+segment.getCorrespondientLineId()+"',"
		+ "'"+segment.getName()+"',"
		+ "'"+2+"'"
		+ ")";
		System.out.println(sqlQuery);
		
		connect();
		try{
			Statement stm = connection.createStatement();
			if(stm.executeUpdate(sqlQuery)>0){
				ret=true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		disconnect();
		return ret;			
	}
}
