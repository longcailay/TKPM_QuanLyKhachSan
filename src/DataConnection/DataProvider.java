package DataConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DataProvider {
	/** Khởi tạo biến thực hiện kết nối tới cơ sở dữ liệu. */
	private Connection conn;
	
	private Connection getConnection() {
		try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QuanLyKhachSan1;user=sa;password=05111998");
		} catch (ClassNotFoundException e) {
			System.err.println("Không tìm thấy class.");
		} catch (SQLException e) {
			System.err.println("Lỗi kết nối cơ sở dư liệu.");
		}
		if (conn == null) {
			throw new NullPointerException("Kết nối không thành công.");
		}
		return conn;
	}
	
//	public int countRecord(String tblName) {
//		int numberRecord = 0;
//		ResultSet resultSet = null;
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		// Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
//		StringBuffer sbCommand = new StringBuffer("select count(*)");
//		sbCommand.append(" from ");
//		sbCommand.append(tblName);
//		try {
//			connection = getConnection();
//			preparedStatement = conn.prepareStatement(sbCommand.toString());
//			resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				numberRecord = resultSet.getInt(1);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				resultSet.close();
//				preparedStatement.close();
//				connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return numberRecord;
//	}
	
	/*Nguồn: https://stackoverflow.com/questions/10620448/most-simple-code-to-populate-jtable-from-resultset*/
	private DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	
	public JTable ExcuteQuery(String query) {
		JTable result = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// Khởi tạo đối tượng chứa câu lệnh thực hiện tìm kiếm dữ liệu.
		StringBuffer sbCommand = new StringBuffer(query);
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sbCommand.toString());
			resultSet = preparedStatement.executeQuery();
			result = new JTable(buildTableModel(resultSet));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	 public int ExcuteNonQuery(String query)
     {
         int data = 0;
         PreparedStatement preparedStatement = null;
         Connection connection = null;
         StringBuffer sbCommand = new StringBuffer(query);
         try {
        	 connection = getConnection();
        	 preparedStatement = conn.prepareStatement(sbCommand.toString());
        	 data = preparedStatement.executeUpdate();
         }catch (Exception e) {
			// TODO: handle exception
        	 e.printStackTrace();
		}finally {
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
         return data;
     }
}