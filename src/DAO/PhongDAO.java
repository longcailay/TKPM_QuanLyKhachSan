package DAO;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import javax.swing.JTable;

import DTO.ChiTietPhong;
import DTO.Khach;
import DTO.Phong;
import DataConnection.DataProvider;

public class PhongDAO {
	public static ArrayList<Phong> LoadDSPhong(){
		ArrayList<Phong> result = new ArrayList<Phong>();
		String query = "exec pro_LoadDSPhong";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		Phong phong = null;
		
		int countRow  = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenPhong =  (String) table.getModel().getValueAt(i, 1);
			String loaiPhong = (String) table.getModel().getValueAt(i, 2);
			String ghiChu = (String) table.getModel().getValueAt(i, 3);
			int tinhTrang = (int) table.getModel().getValueAt(i, 4);
			phong = new Phong(id, tenPhong, loaiPhong, ghiChu, tinhTrang);
			result.add(phong);
		}
		return result;
	}
	
	public static ArrayList<Phong> LoadDSPhongTheoLoaiPhongVaTinhTrang(String lp, int tt){
		ArrayList<Phong> result = new ArrayList<Phong>();
		String query = "pro_LoadDanhSachPhongTheoLoaiPhongVaTinhTrang \"" + lp + "\", " + tt;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		Phong phong = null;
		
		int countRow  = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id = (int) table.getModel().getValueAt(i, 0);
			String tenPhong =  (String) table.getModel().getValueAt(i, 1);
			String loaiPhong = (String) table.getModel().getValueAt(i, 2);
			String ghiChu = (String) table.getModel().getValueAt(i, 3);
			int tinhTrang = (int) table.getModel().getValueAt(i, 4);
			phong = new Phong(id, tenPhong, loaiPhong, ghiChu, tinhTrang);
			result.add(phong);
		}
		return result;
	}
	
	public static ChiTietPhong LoadChiTietPhong(int idPhong){
		int id = 0;
		String tenPhong = null;
		String ghiChu = null;
		int tinhTrang = 0;
		int loaiPhong = 0;
		java.util.Date ngayThue = null;
		ArrayList<Khach> dsKhach = new ArrayList<Khach>();
		
		String query = "pro_LoadChiTietPhong " + idPhong;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() >=1) {
			id = (int) table.getModel().getValueAt(0, 0);
			tenPhong = (String) table.getModel().getValueAt(0, 1);
			ghiChu = (String) table.getModel().getValueAt(0, 2);
			tinhTrang = (int) table.getModel().getValueAt(0, 3);
			loaiPhong = (int) table.getModel().getValueAt(0, 4);
			if(table.getModel().getValueAt(0, 5) != null) {
				String strNgayThue = ((String) table.getModel().getValueAt(0, 5).toString()).substring(0, 10);//Chỉ lấy phần yyyy-MM-dd mà bỏ phần time HH:mm:ss
				try {
					ngayThue = new SimpleDateFormat("yyyy-MM-dd").parse(strNgayThue);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
		String query2 = "pro_LoadDanhSachKhachDangThuePhong " + idPhong;
		Khach khach = null;
		JTable table2 = dp.ExcuteQuery(query2);
		int countRow  = table2.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int idKhach = (int) table2.getModel().getValueAt(i, 0);
			String hoTen =  (String) table2.getModel().getValueAt(i, 1);
			String cmnd = (String) table2.getModel().getValueAt(i, 2);
			String diaChi = (String) table2.getModel().getValueAt(i, 3);
			int loaiKhach = (int) table2.getModel().getValueAt(i, 4);
			khach = new Khach(idKhach, hoTen, cmnd, diaChi, loaiKhach);
			dsKhach.add(khach);
		}
		
		ChiTietPhong result = new ChiTietPhong(id, tenPhong, ghiChu, tinhTrang, loaiPhong, ngayThue, dsKhach);
		return result;
	}
	
	public static int ThemPhongMoi(String tenPhong, String ghiChu, String tenLoaiPhong) {
		int result;
		String query = "EXEC pro_ThemPhongMoi N'"+ tenPhong + "', N'" + ghiChu + "', N'" + tenLoaiPhong + "'";
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	/*Bắt đầu sửa từ đây và chưa làm csdl luôn*/
	public static int SuaPhong(String tenPhong, String ghiChu, String tenLoaiPhong) {
		int result;
		String query = "EXEC pro_ThemPhongMoi N'"+ tenPhong + "', N'" + ghiChu + "', N'" + tenLoaiPhong + "'";
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static Phong LayThongTinPhongTheoTenPhong(String TenPhong) {
		String query = "pro_LayThongTinPhongTheoTenPhong N'" + TenPhong + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		Phong phong = null;
		
		int countRow  = table.getRowCount();
		if(countRow > 0) {
			int id = (int) table.getModel().getValueAt(0, 0);
			String tenPhong =  (String) table.getModel().getValueAt(0, 1);
			//String loaiPhong = (String) table.getModel().getValueAt(0, 2);
			String ghiChu = (String) table.getModel().getValueAt(0, 2);
			int tinhTrang = (int) table.getModel().getValueAt(0, 3);
			phong = new Phong(id, tenPhong, "", ghiChu, tinhTrang);
		}
		return phong;
	}
	
	public static int XoaPhong(String tenPhong) {
		String query = "pro_XoaPhong N'" + tenPhong + "'";
		DataProvider dp = new DataProvider();
		int result = dp.ExcuteNonQuery(query);
		return result;
	}
}
