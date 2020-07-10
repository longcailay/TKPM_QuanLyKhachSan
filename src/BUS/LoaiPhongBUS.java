package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiPhongDAO;
import DTO.LoaiPhong;

public class LoaiPhongBUS {
	public static ArrayList<LoaiPhong> loadDSLoaiPhong(){
		return LoaiPhongDAO.loadDSLoaiPhong();
	}
	public static LoaiPhong loadLoaiPhongTheoTenPhong(String tenPhong) {
		if(tenPhong.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên phòng không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return LoaiPhongDAO.loadLoaiPhongTheoTenPhong(tenPhong);
	}
}
