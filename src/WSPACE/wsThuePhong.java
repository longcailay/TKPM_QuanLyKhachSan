package WSPACE;
import UI.HomePage;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiKhachBUS;
import BUS.NguoiDungBUS;
import BUS.PhieuThueBUS;
import BUS.PhongBUS;
import DTO.Khach;
import DTO.PhieuThue;
import DTO.Phong;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class wsThuePhong extends JPanel {
	private JTable tbPhieuThue;
	private JTable tbKhachThue;
	
	private JButton btnTimKiem;
	private JButton btnCapNhat;
	private JButton btnXoaPhieu;
	private JComboBox cmbTenPhong;
	private JComboBox cmbTinhTrang;
	
	ArrayList<PhieuThue> listPhieuThue = PhieuThueBUS.LoadDanhSachPhieuThue();
	
	private PhieuThue phieuThue = new PhieuThue();
	ArrayList<Khach> listKhach = new ArrayList<Khach>();
	ArrayList<Phong> listPhong = PhieuThueBUS.LoadDanhSachPhongCoPhieuThue();
	/**
	 * Create the panel.
	 */
	public wsThuePhong() {
		
		//JPanel pnWorkspace = new JPanel();
		this.setBackground(Color.PINK);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Danh sách khách thuê trong phòng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		tbKhachThue = new JTable();
		tbKhachThue.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "H\u1ECD t\u00EAn", "CMND", "\u0110\u1ECBa ch\u1EC9", "Lo\u1EA1i kh\u00E1ch"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbKhachThue.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbKhachThue.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane_1.setViewportView(tbKhachThue);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(332)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_2_1)
					.addGap(10)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblNewLabel_2 = new JLabel("Danh sách phiếu thuê");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		tbPhieuThue = new JTable();
		tbPhieuThue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowPhieuThueClick();
			}
		});
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
				"STT", "T\u00EAn ph\u00F2ng", "Ng\u00E0y thu\u00EA", "Ng\u00E0y tr\u1EA3 ph\u00F2ng", "T\u00ECnh tr\u1EA1ng", "Ng\u01B0\u1EDDi l\u1EADp phi\u1EBFu"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbPhieuThue.getColumnModel().getColumn(0).setPreferredWidth(30);
		tbPhieuThue.getColumnModel().getColumn(0).setMaxWidth(30);
		scrollPane.setViewportView(tbPhieuThue);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(new Color(218, 165, 32));
		btnCapNhat.setForeground(Color.WHITE);
		
		btnXoaPhieu = new JButton("Xóa phiếu");
		btnXoaPhieu.setBackground(new Color(255, 0, 0));
		btnXoaPhieu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnXoaPhieuClick();
			}
		});
		
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
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(309)
							.addComponent(btnCapNhat)
							.addGap(113)
							.addComponent(btnXoaPhieu)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCapNhat)
						.addComponent(btnXoaPhieu))
					.addGap(19))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn ph\u00F2ng");
		lblNewLabel.setBounds(40, 20, 90, 20);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbTenPhong = new JComboBox();
		cmbTenPhong.setBounds(140, 18, 188, 21);
		cmbTenPhong.setFont(new Font("Tahoma", Font.BOLD, 18));
		cmbTenPhong.setEditable(true);
		
		JLabel lblNewLabel_1 = new JLabel("Tình trạng");
		lblNewLabel_1.setBounds(415, 20, 90, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		cmbTinhTrang = new JComboBox();
		cmbTinhTrang.setBounds(525, 18, 195, 25);
		cmbTinhTrang.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBounds(778, 22, 85, 21);
		panel.setLayout(null);
		panel.add(lblNewLabel);
		panel.add(cmbTenPhong);
		panel.add(lblNewLabel_1);
		panel.add(cmbTinhTrang);
		panel.add(btnTimKiem);
		setLayout(groupLayout);
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnTimKiemClick();
			}
		});
		
		
		loadDanhSachPhieuThue();
		loadComboboxTenPhong();
		loadComboboxTinhTrang();
	}
	
	void loadDanhSachPhieuThue() {
		int r = 0;
		int c = 0;
		r = tbPhieuThue.getRowCount();
		c = tbPhieuThue.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbPhieuThue.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(PhieuThue phieuThue: listPhieuThue) {
			tbPhieuThue.setValueAt(row + 1, row, 0);
			tbPhieuThue.setValueAt(phieuThue.getTenPhong(), row, 1);
			tbPhieuThue.setValueAt(phieuThue.getNgayThue(), row, 2);
			tbPhieuThue.setValueAt(phieuThue.getNgayKetThuc(), row, 3);
			String strTinhTrang = "";
			switch (phieuThue.getTinhTrang()) {
				case 0:
					strTinhTrang = "Đang cho thuê";
					break;
				case 1:
					strTinhTrang = "Đã thanh toán";
					break;
				case 2:
					strTinhTrang = "Chưa thanh toán";
					break;
			}
			tbPhieuThue.setValueAt(strTinhTrang,row, 4);
			tbPhieuThue.setValueAt(NguoiDungBUS.LoadTenNguoiDungTheoID(phieuThue.getIdNguoiDung()), row, 5);
			row++;
		}
	}
	void loadComboboxTenPhong() {
		cmbTenPhong.addItem("Tất cả");
		for(Phong phong: listPhong) {
			cmbTenPhong.addItem(phong.getTenPhong());
		}
	}
	
	void loadComboboxTinhTrang() {
		cmbTinhTrang.addItem("Tất cả");
		cmbTinhTrang.addItem("Đang cho thuê");
		cmbTinhTrang.addItem("Đã thanh toán");
		cmbTinhTrang.addItem("Chưa thanh toán");
	}
	
	void btnXoaPhieuClick(){
		if(phieuThue.getId() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn phiếu thuê cần xóa!", "Warning!",JOptionPane.WARNING_MESSAGE);
		}
		else {
			if(phieuThue.getTinhTrang() == 1) {
				JOptionPane.showMessageDialog(null, "Phiếu thuê đã thanh toán xong, không thể xóa!", "Warning!",JOptionPane.WARNING_MESSAGE);
				return;
			}
			int btnOK = JOptionPane.OK_OPTION;
			int r = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa phiếu thuê!", "Warning!", btnOK);
			if(r == JOptionPane.OK_OPTION) {
				if(PhieuThueBUS.XoaPhieuThueTheoID(phieuThue.getId()) != 0){
					PhongBUS.CapNhatTinhTrangPhongSangConTrong(phieuThue.getIdPhong());
					listPhieuThue = PhieuThueBUS.LoadDanhSachPhieuThue();
					loadDanhSachPhieuThue();
					JOptionPane.showMessageDialog(null, "Xóa phiếu thuê thành công!", "Information!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}		
	}
	void loadDanhSachKhachCuaPhieuThue() {
		int r = 0;
		int c = 0;
		r = tbKhachThue.getRowCount();
		c = tbKhachThue.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbKhachThue.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(Khach khach: listKhach) {
			tbKhachThue.setValueAt(row + 1, row, 0);
			tbKhachThue.setValueAt(khach.getHoTen(), row, 1);
			tbKhachThue.setValueAt(khach.getCmnd(), row, 2);
			tbKhachThue.setValueAt(khach.getDiaChi(), row, 3);
			String strTenLoaiKhach = "";
			strTenLoaiKhach = LoaiKhachBUS.LoadLoaiKhachTheoID(khach.getLoaiKhach()).getTenLoai();
			tbKhachThue.setValueAt(strTenLoaiKhach,row, 4);
			row++;
		}
	}
	
	void rowPhieuThueClick() {
		int rSelection = -1;
		rSelection = tbPhieuThue.getSelectedRow();
		if(rSelection <= listPhieuThue.size() - 1) {
			phieuThue = listPhieuThue.get(rSelection);
			listKhach = phieuThue.getDanhSachKhach();
			loadDanhSachKhachCuaPhieuThue();
		}
		else {
			phieuThue = new PhieuThue();
			listKhach = new ArrayList<Khach>();
			loadDanhSachKhachCuaPhieuThue();
		}
	}
	
	void btnTimKiemClick() {
		listPhieuThue = PhieuThueBUS.LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang(cmbTenPhong.getSelectedItem().toString(), cmbTinhTrang.getSelectedItem().toString());
		loadDanhSachPhieuThue();
	}
}
