package WSPACE;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BUS.ChiTietHoaDonBUS;
import BUS.HoaDonBUS;
import BUS.LoaiKhachBUS;
import BUS.NguoiDungBUS;
import BUS.PhieuThueBUS;
import DTO.ChiTietHoaDon;
import DTO.HoaDon;
import DTO.Khach;
import DTO.PhieuThue;
import DTO.Phong;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;

public class wsHoaDon extends JPanel {
	private JTable tbDSHoaDon;
	private JTable tbCTHoaDon;
	
	private JButton btnTimKiem;
	private JComboBox cmbMaHoaDon;
	private JComboBox cmbKhachHang;
	
	ArrayList<HoaDon> listHoaDon = HoaDonBUS.LoadDanhSachHoaDon();
	//ArrayList<String> listKhachHang = HoaDonBUS.LoadDanhSachKhachHang();
	
	public static HoaDon hoaDon = new HoaDon();
	public static ArrayList<Khach> listKhach = new ArrayList<Khach>();
	ArrayList<Phong> listPhong = PhieuThueBUS.LoadDanhSachPhongCoPhieuThue();
	
	
	private Locale localeVN = new Locale("vi", "VN");
	private NumberFormat numberFormatVN = NumberFormat.getCurrencyInstance(localeVN);
	/**
	 * Create the panel.
	 */
	public wsHoaDon() {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		//JPanel pnWorkspace = new JPanel();
		this.setBackground(UIManager.getColor("Button.background"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel_2_1 = new JLabel("Chi tiết hóa đơn");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tbCTHoaDon = new JTable();
		tbCTHoaDon.setModel(new DefaultTableModel(
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
				"STT", "Phi\u1EBFu thu\u00EA", "S\u1ED1 ng\u00E0y", "\u0110\u01A1n gi\u00E1", "Ph\u1EE5 thu", "Ti\u1EC1n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbCTHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbCTHoaDon.getColumnModel().getColumn(0).setMaxWidth(30);
		tbCTHoaDon.getColumnModel().getColumn(1).setMaxWidth(80);
		tbCTHoaDon.getColumnModel().getColumn(2).setMaxWidth(80);
		scrollPane_1.setViewportView(tbCTHoaDon);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(354)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2_1)
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Danh s\u00E1ch h\u00F3a \u0111\u01A1n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		tbDSHoaDon = new JTable();
		tbDSHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowHoaDonClick();
			}
		});
		tbDSHoaDon.setModel(new DefaultTableModel(
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "ID", "Kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9", "T\u1ED5ng ti\u1EC1n", "Ng\u01B0\u1EDDi l\u1EADp phi\u1EBFu"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDSHoaDon.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbDSHoaDon.getColumnModel().getColumn(0).setMaxWidth(30);
		tbDSHoaDon.getColumnModel().getColumn(1).setPreferredWidth(50);
		tbDSHoaDon.getColumnModel().getColumn(1).setMaxWidth(50);
		scrollPane.setViewportView(tbDSHoaDon);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(358)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 483, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Mã hóa đơn");
		lblNewLabel.setBounds(40, 20, 90, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbMaHoaDon = new JComboBox();
		cmbMaHoaDon.setBounds(140, 18, 118, 21);
		cmbMaHoaDon.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Khách hàng");
		lblNewLabel_1.setBounds(285, 20, 127, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbKhachHang = new JComboBox();
		cmbKhachHang.setBounds(422, 18, 320, 25);
		cmbKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(778, 22, 85, 21);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(cmbMaHoaDon);
		panel.add(lblNewLabel_1);
		panel.add(cmbKhachHang);
		panel.add(btnTimKiem);
		setLayout(groupLayout);
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnTimKiemClick();
			}
		});
		
		
		loadDanhSachHoaDon();
		loadComboboxMaHoaDon();
		loadComboboxKhachHang();
	}
	
	void loadDanhSachHoaDon() {
		int r = 0;
		int c = 0;
		r = tbDSHoaDon.getRowCount();
		c = tbDSHoaDon.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbDSHoaDon.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(HoaDon hoaDon: listHoaDon) {
			tbDSHoaDon.setValueAt(row + 1, row, 0);
			tbDSHoaDon.setValueAt(hoaDon.getId(), row, 1);
			tbDSHoaDon.setValueAt(hoaDon.getKhachHang(), row, 2);
			tbDSHoaDon.setValueAt(hoaDon.getDiaChi(), row, 3);
			tbDSHoaDon.setValueAt(numberFormatVN.format(hoaDon.getTongTien()), row, 4);
			tbDSHoaDon.setValueAt(NguoiDungBUS.LoadTenNguoiDungTheoID(hoaDon.getNguoiDung()), row, 5);
			row++;
		}
	}
	void loadComboboxMaHoaDon() {
		cmbMaHoaDon.addItem("Tất cả");
		for(HoaDon hoaDon: listHoaDon) {
			cmbMaHoaDon.addItem(hoaDon.getId());
		}
	}
	
	void loadComboboxKhachHang() {
		cmbKhachHang.addItem("Tất cả");
		for(HoaDon hoaDon: listHoaDon) {
			cmbKhachHang.addItem(hoaDon.getKhachHang());
		}
	}
	
	void loadChiTietHoaDon(int idHoaDon) {
		int r = 0;
		int c = 0;
		r = tbCTHoaDon.getRowCount();
		c = tbCTHoaDon.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbCTHoaDon.setValueAt(null, i, j);
			}
		}
		if(idHoaDon >= 0) {
			int row = 0;
			ArrayList<ChiTietHoaDon> listCTHD = ChiTietHoaDonBUS.LoadDSchiTietHoaDonTheoIDhoaDon(idHoaDon);
			for(ChiTietHoaDon cthd: listCTHD) {
				tbCTHoaDon.setValueAt(row + 1, row, 0);
				tbCTHoaDon.setValueAt(cthd.getIdPhieuThue(), row, 1);
				tbCTHoaDon.setValueAt(cthd.getSoNgay(), row, 2);
				tbCTHoaDon.setValueAt(numberFormatVN.format(cthd.getDonGia()), row, 3);
				tbCTHoaDon.setValueAt(numberFormatVN.format(cthd.getPhuThu()), row, 4);
				tbCTHoaDon.setValueAt(numberFormatVN.format(cthd.getTien()), row, 5);
				row++;
			}
		}
	}
	
	void rowHoaDonClick() {
		int rSelection = -1;
		rSelection = tbDSHoaDon.getSelectedRow();
		if(rSelection <= listHoaDon.size() - 1) {
			int idHoaDon = (int)tbDSHoaDon.getModel().getValueAt(rSelection, 1);
			loadChiTietHoaDon(idHoaDon);
		}
		else {
			loadChiTietHoaDon(-1);
		}
	}
	
	void btnTimKiemClick() {
		listHoaDon = HoaDonBUS.LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang(cmbMaHoaDon.getSelectedItem().toString(), cmbKhachHang.getSelectedItem().toString());
		loadDanhSachHoaDon();
	}
}
