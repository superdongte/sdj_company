package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sdj_company.service.EmployeeUiService;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Employee_ui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfEmpno;
	private JTextField tfEmpname;
	private JTextField tfIpsa;
	private JTextField tfTno;
	private JTextField tFName;
	private JButton btnAdd;
	private JButton btnCancel;
	private EmployeeUiService Service;
	private Employee_panel pEmpList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_ui frame = new Employee_ui();
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
	public Employee_ui() {
		Service = new EmployeeUiService();
		initComponents();
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblEmpno = new JLabel("번호");
		lblEmpno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblEmpno);
		
		tfEmpno = new JTextField();
		tfEmpno.setEnabled(false);
		panel.add(tfEmpno);
		tfEmpno.setColumns(10);
		
		JLabel lblEmpname = new JLabel("사원명");
		lblEmpname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblEmpname);
		
		tfEmpname = new JTextField();
		panel.add(tfEmpname);
		tfEmpname.setColumns(10);
		
		JLabel lblTitle = new JLabel("직책");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTitle);
		
		JComboBox tfTitle = new JComboBox();
		panel.add(tfTitle);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSalary);
		
		JSpinner salary = new JSpinner();
		salary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		panel.add(salary);
		
		JLabel gender = new JLabel("성별");
		gender.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(gender);
		
		JPanel gender_1 = new JPanel();
		panel.add(gender_1);
		gender_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton man = new JRadioButton("남자");
		man.setSelected(true);
		gender_1.add(man);
		
		JRadioButton woman = new JRadioButton("여자");
		gender_1.add(woman);
		
		JLabel lblDepartment = new JLabel("부서");
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDepartment);
		
		JComboBox department = new JComboBox();
		panel.add(department);
		
		JLabel lblIpsa = new JLabel("입사일");
		lblIpsa.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblIpsa);
		
		tfIpsa = new JTextField();
		panel.add(tfIpsa);
		tfIpsa.setColumns(10);
		
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);
		
		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);
		
		pEmpList = new Employee_panel();
		pEmpList.setList(Service.selectEmpAll());
	    pEmpList.loadData();
	    contentPane.add(pEmpList);

		/*JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));*/
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancel) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getSource() == btnAdd) {
			do_btnAdd_actionPerformed(e);
		}
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
	}
}
