package WSPACE;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import BUS.HoaDonBUS;
import BUS.LoaiKhachBUS;
import BUS.LoaiPhongBUS;
import BUS.PhieuThueBUS;
import DTO.PhieuThue;
import DTO.PhieuThueChiTiet;
import UI.HomePage;
import DTO.HoaDon;
import DTO.Khach;
import DTO.LoaiPhong;
import DTO.ChiTietHoaDon;
import java.awt.Component;

import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
public class wsThanhToan extends JPanel{
	private static final PrinterJob PDFPrinterJob = null;
	private JTextField txtTenPhong;
	private JTextField txtNgayThue;
	private JTextField txtNgayTra;
	private JTextField txtTienPhong;
	private JTable tbDanhSachKhach;
	public static JTextField txtKhachHang;
	public static JTextField txtDiaChi;
	private JTable tbPhieuThue;
	public static JTextField txtTriGia;
	private  JComboBox cmbMaPhieuThue;
	private JButton btnThemVaoHoaDon;
	private PhieuThue phieuThue = new PhieuThue();//Phiếu thuê mà Combox đang chọn
	private ArrayList<Integer> dsIDPhieuThueCTT = PhieuThueBUS.LoadDanhSachIDPhieuThueChuaThanhToan();// danh sach ID phieu thue chua thanh toan
	private PhieuThueChiTiet ptct = new PhieuThueChiTiet();
	public static ArrayList<PhieuThueChiTiet> dsPTCT = new ArrayList<PhieuThueChiTiet>();
	private float triGia = 0.0f;
	
	
	public static int idHoaDon = HoaDonBUS.getIDHoaDonMax() + 1;
	private int idNguoiDung = HomePage.nguoiDung.getId();
	
	//định dạng đơn vị tiền tệ VNĐ
	private Locale localeVN = new Locale("vi", "VN");
	private NumberFormat numberFormatVN = NumberFormat.getCurrencyInstance(localeVN);
	
	private JPanel panel_1;
	private JPanel panel;
	public wsThanhToan() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(0, 0, 0)));
		
		panel_1 = new JPanel();
		panel_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 523, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
				.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_2 = new JLabel("Hóa đơn thanh toán");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_3_4 = new JLabel("Khách hàng/ Cơ quan");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtKhachHang = new JTextField();
		txtKhachHang.setForeground(Color.BLACK);
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKhachHang.setDisabledTextColor(Color.BLACK);
		txtKhachHang.setColumns(10);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setForeground(Color.BLACK);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDiaChi.setDisabledTextColor(Color.BLACK);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Địa chỉ");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Phiếu thuê");
		lblNewLabel_3_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setAlignmentY(0.0f);
		scrollPane_1.setAlignmentX(0.0f);
		scrollPane_1.setEnabled(false);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Trị giá");
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTriGia = new JTextField();
		txtTriGia.setForeground(Color.RED);
		txtTriGia.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtTriGia.setEnabled(false);
		txtTriGia.setDisabledTextColor(Color.BLACK);
		txtTriGia.setColumns(10);
		
		JButton btnDatLai = new JButton("Đặt lại");
		btnDatLai.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDatLai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadCMBMaPhieuThue();
				dsPTCT = new ArrayList<PhieuThueChiTiet>();
				loadTablePhieuThue();
			}
		});
		
		JButton btnHoanTat = new JButton("Hoàn tất");
		btnHoanTat.setForeground(Color.WHITE);
		btnHoanTat.setBackground(Color.BLUE);
		btnHoanTat.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnHoanTat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnHoanTatClick();
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel_3_4_1_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtKhachHang, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_4_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_2_1_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTriGia, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(145)
							.addComponent(btnDatLai, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnHoanTat, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtKhachHang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_4_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lblNewLabel_3_4_1_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTriGia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_2_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDatLai, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnHoanTat, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		
		tbPhieuThue = new JTable();
		tbPhieuThue.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 phi\u1EBFu", "Ph\u00F2ng", "S\u1ED1 ng\u00E0y", "\u0110\u01A1n gi\u00E1", "Ph\u1EE5 thu", "Ti\u1EC1n"
			}
		));
		tbPhieuThue.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbPhieuThue.getColumnModel().getColumn(2).setPreferredWidth(50);
		scrollPane_1.setViewportView(tbPhieuThue);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Tên phòng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTenPhong = new JTextField();
		txtTenPhong.setEnabled(false);
		txtTenPhong.setForeground(Color.RED);
		txtTenPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtTenPhong.setDisabledTextColor(Color.BLACK);
		txtTenPhong.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ngày thuê");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_2 = new JLabel("Ngày trả");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_3 = new JLabel("Khách");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		//jScrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Tiền phòng");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnThemVaoHoaDon = new JButton("Thêm vào hóa đơn");
		btnThemVaoHoaDon.setForeground(Color.WHITE);
		btnThemVaoHoaDon.setBackground(Color.BLUE);
		btnThemVaoHoaDon.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThemVaoHoaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnThemVaoHoaDonClick();
			}
		});
		
		
		txtNgayThue = new JTextField();
		txtNgayThue.setEnabled(false);
		txtNgayThue.setForeground(Color.RED);
		txtNgayThue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtNgayThue.setDisabledTextColor(Color.BLACK);
		txtNgayThue.setColumns(10);
		
		txtNgayTra = new JTextField();
		txtNgayTra.setEnabled(false);
		txtNgayTra.setForeground(Color.RED);
		txtNgayTra.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtNgayTra.setDisabledTextColor(Color.BLACK);
		txtNgayTra.setColumns(10);
		
		cmbMaPhieuThue = new JComboBox();
		loadCMBMaPhieuThue();
		cmbMaPhieuThue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadChiTietPhieuThue();
			}
		});
		
		
		txtTienPhong = new JTextField();
		txtTienPhong.setForeground(Color.RED);
		txtTienPhong.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtTienPhong.setEnabled(false);
		txtTienPhong.setDisabledTextColor(Color.BLACK);
		txtTienPhong.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_3_5 = new JLabel("Chọn phiếu");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_2_1 = new JLabel("Thêm phiếu thuê vào hóa đơn");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(135)
					.addComponent(lblNewLabel_3_2_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtTienPhong, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(btnThemVaoHoaDon, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(118))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmbMaPhieuThue, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNgayThue, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtNgayTra, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtTenPhong, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addGap(67))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_5)
						.addComponent(cmbMaPhieuThue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenPhong, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3_1)
						.addComponent(txtNgayThue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_3_2)
						.addComponent(txtNgayTra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(lblNewLabel_3_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTienPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_2_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnThemVaoHoaDon, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		tbDanhSachKhach = new JTable();
		tbDanhSachKhach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"STT", "Kh\u00E1ch h\u00E0ng", "Lo\u1EA1i kh\u00E1ch"
			}
		));
		tbDanhSachKhach.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbDanhSachKhach.getColumnModel().getColumn(0).setMaxWidth(30);
		tbDanhSachKhach.getColumnModel().getColumn(2).setMaxWidth(400);
		tbDanhSachKhach.setEnabled(false);
		scrollPane.setViewportView(tbDanhSachKhach);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		loadTablePhieuThueBanDau();
	}
	
	void loadCMBMaPhieuThue() {
		while(cmbMaPhieuThue.getItemCount() > 0) {
			cmbMaPhieuThue.removeItemAt(0);
		}
		cmbMaPhieuThue.addItem(null);
		for (int id: dsIDPhieuThueCTT) {
			cmbMaPhieuThue.addItem(id);
		}
	}
	void loadChiTietPhieuThue() {
		if(cmbMaPhieuThue.getSelectedItem() == null) {
			txtTenPhong.setText("");
			txtNgayThue.setText("");
			txtNgayTra.setText("");
			txtTienPhong.setText("");
			for(int i = 0; i < tbDanhSachKhach.getRowCount(); i++)
			{
				for(int j = 0; j < tbDanhSachKhach.getColumnCount(); j++) {
					tbDanhSachKhach.setValueAt("", i, j);
				}
			}
		}
		else {
			phieuThue = PhieuThueBUS.LoadPhieuThueTheoID((int)cmbMaPhieuThue.getSelectedItem());
			txtTenPhong.setText(phieuThue.getTenPhong());
			String strNgayThue = phieuThue.getNgayThue().toString();
			String strNgayTra = phieuThue.getNgayKetThuc().toString();
			txtNgayThue.setText(strNgayThue);
			txtNgayTra.setText(strNgayTra);
			for(int i = 0; i < tbDanhSachKhach.getRowCount(); i++)
			{
				for(int j = 0; j < tbDanhSachKhach.getColumnCount(); j++) {
					tbDanhSachKhach.setValueAt("", i, j);
				}
			}
			
			for(int i = 0; i < phieuThue.getDanhSachKhach().size(); i++)
			{
				int STT = phieuThue.getDanhSachKhach().get(i).getId();
				String khachHang = phieuThue.getDanhSachKhach().get(i).getHoTen();
				int loaiKhach = phieuThue.getDanhSachKhach().get(i).getLoaiKhach();
				String strLoaiKhach = LoaiKhachBUS.LoadLoaiKhachTheoID(loaiKhach).getTenLoai();
				tbDanhSachKhach.setValueAt(STT, i, 0);
				tbDanhSachKhach.setValueAt(khachHang, i, 1);
				tbDanhSachKhach.setValueAt(strLoaiKhach, i, 2);
			}
			tinhTienPhong();
		}
	}
	
	///
	void tinhTienPhong() {
		LoaiPhong loaiPhong = LoaiPhongBUS.loadLoaiPhongTheoTenPhong(phieuThue.getTenPhong());
		float donGia = loaiPhong.getDonGia().floatValue();
		float phuThuSLK = 0.0f;//phụ thu theo số lượng khách thêm
		int soLuongKhachThue = phieuThue.getDanhSachKhach().size();
		if(soLuongKhachThue > loaiPhong.getSoLuongKhachBinhThuong()) {//số lượng khách thuê vượt số lượng khách bình thường
			phuThuSLK =  (float) ((soLuongKhachThue - loaiPhong.getSoLuongKhachBinhThuong()) * loaiPhong.getPhuThu());	
		}
		float phuThuLK = 1.0f;//hệ số phụ thu theo loại khách
		for(Khach khach: phieuThue.getDanhSachKhach()) {
			if(khach.getLoaiKhach() == 2) {//chỉ cẩn 1 ít nhất 1 khách nước ngoài là được nhân với hệ số 1.5
				phuThuLK = (float) LoaiKhachBUS.LoadLoaiKhachTheoID(2).getPhuThu();
				break;
			}
		}
		int soNgayThue = 0;	
		
		//chỉ lấy số ngày và loại bỏ hh:mm:ss
		String strNgayThue = phieuThue.getNgayThue().toString().substring(0,10);
		String strNgayKetThuc = phieuThue.getNgayKetThuc().toString().substring(0, 10);
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date ngayThue = fm.parse(strNgayThue);
			Date ngayKetThuc = fm.parse(strNgayKetThuc);
			soNgayThue =(int) ((ngayKetThuc.getTime() - ngayThue.getTime())/86400000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("Đơn giá " + donGia);
//		System.out.println("soNgayThue " + soNgayThue);
//		System.out.println("phuThuSLK " + phuThuSLK);
//		System.out.println("phuThuLK " + phuThuLK);
		float tongTien = donGia*soNgayThue*(1.0f + phuThuSLK)*phuThuLK;
		float tongPhuThu =(float) (tongTien - donGia*soNgayThue);
		
		
		String strTienPhong = numberFormatVN.format(tongTien);
		txtTienPhong.setText(strTienPhong);
		ptct = new PhieuThueChiTiet(phieuThue.getId(), phieuThue.getTenPhong(),soNgayThue, donGia, tongPhuThu, tongTien);
	}
	
	public void btnThemVaoHoaDonClick(){
		if(cmbMaPhieuThue.getModel().getSelectedItem() != null) {
			dsPTCT.add(ptct);
			cmbMaPhieuThue.removeItemAt(cmbMaPhieuThue.getSelectedIndex());
		}
		else {
			//System.out.println("NO");
		}
		loadTablePhieuThue();
	}
	
	
	///////////////////////////////////////////////
	void loadTablePhieuThueBanDau() {//lúc trả phòng ta chọn "Thêm vào hóa đơn"
		if(wsQuanLyPhong.dsIDPhieuThue.size() > 0) {
			String cmb = "";
			for(int i = 1; i < cmbMaPhieuThue.getItemCount(); i++) {
				cmb = cmbMaPhieuThue.getItemAt(i).toString();
				for(int j = 0; j < wsQuanLyPhong.dsIDPhieuThue.size(); j++) {
					if(cmb.equals(wsQuanLyPhong.dsIDPhieuThue.get(j))){
						cmbMaPhieuThue.setSelectedIndex(i);
						i--;
						btnThemVaoHoaDon.doClick();
					}
				}
			}
		}
		wsQuanLyPhong.dsIDPhieuThue = new ArrayList<String>();
		cmbMaPhieuThue.setSelectedIndex(0);
	}
	
	void loadTablePhieuThue() {
		for(int i = 0; i < tbPhieuThue.getRowCount(); i++)
		{
			for(int j = 0; j < tbPhieuThue.getColumnCount(); j++) {
				tbPhieuThue.setValueAt("", i, j);
			}
		}
		
		for(int i =  0; i < dsPTCT.size(); i++) {
			tbPhieuThue.setValueAt(dsPTCT.get(i).getId(), i, 0);
			tbPhieuThue.setValueAt(dsPTCT.get(i).getTenPhong(), i, 1);
			tbPhieuThue.setValueAt(dsPTCT.get(i).getSoNgay(), i, 2);
			tbPhieuThue.setValueAt(numberFormatVN.format(dsPTCT.get(i).getDonGia()), i, 3);
			tbPhieuThue.setValueAt(numberFormatVN.format(dsPTCT.get(i).getPhuThu()), i, 4);
			tbPhieuThue.setValueAt(numberFormatVN.format(dsPTCT.get(i).getTien()), i, 5);
		}
		triGiaHoaDon();
	}
	void triGiaHoaDon() {
		triGia = 0.0f;
		for(int i = 0; i < dsPTCT.size(); i++) {
			triGia += dsPTCT.get(i).getTien();
		}
		txtTriGia.setText(numberFormatVN.format(triGia));
	}
	
	void btnHoanTatClick() {
		HoaDon hd = new HoaDon(idHoaDon, txtKhachHang.getText(), txtDiaChi.getText(), triGia, idNguoiDung);
		int success = HoaDonBUS.TaoHoaDon(hd);
		if(success == -1) {
			return;
		}
		else {
			if(dsPTCT.size() == 0) {
				JOptionPane.showMessageDialog(null, "Hóa đơn phải có ít nhất một phiếu thuê!", "Warning!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			for(PhieuThueChiTiet pt : dsPTCT) {
				ChiTietHoaDon cthd = new ChiTietHoaDon(idHoaDon, pt.getId(), pt.getSoNgay(), pt.getDonGia(), pt.getPhuThu(), pt.getTien());
				success = HoaDonBUS.TaoChiTietHoaDon(cthd);
				if(success == -1) {
					JOptionPane.showMessageDialog(null, "Tạo chi tiết hóa đơn thất bại!", "Error!", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
			InHoaDon a = new InHoaDon();
			a.setVisible(false);
			idHoaDon = HoaDonBUS.getIDHoaDonMax() + 1;
			dsPTCT = new ArrayList<PhieuThueChiTiet>();
			dsIDPhieuThueCTT = PhieuThueBUS.LoadDanhSachIDPhieuThueChuaThanhToan();
			txtKhachHang.setText("");
			txtDiaChi.setText("");
			loadTablePhieuThue();
		}	

	}
}
