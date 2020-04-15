package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import WSPACE.*;

public class HomePage extends JFrame {
	
	
	
	//global variable
	//Các group Layout cho 3 Panel chính
	private GroupLayout groupLayout;
	
	//3 Panel chinh
	private JPanel pnWorkspace;
	private JPanel pnMenu;
	private JPanel pnTitle;
	
	//Panel Menu
	public static JButton btnQuanLyPhong;
	public static JButton btnHoaDon;	
	public static JButton btnNhanVien;	
	public static JButton btnBaoCao;	
	public static JButton btnCaiDat;	
	public static JButton btnThuePhong;	
	public static JButton btnThanhTon;
	
	//panel Title
	public static JLabel lblTitle;
	
	//workspace 
	public static wsThuePhong wsThuePhong;
	private JLabel lblNewLabel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
		
		
		//các button
		btnQuanLyPhong = new JButton("Quản Lý Phòng");
		btnQuanLyPhong.setBounds(0, 327, 270, 73);
		pnMenu.add(btnQuanLyPhong);
		
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
		
		btnThuePhong = new JButton("Thuê Phòng");
		btnThuePhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTitle.setText(btnThuePhong.getText());
				//clear workspace hiện tại ???
				pnWorkspace.setVisible(false);
				
				wsThuePhong = new wsThuePhong();
				wsThuePhong.setVisible(true);
				
				groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(wsThuePhong, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
								.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(wsThuePhong, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
				);
				
				getContentPane().setLayout(groupLayout);
				
			}
		});
		btnThuePhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnThuePhong.setActionCommand("Thuê Phòng");
		btnThuePhong.setBounds(0, 109, 270, 73);
		pnMenu.add(btnThuePhong);
		
		btnThanhTon = new JButton("Thanh Toán");
		btnThanhTon.setBounds(0, 181, 270, 73);
		pnMenu.add(btnThanhTon);
		
		pnMenu.setLayout(null);
	}
	public void setupTitle(JPanel pnTitle) {
		pnTitle.setAlignmentY(0.0f);
		pnTitle.setAlignmentX(0.0f);
		pnTitle.setBackground(Color.GREEN);
		
		lblTitle = new JLabel("Tiêu Đề");
	}
	
	public void setupWorkspace(JPanel pnWorkspace) {
		pnWorkspace.setBackground(new Color(102, 255, 255));
		
	}
	public HomePage() {		
		setSize(new Dimension(1200, 800));
		setTitle("HoApp");

		//Cài đặt Panel Menu
		pnMenu = new JPanel();
		setupPanelMenu(pnMenu);
		
		//Cài đặt Title
		pnTitle = new JPanel();
		setupTitle(pnTitle);
		
		//Cài đặt Work
		pnWorkspace = new JPanel();	
		setupWorkspace(pnWorkspace);
		
		
		//Begin: add group Layout 3 panel chính
		groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnMenu, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnWorkspace, GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
						.addComponent(pnTitle, GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(pnMenu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnTitle, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnWorkspace, GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
		);
		//End: add group Layout 3 panel chính
		
		
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
