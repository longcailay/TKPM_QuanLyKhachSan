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

public class wsQuanLyPhong extends JPanel {
	/*Khai báo các biến*/
	public static JComboBox cmbLoaiPhong;
	public static JComboBox cmbTinhTrang;
	public static JButton btnDuyet;
	public static JButton btnThemPhongMoi;
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
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JPanel panel_1 = new JPanel();
		JPanel panel_3 = new JPanel();
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
		
		JLabel lblNewLabel_3 = new JLabel("Danh S\u00E1ch Kh\u00E1ch Thu\u00EA");
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(Color.RED);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(241)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(53)
							.addComponent(btnNewButton)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_3)
					.addGap(116)
					.addComponent(btnNewButton)
					.addContainerGap(448, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		setLayout(groupLayout);

	}
}
