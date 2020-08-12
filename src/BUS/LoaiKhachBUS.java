package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiKhachDAO;
import DTO.LoaiKhach;
import WSPACE.wsCaiDat;

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
	
	public static int ThemLoaiKhach(String tenLoai, String phuThu) {
		if(tenLoai.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên loại không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			for(LoaiKhach loaiKhach: wsCaiDat.listLoaiKhach) {
				if(loaiKhach.getTenLoai().equals(tenLoai)) {
					JOptionPane.showMessageDialog(null, "Tên loại đã tồn tại!", "Warning!", JOptionPane.WARNING_MESSAGE);
					return -1;
				}
			}
		}
		
		
		if(phuThu.isBlank()) {
			JOptionPane.showMessageDialog(null, "Phụ thu không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		else {
			try {
				Double.valueOf(phuThu);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Phụ thu không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -2;
			}
			if(Double.valueOf(phuThu) < 0.0) {
				JOptionPane.showMessageDialog(null, "Phụ thu không không phải số âm!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -2;
			}
		}
		JOptionPane.showMessageDialog(null, "Thêm loại khách thành công!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
		
		return LoaiKhachDAO.ThemLoaiKhach(tenLoai, Double.valueOf(phuThu));
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
	
	public static int CapNhatLoaiKhach(String maLoai, String tenLoai, String phuThu) {
		if(maLoai.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại khách!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			if(tenLoai.isBlank()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại khách!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
			else {
				//Kiểm tra tên loại đã tồn tại chưa
				
//				for(int i = 0; i < wsCaiDat.listLoaiKhach.size(); i++) {
//					LoaiKhach loaiKhach = wsCaiDat.listLoaiKhach.get(i);
//					if(loaiKhach.equals(tenLoai) && i != wsCaiDat.tbLoaiKhach.getSelectedRow()+1) {
//						JOptionPane.showMessageDialog(null, "Tên này đã tồn tại!", "Warning!", JOptionPane.WARNING_MESSAGE);
//						return -1;
//					}
//				}
			}
			
			
			if(phuThu.isBlank()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập phụ thu!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
			else {
				try {
					Double.valueOf(phuThu);
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, "Phụ thu không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
					return -1;
				}
				if(Double.valueOf(phuThu) < 0.0) {
					JOptionPane.showMessageDialog(null, "Phụ thu không không phải số âm!", "Warning!", JOptionPane.WARNING_MESSAGE);
					return -1;
				}
			}
			LoaiKhach loaiKhach = new LoaiKhach(Integer.valueOf(maLoai), tenLoai, Double.valueOf(phuThu));
			if(LoaiKhachDAO.CapNhatLoaiKhach(loaiKhach) != -1) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return 1;
	}
}
