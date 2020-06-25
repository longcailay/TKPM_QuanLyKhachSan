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
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;

import UI.HomePage;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.GridLayout;

public class wsQuanLyPhong extends JPanel {
	/*Khai báo các biến*/
	public static JComboBox cmbLoaiPhong;
	public static JComboBox cmbTinhTrang;
	public static JButton btnDuyet;
	public static JButton btnThemPhongMoi;
	private JTextField txtTinhTrang;
	private JTextField txtNgayThue;
	private JTable table;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public wsQuanLyPhong() {
		//JPanel pnWorkspace = new JPanel();
		this.setBackground(Color.PINK);
		
		JPanel panel = new JPanel();
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setAlignmentY(0.0f);
		
		JPanel panel_2 = new JPanel();
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
		
		JLabel lblPhong = new JLabel("New label");
		lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPhong.setBounds(154, 57, 45, 20);
		panel_2.add(lblPhong);
		
		JLabel lblNewLabel_3 = new JLabel("Tình trạng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(42, 139, 75, 13);
		panel_2.add(lblNewLabel_3);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTinhTrang.setEnabled(false);
		txtTinhTrang.setBounds(127, 137, 96, 19);
		panel_2.add(txtTinhTrang);
		txtTinhTrang.setColumns(10);
		
		JLabel lblNgayThue = new JLabel("Tình trạng");
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
		
		table = new JTable();
		table.setBounds(10, 269, 250, 115);
		panel_2.add(table);
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGhiCh.setBounds(42, 411, 75, 13);
		panel_2.add(lblGhiCh);
		
		textField = new JTextField();
		textField.setBounds(10, 434, 250, 63);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnThuePhong = new JButton("Thuê phòng");
		btnThuePhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnThuePhong.setBounds(10, 516, 117, 33);
		panel_2.add(btnThuePhong);
		
		JButton btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnTraPhong.setBounds(143, 516, 117, 33);
		panel_2.add(btnTraPhong);
		
		JButton btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSuaPhong.setBounds(10, 579, 117, 33);
		panel_2.add(btnSuaPhong);
		
		JButton btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnXoaPhong.setBounds(143, 579, 117, 33);
		panel_2.add(btnXoaPhong);
		
		JPanel panel_1 = new JPanel();
		JPanel panel_3 = new JPanel();
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
		for(int i = 0; i < 30; i++) {
		JButton btn = new JButton("Button" + i);
		btn.setPreferredSize(new Dimension(108, 100));//Kích thước chuẩn
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomePage.lblTitle.setText(btn.getText());
			}
		});
		panel_3.add(btn);
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
}
