package BUS;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.LoaiKhachDAO;
import DAO.LoaiPhongDAO;
import DTO.LoaiKhach;
import DTO.LoaiPhong;
import WSPACE.wsCaiDat;

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
	
	public static int CapNhatLoaiPhong(String maLoai, String tenLoai, String donGia, String soKhachBT, String soKhachTD, String phuThu) {
		if(maLoai.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn loại phòng!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		if(tenLoai.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên loại phòng!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			//Kiểm tra tên loại đã tồn tại chưa???
			

		}
		
		if(donGia.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đơn giá!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			try {
				Double.valueOf(donGia);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
			if(Double.valueOf(donGia) < 0.0) {
				JOptionPane.showMessageDialog(null, "Đơn giá không không phải số âm!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
		}
		
		if(soKhachBT.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng khách bình thường!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			try {
				Integer.valueOf(soKhachBT);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Số khách bình thường không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
			if(Integer.valueOf(soKhachBT) < 1) {
				JOptionPane.showMessageDialog(null, "Số khách bình thường không nhỏ hơn 1!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
		}
		
		
		if(soKhachTD.isBlank()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng khách tối đa!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			try {
				Integer.valueOf(soKhachTD);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Số khách tối đa không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
			if(Integer.valueOf(soKhachTD) < Integer.valueOf(soKhachBT)) {
				JOptionPane.showMessageDialog(null, "Số khách tối không nhỏ hơn số khách bình thường!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -1;
			}
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
		
		LoaiPhong loaiPhong = new LoaiPhong(Integer.valueOf(maLoai), tenLoai, BigDecimal.valueOf(Double.valueOf(donGia)), Integer.valueOf(soKhachBT), Integer.valueOf(soKhachTD), Double.valueOf(phuThu));
		if(LoaiPhongDAO.CapNhatLoaiPhong(loaiPhong) != -1) {
			JOptionPane.showMessageDialog(null, "Cập nhật loại phòng thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return 1;
	}
	
	
	public static int ThemLoaiPhong(String tenLoai, String donGia, String slkbt, String slktd, String phuThu) {
		if(tenLoai.isBlank()) {
			JOptionPane.showMessageDialog(null, "Tên loại không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		else {
			for(LoaiPhong loaiPhong: wsCaiDat.listLoaiPhong) {
				if(loaiPhong.getTenLoai().equals(tenLoai)) {
					JOptionPane.showMessageDialog(null, "Tên loại đã tồn tại!", "Warning!", JOptionPane.WARNING_MESSAGE);
					return -1;
				}
			}
		}
		
		if(slkbt.isBlank()) {
			JOptionPane.showMessageDialog(null, "Số khách bình thường không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -3;
		}
		else {
			try {
				Integer.valueOf(slkbt);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Số khách bình thường không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -3;
			}
			if(Integer.valueOf(slkbt) < 1) {
				JOptionPane.showMessageDialog(null, "Số khách bình thường phải > 0!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -3;
			}
		}
		
		if(slktd.isBlank()) {
			JOptionPane.showMessageDialog(null, "Số khách tối đa không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -4;
		}
		else {
			try {
				Integer.valueOf(slktd);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Số khách tối đa không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -4;
			}
			if(Integer.valueOf(slktd) < Integer.valueOf(slkbt)) {
				JOptionPane.showMessageDialog(null, "Số khách tối đa không bé hơn số khách bình thường!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -4;
			}
		}
		
		if(donGia.isBlank()) {
			JOptionPane.showMessageDialog(null, "Đơn giá không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -2;
		}
		else {
			try {
				Double.valueOf(donGia);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Đơn giá không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -2;
			}
			if(Double.valueOf(donGia) < 0.0) {
				JOptionPane.showMessageDialog(null, "Đơn giá không phải số âm!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -2;
			}
		}
		
		
		
		if(phuThu.isBlank()) {
			JOptionPane.showMessageDialog(null, "Phụ thu không được bỏ trống!", "Warning!", JOptionPane.WARNING_MESSAGE);
			return -5;
		}
		else {
			try {
				Double.valueOf(phuThu);
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "Phụ thu không hợp lệ!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -5;
			}
			if(Double.valueOf(phuThu) < 0.0) {
				JOptionPane.showMessageDialog(null, "Phụ thu không không phải số âm!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return -5;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Thêm loại phòng thành công!", "Warning!", JOptionPane.INFORMATION_MESSAGE);
		LoaiPhong lp = new LoaiPhong(-1, tenLoai,BigDecimal.valueOf(Double.valueOf(donGia)), Integer.valueOf(slkbt), Integer.valueOf(slktd),Integer.valueOf(phuThu));
		
		return LoaiPhongDAO.ThemLoaiPhong(lp);
	}
}
