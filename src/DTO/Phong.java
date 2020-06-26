package DTO;

public class Phong {
	private int id;
    private String tenPhong, loaiPhong, ghiChu;
    private int tinhTrang; //0. còn trống, 1. đã thuê, -1. đã bị xóa

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

	public String getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(String loaiPhong) {
		this.loaiPhong = loaiPhong;
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

	public Phong(int id, String tenPhong, String loaiPhong, String ghiChu, int tinhTrang) {
		super();
		this.id = id;
		this.tenPhong = tenPhong;
		this.loaiPhong = loaiPhong;
		this.ghiChu = ghiChu;
		this.tinhTrang = tinhTrang;
	}

}
