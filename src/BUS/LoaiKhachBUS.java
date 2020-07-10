package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiKhachDAO;
import DTO.LoaiKhach;

public class LoaiKhachBUS {
	public static ArrayList<LoaiKhach> loadDSLoaiKhach(){
		return LoaiKhachDAO.loadDSLoaiKhach();
	}
	public static int ThemKhach(String hoTen, String cmnd, String diaChi, String tenLoaiKhach) {
		if(hoTen.isBlank()){
			JOptionPane.showMessageDialog(null, "Tên khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(KiemTraCMNDHopLe(cmnd) == false) {
			JOptionPane.showMessageDialog(null, "Số CMND không hợp lệ!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(cmnd.length() < 10 || cmnd.length() > 20) {
			JOptionPane.showMessageDialog(null, "Số chữ số của CMND nằm trong khoản 10 -> 20 chữ số!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		if(diaChi.isBlank()){
			JOptionPane.showMessageDialog(null, "Địa chỉ khách không được bỏ trống!","Warning", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		return LoaiKhachDAO.ThemKhach(hoTen, cmnd, diaChi, tenLoaiKhach);
	}
	private static boolean KiemTraCMNDHopLe(String cmnd) {
		boolean result = true;
		for(int i = 0; i < cmnd.length(); i++) {
			char c = cmnd.charAt(i);
			if( !( c >= '0' && c <= '9' ) ) {// c nằm ngoài khoản (0,9)
				return false;
			}
		}
		return result;
	}
	
	public static int LoadMaLoaiKhachTheoTenLoaiKhach(String tenLoaiKhach) {
		return LoaiKhachDAO.LoadMaLoaiKhachTheoTenLoaiKhach(tenLoaiKhach);
	}
	
	public static LoaiKhach LoadLoaiKhachTheoID(int id) {
		if(id < 0) {
			JOptionPane.showMessageDialog(null, "ID loại khách không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return null;
		}
		return LoaiKhachDAO.LoadLoaiKhachTheoID(id);
	}
}
