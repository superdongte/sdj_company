package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class management extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton BtnEmp;
	private JButton BtnDepart;
	private JButton BtnTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					management frame = new management();
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
	public management() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ERP관리 프로그램");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		BtnEmp = new JButton("사원관리");
		BtnEmp.addActionListener(this);
		contentPane.add(BtnEmp);
		
		BtnDepart = new JButton("부서관리");
		BtnDepart.addActionListener(this);
		contentPane.add(BtnDepart);
		
		BtnTitle = new JButton("직책관리");
		BtnTitle.addActionListener(this);
		contentPane.add(BtnTitle);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == BtnTitle) {
			try {
				do_BtnTitle_actionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == BtnDepart) {
			try {
				do_BtnDepart_actionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == BtnEmp) {
			try {
				do_BtnEmp_actionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	protected void do_BtnEmp_actionPerformed(ActionEvent e) throws SQLException {
		Employee_ui employee_ui = new Employee_ui();
		employee_ui.setVisible(true);
 		
	}
	protected void do_BtnDepart_actionPerformed(ActionEvent e) throws SQLException{
		Department_ui department_ui = new Department_ui();
		department_ui.setVisible(true);
	}
	protected void do_BtnTitle_actionPerformed(ActionEvent e) throws SQLException{
		Title_ui title_ui = new Title_ui();
		title_ui.setVisible(true);
	}
}
