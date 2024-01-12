package banking_pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnectionPart {
	private static final JDBCConnectionPart INSTANCE = new JDBCConnectionPart();
	private Connection connection = null;

	private JDBCConnectionPart() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/bca", "root", "");
			System.out.println("Connection Success....................");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static JDBCConnectionPart getInstance() {
		return INSTANCE;
	}

	public static void save(String firstname, String lastname, String username, String password, String address, String contact, String gender, String balance)
	 {
		try {
		
			Connection connection = JDBCConnectionPart.getInstance().getConnection();
		
			Statement statement = connection.createStatement();

            String query = "INSERT INTO account(first_name, last_name, username, password, address, contact, gender, balance) values('" + firstname + "','" + lastname + "','" + username + "','" + password + "','" + address + "','" +
            		contact + "','" + gender + "','" + balance + "')";

			statement.executeUpdate(query);
			System.out.println("Insert Successful........");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}

	public static List<Map<String, String>> getList() {
		List<Map<String, String>> data = new ArrayList<Map<String, String>>();
		try {
			Connection connection = JDBCConnectionPart.getInstance().getConnection();
		
			Statement statement = connection.createStatement();
		
			String selectQuery = "select * from account";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
		
			while(resultSet.next()) {
				String sNo = resultSet.getString(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String username = resultSet.getString(4);
				String password = resultSet.getString(5);
				String address = resultSet.getString(6);
				String contact = resultSet.getString(7);
				String gender = resultSet.getString(8);
				String balance = resultSet.getString(9);
			
				Map<String, String> record = new HashMap<String, String>();
				record.put("sNo", sNo);
				record.put("firstname", firstName);
				record.put("lastname", lastName);
				record.put("username", username);
				record.put("password", password);
				record.put("address", address);
				record.put("contact", contact);
				record.put("gender", gender);
				record.put("balance", balance);
			
				data.add(record);
			}
		
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return data;
	}
}

