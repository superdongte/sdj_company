package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import sdj_company.service.EmployeeUiService;
import sdj_product.dto.Department;
import sdj_product.dto.Employee;
import sdj_product.dto.Title;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
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
	private JComboBox<Title> cbEmpTitle;
	private JComboBox<Department> cbEmpDept;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSpinner salary;
	
	public Employee_ui() throws SQLException {
		Service = new EmployeeUiService();
		initComponents();
	}
	private void initComponents() throws SQLException {
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
		tfEmpno.setText(Service.nextEmpNo());
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
		
		DefaultComboBoxModel<Title> titleModel = new DefaultComboBoxModel<>(new Vector<>(Service.selectTitleAll()));
		cbEmpTitle = new JComboBox<>(titleModel);
		cbEmpTitle.setSelectedIndex(-1);
		panel.add(cbEmpTitle);
		
		JLabel lblSalary = new JLabel("급여");
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSalary);
		
		salary = new JSpinner();
		salary.setModel(new SpinnerNumberModel(1500000, 1000000, 5000000, 100000));
		panel.add(salary);
		
//		JLabel gender = new JLabel("성별");
//		gender.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel.add(gender);
//		
//		JPanel panel_1 = new JPanel();
//		panel.add(panel_1);
//		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
//		
//		JRadioButton rdbtnMale_1 = new JRadioButton("남");
//		rdbtnMale_1.setSelected(true);
//		rdbtnMale_1.setHorizontalAlignment(SwingConstants.RIGHT);
//		panel_1.add(rdbtnMale_1);
//		
//		JRadioButton rdbtnFemale_1 = new JRadioButton("여");
//		panel_1.add(rdbtnFemale_1);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblGender);

		JPanel pGender = new JPanel();
		panel.add(pGender);
		pGender.setLayout(new GridLayout(0, 2, 0, 0));

		rdbtnMale = new JRadioButton("남");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setHorizontalAlignment(SwingConstants.RIGHT);
		pGender.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("여");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setHorizontalAlignment(SwingConstants.LEFT);
		pGender.add(rdbtnFemale);
		
		JLabel lblDepartment = new JLabel("부서");
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblDepartment);
		
//		JComboBox department = new JComboBox();
//		panel.add(department);
			
		DefaultComboBoxModel<Department> deptModel = new DefaultComboBoxModel<>(new Vector<>(Service.selectDeptAll()));
		cbEmpDept = new JComboBox<>(deptModel);
		cbEmpDept.setSelectedIndex(-1);
		panel.add(cbEmpDept);
		
		
		JLabel lblIpsa = new JLabel("입사일");
		lblIpsa.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblIpsa);
		
		tfIpsa = new JTextField();
		tfIpsa.setColumns(10);
		tfIpsa.setText(String.format("%tF", new Date()));
		panel.add(tfIpsa);
		
		
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
	   
	    pEmpList.setPopupMenu(getPopupMenu());
	}

	private JPopupMenu getPopupMenu() {
		JPopupMenu popupMenu = new JPopupMenu();

		JMenuItem mntmUpdate = new JMenuItem("수정");
		mntmUpdate.addActionListener(this);
		popupMenu.add(mntmUpdate);

		JMenuItem mntmDelete = new JMenuItem("삭제");
		mntmDelete.addActionListener(this);
		popupMenu.add(mntmDelete);

		return popupMenu;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("삭제")) {
			do_mntmDelete_actionPerformed(e);
		}
		if (e.getActionCommand().equals("수정")) {
			if (e.getSource() == btnAdd) {
				do_btnUpdate_actionPerfromed(e);
			} else {
				do_mntmUpdate_actionPerformed(e);
			}
		}
		if (e.getActionCommand().equals("취소")) {
			do_btnCancel_actionPerformed(e);
		}
		if (e.getActionCommand().equals("추가")) {
			do_btnAdd_actionPerformed(e);
		}
	}
	private void do_mntmUpdate_actionPerformed(ActionEvent e) {
		Employee emp = pEmpList.getSelectedEmployee();
		setEmployee(emp);

		btnAdd.setText("수정");
		
	}

	private void setEmployee(Employee emp) {
		tfEmpno.setText(emp.getEmpno());
		tfEmpname.setText(emp.getEmpname());
		cbEmpTitle.setSelectedItem(emp.getTitle());
		salary.setValue(emp.getSalary());
		/* buttonGroup.setSelected(RadioButton, true); */
		if (emp.getGender().equals("남자")) {
			rdbtnMale.setSelected(true);
		} else {
			rdbtnFemale.setSelected(true);
		}
		cbEmpDept.setSelectedItem(emp.getDno());
		tfIpsa.setText(emp.getIpsa() + "");
		
	}

	private void do_btnUpdate_actionPerfromed(ActionEvent e) {
		Employee emp = getEmployee();
		int res = 0;

		try {
			res = Service.UpdateEmployee(emp);
			pEmpList.setList(Service.selectEmpAll());
			pEmpList.loadData();
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "수정되었습니다.");
				btnAdd.setText("추가");
				tfEmpno.setText(Service.nextEmpNo());
			}
			clearTf();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		btnAdd.setText("추가");
	}
		
	private void clearTf() {
		try {
			tfEmpno.setText(Service.nextEmpNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tfEmpname.setText("");
		cbEmpTitle.setSelectedIndex(-1);
		salary.setValue(1500000);
		rdbtnMale.setSelected(true);
		cbEmpDept.setSelectedIndex(-1);
		tfIpsa.setText(String.format("%tF", new Date()));
		tfEmpname.requestFocus();
		
	}

	private Employee getEmployee() {
		String empNo = tfEmpno.getText().trim();
		String empName = tfEmpname.getText().trim();
		Title title = (Title) cbEmpTitle.getSelectedItem();
		int Ssalary = (int) salary.getValue();
		String gender = null;
		if (rdbtnMale.isSelected()) {
			gender = "남자";
		} else {
			gender = "여자";
		}
		Department department = (Department) cbEmpDept.getSelectedItem();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(tfIpsa.getText().trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Employee(empNo, empName, title, Ssalary, gender, date, department);
	}

	

	private void do_mntmDelete_actionPerformed(ActionEvent e) {
		Employee emp = pEmpList.getSelectedEmployee();
		int res = 0;

		try {
			res = Service.unRegisterEmployee(emp);
			pEmpList.setList(Service.selectEmpAll());
			pEmpList.loadData();
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "삭제되었습니다.");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		Employee emp = getEmployee();
		int res = 0;

		try {
			res = Service.registerEmployee(emp);
			pEmpList.setList(Service.selectEmpAll());
			pEmpList.loadData();
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "추가되었습니다.");
			}
			clearTf();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		dispose();
	}
}
