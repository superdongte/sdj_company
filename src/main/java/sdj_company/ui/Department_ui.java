package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sdj_company.service.DeptUiService;
import sdj_product.dto.Department;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Department_ui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tFDeptno;
	private JTextField tfDeptname;
	private JTextField tfFloor;
	private DeptUiService service;
	private JButton btnAdd;
	private JButton btnCancel;
	private Department_panel pDeptList;
	
	public static final String ADD = "추가";
	public static final String UPDATE = "수정";
	public static final String DEL = "삭제";
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

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

/*		Department_panel D_panel = new Department_panel();
		D_panel.setLists(service.selectDeptAll());
		D_panel.loadData();*/

		pDeptList = new Department_panel();
		pDeptList.setLists(service.selectDeptAll());
		pDeptList.loadData();
		contentPane.add(pDeptList);
		/*
		 * contentPane.add(D_panel, BorderLayout.CENTER); D_panel.setLayout(new
		 * BorderLayout(0, 0));
		 */
		pDeptList.setPopupMenu(createDeptPopUpMenu());
	}
	private JPopupMenu createDeptPopUpMenu() {
		JPopupMenu PopMenu = new JPopupMenu();
		JMenuItem delitem = new JMenuItem("삭제");
		delitem.addActionListener(this);
		JMenuItem updateitem = new JMenuItem("수정");
		updateitem.addActionListener(this);
		PopMenu.add(updateitem);
		PopMenu.add(delitem);
		return PopMenu;
	}
	
	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, e);
		if (e.getActionCommand().equals("취소")) {
			do_btnCancel_actionPerformed(e);
		}
		
		if(e.getActionCommand().equals(UPDATE)) {
			if(e.getSource() == btnAdd) {
				do_btnUpdate_actionPerformed(e);
			}else {
				do_mntnUpdate_actionPerformed(e);
			}
		}
		if(e.getActionCommand().equals(ADD)) {
				do_btnAdd_actionPerformed(e);
		}
		if(e.getActionCommand().equals(DEL)) {
			do_mntmDel_actionPerformed(e);
		}
	}

	private void do_mntmDel_actionPerformed(ActionEvent e) {
		Department selectedSt = pDeptList.selectedItem();
		JOptionPane.showMessageDialog(null, selectedSt);
		try {
			int res = service.unRegisterDepartment(selectedSt);
			if(res == 1) {
				pDeptList.setLists(service.selectDeptAll());
				pDeptList.loadData();
				JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
			}
		}catch(SQLException e1) {
			if(e1.getErrorCode() == 1451) {
				JOptionPane.showMessageDialog(null, "해당부서에 사원이 존재합니다");	
		}else {
			e1.printStackTrace();
		}
	}
}

	private void do_mntnUpdate_actionPerformed(ActionEvent e) {
		Department selectedStd = pDeptList.selectedItem();
		setDepartment(selectedStd);
		btnAdd.setText(UPDATE);
		
	}
	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		Department delDept = getDepartment();
		try {
			int res = service.UpdateDepartment(delDept);
			if(res == 1) {
				pDeptList.setLists(service.selectDeptAll());
				pDeptList.loadData();
				JOptionPane.showMessageDialog(null, "수정되엇습니다.");
			}
		}catch(SQLException e1){
			 e1.printStackTrace();
		}
	}
	
	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		Department department = getDepartment();
		int res = 0;
		try {
			res = service.registerDepartment(department);
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "추가했다.");
			}
			pDeptList.setLists(service.selectDeptAll());
			pDeptList.loadData();
			clearTf();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "유효하지않는 명령");
			e1.printStackTrace();
		}
	}// end of btn1

	private void clearTf() {
		tfDeptname.setText("");
		tfFloor.setText("");
	}

	private Department getDepartment() {
		String Dno = tFDeptno.getText().trim();
		String Dname = tfDeptname.getText().trim();
		int Dfloor = Integer.parseInt(tfFloor.getText().trim());
		return new Department(Dno, Dname, Dfloor);
	}
	private void setDepartment(Department dept) {
			tFDeptno.setText(dept.getDeptno());
			tfDeptname.setText(dept.getDeptname());
			tfFloor.setText(dept.getFloor()+"");
	}
	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		clearTf();
	}
}// end of class
