package DAO;

import DataConnection.DataProvider;

public class TraPhongDAO {
	public static int TraPhong(int idPhong) {
		int result;
		String query = "pro_TraPhong " + idPhong;
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
}
