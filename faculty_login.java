import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class faculty_login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	
	public static JLabel lblJkj;
	
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					faculty_login frame = new faculty_login("faMukeshJ",1);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public faculty_login(String fid,int flag) throws SQLException {
		
		connections pop=new connections(flag);
		
		pop.rs=pop.st.executeQuery("Select * from  Faculty_user where collegeida='"+fid+"'");
		pop.rs.next();
		String fidv="Welcome "+pop.rs.getString("namea").toUpperCase();
		lblJkj = new JLabel(fidv);
		lblJkj.setBounds(51, 14, 226, 16);
		
		
		setBounds(100, 100, 640, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(lblJkj);
		
		JLabel lblFacultyPortal = new JLabel("FACULTY PORTAL");
		lblFacultyPortal.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFacultyPortal.setBounds(230, 75, 176, 14);
		contentPane.add(lblFacultyPortal);
		
		JButton button = new JButton("Create New Notice");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				submitdoc sd;
				try {
					sd = new submitdoc(fid,flag);
					sd.setExtendedState(JFrame.MAXIMIZED_BOTH);
					sd.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		button.setBounds(62, 129, 215, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Submit a new application");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			application apl=new application(flag);
			apl.setExtendedState(JFrame.MAXIMIZED_BOTH);
			apl.setVisible(true);
			}
		});
		
		button_1.setBounds(62, 223, 215, 23);
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
		button_2.setBounds(62, 271, 215, 23);
		contentPane.add(button_2);
		
		JButton btnSubmitNewResearch = new JButton("Submit New Research Paper");
		btnSubmitNewResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Research raj;
				try {
					raj = new Research(flag);
					raj.setExtendedState(JFrame.MAXIMIZED_BOTH);
					raj.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnSubmitNewResearch.setBounds(325, 129, 215, 23);
		contentPane.add(btnSubmitNewResearch);
		
		JButton btnViewAllResearch = new JButton("View Research Papers");
		btnViewAllResearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				respap rspp;
				try {
					rspp = new respap(flag);
					rspp.setExtendedState(JFrame.MAXIMIZED_BOTH);
					rspp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
			}
		});
		btnViewAllResearch.setBounds(325, 176, 215, 23);
		contentPane.add(btnViewAllResearch);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(508, 11, 106, 23);
		contentPane.add(btnLogout);
		
		JButton btnAddANew = new JButton("Add a new user");
		btnAddANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				add_user adusr;
				try {
					adusr = new add_user(flag);
					adusr.setExtendedState(JFrame.MAXIMIZED_BOTH);
					adusr.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAddANew.setBounds(325, 223, 215, 23);
		contentPane.add(btnAddANew);
		
		JButton btnViewAchievement = new JButton("view Achievement");
		btnViewAchievement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				search_achievement achs;
				try {
					achs = new search_achievement(flag);
					achs.setExtendedState(JFrame.MAXIMIZED_BOTH);
					achs.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnViewAchievement.setBounds(325, 270, 215, 25);
		contentPane.add(btnViewAchievement);
		
		JButton btnViewSubmittedDocument = new JButton("View Submitted Document");
		btnViewSubmittedDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				viewsubmit bbq;
				try {
					bbq = new viewsubmit(fidv, flag);
					bbq.setExtendedState(JFrame.MAXIMIZED_BOTH);
					bbq.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnViewSubmittedDocument.setBounds(62, 175, 215, 23);
		contentPane.add(btnViewSubmittedDocument);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		btnBack.setBounds(17, 43, 89, 23);
		contentPane.add(btnBack);
		
		
	}
}
