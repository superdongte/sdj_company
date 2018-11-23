package sdj_company.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Title_panel extends JPanel {
	private JTable T_table;

	/**
	 * Create the panel.
	 */
	public Title_panel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		T_table = new JTable();
		scrollPane.setViewportView(T_table);
	}

}
