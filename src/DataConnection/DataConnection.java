package DataConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class DataConnection {
    private static DataConnection instance;
    private Connection connection;
    private String url = "jdbc:sqlserver://localhost;databaseName=QuanLyKhachSan1";
    private String username = "sa";
    private String password = "05111998";

    private DataConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataConnection();
        }

        return instance;
    }

	public Statement createStatement(int typeScrollSensitive, int concurUpdatable) {
		Statement result = null;
		try {
			result = connection.createStatement(typeScrollSensitive, concurUpdatable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public PreparedStatement prepareStatement(String query) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
    
}