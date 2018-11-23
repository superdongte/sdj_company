package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import sdj_company.service.TitleUiService;
import sdj_product.dto.Title;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Title_ui extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tFTno;
	private JTextField tFName;
	private JButton btnAdd;
	private JButton btnCancel;
	private Title_panel TList;
	private TitleUiService service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Title_ui frame = new Title_ui();
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
	public static final String ADD = "추가";
	public static final String UPDATE = "수정";
	public static final String DEL = "삭제";

	public Title_ui() {
		service = new TitleUiService();
		initComponents();
	}

	private void initComponents() {
		setTitle("직책관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel lblTno = new JLabel("번호");
		lblTno.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTno);

		tFTno = new JTextField();
		tFTno.setEnabled(false);
		panel.add(tFTno);
		tFTno.setText(service.nextTno());
		tFTno.setColumns(10);

		JLabel lblTname = new JLabel("직책명");
		lblTname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTname);

		tFName = new JTextField();
		panel.add(tFName);
		tFName.setColumns(10);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		panel.add(btnAdd);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		panel.add(btnCancel);

		TList = new Title_panel();
		TList.setLists(service.selectTitleAll());
		TList.loadData();
		contentPane.add(TList);
		/*
		 * JPanel Title_panel = new JPanel(); contentPane.add(Title_panel);
		 * Title_panel.setLayout(new BorderLayout(0, 0));
		 */
		TList.setPopupMenu(createTitlePopUpMenu());
	}

	private JPopupMenu createTitlePopUpMenu() {
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
		if (e.getActionCommand().equals("취소")) {
			do_btnCancel_actionPerformed(e);
		}

		if (e.getActionCommand().equals(UPDATE)) {
			if (e.getSource() == btnAdd) {
				do_btnUpdate_actionPerformed(e);
			} else {
				do_mntUpdate_actionPerformed(e);
			}
		}
		if (e.getActionCommand().equals(ADD)) {
			do_btnAdd_actionPerformed(e);
		} 
		if (e.getActionCommand().equals(DEL)) {
			do_mntDel_actionPerformed(e);
		}
	}// END

	private void do_mntDel_actionPerformed(ActionEvent e) {
		Title selectedSt = TList.selectedTitle();
		JOptionPane.showMessageDialog(null, selectedSt);
		try {
			int res = service.unRegisterTitle(selectedSt);
			if (res == 1) {
				TList.setLists(service.selectTitleAll());
				TList.loadData();
				JOptionPane.showMessageDialog(null, "삭제 되었습니당");
			}
		} catch (SQLException e1) {
			if (e1.getErrorCode() == 1451) {
				JOptionPane.showMessageDialog(null, "해당부서에 사원이 없습니다.");
			} else {
				e1.printStackTrace();
			}
		}

	}

	private void do_mntUpdate_actionPerformed(ActionEvent e) {
		Title selectedSt = TList.selectedTitle();
		setTitle(selectedSt);
		btnAdd.setText(UPDATE);

	}

	private void do_btnUpdate_actionPerformed(ActionEvent e) {
		Title deltept = gettitle();
		try {
			int res = service.UpdateTitle(deltept);
			if (res == 1) {
				TList.setLists(service.selectTitleAll());
				TList.loadData();
				JOptionPane.showMessageDialog(null, "수정되었습니당");
				clearTft();
				btnAdd.setText(ADD);
				tFTno.setText(service.nextTno());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	protected void do_btnAdd_actionPerformed(ActionEvent e) {
		Title title = gettitle();
		int res = 0;
		try {
			res = service.registerTitle(title);
			if (res == 1) {
				JOptionPane.showMessageDialog(null, "추가했다");
			}
			TList.setLists(service.selectTitleAll());
			TList.loadData();
			clearTft();
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "유효하지않는 명령");
			e1.printStackTrace();
		}
	}

	protected void do_btnCancel_actionPerformed(ActionEvent e) {
		clearTft();
	}

	private void clearTft() {
		tFName.setText("");

	}

	private Title gettitle() {
		String Tno = tFTno.getText().trim();
		String Tname = tFName.getText().trim();
		return new Title(Tno, Tname);
	}

	private void setTitle(Title tept) {
		tFTno.setText(tept.getTno());
		tFName.setText(tept.getTname());
	}
}
