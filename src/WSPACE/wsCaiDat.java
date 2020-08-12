package WSPACE;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BUS.LoaiKhachBUS;
import BUS.LoaiPhongBUS;
import UI.ThemLoaiKhach;
import UI.ThemLoaiPhong;
import javax.swing.JTextField;

import DTO.Khach;
import DTO.LoaiKhach;
import DTO.LoaiPhong;
import DTO.PhieuThue;
public class wsCaiDat extends JPanel{
	public static JTable tbLoaiKhach;
	private JTextField txtMaLoaiKhach;
	private JTextField txtTenLoaiKhach;
	private JTextField txtPhuThuLoaiKhach;
	private JTable tbLoaiPhong;
	private JTextField txtMaLoaiPhong;
	private JTextField txtSoLuongKhachBT;
	private JTextField txtDonGiaLoaiPhong;
	private JTextField txtTenLoaiPhong;
	private JTextField txtSoLuongKhachToiDa;
	private JTextField txtPhuThuLoaiPhong;
	
	public static ArrayList<LoaiKhach> listLoaiKhach = LoaiKhachBUS.loadDSLoaiKhach();
	private LoaiKhach loaiKhach = new LoaiKhach();
	
	public static ArrayList<LoaiPhong> listLoaiPhong = LoaiPhongBUS.loadDSLoaiPhong();
	private LoaiPhong loaiPhong = new LoaiPhong();
	
	public wsCaiDat() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
		);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Qu\u1EA3n l\u00FD lo\u1EA1i ph\u00F2ng");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnThemMoiLoaiPhong = new JButton("Th\u00EAm m\u1EDBi");
		btnThemMoiLoaiPhong.setForeground(Color.WHITE);
		btnThemMoiLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThemMoiLoaiPhong.setBackground(Color.BLUE);
		btnThemMoiLoaiPhong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemLoaiPhong tlp = new ThemLoaiPhong();
				tlp.setVisible(true);
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblNewLabel_3_3 = new JLabel("M\u00E3 lo\u1EA1i");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_4 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng kh\u00E1ch b\u00ECnh th\u01B0\u1EDDng");
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_5 = new JLabel("\u0110\u01A1n gi\u00E1");
		lblNewLabel_3_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtMaLoaiPhong = new JTextField();
		txtMaLoaiPhong.setEditable(false);
		txtMaLoaiPhong.setEnabled(false);
		txtMaLoaiPhong.setForeground(Color.BLACK);
		txtMaLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaLoaiPhong.setDisabledTextColor(Color.BLACK);
		txtMaLoaiPhong.setColumns(10);
		
		txtSoLuongKhachBT = new JTextField();
		txtSoLuongKhachBT.setForeground(Color.BLACK);
		txtSoLuongKhachBT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongKhachBT.setDisabledTextColor(Color.BLACK);
		txtSoLuongKhachBT.setColumns(10);
		
		txtDonGiaLoaiPhong = new JTextField();
		txtDonGiaLoaiPhong.setForeground(Color.BLACK);
		txtDonGiaLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDonGiaLoaiPhong.setDisabledTextColor(Color.BLACK);
		txtDonGiaLoaiPhong.setColumns(10);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("T\u00EAn lo\u1EA1i");
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_4_1 = new JLabel("S\u1ED1 l\u01B0\u1EE3ng kh\u00E1ch t\u1ED1i \u0111a");
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_4_2 = new JLabel("Ph\u1EE5 thu");
		lblNewLabel_3_4_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setForeground(Color.BLACK);
		txtTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenLoaiPhong.setDisabledTextColor(Color.BLACK);
		txtTenLoaiPhong.setColumns(10);
		
		txtSoLuongKhachToiDa = new JTextField();
		txtSoLuongKhachToiDa.setForeground(Color.BLACK);
		txtSoLuongKhachToiDa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoLuongKhachToiDa.setDisabledTextColor(Color.BLACK);
		txtSoLuongKhachToiDa.setColumns(10);
		
		txtPhuThuLoaiPhong = new JTextField();
		txtPhuThuLoaiPhong.setForeground(Color.BLACK);
		txtPhuThuLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhuThuLoaiPhong.setDisabledTextColor(Color.BLACK);
		txtPhuThuLoaiPhong.setColumns(10);
		
		JButton btnCapNhatLoaiPhong = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhatLoaiPhong.setForeground(Color.WHITE);
		btnCapNhatLoaiPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCapNhatLoaiPhong.setBackground(Color.BLUE);
		btnCapNhatLoaiPhong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCapNhatLoaiPhongClick();
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(61)
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(353, Short.MAX_VALUE)
							.addComponent(btnThemMoiLoaiPhong, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(180)
							.addComponent(btnCapNhatLoaiPhong, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtDonGiaLoaiPhong)
								.addComponent(txtSoLuongKhachBT)
								.addComponent(txtMaLoaiPhong, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_3_4_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3_3_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTenLoaiPhong, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(txtSoLuongKhachToiDa, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(txtPhuThuLoaiPhong, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
								.addComponent(lblNewLabel_3_4_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel_2_1_1)
					.addGap(51)
					.addComponent(btnThemMoiLoaiPhong, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_3_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMaLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_3_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtTenLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addGap(24)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_4_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSoLuongKhachBT, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtSoLuongKhachToiDa, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_4_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDonGiaLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPhuThuLoaiPhong, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnCapNhatLoaiPhong, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		
		tbLoaiPhong = new JTable();
		tbLoaiPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowLoaiPhongClick();
			}
		});
		tbLoaiPhong.setModel(new DefaultTableModel(
			new Object[][] {
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
				"M\u00E3 lo\u1EA1i", "T\u00EAn lo\u1EA1i", "S\u1ED1 kh\u00E1ch b/th\u01B0\u1EDDng", "S\u1ED1 kh\u00E1ch t/\u0111a", "\u0110\u01A1n gi\u00E1", "Ph\u1EE5 thu"
			}
		));
		tbLoaiPhong.getColumnModel().getColumn(0).setPreferredWidth(45);
		tbLoaiPhong.getColumnModel().getColumn(0).setMaxWidth(45);
		tbLoaiPhong.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbLoaiPhong.getColumnModel().getColumn(2).setMinWidth(100);
		tbLoaiPhong.getColumnModel().getColumn(5).setPreferredWidth(50);
		tbLoaiPhong.getColumnModel().getColumn(5).setMaxWidth(50);
		scrollPane_1.setViewportView(tbLoaiPhong);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Qu\u1EA3n l\u00FD lo\u1EA1i kh\u00E1ch");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnThemMoiLoaiKhach = new JButton("Th\u00EAm m\u1EDBi");
		btnThemMoiLoaiKhach.setForeground(Color.WHITE);
		btnThemMoiLoaiKhach.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThemMoiLoaiKhach.setBackground(Color.BLUE);
		btnThemMoiLoaiKhach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ThemLoaiKhach tlk = new ThemLoaiKhach();
				tlk.setVisible(true);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		txtMaLoaiKhach = new JTextField();
		txtMaLoaiKhach.setEditable(false);
		txtMaLoaiKhach.setEnabled(false);
		txtMaLoaiKhach.setForeground(Color.BLACK);
		txtMaLoaiKhach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtMaLoaiKhach.setDisabledTextColor(Color.BLACK);
		txtMaLoaiKhach.setColumns(10);
		
		txtTenLoaiKhach = new JTextField();
		txtTenLoaiKhach.setForeground(Color.BLACK);
		txtTenLoaiKhach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTenLoaiKhach.setDisabledTextColor(Color.BLACK);
		txtTenLoaiKhach.setColumns(10);
		
		txtPhuThuLoaiKhach = new JTextField();
		txtPhuThuLoaiKhach.setForeground(Color.BLACK);
		txtPhuThuLoaiKhach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhuThuLoaiKhach.setDisabledTextColor(Color.BLACK);
		txtPhuThuLoaiKhach.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("M\u00E3 lo\u1EA1i");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_1 = new JLabel("T\u00EAn lo\u1EA1i");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_3_2 = new JLabel("Ph\u1EE5 thu");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnCapNhatLoaiKhach = new JButton("C\u1EADp nh\u1EADt");
		btnCapNhatLoaiKhach.setForeground(Color.WHITE);
		btnCapNhatLoaiKhach.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCapNhatLoaiKhach.setBackground(Color.BLUE);
		btnCapNhatLoaiKhach.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnCapNhatLoaiKhachClick();
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(217, Short.MAX_VALUE)
							.addComponent(btnThemMoiLoaiKhach, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtMaLoaiKhach, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtTenLoaiKhach, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtPhuThuLoaiKhach, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(btnCapNhatLoaiKhach, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(110))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(52)
					.addComponent(lblNewLabel_2_1)
					.addGap(46)
					.addComponent(btnThemMoiLoaiKhach, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtMaLoaiKhach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtTenLoaiKhach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPhuThuLoaiKhach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnCapNhatLoaiKhach, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		tbLoaiKhach = new JTable();
		tbLoaiKhach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rowLoaiKhachClick();
			}
		});
		tbLoaiKhach.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"M\u00E3 lo\u1EA1i", "T\u00EAn lo\u1EA1i", "Ph\u1EE5 thu"
			}
		));
		tbLoaiKhach.getColumnModel().getColumn(0).setPreferredWidth(50);
		tbLoaiKhach.getColumnModel().getColumn(0).setMaxWidth(50);
		loadTableLoaiKhach();
		loadTableLoaiPhong();
		
		
		
		scrollPane.setViewportView(tbLoaiKhach);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}
	
	void loadTableLoaiKhach() {
		int r = 0;
		int c = 0;
		r = tbLoaiKhach.getRowCount();
		c = tbLoaiKhach.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbLoaiKhach.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(LoaiKhach loaiKhach: listLoaiKhach) {
			//tbLoaiKhach.setValueAt(row + 1, row, 0);
			tbLoaiKhach.setValueAt(loaiKhach.getId(), row, 0);
			tbLoaiKhach.setValueAt(loaiKhach.getTenLoai(), row, 1);
			tbLoaiKhach.setValueAt(loaiKhach.getPhuThu(), row, 2);
			row++;
		}
	}
	
	void loadTableLoaiPhong() {
		int r = 0;
		int c = 0;
		r = tbLoaiPhong.getRowCount();
		c = tbLoaiPhong.getColumnCount();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				tbLoaiPhong.setValueAt(null, i, j);
			}
		}
		int row = 0;
		for(LoaiPhong loaiPhong: listLoaiPhong) {
			//tbLoaiPhong.setValueAt(row + 1, row, 0);
			tbLoaiPhong.setValueAt(loaiPhong.getId(), row, 0);
			tbLoaiPhong.setValueAt(loaiPhong.getTenLoai(), row, 1);
			tbLoaiPhong.setValueAt(loaiPhong.getSoLuongKhachBinhThuong(), row, 2);
			tbLoaiPhong.setValueAt(loaiPhong.getSoLuongKhachToiDa(), row, 3);
			tbLoaiPhong.setValueAt(loaiPhong.getDonGia(), row, 4);
			tbLoaiPhong.setValueAt(loaiPhong.getPhuThu(), row, 5);
			row++;
		}
	}
	void rowLoaiKhachClick() {
		int rSelection = -1;
		rSelection = tbLoaiKhach.getSelectedRow();
		if(rSelection <= listLoaiKhach.size() - 1) {
			loaiKhach = listLoaiKhach.get(rSelection);
			txtMaLoaiKhach.setText(String.valueOf(loaiKhach.getId()));
			txtTenLoaiKhach.setText(loaiKhach.getTenLoai());
			txtPhuThuLoaiKhach.setText(String.valueOf(loaiKhach.getPhuThu()));
		}
		else {
			loaiKhach = null;
			txtMaLoaiKhach.setText("");
			txtTenLoaiKhach.setText("");
			txtPhuThuLoaiKhach.setText("");
		}
	}
	
	void rowLoaiPhongClick() {
		int rSelection = -1;
		rSelection = tbLoaiPhong.getSelectedRow();
		if(rSelection <= listLoaiPhong.size() - 1) {
			loaiPhong = listLoaiPhong.get(rSelection);
			txtMaLoaiPhong.setText(String.valueOf(loaiPhong.getId()));
			txtTenLoaiPhong.setText(loaiPhong.getTenLoai());
			txtSoLuongKhachBT.setText(String.valueOf(loaiPhong.getSoLuongKhachBinhThuong()));
			txtSoLuongKhachToiDa.setText(String.valueOf(loaiPhong.getSoLuongKhachToiDa()));
			txtDonGiaLoaiPhong.setText(String.valueOf(loaiPhong.getDonGia()));
			txtPhuThuLoaiPhong.setText(String.valueOf(loaiPhong.getPhuThu()));
		}
		else {
			loaiPhong = null;
			txtMaLoaiPhong.setText("");
			txtTenLoaiPhong.setText("");
			txtSoLuongKhachBT.setText("");
			txtSoLuongKhachToiDa.setText("");
			txtDonGiaLoaiPhong.setText("");
			txtPhuThuLoaiPhong.setText("");
		}
	}
	
	void btnCapNhatLoaiKhachClick() {
		if( LoaiKhachBUS.CapNhatLoaiKhach(txtMaLoaiKhach.getText(), txtTenLoaiKhach.getText(), txtPhuThuLoaiKhach.getText()) == 1){
			listLoaiKhach = LoaiKhachBUS.loadDSLoaiKhach();
			loadTableLoaiKhach();
		}
	}
	
	void btnCapNhatLoaiPhongClick() {
		if( LoaiPhongBUS.CapNhatLoaiPhong(txtMaLoaiPhong.getText(),txtTenLoaiPhong.getText(), txtDonGiaLoaiPhong.getText(), txtSoLuongKhachBT.getText(), txtSoLuongKhachToiDa.getText(), txtPhuThuLoaiPhong.getText()) == 1){
			listLoaiPhong = LoaiPhongBUS.loadDSLoaiPhong();
			loadTableLoaiPhong();
		}
	}
}
