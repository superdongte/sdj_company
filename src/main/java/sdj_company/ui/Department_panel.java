package sdj_company.ui;

import javax.swing.JPanel;
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
	/**
	 * Create the panel.
	 */
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
}//end of class
