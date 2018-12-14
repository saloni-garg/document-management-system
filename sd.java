import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.event.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class sd extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel username_field;
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	
	
	
	public static void main(String[] args) throws SQLException {
		
					sd frame = new sd("16ucs111",1);
					frame.setVisible(true);
				
	}

	/**
	 * Create the frame.
	 */
	
	String fidv;
	public sd(String fid,int flag) throws SQLException {
		
		connections pop=new connections(flag);
		
		pop.rs=pop.st.executeQuery("Select * from  user where collegeida='"+fid+"'");
		pop.rs.next();
		fidv="Welcome "+pop.rs.getString("namea").toUpperCase();
		username_field = new JLabel(fidv);
		username_field.setBounds(51, 23, 193, 16);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(username_field);
		
		JButton button = new JButton("View Current Notices");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewsubmit vs;
				try {
					vs = new viewsubmit(fid,flag);
					vs.setExtendedState(JFrame.MAXIMIZED_BOTH);
					vs.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setBounds(56, 122, 215, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submit a new application");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				application apl=new application(flag);
				apl.setExtendedState(JFrame.MAXIMIZED_BOTH);
				apl.setVisible(true);
				
			}
		});
		button_1.setBounds(56, 169, 215, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("View Submitted Applications");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submittedApplication subapp;
				try {
					subapp = new submittedApplication(fid, flag);
					subapp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(56, 216, 215, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Submit a new Research Paper");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Research srp;
				try {
					srp = new Research(flag);
					srp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					
					srp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_3.setBounds(344, 122, 215, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("View Research Papers");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				respap rp;
				try {
					rp = new respap(flag);
					rp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					rp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button_4.setBounds(344, 169, 215, 23);
		contentPane.add(button_4);
		
		JLabel label = new JLabel("STUDENT PORTAL");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(210, 55, 176, 14);
		contentPane.add(label);
		
		JToggleButton toggleButton = new JToggleButton("Logout");
		
		toggleButton.setBounds(476, 23, 121, 23);
		contentPane.add(toggleButton);
		
		JButton btnSubmitAnAchievement = new JButton("Submit an Achievement");
		btnSubmitAnAchievement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				acheivments ach;
				try {
					ach = new acheivments(flag);
					ach.setExtendedState(JFrame.MAXIMIZED_BOTH); ach.setUndecorated(true); 
					ach.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnSubmitAnAchievement.setBounds(344, 215, 215, 25);
		contentPane.add(btnSubmitAnAchievement);
		
		JButton btnViewAchievements = new JButton("View Achievements");
		btnViewAchievements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			search_achievement sea;
			try {
				sea = new search_achievement(flag);
				sea.setExtendedState(JFrame.MAXIMIZED_BOTH);
				sea.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		btnViewAchievements.setBounds(58, 262, 213, 25);
		contentPane.add(btnViewAchievements);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setBounds(21, 53, 89, 23);
		contentPane.add(btnBack);
		
		
	}
}