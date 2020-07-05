package BUS;

import java.util.ArrayList;

import DAO.LoaiPhongDAO;
import DTO.LoaiPhong;

public class LoaiPhongBUS {
	public static ArrayList<LoaiPhong> loadDSLoaiPhong(){
		return LoaiPhongDAO.loadDSLoaiPhong();
	}
}
