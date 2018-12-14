import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

	public class NOC extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NOC frame = new NOC(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); */
	}
	public NOC(int flag) throws SQLException {
		

	
		setBounds(100, 100, 730, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize(flag);
	}
	
	private void initialize(int flag) throws SQLException {
		
		
			connections pop = new connections(flag);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		   Date date = new Date();  
		    String dy=formatter.format(date);
		    System.out.println(dy);
		contentPane.setLayout(null);
		
		JLabel lblPhone = new JLabel("Student Roll No./ Faculty ID");
		lblPhone.setBounds(60, 229, 170, 14);
		getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(258, 226, 109, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Department");
		lblEmailId.setBounds(60, 276, 89, 14);
		getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(258, 274, 109, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Email address");
		lblAddress.setBounds(60, 323, 89, 14);
		getContentPane().add(lblAddress);
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(215, 525, 117, 20);
		getContentPane().add(btnClear);
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String idf = textField_1.getText();
				
				String deptf = textField_2.getText();
				String emailf = textField_3.getText();
				String reasonf = textField_4.getText();
				System.out.println(emailf);
				
				 try {
						int count = pop.st.executeUpdate("INSERT INTO nocapp (submission_date,rollno, dept, email, reason) values('"+dy+"','"+idf+"','"+deptf+"','"+emailf+"','"+reasonf+"')");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				
			}
		});
		
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(60, 524, 89, 23);
		getContentPane().add(btnSubmit);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(258, 320, 109, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(258, 371, 286, 106);
		getContentPane().add(textField_4);
		
		JLabel lblReasonForNoc = new JLabel("Reason For NOC");
		lblReasonForNoc.setBounds(60, 381, 129, 14);
		contentPane.add(lblReasonForNoc);
		
		JLabel lblNocApplication = new JLabel("NOC APPLICATION");
		lblNocApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblNocApplication.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNocApplication.setBounds(219, 88, 320, 27);
		contentPane.add(lblNocApplication);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		button.setBounds(32, 27, 72, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Log Out");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.awt.Window win[] = java.awt.Window.getWindows(); 
				for(int i=0;i<win.length;i++){ 
				win[i].dispose(); 
				}
				try {
					Login looo = new Login(flag);
					looo.setVisible(true);
				} catch (SQLException eRR) {
					// TODO Auto-generated catch block
					eRR.printStackTrace();
				}
			
			}
			
		});
		button_1.setBounds(571, 29, 117, 23);
		contentPane.add(button_1);
		
}	
}

