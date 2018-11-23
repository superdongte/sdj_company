package sdj_company.ui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import sdj_product.dto.Title;

import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;
import java.awt.BorderLayout;

public class Title_panel extends JPanel {
	private JTable T_table;
	private List<Title> list;
	public void setLists(List<Title> list) {
		this.list = list;
	}
	/**
	 * Create the panel.
	 */
	public Title_panel() {

		initComponents();
	}
	private void initComponents() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		
		T_table = new JTable();
		scrollPane.setViewportView(T_table);
	}
	/*private void setAlignWidth() {
	      tableCellAlignment(SwingConstants.CENTER, 0, 1);
	      tableSetWidth(100, 200);
	      
	   }
	private void tableSetWidth(int i, int j) {
		// TODO Auto-generated method stub
		
	}*/
	private void tableCellAlignment(int center, int i, int j) {
		// TODO Auto-generated method stub
		
	}
	public void loadData() {
		T_table.setModel(new DefaultTableModel(
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
		return new String[] {"번호","직책명"};
	}
	private Object[] getRow(Title title) {
		return new Object[] {title.getTno(),title.getTname()};
	}
	public void setPopupMenu(JPopupMenu createTitlePopUpMenu) {
		T_table.setComponentPopupMenu(createTitlePopUpMenu);
	}
	public Title selectedTitle() {
		int selectedIndex = T_table.getSelectedRow();
		if(selectedIndex == -1) {
			JOptionPane.showMessageDialog(null, "해당항목을 선택하세요");
			return null;
		}
		String tno = (String) T_table.getValueAt(selectedIndex, 0);
		String tname = (String) T_table.getValueAt(selectedIndex, 1);
		return new Title(tno,tname);
	}
}
