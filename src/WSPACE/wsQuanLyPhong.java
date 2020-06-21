package WSPACE;
import UI.HomePage;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.JTable;

public class wsQuanLyPhong extends JPanel {
	
	/**
	 * Create the panel.
	 */
	public wsQuanLyPhong() {
		
		//JPanel pnWorkspace = new JPanel();
		this.setBackground(Color.PINK);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 838, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 642, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

	}
}
