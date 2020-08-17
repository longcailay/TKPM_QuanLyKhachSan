package WSPACE;

import javax.swing.JPanel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import com.toedter.calendar.JCalendar;

import BUS.BaoCaoBUS;
import DTO.BaoCao;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.awt.Label;



public class wsBaoCao extends JPanel{
	private JCalendar cldThang;
	private JComboBox cmbLoaiBaoCao;
	private JButton btnBaoCao;
	
	
	private JPanel pnBieuDo;
	private JFreeChart pieChart;
    private ChartPanel chartPanel;
    private ArrayList<BaoCao> lsBaoCao;
	public wsBaoCao() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		
		pnBieuDo = new JPanel();
		pnBieuDo.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
				.addComponent(pnBieuDo, GroupLayout.DEFAULT_SIZE, 922, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnBieuDo, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
		);
		JLabel lblNewLabel_3 = new JLabel("Báo cáo theo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cmbLoaiBaoCao = new JComboBox();
		cmbLoaiBaoCao.setModel(new DefaultComboBoxModel(new String[] {"Doanh thu theo loại phòng", "Mật độ sử dụng phòng"}));
		cmbLoaiBaoCao.setSelectedIndex(0);
		
		JLabel lblNewLabel_3_1 = new JLabel("Chọn tháng");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		cldThang = new JCalendar();
		cldThang.getDayChooser().setVisible(false);
		
		btnBaoCao = new JButton("Báo cáo");
		btnBaoCao.setForeground(Color.WHITE);
		btnBaoCao.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBaoCao.setBackground(Color.BLUE);
		btnBaoCao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					btnBaoCaoClick();
			}
		});
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(cmbLoaiBaoCao, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
					.addGap(110)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cldThang, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
							.addGap(103)
							.addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBaoCao, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(cldThang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbLoaiBaoCao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		
		lsBaoCao =  BaoCaoBUS.BaoCaoDoanhThuTheoLoaiPhong(cldThang.getMonthChooser().getMonth() + 1,String.valueOf(cldThang.getYearChooser().getYear()));
		loadBieuDo();
	}
	
	private JFreeChart createChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart(cmbLoaiBaoCao.getModel().getSelectedItem().toString(), dataset, true, true, false);
		 //Format Label
	    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
	        "{0} : {2}", new DecimalFormat("0"), new DecimalFormat("0%"));
	    ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);
	    return chart;
	}

	private PieDataset createDataset() {
	  DefaultPieDataset dataset = new DefaultPieDataset();
	  for(BaoCao bc: lsBaoCao) {
		  dataset.setValue(bc.getTen(), bc.getGiaTri());
	  }
	  return dataset;
	}

	void loadBieuDo() {
		pnBieuDo.removeAll();
		pieChart = createChart(createDataset());
	    chartPanel = new ChartPanel(pieChart);
		pnBieuDo.setBackground(Color.white);
		Dimension dChart = new Dimension(857,512);
		chartPanel.setPreferredSize(dChart);
		chartPanel.setBackground(Color.white);
		pnBieuDo.add(chartPanel);
		pnBieuDo.setVisible(false);
		pnBieuDo.setVisible(true);
	}
	
	void btnBaoCaoClick() {
		if(cmbLoaiBaoCao.getSelectedItem().toString().equals("Doanh thu theo loại phòng")) {
			lsBaoCao =  BaoCaoBUS.BaoCaoDoanhThuTheoLoaiPhong(cldThang.getMonthChooser().getMonth() + 1,String.valueOf(cldThang.getYearChooser().getYear()));
		}
		if(cmbLoaiBaoCao.getSelectedItem().toString().equals("Mật độ sử dụng phòng")) {
			lsBaoCao = BaoCaoBUS.BaoCaoMatDoSuDungPhong(cldThang.getMonthChooser().getMonth() + 1,String.valueOf(cldThang.getYearChooser().getYear()));
		}
		loadBieuDo();
	}

}
