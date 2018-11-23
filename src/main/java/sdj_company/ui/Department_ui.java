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
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Department_ui extends JFrame {

	private JPanel contentPane;
	private JTextField tFDeptno;
	private JTextField tfDeptname;
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
		setBounds(100, 100, 450, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 10, 10));
		
		JLabel lblDeptno = new JLabel("번호");
		lblDeptno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDeptno);
		
		tFDeptno = new JTextField();
		panel.add(tFDeptno);
		tFDeptno.setColumns(10);
		
		JLabel lblDeptname = new JLabel("부서명");
		lblDeptname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDeptname);
		
		tfDeptname = new JTextField();
		panel.add(tfDeptname);
		tfDeptname.setColumns(10);
		
		JLabel lblFloor = new JLabel("위치");
		lblFloor.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblFloor);
		
		tfFloor = new JTextField();
		panel.add(tfFloor);
		tfFloor.setColumns(10);
		
		JButton btn1 = new JButton("추가");
		panel.add(btn1);
		
		JButton btn2 = new JButton("취소");
		panel.add(btn2);
		
		JPanel D_panel = new JPanel();
		contentPane.add(D_panel, BorderLayout.CENTER);
		D_panel.setLayout(new BorderLayout(0, 0));
	}

}
