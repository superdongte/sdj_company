package sdj_company.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sdj_product.dto.Department;

public class Department_panel extends JPanel {
	private JTable D_table;
	private List<Department> list;
	public void setLists(List<Department> list) {
		this.list = list;
	}
	
	public Department_panel() {

		initComponents();
	}
	
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		D_table = new JTable();
		scrollPane.setViewportView(D_table);
	}
	public void loadData() {
		D_table.setModel(new DefaultTableModel(
				getdatas(),
				getCoulum()
				));
				
	}
	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			datas[i]=getRow(list.get(i));
		}
		return datas;
	}
	
	private Object[] getCoulum() {
		return new String[] {"부서번호","부서명","위치"};
	}
	private Object[] getRow(Department department) {
		return new Object[] {department.getDeptno(),department.getDeptname(),department.getFloor()};
	}
	
	public void setPopupMenu(JPopupMenu createDeptPopUpMenu) {
		D_table.setComponentPopupMenu(createDeptPopUpMenu);
	}
	public Department selectedItem() {
		int selectedIndex = D_table.getSelectedRow();
		if(selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "해당 항목을 선택하세욧");
			return null;
		}
		String deptno = (String) D_table.getValueAt(selectedIndex, 0);
		String deptname = (String) D_table.getValueAt(selectedIndex, 1);
		int floor = (int)D_table.getValueAt(selectedIndex,2);
		return new Department(deptno,deptname,floor);
	} 
}//end of class
