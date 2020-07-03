package BUS;

import java.util.ArrayList;
import DTO.Phong;
import DAO.PhongDAO;
public class PhongBUS {
	public static ArrayList<Phong> LoadDSPhong(){
		return PhongDAO.LoadDSPhong();
	}
}

