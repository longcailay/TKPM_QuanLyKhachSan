package DataConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataProvider {
 	public boolean ExcuteNonQuery(String query)
    {
        boolean data = false;
        PreparedStatement stmt = null;
        DataConnection conn = null;
        try {
        	conn = DataConnection.getInstance();
        	conn.getConnection();
        	stmt = conn.prepareStatement(query);
        	data = stmt.execute();
        }catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn.getConnection() != null) {
				try {
					conn.getConnection().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
        return data;
    }
 	public ResultSet ExecuteQuery(String query) {
 		 ResultSet data = null;
         PreparedStatement stmt = null;
         DataConnection conn = null;
         try {
         	conn = DataConnection.getInstance();
         	conn.getConnection();
         	stmt = conn.prepareStatement(query);
         	data = stmt.executeQuery();
         }catch (Exception e) {
 			e.printStackTrace();
 		}finally {
 			if(stmt != null) {
 				try {
 					stmt.close();
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
 			}
 			if(conn.getConnection() != null) {
 				try {
 					conn.getConnection().close();
 				} catch (SQLException e) {
 					e.printStackTrace();
 				}
 			}
 		}
         return data;
 	}
	 
	
}
