import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	
	
	private JLabel username;
	private JLabel passwordf;
	private JTextField user;
	private JPasswordField pass;
	private JButton loginBtn;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/**EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bbbb frame = new bbbb();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});**/
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Login(int flag) throws SQLException {
		
		
		connections pop=new connections(flag);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username=new JLabel("UserName");
		passwordf=new JLabel("Password");
		user=new JTextField();
		pass=new JPasswordField();
		loginBtn=new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==loginBtn)
				{
					String usrname=user.getText();
					String myPass=String.valueOf(pass.getPassword());
					String two_char=usrname.substring(0,2);
					if(two_char.equals("fa"))
					{
						
						try {
							pop.rs=pop.st.executeQuery("Select * from  Faculty_user where collegeida='"+usrname+"'");
							if(pop.rs.next())
							{
								String pass_rec=pop.rs.getString("password");
								if(pass_rec.equals(myPass)==true)
								{
									
									faculty_login fl=new faculty_login(usrname,flag);
									fl.setExtendedState(JFrame.MAXIMIZED_BOTH);
									fl.setVisible(true);
									
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Invalid Credentials");
								}
							}
							else
								JOptionPane.showMessageDialog(null, "No such User");
						
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
					else if(usrname.equals("registrar"))
					{
						try {
							pop.rs=pop.st.executeQuery("Select * from  Faculty_user where collegeida='"+usrname+"'");
							if(pop.rs.next())
							{
								String pass_rec=pop.rs.getString("password");
								if(pass_rec.equals(myPass)==true)
								{
									
									registrar_login rrr=new registrar_login(usrname, flag);
									rrr.setExtendedState(JFrame.MAXIMIZED_BOTH);
									rrr.setVisible(true);
											
									
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Invalid Credentials");
								}
							}
							else
								JOptionPane.showMessageDialog(null, "No such User");
						
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						
						try {
							pop.rs=pop.st.executeQuery("Select * from  user where collegeida='"+usrname+"'");
							if(pop.rs.next())
							{
								String pass_rec=pop.rs.getString("password");
									if(pass_rec.equals(myPass)==true)
									{
										
										student_login_page slp=new student_login_page(usrname, flag);
										slp.setVisible(true);
										slp.setExtendedState(JFrame.MAXIMIZED_BOTH);
										System.out.println("you are in student");	
										
									}
									else
									{
										JOptionPane.showMessageDialog(null, "Invalid Credentials");
									}
							}
							else
								JOptionPane.showMessageDialog(null, "No such User");
						
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				
						
							
					
					

					
				}
			}
		});
		username.setBounds(100,50,100,50);
		passwordf.setBounds(100,80,100,100);
		user.setBounds(200, 60,100,30);
		pass.setBounds(200, 115,100,30);
		loginBtn.setBounds(150, 180, 100, 40);

		contentPane.add(username);
		contentPane.add(passwordf);
		contentPane.add(user);
		contentPane.add(pass);
		contentPane.add(loginBtn);
		
	}
}