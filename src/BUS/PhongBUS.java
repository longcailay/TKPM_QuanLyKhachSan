package BUS;

import java.util.ArrayList;

import DTO.ChiTietPhong;
import DTO.Phong;
import DAO.PhongDAO;
public class PhongBUS {
	public static ArrayList<Phong> LoadDSPhong(){
		return PhongDAO.LoadDSPhong();
	}
	
	public static ChiTietPhong LoadChiTietPhong(int idPhong) {
		return PhongDAO.LoadChiTietPhong(idPhong);
	}
}

