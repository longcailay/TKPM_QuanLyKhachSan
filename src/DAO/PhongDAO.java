package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.Phong;
import DataConnection.DataProvider;

public class PhongDAO {
	public static ArrayList<Phong> LoadDSPhong() throws SQLException{
		ArrayList<Phong> result = new ArrayList<Phong>();
		String query = "exec pro_LoadDSPhong";
		DataProvider dp = new DataProvider();
		ResultSet resultSet = dp.ExecuteQuery(query);
		do {//int id, String tenPhong, String loaiPhong, String ghiChu, int tinhTrang
			Phong phong = new Phong((int)resultSet.getInt("ID"), resultSet.getString("TenPhong"),resultSet.getString("LoaiPhong"),resultSet.getString("GhiChu"),(int)resultSet.getInt("TinhTrang"));
			result.add(phong);
		}while(resultSet.next());
		return result;
	}
	
}
