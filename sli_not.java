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
import java.awt.EventQueue;
import java.awt.Font;
public class sli_not extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblRollNumber;
	private JTextField textField_6;
	private JButton btnSubmit;
	private JButton btnLogOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sli_not frame = new sli_not(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});**/
	}

	/**
	 * Create the frame.
	 */
	public sli_not(int flag) throws SQLException {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		   Date date = new Date();  
		    String dy=formatter.format(date);
		    System.out.println(dy);
		
		connections pop=new connections(flag);
		setBounds(100, 100, 627, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubmitTheFollowing = new JLabel("Submit the following details for SLI notification:");
		lblSubmitTheFollowing.setBounds(32, 60, 254, 14);
		contentPane.add(lblSubmitTheFollowing);
		
		JLabel lblNameOfCompany = new JLabel("Name of Company:");
		lblNameOfCompany.setBounds(32, 169, 98, 14);
		contentPane.add(lblNameOfCompany);
		
		textField = new JTextField();
		textField.setBounds(266, 169, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTimePeriodOf = new JLabel("Time Period of SLI (No of months):");
		lblTimePeriodOf.setBounds(32, 204, 204, 14);
		contentPane.add(lblTimePeriodOf);
		
		JLabel lblStipend = new JLabel("Stipend:");
		lblStipend.setBounds(32, 235, 98, 14);
		contentPane.add(lblStipend);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(266, 204, 120, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(266, 235, 120, 20);
		contentPane.add(textField_2);
		
		JLabel lblDateFrom = new JLabel("Date From:");
		lblDateFrom.setBounds(32, 274, 98, 14);
		contentPane.add(lblDateFrom);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 271, 69, 20);
		contentPane.add(textField_3);
		
		JLabel lblDateTo = new JLabel("Date Till:");
		lblDateTo.setBounds(226, 271, 98, 14);
		contentPane.add(lblDateTo);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(297, 268, 69, 20);
		contentPane.add(textField_4);
		
		lblRollNumber = new JLabel("Roll Number:");
		lblRollNumber.setBounds(32, 132, 98, 14);
		contentPane.add(lblRollNumber);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(266, 132, 120, 20);
		contentPane.add(textField_6);
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(263, 517, 117, 20);
		getContentPane().add(btnClear);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				String s2 = textField_1.getText();
				String s3 = textField_2.getText();
				String s4 = textField_3.getText();
				String s5 = textField_4.getText();
				String s7 = textField_6.getText();
				
				 try {
						int count = pop.st.executeUpdate("INSERT INTO sli (submission_date,cname, rollno, time, stipend, dfrom, dto)"+ "values('"+dy+"','"+s1+"','"+s7+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"')");
						JOptionPane.showMessageDialog(null, "data pushed");
				 } catch (SQLException e1) {
						e1.printStackTrace();
					}
			}
		});
		btnSubmit.setBounds(67, 313, 89, 23);
		contentPane.add(btnSubmit);
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
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
		btnLogOut.setBounds(495, 21, 106, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblSliNotifier = new JLabel("SLI   NOTIFICATION");
		lblSliNotifier.setFont(new Font("Adobe Gothic Std B", Font.BOLD, 17));
		lblSliNotifier.setBounds(238, 21, 199, 28);
		contentPane.add(lblSliNotifier);
		
		JLabel lblddmmyyyy = new JLabel("*dd/mm/yyyy");
		lblddmmyyyy.setBounds(190, 296, 98, 14);
		contentPane.add(lblddmmyyyy);
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				
				textField_3.setText(null);
				textField_4.setText(null);
				textField_6.setText(null);
				
				
				
			}
		});
		
	}
}
