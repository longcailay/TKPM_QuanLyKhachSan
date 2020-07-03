package DTO;

import java.sql.Date;

public class ChiTietPhong {
	private int id;
	private String tenPhong;
	private String ghiChu;
	private int tinhTrang;
	private String tenLoai;
	private Date ngayThue;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public ChiTietPhong(int ID, String TenPhong, String GhiChu,	int TinhTrang,String TenLoai,Date NgayThue) {
		id = ID;
		tenPhong = TenPhong;
		ghiChu = GhiChu;
		tinhTrang = TinhTrang;
		ngayThue = NgayThue;
	}
}
