package DTO;

import java.util.ArrayList;

public class HoaDon {
	private int id;
	private String khachHang;
	private String diaChi;
	private float tongTien;
	private int nguoiDung;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(String khachHang) {
		this.khachHang = khachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public int getNguoiDung() {
		return nguoiDung;
	}
	public void setNguoiDung(int nguoiDung) {
		this.nguoiDung = nguoiDung;
	}
	public HoaDon(int id, String khachHang, String diaChi, float tongTien, int nguoiDung) {
		super();
		this.id = id;
		this.khachHang = khachHang;
		this.diaChi = diaChi;
		this.tongTien = tongTien;
		this.nguoiDung = nguoiDung;
	}
	
	
}
