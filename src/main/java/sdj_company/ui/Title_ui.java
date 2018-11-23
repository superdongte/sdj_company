package sdj_company.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Title_ui extends JFrame {

	private JPanel contentPane;
	private JTextField tFTno;
	private JTextField tFName;

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
	public Title_ui() {
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
		panel.add(tFTno);
		tFTno.setColumns(10);
		
		JLabel lblTname = new JLabel("직책명");
		lblTname.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTname);
		
		tFName = new JTextField();
		panel.add(tFName);
		tFName.setColumns(10);
		
		JButton btn1 = new JButton("추가");
		panel.add(btn1);
		
		JButton btn2 = new JButton("취소");
		panel.add(btn2);
		
		JPanel Title_panel = new JPanel();
		contentPane.add(Title_panel);
		Title_panel.setLayout(new BorderLayout(0, 0));
	}

}
