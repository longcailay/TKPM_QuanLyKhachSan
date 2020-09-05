package DAO;


import java.util.ArrayList;

import javax.swing.JTable;


import DTO.NguoiDung;

import DataConnection.DataProvider;

public class NguoiDungDAO {
	public static NguoiDung LoadNguoiDungTheoID(int id) {
		NguoiDung result = new NguoiDung();
		String query = "SELECT * FROM NGUOI_DUNG WHERE ID = "+ id;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			id =(int) table.getModel().getValueAt(0, 0);
			String hoTen =(String) table.getModel().getValueAt(0, 1);
			String cmnd =(String) table.getModel().getValueAt(0, 2);
			String sdt =(String) table.getModel().getValueAt(0, 3);
			String diaChi = (String)table.getModel().getValueAt(0, 4);
			String taiKhoan =(String) table.getModel().getValueAt(0, 5);
			String matKhau = (String)table.getModel().getValueAt(0, 6);
			int tinhTrang = (int) table.getModel().getValueAt(0, 7);
			int phanQuyen =(int) table.getModel().getValueAt(0, 8);
			result = new NguoiDung(id, hoTen, cmnd, sdt, diaChi, taiKhoan, matKhau, tinhTrang, phanQuyen);
		}
		return result;
	}
	
	public static String LoadTenNguoiDungTheoID(int id) {
		String  result = "";
		String query = "SELECT HoTen FROM NGUOI_DUNG WHERE ID = "+ id;
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		if(table.getRowCount() > 0) {
			String hoTen =(String) table.getModel().getValueAt(0, 0);
			result = hoTen;
		}
		return result;
	}
	
	public static ArrayList<NguoiDung> LoadDSNguoiDung(){
		ArrayList<NguoiDung> result = new ArrayList<NguoiDung>();
		String query = "select * from NGUOI_DUNG where TinhTrang = 1";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow  = table.getRowCount();
		for(int i = 0; i < countRow; i++) {
			int id =(int) table.getModel().getValueAt(i, 0);
			String hoTen =(String) table.getModel().getValueAt(i, 1);
			String cmnd =(String) table.getModel().getValueAt(i, 2);
			String sdt =(String) table.getModel().getValueAt(i, 3);
			String diaChi = (String)table.getModel().getValueAt(i, 4);
			String taiKhoan =(String) table.getModel().getValueAt(i, 5);
			String matKhau = (String)table.getModel().getValueAt(i, 6);
			int tinhTrang = (int) table.getModel().getValueAt(i, 7);
			int phanQuyen =(int) table.getModel().getValueAt(i, 8);
			result.add(new NguoiDung(id, hoTen, cmnd, sdt, diaChi, taiKhoan, matKhau, tinhTrang, phanQuyen));
		}
		return result;
	}
	

	public static int ThemNguoiDungMoi(NguoiDung nd) {
		int result;
		String query = "insert into NGUOI_DUNG (HoTen, CMND, SDT, DiaChi,TaiKhoan, MatKhau, TinhTrang, PhanQuyen) values(N'" + nd.getHoTen() + "', N'" + nd.getCmnd() + "', N'" + nd.getSdt() + "',N'" + nd.getDiaChi() + "',N'" +  nd.getTaiKhoan() +"',N'" + nd.getMatKhau()+ "',1," + nd.getPhanQuyen()+ ")";
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	public static boolean KiemTraTenTaiKhoanTonTai(String tenTaiKhoan) {
		boolean result = false;
		int count = 0;
		String query = "select count(TaiKhoan) from NGUOI_DUNG where TaiKhoan = N'" + tenTaiKhoan + "'";
		DataProvider dp = new DataProvider();
		JTable table = dp.ExcuteQuery(query);
		
		int countRow  = table.getRowCount();
		if(countRow > 0) {
			count =(int) table.getModel().getValueAt(0, 0);
		}
		if(count >= 1) {//tài khoản đã tồn tại
			result = true;
		}
		return result;
	}
	
	public static int CapNhatNguoiDung(NguoiDung nd) {
		int result;
		String query = "update NGUOI_DUNG set HoTen = N'" + nd.getHoTen() + "', CMND = N'"+ nd.getCmnd()+ "', SDT = N'" + nd.getSdt()+ "', DiaChi = N'"+nd.getDiaChi()+"', MatKhau = N'"+nd.getMatKhau()+ "', PhanQuyen = " + nd.getPhanQuyen() + " where id = " + nd.getId();
		System.out.println(query);
		//String query1 = "EXEC pro_CapNhatNguoiDung "+ nd.getId() + ", N'"+ nd.getHoTen() + "', N'" + nd.getCmnd() + "', N'" + nd.getSdt() + "', N'" + nd.getDiaChi() + "', N'" + nd.getTaiKhoan() + "', N'" + nd.getMatKhau() + "', " + nd.getPhanQuyen();
		DataProvider dp = new DataProvider();
		result = dp.ExcuteNonQuery(query);		
		return result;
	}
	
	
	public static int XoaNguoiDung(int id) {
		String query = "Update NGUOI_DUNG set TinhTrang = 0 where ID = " + id;
		DataProvider dp = new DataProvider();
		int result = dp.ExcuteNonQuery(query);
		return result;
	}
	
}
