package sdj_company;

import java.awt.EventQueue;

import sdj_company.ui.Department_ui;

public class Main {
	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Department_ui frame = new Department_ui();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}			
	
}
