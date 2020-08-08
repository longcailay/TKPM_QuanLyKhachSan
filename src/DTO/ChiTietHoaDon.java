package DTO;

public class ChiTietHoaDon {
	private int idHoaDon;
	private int idPhieuThue;
	private int soNgay;
	private float donGia;
	private float phuThu;
	private float tien;
	public int getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public int getIdPhieuThue() {
		return idPhieuThue;
	}
	public void setIdPhieuThue(int idPhieuThue) {
		this.idPhieuThue = idPhieuThue;
	}
	public int getSoNgay() {
		return soNgay;
	}
	public void setSoNgay(int soNgay) {
		this.soNgay = soNgay;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public float getPhuThu() {
		return phuThu;
	}
	public void setPhuThu(float phuThu) {
		this.phuThu = phuThu;
	}
	public float getTien() {
		return tien;
	}
	public void setTien(float tien) {
		this.tien = tien;
	}
	public ChiTietHoaDon(int idHoaDon, int idPhieuThue, int soNgay, float donGia, float phuThu, float tien) {
		super();
		this.idHoaDon = idHoaDon;
		this.idPhieuThue = idPhieuThue;
		this.soNgay = soNgay;
		this.donGia = donGia;
		this.phuThu = phuThu;
		this.tien = tien;
	}
	
}
