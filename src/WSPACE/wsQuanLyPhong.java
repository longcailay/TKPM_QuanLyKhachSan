package WSPACE;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import ButtonPhong.*;
import UI.HomePage;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import BUS.*;
import DTO.*;

import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;

public class wsQuanLyPhong extends JPanel {
	
	/*Khai báo các biến*/
	//các panel
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	
	private JComboBox cmbLoaiPhong;
	private JComboBox cmbTinhTrang;
	private JButton btnDuyet;
	private JButton btnThemPhongMoi;
	private JLabel lblPhong;
	private JTextField txtTinhTrang;
	private JTextField txtNgayThue;
	private JTable tbDanhSachKhachThue;
	private JTextField txtGhiChu;
	
	private JButton btnThuePhong;
	private JButton btnTraPhong;
	private JButton btnSuaPhong;
	private JButton btnXoaPhong;
	/**
	 * Create the panel.
	 */
	public wsQuanLyPhong() {
		//JPanel pnWorkspace = new JPanel();
		this.setBackground(Color.PINK);
		
		panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(0.0f);
		
		panel_2 = new JPanel();
		panel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 542, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PHÒNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(69, 57, 75, 20);
		panel_2.add(lblNewLabel_1);
		
		lblPhong = new JLabel("New label");
		lblPhong.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPhong.setBounds(154, 47, 69, 33);
		panel_2.add(lblPhong);
		
		JLabel lblNewLabel_3 = new JLabel("Tình trạng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(42, 139, 75, 13);
		panel_2.add(lblNewLabel_3);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setDisabledTextColor(Color.BLACK);
		txtTinhTrang.setForeground(Color.RED);
		txtTinhTrang.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		txtTinhTrang.setEnabled(false);
		txtTinhTrang.setBounds(127, 137, 96, 19);
		panel_2.add(txtTinhTrang);
		txtTinhTrang.setColumns(10);
		
		JLabel lblNgayThue = new JLabel("Ngày thuê");
		lblNgayThue.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgayThue.setBounds(42, 192, 75, 13);
		panel_2.add(lblNgayThue);
		
		txtNgayThue = new JTextField();
		txtNgayThue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtNgayThue.setEnabled(false);
		txtNgayThue.setColumns(10);
		txtNgayThue.setBounds(127, 190, 96, 19);
		panel_2.add(txtNgayThue);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKhchHng.setBounds(42, 246, 75, 13);
		panel_2.add(lblKhchHng);
		
		tbDanhSachKhachThue = new JTable();
		tbDanhSachKhachThue.setBounds(10, 269, 250, 115);
		panel_2.add(tbDanhSachKhachThue);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGhiCh.setBounds(42, 411, 75, 13);
		panel_2.add(lblGhiCh);
		
		txtGhiChu = new JTextField();
		txtGhiChu.setBounds(10, 434, 250, 63);
		panel_2.add(txtGhiChu);
		txtGhiChu.setColumns(10);
		
		btnThuePhong = new JButton("Thuê phòng");
		btnThuePhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThuePhong.setBounds(10, 516, 117, 33);
		panel_2.add(btnThuePhong);
		
		btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTraPhong.setBounds(143, 516, 117, 33);
		panel_2.add(btnTraPhong);
		
		btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSuaPhong.setBounds(10, 579, 117, 33);
		panel_2.add(btnSuaPhong);
		
		btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoaPhong.setBounds(143, 579, 117, 33);
		panel_2.add(btnXoaPhong);
		
		panel_1 = new JPanel();
		panel_3 = new JPanel();
		panel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_3.setMinimumSize(new Dimension(15, 15));
		panel_3.setForeground(new Color(0, 0, 0));
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setAutoscrolls(true);
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
				.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 586, Short.MAX_VALUE)
		);
		
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.BASELINE)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
		);
		
		
		
		//load danh sách các phòng
		try {
			LoadDSPhong();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JLabel lblNewLabel = new JLabel("Ch\u1ECDn lo\u1EA1i ph\u00F2ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTnhTrng = new JLabel("T\u00ECnh tr\u1EA1ng");
		lblTnhTrng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cmbLoaiPhong = new JComboBox();
		cmbLoaiPhong.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "Vip", "Bình thường"}));
		
		cmbTinhTrang = new JComboBox();
		cmbTinhTrang.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		
		btnDuyet = new JButton("Duyệt");
		
		btnThemPhongMoi = new JButton("Thêm phòng");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(cmbLoaiPhong, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cmbTinhTrang, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblTnhTrng, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addGap(63)
					.addComponent(btnDuyet)
					.addGap(37)
					.addComponent(btnThemPhongMoi)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblTnhTrng, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbLoaiPhong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbTinhTrang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDuyet)
						.addComponent(btnThemPhongMoi))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		
		btnThemPhongMoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomePage.lblTitle.setText(btnThemPhongMoi.getText());
			}
		});
		setLayout(groupLayout);

	}
	
	public void HienThiDanhSachPhong(ArrayList<Phong> listPhong)
    {
		String pathImage = "/images/roomBConTrong.png";
		for(Phong phong: listPhong) {
			
			if(phong.getTinhTrang() == 0) {
				if(phong.getLoaiPhong().equals("Loại A")) {
					pathImage = "/images/roomAConTrong.png";
				}
				
				if(phong.getLoaiPhong().equals("Loại B")) {
					pathImage = "/images/roomBConTrong.png";
				}
				if(phong.getLoaiPhong().equals("Loại C")) {
					pathImage = "/images/roomCConTrong.png";
				}
			}
			
			if(phong.getTinhTrang() == 1) {
				if(phong.getLoaiPhong().equals("Loại A")) {
					pathImage = "/images/roomADangThue.png";
				}
				if(phong.getLoaiPhong().equals("Loại B")) {
					pathImage = "/images/roomBDangThue.png";
				}
				if(phong.getLoaiPhong().equals("Loại C")) {
					pathImage = "/images/roomCDangThue.png";
				}
			}
			
			System.out.println("Tinh trang"+  phong.getTinhTrang() + "  " + phong.getLoaiPhong() + "  " + pathImage);
			if(phong.getTinhTrang() == 0 || phong.getTinhTrang() == 1) {//Nếu không phải phòng đã bị xóa thì add vào panel
				ButtonPhong b = new ButtonPhong(phong.getId(), phong.getTenPhong(), pathImage);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						lblPhong.setText(b.getText());	
						String tinhTrang = "";
						if(phong.getTinhTrang() == 0) {
							tinhTrang = "Còn trống";
						}
						else {
							tinhTrang = "Đã thuê";
						}
						txtTinhTrang.setText(tinhTrang);
						
					}
				});
				panel_3.add(b);
			}
		}
    }
	void LoadDSPhong() throws SQLException
    {
        ArrayList<Phong> listPhong = PhongBUS.LoadDSPhong();
        HienThiDanhSachPhong(listPhong);
    }
}
