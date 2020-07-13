package DAO;

import DataConnection.DataProvider;

public class KhachDAO {
	 public static int XoaKhachTheoID(int idKhach) {
		 int result = 0;
		 String query = "DELETE FROM KHACH WHERE ID = " + idKhach;
		 DataProvider dp = new DataProvider();
		 result = dp.ExcuteNonQuery(query);
		 return result;
	 }
}
