package UI;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;

import WSPACE.*;

public class HomePage extends JFrame {
	//Các group Layout cho 3 Panel chính
	private GroupLayout groupLayout;
	
	//3 Panel chinh
	private JPanel pnWorkspace;
	private JPanel pnMenu;
	private JPanel pnTitle;
	
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
		pnMenu.setBackground(Color.YELLOW);
		pnMenu.setForeground(new Color(0, 255, 0));
		
		InitializePanelMenu(pnMenu);//set vị trí và kích thước các Button trong PanelMenu
		
		//Tạo các workSpace khi nhấn các nút chức năng
		btnQuanLyPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnQuanLyPhong.getText());
				loadNewWorkspace("QuanLyPhong");
			}
		});
		
		btnThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnThuePhong.getText());
				loadNewWorkspace("ThuePhong");
			}
		});
		
		btnNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnNhanVien.getText());
				loadNewWorkspace("NhanVien");
			}
		});
		
		
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
		pnTitle.setBackground(Color.green);
		lblTitle = new JLabel();
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
		pnMenu.add(btnQuanLyPhong);
		
		btnThuePhong = new JButton("Thuê Phòng");
		btnThuePhong.setBounds(0, 327, 270, 73);
		pnMenu.add(btnThuePhong);
		
		btnHoaDon = new JButton("Hóa Đơn");
		btnHoaDon.setBounds(0, 254, 270, 73);
		pnMenu.add(btnHoaDon);
		
		btnNhanVien = new JButton("Nhân Viên");
		btnNhanVien.setBounds(0, 400, 270, 73);
		pnMenu.add(btnNhanVien);
		
		btnBaoCao = new JButton("Báo Cáo");
		btnBaoCao.setBounds(0, 472, 270, 73);
		pnMenu.add(btnBaoCao);
		
		btnCaiDat = new JButton("Cài Đặt");
		btnCaiDat.setBounds(0, 542, 270, 79);
		pnMenu.add(btnCaiDat);
		
		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.setBounds(0, 181, 270, 73);
		pnMenu.add(btnThanhToan);
	}
		
	
	public HomePage() {		
		setSize(new Dimension(1200, 800));
		setTitle("HoApp");
		setLocationRelativeTo(null);//set center of screen

		//Cài đặt Panel Menu
		pnMenu = new JPanel();
		setupPanelMenu(pnMenu);
		
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
					.addGap(357)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(371, Short.MAX_VALUE))
		);
		gl_pnTitle.setVerticalGroup(
			gl_pnTitle.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTitle.createSequentialGroup()
					.addGap(5)
					.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnTitle.setLayout(gl_pnTitle);
		//End: group Layout cho panel Title
		
		
		getContentPane().setLayout(groupLayout);//Quan trọng set Layout cho 3 Panel Chính trên HomePage	
	}
}
