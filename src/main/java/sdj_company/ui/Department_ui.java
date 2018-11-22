package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Color;

public class Department_ui extends JFrame {

	private JPanel contentPane;
	private JTextField tfDeptno;
	private JTextField tfName;
	private JTextField tfFloor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department_ui frame = new Department_ui();
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
	public Department_ui() {
		initComponents();
	}
	private void initComponents() {
		setTitle("부서관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lbldeptno = new JLabel("번호");
		panel.add(lbldeptno);
		
		tfDeptno = new JTextField();
		panel.add(tfDeptno);
		tfDeptno.setColumns(10);
		
		JLabel lbldeptname = new JLabel("부서명");
		panel.add(lbldeptname);
		
		tfName = new JTextField();
		panel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblfloor = new JLabel("위치");
		panel.add(lblfloor);
		
		tfFloor = new JTextField();
		panel.add(tfFloor);
		tfFloor.setColumns(10);
		
		JButton btnAdd = new JButton("추가");
		panel.add(btnAdd);
		
		JButton btnCancel = new JButton("취소");
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
	}

}
