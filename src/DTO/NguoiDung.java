package DTO;

public class NguoiDung {
	private int id;
	private String hoTen;
	private String cmnd;
	private String sdt;
	private String diaChi;
	private String taiKhoan;
	private String matKhau;
	private int tinhTrang;
	private int phanQuyen;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public int getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(int phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public NguoiDung(int id, String hoTen, String cmnd, String sdt, String diaChi, String taiKhoan, String matKhau,
			int tinhTrang, int phanQuyen) {
		this.id = id;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.tinhTrang = tinhTrang;
		this.phanQuyen = phanQuyen;
	}
	public NguoiDung() {
		this.id = 1;
		this.hoTen = "Nguyễn Văn A";
		this.cmnd = "123456789";
		this.sdt = "0329435555";
		this.diaChi = "Tien giang";
		this.taiKhoan = "admin";
		this.matKhau = "113";
		this.tinhTrang = 1;
		this.phanQuyen = 1;
	}
	
	
}
