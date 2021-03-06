package sdj_company.ui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import sdj_product.dto.Employee;

public class Employee_panel extends JPanel {
	private JTable E_table;
	private List<Employee> list;
	
	public void setList(List<Employee>list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public Employee_panel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		E_table = new JTable();
		scrollPane.setViewportView(E_table);
	}
	public void loadData() {
		E_table.setModel(new DefaultTableModel(
				getdatas(),
				getColumn()
				));
	}
	private Object[] getColumn() {
		return new String[] {"사원번호","사원명","직책","급여","성별","부서","입사일"};
	}
	private Object[][] getdatas() {
		Object[][] datas = new Object[list.size()][];
		for(int i = 0; i<list.size(); i++) {
			datas[i] = getRow(list.get(i));
		}
		return datas;
	}
	private Object[] getRow(Employee employee) {
		return new Object[] {employee.getEmpno(),employee.getEmpname(),employee.getTitle().getTname(),employee.getSalary()
				,employee.getGender(),String.format("%s(%s층)",employee.getDno().getDeptname(),employee.getDno().getFloor()),employee.getIpsa()};
	}
	public void setPopupMenu(JPopupMenu popupMenu) {
		E_table.setComponentPopupMenu(popupMenu);
		
	}
	public Employee getSelectedEmployee() {
		int selectedIndex = E_table.getSelectedRow();
		String empNo = (String) E_table.getValueAt(selectedIndex, 0);
		Employee emp = new Employee(empNo);
		return list.get(list.indexOf(emp));
	}	
	
	
}
