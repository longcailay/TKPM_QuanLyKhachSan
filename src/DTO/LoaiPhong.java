package DTO;

import java.math.BigDecimal;

public class LoaiPhong {
	private int id;
	private String tenLoai;
	private BigDecimal donGia;
	private int soLuongKhachBinhThuong;
	private int soLuongKhachToiDa;
	private double PhuThu;
	public double getPhuThu() {
		return PhuThu;
	}
	public void setPhuThu(double phuThu) {
		PhuThu = phuThu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	public BigDecimal getDonGia() {
		return donGia;
	}
	public void setDonGia(BigDecimal donGia) {
		this.donGia = donGia;
	}
	public int getSoLuongKhachBinhThuong() {
		return soLuongKhachBinhThuong;
	}
	public void setSoLuongKhachBinhThuong(int soLuongKhachBinhThuong) {
		this.soLuongKhachBinhThuong = soLuongKhachBinhThuong;
	}
	public int getSoLuongKhachToiDa() {
		return soLuongKhachToiDa;
	}
	public void setSoLuongKhachToiDa(int soLuongKhachToiDa) {
		this.soLuongKhachToiDa = soLuongKhachToiDa;
	}
	public LoaiPhong(int id, String tenLoai, BigDecimal donGia, int soLuongKhachBinhThuong, int soLuongKhachToiDa,
			double phuThu) {
		this.id = id;
		this.tenLoai = tenLoai;
		this.donGia = donGia;
		this.soLuongKhachBinhThuong = soLuongKhachBinhThuong;
		this.soLuongKhachToiDa = soLuongKhachToiDa;
		PhuThu = phuThu;
	}
	
	
	
	
}
