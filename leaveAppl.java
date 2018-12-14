import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class leaveAppl extends JFrame {
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
					leaveAppl frame = new leaveAppl(1);
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
	public leaveAppl(int flag) throws SQLException {
		
		setBounds(100, 100, 730, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		initialize(flag);
	}
	
	private void initialize(int flag) throws SQLException {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		   Date date = new Date();  
		    String dy=formatter.format(date);
		    System.out.println(dy);
		
		connections pop=new connections(flag);
		contentPane.setLayout(null);
		
		JLabel lblPhone = new JLabel("Student Roll No./ Faculty ID");
		lblPhone.setBounds(65, 196, 170, 14);
		getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 193, 109, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Department");
		lblEmailId.setBounds(65, 243, 89, 14);
		getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(263, 241, 109, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Email address");
		lblAddress.setBounds(65, 290, 89, 14);
		getContentPane().add(lblAddress);
				
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(220, 515, 117, 20);
		getContentPane().add(btnClear);		
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String s2 = textField_1.getText();
			String s3 = textField_2.getText();
			String s4 = textField_3.getText();
			String s5 = textField_4.getText();
			
			 try {
					int count = pop.st.executeUpdate("INSERT INTO la (submission_date, rollno, dept, email, reason)"+ "values('"+dy+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
					JOptionPane.showMessageDialog(null, "Data Pushed");
			 } catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 514, 89, 23);
		getContentPane().add(btnSubmit);
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 287, 109, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 338, 286, 106);
		getContentPane().add(textField_4);
		
		JLabel lblReasonForApplication = new JLabel("Reason for Application");
		lblReasonForApplication.setBounds(65, 338, 147, 14);
		contentPane.add(lblReasonForApplication);
		
		JLabel lblSubmitNewApplication = new JLabel("SUBMIT NEW APPLICATION");
		lblSubmitNewApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitNewApplication.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSubmitNewApplication.setBounds(197, 72, 320, 27);
		contentPane.add(lblSubmitNewApplication);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		button.setBounds(10, 13, 72, 23);
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
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setBounds(549, 13, 117, 23);
		contentPane.add(button_1);
		

}	
}
	


