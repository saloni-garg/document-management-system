
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class verify_data_storage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					verify_data_storage frame = new verify_data_storage();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public verify_data_storage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToDocument = new JLabel("Welcome to Document Management System");
		lblWelcomeToDocument.setFont(new Font("Adobe Gothic Std B", Font.PLAIN, 18));
		lblWelcomeToDocument.setBounds(125, 46, 418, 18);
		contentPane.add(lblWelcomeToDocument);
		
		JLabel lblWhichDatabaseWould = new JLabel("Which Database would you prefer to use?");
		lblWhichDatabaseWould.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 14));
		lblWhichDatabaseWould.setBounds(91, 107, 380, 32);
		contentPane.add(lblWhichDatabaseWould);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("AMAZON RDS");
		rdbtnNewRadioButton.setBounds(91, 191, 139, 23);
		contentPane.add(rdbtnNewRadioButton);	
		JRadioButton rdbtnOffline = new JRadioButton("Offline");
		rdbtnOffline.setBounds(275, 191, 139, 23);
		contentPane.add(rdbtnOffline);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			int f;
			if(rdbtnNewRadioButton.isSelected())
				f=1;
			else
				f=0;
			Login ll;
			try {
				ll = new Login(f);
				ll.setExtendedState(JFrame.MAXIMIZED_BOTH); 

				ll.setVisible(true);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		btnNewButton.setBounds(180, 263, 89, 23);
		contentPane.add(btnNewButton);
		
		
		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnNewRadioButton);
		gp.add(rdbtnOffline);
		
		
		
	}
}