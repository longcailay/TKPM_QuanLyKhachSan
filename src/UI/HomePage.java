package UI;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import DTO.NguoiDung;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;

import WSPACE.*;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Label;
import java.awt.SystemColor;

public class HomePage extends JFrame {
	//Các group Layout cho 3 Panel chính
	private GroupLayout groupLayout;
	
	//3 Panel chinh
	public static JPanel pnWorkspace= new JPanel();
	public static JPanel pnMenu = new JPanel();
	public static JPanel pnTitle= new JPanel();
	
	//panel Title
	public static JLabel lblTitle;
	
	//Panel Menu
	public static JButton btnQuanLyPhong;
	public static JButton btnThuePhong;	
	public static JButton btnHoaDon;	
	public static JButton btnNhanVien;	
	public static JButton btnBaoCao;	
	public static JButton btnCaiDat;	
	public static JButton btnThanhToan;
	public static JButton btnDangXuat = new JButton("Đăng xuất");
	
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	//Cái này là người dùng
	public static NguoiDung nguoiDung = new NguoiDung();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.btnQuanLyPhong.doClick();
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public void setupPanelMenu(JPanel pnMenu)
	{
		pnMenu.setAlignmentY(0.0f);
		pnMenu.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnMenu.setBackground(new Color(0, 153, 255));
		pnMenu.setForeground(new Color(0, 255, 0));
		
		InitializePanelMenu(pnMenu);//set vị trí và kích thước các Button trong PanelMenu
		
		//Tạo các workSpace khi nhấn các nút chức năng
		btnQuanLyPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnQuanLyPhong.getText());
				loadNewWorkspace("QuanLyPhong");
				setButtonPressedColor(btnQuanLyPhong);
			}
		});
		
		btnThanhToan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnThanhToan.getText());
				loadNewWorkspace("ThanhToan");
				setButtonPressedColor(btnThanhToan);
			}
		});
		
		btnHoaDon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnHoaDon.getText());
				loadNewWorkspace("HoaDon");
				setButtonPressedColor(btnHoaDon);
			}
		});
		
		btnThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnThuePhong.getText());
				loadNewWorkspace("ThuePhong");
				setButtonPressedColor(btnThuePhong);
			}
		});
		
		btnNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnNhanVien.getText());
				loadNewWorkspace("NhanVien");
				setButtonPressedColor(btnNhanVien);
			}
		});
		
		btnBaoCao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnBaoCao.getText());
				loadNewWorkspace("BaoCao");
				setButtonPressedColor(btnBaoCao);
			}
		});
		
		btnCaiDat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnCaiDat.getText());
				loadNewWorkspace("CaiDat");
				setButtonPressedColor(btnCaiDat);
			}
		});
		
		listButton.add(btnQuanLyPhong);
		listButton.add(btnThuePhong);
		listButton.add(btnHoaDon);
		listButton.add(btnNhanVien);
		listButton.add(btnBaoCao);
		listButton.add(btnCaiDat);
		listButton.add(btnThanhToan);
		pnMenu.setLayout(null);
	}
	
	public void loadNewWorkspace(String ws)
	{
		pnWorkspace.setVisible(false);
		if(ws == "NhanVien") {
			pnWorkspace = new wsNhanVien();
		}else if (ws == "ThuePhong")
		{
			pnWorkspace = new wsThuePhong();
		}else if (ws == "BaoCao")
		{
			pnWorkspace = new wsBaoCao();
		}else if (ws == "CaiDat")
		{
			pnWorkspace = new wsCaiDat();
		}else if (ws == "HoaDon")
		{
			pnWorkspace = new wsHoaDon();
		}else if (ws == "ThuePhong")
		{
			pnWorkspace = new wsThuePhong();
		}
		else if (ws == "QuanLyPhong")
		{
			pnWorkspace = new wsQuanLyPhong();
		}
		else
		{
			pnWorkspace = new wsThanhToan();
		}
		pnWorkspace.setVisible(true);
		addGroupLayoutPanels(pnWorkspace);
		getContentPane().setLayout(groupLayout);
	}
	
	public void setupTitle(JPanel pnTitle) {
		pnTitle.setAlignmentY(0.0f);
		pnTitle.setAlignmentX(0.0f);
		pnTitle.setBackground(new Color(240, 240, 240));
		lblTitle = new JLabel();
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
	}
	
	public void setupWorkspace(JPanel pnWorkspace) {
		//pnWorkspace.setBackground(new Color(102, 5, 255));
	}
	
	
	//Khung làm việc dùng Group layout để bố trí các Panel chính cho chương trình
	//Gồm có 3 Panel chính: Workspace, title, menu chức năng
	public void addGroupLayoutPanels(JPanel workSpace)
	{
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(workSpace, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
						.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(workSpace, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
		);
	}
	
	public void InitializePanelMenu(JPanel pnMenu)
	{
		btnQuanLyPhong = new JButton("Quản Lý Phòng");
		btnQuanLyPhong.setBounds(0, 109, 270, 73);
		btnQuanLyPhong.setBackground(new Color(0, 51, 255));
		btnQuanLyPhong.setBorder(null);
		btnQuanLyPhong.setForeground(SystemColor.control);
		pnMenu.add(btnQuanLyPhong);
		
		btnThuePhong = new JButton("Phiếu thuê");
		btnThuePhong.setForeground(SystemColor.control);
		btnThuePhong.setBorder(null);
		btnThuePhong.setBackground(new Color(0, 51, 255));
		btnThuePhong.setBounds(0, 327, 270, 73);
		pnMenu.add(btnThuePhong);
		
		btnHoaDon = new JButton("Hóa Đơn");
		btnHoaDon.setForeground(SystemColor.control);
		btnHoaDon.setBorder(null);
		btnHoaDon.setBackground(new Color(0, 51, 255));
		btnHoaDon.setBounds(0, 254, 270, 73);
		pnMenu.add(btnHoaDon);
		
		btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setForeground(SystemColor.control);
		btnNhanVien.setBorder(null);
		btnNhanVien.setBackground(new Color(0, 51, 255));
		btnNhanVien.setBounds(0, 400, 270, 73);
		pnMenu.add(btnNhanVien);
		
		btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setForeground(SystemColor.control);
		btnBaoCao.setBorder(null);
		btnBaoCao.setBackground(new Color(0, 51, 255));
		btnBaoCao.setBounds(0, 472, 270, 73);
		pnMenu.add(btnBaoCao);
		
		btnCaiDat = new JButton("Cài Đặt");
		btnCaiDat.setForeground(SystemColor.control);
		btnCaiDat.setBorder(null);
		btnCaiDat.setBackground(new Color(0, 51, 255));
		btnCaiDat.setBounds(0, 542, 270, 79);
		pnMenu.add(btnCaiDat);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBorder(null);
		btnThanhToan.setForeground(SystemColor.control);
		btnThanhToan.setBackground(new Color(0, 51, 255));
		btnThanhToan.setBounds(0, 181, 270, 73);
		pnMenu.add(btnThanhToan);
	}
		
	void setButtonPressedColor(JButton btn) {
		for(JButton button: listButton) {
			if(button.equals(btn)) {
				btn.setBackground(new Color(0, 51, 153));
			}
			else {
				button.setBackground(new Color(0, 51, 255));
			}
		}
	}
	public HomePage() {		
		setSize(new Dimension(1200, 800));
		//setBackground(new Color(0, 51, 255));
		//setForeground(new Color(0, 51, 255));
		setTitle("HoApp");
		setLocationRelativeTo(null);//set center of screen

		//Cài đặt Panel Menu
		pnMenu = new JPanel();
		setupPanelMenu(pnMenu);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("/images/hotel.png")));
		lblNewLabel.setBounds(0, 0, 270, 111);
		pnMenu.add(lblNewLabel);
		
		//Cài đặt Title
		pnTitle = new JPanel();
		setupTitle(pnTitle);
		
		//Cài đặt Workspace (khung làm việc chính)
		pnWorkspace = new JPanel();	
		setupWorkspace(pnWorkspace);
			
		
		//Begin: group Layout cho panel Title
		GroupLayout gl_pnTitle = new GroupLayout(pnTitle);
		gl_pnTitle.setHorizontalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					//.addComponent(btnDangXuat,GroupLayout.DEFAULT_SIZE, 100, GroupLayout.DEFAULT_SIZE)
					.addContainerGap(371, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					//.addComponent(btnDangXuat,GroupLayout.DEFAULT_SIZE, 20, GroupLayout.DEFAULT_SIZE)
					.addContainerGap())
		);
		pnTitle.setLayout(gl_pnTitle);
		//End: group Layout cho panel Title
		
		getContentPane().setLayout(groupLayout);//Quan trọng set Layout cho 3 Panel Chính trên HomePage	
	}
}
