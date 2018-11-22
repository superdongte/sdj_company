package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class management extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton Btn1;
	private JButton Btn2;
	private JButton Btn3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					management frame = new management();
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
	public management() {
		initComponents();
	}
	private void initComponents() {
		setTitle("ERP관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 104);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 10, 10));
		
		Btn1 = new JButton("사원관리");
		Btn1.addActionListener(this);
		contentPane.add(Btn1);
		
		Btn2 = new JButton("부서관리");
		Btn2.addActionListener(this);
		contentPane.add(Btn2);
		
		Btn3 = new JButton("직책관리");
		Btn3.addActionListener(this);
		contentPane.add(Btn3);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Btn3) {
			do_Btn3_actionPerformed(e);
		}
		if (e.getSource() == Btn2) {
			do_Btn2_actionPerformed(e);
		}
		if (e.getSource() == Btn1) {
			do_Btn1_actionPerformed(e);
		}
	}
	protected void do_Btn1_actionPerformed(ActionEvent e) {
	}
	protected void do_Btn2_actionPerformed(ActionEvent e) {
	}
	protected void do_Btn3_actionPerformed(ActionEvent e) {
	}
}
