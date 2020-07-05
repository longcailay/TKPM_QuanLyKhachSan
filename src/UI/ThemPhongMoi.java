package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import DAO.LoaiPhongDAO;
import DTO.LoaiPhong;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.TextField;
import java.util.ArrayList;
import java.awt.Label;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JButton;

public class ThemPhongMoi extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenPhong;
	private JComboBox cmbLoaiPhong;
	private JEditorPane edpGhiChu;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemPhongMoi frame = new ThemPhongMoi();
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
	public ThemPhongMoi() {
		setResizable(false);
		setTitle("HoApp - Thêm phòng mới");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 475);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm phòng mới");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(161, 10, 162, 28);
		contentPane.add(lblNewLabel);
		
		Label label = new Label("Tên phòng");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(94, 62, 101, 33);
		contentPane.add(label);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenPhong.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtTenPhong.setText("102");
		txtTenPhong.setBounds(222, 62, 199, 33);
		contentPane.add(txtTenPhong);
		txtTenPhong.setColumns(10);
		
		Label label_2 = new Label("Ghi chú");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2.setBounds(94, 160, 101, 33);
		contentPane.add(label_2);
		
		cmbLoaiPhong = new JComboBox();
		cmbLoaiPhong.setBounds(222, 111, 199, 33);
		contentPane.add(cmbLoaiPhong);
		loadLoaiPhong();
		
		Label label_2_1 = new Label("Loại phòng");
		label_2_1.setForeground(Color.BLACK);
		label_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_2_1.setBounds(94, 111, 101, 33);
		contentPane.add(label_2_1);
		
		edpGhiChu = new JEditorPane();
		edpGhiChu.setBounds(94, 199, 327, 125);
		contentPane.add(edpGhiChu);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(94, 368, 85, 21);
		contentPane.add(btnNewButton);
	}
	
	 void loadLoaiPhong() {
		 ArrayList<LoaiPhong> listLoaiPhong = LoaiPhongDAO.loadDSLoaiPhong();
		 for(LoaiPhong loaiPhong: listLoaiPhong) {
			 cmbLoaiPhong.addItem(loaiPhong.getTenLoai());
		 }
		 
	 }
	
}
