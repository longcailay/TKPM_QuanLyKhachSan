package DAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;

import DTO.Khach;
import DTO.PhieuThue;
import DTO.Phong;
import DataConnection.DataProvider;

public class PhieuThueDAO {
	public static int TaoPhieuThue(PhieuThue phieuThue) {
		int result;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ngayThue = sdf.format(phieuThue.getNgayThue());
		String query = "pro_TaoPhieuThue N'"+ ngayThue + "', N'" + phieuThue.getTinhTrang() + "', " + phieuThue.getIdPhong() + ", " + phieuThue.getIdNguoiDung();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static int getIDPhieuThueMax() {
		int result = -1;
		String query = "SELECT MAX(ID) FROM PHIEU_THUE";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			result = (int) table.getModel().getValueAt(0, 0);
		}
		return result;
	}
	
	public static int TaoChiTietPhieuThue(int idPhieuthue, Khach khach ) {
		int result = -1;
		String query = "pro_TaoChiTietPhieuThue N'" + idPhieuthue + "', N'" + khach.getHoTen() + "', N'" + khach.getCmnd() + "', N'" + khach.getDiaChi() + "', " + khach.getLoaiKhach();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; //trả ra 2 nếu thực hiện thành công (do thêm khách trước rồi mới thêm chi tiết phiếu thuê
	}
	
	public static int CapNhatTinhTrangPhongThanhDangThue(int idPhong) {//cập nhật tình trạng phòng từ trống sang đang thuê
		int result = -1;
		String query = "UPDATE PHONG SET TinhTrang = 1 WHERE ID = " + idPhong;
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);
		return result; 
	}
	
	public static String getNgayKetThucMax(int idPhong) {
		Date temp = new Date();
		String query = "select Max(NgayKetThuc) from PHIEU_THUE where ID != -1 AND TinhTrang != -1 AND Phong = " + idPhong;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			temp = (Date) table.getModel().getValueAt(0, 0);
		}
		String result = null;
		if(temp != null) {
			result = temp.toString();
		}
		return result;
	}
	
	public static ArrayList<Khach> LoadDanhSachKhachTheoIDPhieuThue(int idPhieuThue){
		ArrayList<Khach> result = new ArrayList<Khach>();
		String query = "SELECT K.* FROM CHI_TIET_PHIEU_THUE CTPT, KHACH K WHERE CTPT.Khach = K.ID AND CTPT.PhieuThue = " + idPhieuThue;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		for(int i = 0; i < coutRow; i++) {
			int id = (int)table.getModel().getValueAt(i, 0);
			String hoTen = (String) table.getModel().getValueAt(i, 1);
			String cmnd = (String) table.getModel().getValueAt(i, 2);
			String diaChi = (String) table.getModel().getValueAt(i, 3);
			int loaiKhach = (int) table.getModel().getValueAt(i, 4);
			Khach khach = new Khach(id, hoTen, cmnd, diaChi, loaiKhach);
			result.add(khach);
		}
		return result;
	}
	
	public static ArrayList<PhieuThue> LoadDanhSachPhieuThue(){
		ArrayList<PhieuThue> result = new ArrayList<PhieuThue>();
		String query = "SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		for(int i = 0; i < coutRow; i++) {
			int id = (int)table.getModel().getValueAt(i, 0);
			Date ngayThue = (Date)table.getModel().getValueAt(i, 1);
			Date ngayKetThuc = (Date)table.getModel().getValueAt(i, 2);
			int tinhTrang = (int)table.getModel().getValueAt(i, 3);
			int idPhong = (int)table.getModel().getValueAt(i, 4);
			int idNguoiDung = (int)table.getModel().getValueAt(i, 5);
			String tenPhong = (String) table.getModel().getValueAt(i, 6);
			ArrayList<Khach> danhSachKhach = new ArrayList<Khach>();
			danhSachKhach = LoadDanhSachKhachTheoIDPhieuThue(id);
			PhieuThue phieuThue = new PhieuThue(id, ngayThue, ngayKetThuc, tinhTrang, idPhong, idNguoiDung, tenPhong, danhSachKhach);
			result.add(phieuThue);
		}
		return result;
	}
	
	public static PhieuThue LoadPhieuThueTheoID(int idPhieuThue) {
		PhieuThue result = new PhieuThue();
		String query = "SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID AND PT.ID = "+ idPhieuThue;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		if(coutRow > 0) {
			int id = (int)table.getModel().getValueAt(0, 0);
			Date ngayThue = (Date)table.getModel().getValueAt(0, 1);
			Date ngayKetThuc = (Date)table.getModel().getValueAt(0, 2);
			int tinhTrang = (int)table.getModel().getValueAt(0, 3);
			int idPhong = (int)table.getModel().getValueAt(0, 4);
			int idNguoiDung = (int)table.getModel().getValueAt(0, 5);
			String tenPhong = (String) table.getModel().getValueAt(0, 6);
			ArrayList<Khach> danhSachKhach = new ArrayList<Khach>();
			danhSachKhach = LoadDanhSachKhachTheoIDPhieuThue(id);
			result = new PhieuThue(id, ngayThue, ngayKetThuc, tinhTrang, idPhong, idNguoiDung, tenPhong, danhSachKhach);
		}
		return result;
	}
	 public static int XoaPhieuThueTheoID(int idPhieuThue) {
		 int result = 0;
		 String query = "UPDATE PHIEU_THUE SET TinhTrang = -1 WHERE ID = " + idPhieuThue;
		 DataProvider dp = new DataProvider();
		 result = dp.ExcuteNonQuery(query);
		 return result;
	 }
	 public static int XoaChiTietPhieuThueTheoID(int idPhieuThue) {
		 int result = 0;
		 String query = "DELETE FROM CHI_TIET_PHIEU_THUE WHERE PhieuThue = " + idPhieuThue;
		 DataProvider dp = new DataProvider();
		 result = dp.ExcuteNonQuery(query);
		 return result;
	 }
	 
	 public static ArrayList<Phong> LoadDanhSachPhongCoPhieuThue(){
		ArrayList<Phong> result = new ArrayList<Phong>();
		String query = "SELECT P.* FROM PHONG P WHERE EXISTS (SELECT ID FROM PHIEU_THUE PT WHERE PT.Phong = P.ID AND PT.TinhTrang != -1)";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		int coutRow = table.getRowCount();
		for(int i = 0; i < coutRow; i++) {
			int id = (int)table.getModel().getValueAt(i, 0);
			String tenPhong = (String) table.getModel().getValueAt(i, 1);
			Phong phong = new Phong(id, tenPhong, "", "", 0);
			result.add(phong);
		}
		return result;
	 }
	 
	 public static ArrayList<PhieuThue> LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang(String TenPhong, int TinhTrang){
			ArrayList<PhieuThue> result = new ArrayList<PhieuThue>();
			String query = "pro_LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang N'" + TenPhong + "', " + TinhTrang;
			DataProvider dp = new DataProvider();
			JTable table = dp.ExcuteQuery(query);
			int coutRow = table.getRowCount();
			for(int i = 0; i < coutRow; i++) {
				int id = (int)table.getModel().getValueAt(i, 0);
				Date ngayThue = (Date)table.getModel().getValueAt(i, 1);
				Date ngayKetThuc = (Date)table.getModel().getValueAt(i, 2);
				int tinhTrang = (int)table.getModel().getValueAt(i, 3);
				int idPhong = (int)table.getModel().getValueAt(i, 4);
				int idNguoiDung = (int)table.getModel().getValueAt(i, 5);
				String tenPhong = (String) table.getModel().getValueAt(i, 6);
				ArrayList<Khach> danhSachKhach = new ArrayList<Khach>();
				danhSachKhach = LoadDanhSachKhachTheoIDPhieuThue(id);
				PhieuThue phieuThue = new PhieuThue(id, ngayThue, ngayKetThuc, tinhTrang, idPhong, idNguoiDung, tenPhong, danhSachKhach);
				result.add(phieuThue);
			}
			return result;
		}
	 
}
