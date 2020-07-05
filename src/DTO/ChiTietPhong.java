package DTO;

import java.util.Date;
import java.util.ArrayList;

public class ChiTietPhong {
	private int id;
	private String tenPhong;
	private String ghiChu;
	private int tinhTrang;
	private int loaiPhong;
	private Date ngayThue;
	private ArrayList<Khach> danhSachKhach;
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
	public int getLoaiPhong() {
		return loaiPhong;
	}
	public void setTenLoai(int loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public Date getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}
	public ArrayList<Khach> getDanhSachKhach() {
		return danhSachKhach;
	}
	public void setDanhSachKhach(ArrayList<Khach> danhSachKhach) {
		this.danhSachKhach = danhSachKhach;
	}
	public ChiTietPhong(int id, String tenPhong, String ghiChu, int tinhTrang, int loaiPhong, Date ngayThue, ArrayList<Khach> danhSachKhach) {
		this.id = id;
		this.tenPhong = tenPhong;
		this.ghiChu = ghiChu;
		this.tinhTrang = tinhTrang;
		this.loaiPhong = loaiPhong;
		this.ngayThue = ngayThue;
		this.danhSachKhach = danhSachKhach;
	}
	public ChiTietPhong() {
		this.id = 0;
		this.tenPhong = null;
		this.ghiChu = null;
		this.tinhTrang = -1;
		this.loaiPhong = 0;
		this.ngayThue = null;
		this.danhSachKhach = null;
	}
	
}
