package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sdj_company.service.DeptUiService;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Department_ui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tFDeptno;
	private JTextField tfDeptname;
	private JTextField tfFloor;
	private DeptUiService service;
	private JButton btn1;
	private JButton btn2;

	
	public Department_ui() {
		
		service = new DeptUiService();
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
		tFDeptno.setEnabled(false);
		panel.add(tFDeptno);
		tFDeptno.setText(service.nextDeptno());
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
		
		btn1 = new JButton("추가");
		btn1.addActionListener(this);
		panel.add(btn1);
		
		btn2 = new JButton("취소");
		btn2.addActionListener(this);
		panel.add(btn2);
		

		Department_panel D_panel = new Department_panel();
		D_panel.setLists(service.selectDeptAll());
		D_panel.loadData();
		contentPane.add(D_panel);
		/*contentPane.add(D_panel, BorderLayout.CENTER);
		D_panel.setLayout(new BorderLayout(0, 0));*/
		
		
	}
		
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn2) {
			do_btn2_actionPerformed(e);
		}
		if (e.getSource() == btn1) {
			do_btn1_actionPerformed(e);
		}
	}
	protected void do_btn1_actionPerformed(ActionEvent e) {
		
	
	}
	protected void do_btn2_actionPerformed(ActionEvent e) {
	}
}//end of class
