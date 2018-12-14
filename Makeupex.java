import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.event.EventQueue;

public class Makeupex extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	
	public static void main(String[] args) throws SQLException
	{
	
					/*Makeupex frame = new Makeupex(1);
					frame.setVisible(true);*/
				
			}
	
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Makeupex(int flag) throws SQLException 
	{
		
		
		
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		initialize(flag);
	
		
	}
	private void initialize(int flag) throws SQLException {
		
		connections pop=new connections(flag);
		
		JLabel lblPhone = new JLabel("Student Roll No./ Faculty ID");
		lblPhone.setBounds(65, 68, 170, 14);
		getContentPane().add(lblPhone);
		
		textField_1 = new JTextField();
		textField_1.setBounds(263, 65, 109, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Department");
		lblEmailId.setBounds(65, 115, 89, 14);
		getContentPane().add(lblEmailId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(263, 113, 109, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Email address");
		lblAddress.setBounds(65, 162, 89, 14);
		getContentPane().add(lblAddress);
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(263, 517, 117, 20);
		getContentPane().add(btnClear);
		
		
		
		
		JButton btnSubmit = new JButton("submit");
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 516, 89, 23);
		getContentPane().add(btnSubmit);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(263, 159, 109, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(263, 390, 286, 106);
		getContentPane().add(textField_4);
		
		JLabel lblReasonForApplication = new JLabel("Reason For NOC");
		lblReasonForApplication.setBounds(65, 390, 127, 14);
		getContentPane().add(lblReasonForApplication);
		
		JLabel lblReasonForMakeup = new JLabel("Reason For Makeup Exam");
		lblReasonForMakeup.setBounds(65, 210, 140, 14);
		getContentPane().add(lblReasonForMakeup);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Medical Emergency");
		rdbtnNewRadioButton.setBounds(263, 206, 151, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnUrgencyAtHome = new JRadioButton("Urgency at Home");
		rdbtnUrgencyAtHome.setBounds(263, 234, 109, 23);
		getContentPane().add(rdbtnUrgencyAtHome);
		
		JRadioButton rdbtnWeddingOfImmediate = new JRadioButton("Wedding of immediate relative");
		rdbtnWeddingOfImmediate.setBounds(263, 260, 171, 23);
		getContentPane().add(rdbtnWeddingOfImmediate);
		
		JRadioButton rdbtnOtherspecify = new JRadioButton("Other (Specify)");
		rdbtnOtherspecify.setBounds(263, 288, 109, 23);
		getContentPane().add(rdbtnOtherspecify);
		
		JLabel lblDetailedDocument = new JLabel("");
		lblDetailedDocument.setBounds(65, 335, 140, 14);
		getContentPane().add(lblDetailedDocument);
		
		
		btnSubmit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				if((textField_1.getText().isEmpty())||(textField_2.getText().isEmpty())||(textField_3.getText().isEmpty()||textField_2.getText().isEmpty()))
					{
					JOptionPane.showMessageDialog(null, "Data Missing");
				
					}
				
				else
				{
				
				String af = textField_1.getText();
				String coll_id_f = textField_2.getText();
				String conf = textField_3.getText();
				String conf1 = textField_4.getText();
				
				
				String rdbtnanswer=null;
				String a1 = "Medical";
				String a2 = "Urgency";
				String a3= "Wedding";
				String a4 = "Other";
				if(rdbtnNewRadioButton.isSelected()) rdbtnanswer=a1;
				if(rdbtnUrgencyAtHome.isSelected()) rdbtnanswer=a2;
				if(rdbtnWeddingOfImmediate.isSelected()) rdbtnanswer=a3;
				if(rdbtnOtherspecify.isSelected()) rdbtnanswer=a4;
				try {
					int countt =pop.st.executeUpdate("INSERT INTO Make_up_exam(Roll_No,Department,Mail_id, Reason) VALUES('"+af+"','"+coll_id_f+"','"+conf+"','"+ rdbtnanswer+"')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
 				JOptionPane.showMessageDialog(null, "Data Submitted");
				}
			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(null);
				textField_2.setText(null);
				
				textField_3.setText(null);
				textField_4.setText(null);
				
				
				
			}
		});
		
}
	
	
	

}
