import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdom.Document;


import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.awt.event.ActionEvent;

public class search_achievement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	
	
	private JTextField textField;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JLabel lblNameOfEvent;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;
	private JButton btnSubmit;
	private JTable table;
	private JButton btnGeneratePdf;
	
	
	public static void main(String[] args) throws SQLException {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					search_achievement frame = new search_achievement(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public search_achievement(int flag) throws SQLException
	{
		connections pop=new connections(flag);
		
		
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type FROM achievement ORDER BY type");
		int a=0,i=0;
		while(pop.rs.next())
			a
			++;
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type FROM achievement ORDER BY type");
		String[] cc=new String[a];
		while(pop.rs.next())
		{
			cc[i]=pop.rs.getString("type").toUpperCase();
			i++;
		}
		
		String[] dd= {"ACADMICS","TECHNICAL","SPORTS","CULTURAL","EVENT MANAGEMENT","ARTS","OTHER"};
		
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNameOfAchiever = new JLabel("Name of Achiever");
		lblNameOfAchiever.setBounds(99, 174, 132, 16);
		contentPane.add(lblNameOfAchiever);
		
		textField = new JTextField();
		textField.setBounds(236, 171, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblField = new JLabel("Field");
		lblField.setBounds(99, 262, 56, 16);
		contentPane.add(lblField);
		
		comboBox = new JComboBox(dd);
		comboBox.setBounds(236, 259, 116, 22);
		contentPane.add(comboBox);
		comboBox.addItem("ALL");
		
		lblNameOfEvent = new JLabel("Name of Event");
		lblNameOfEvent.setBounds(99, 341, 120, 16);
		contentPane.add(lblNameOfEvent);
		
		comboBox_1 = new JComboBox(cc);
		comboBox_1.setBounds(234, 338, 116, 22);
		contentPane.add(comboBox_1);
		comboBox_1.addItem("ALL");
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String s1=(String)comboBox.getSelectedItem();
				String s2=(String)comboBox_1.getSelectedItem();;
				
					if(!textField.getText().isEmpty())
					{
					
						if(s1.equals("ALL")==false)
						{
							
							if(s2.equals("ALL")==false)
							{
								System.out.println(s1);
								System.out.println(s2);
								
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE achiever_name='"+textField.getText()+"'AND "
													+ "field='"+s1+"'AND type='"+s2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE achiever_name='"+textField.getText()+"'AND "
											+ "field='"+s1+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						else
						{
							if(s2.equals("ALL")==false)
							{
							
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE achiever_name='"+textField.getText()+"'AND type='"+s2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE achiever_name='"+textField.getText()+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					else
					{
						if(s1.equals("ALL")==false)
						{
							
							if(s2.equals("ALL")==false)
							{
								
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE field='"+s1+"'AND type='"+s2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE field='"+s1+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						else
						{
							if(s2.equals("ALL")==false)
							{
							
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement WHERE type='"+s2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT *  FROM achievement");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
					}
					
				
				}
					
					table.setModel(DbUtils.resultSetToTableModel(pop.rs));
					
					
				
				
			}
		});
		btnSubmit.setBounds(187, 549, 97, 25);
		contentPane.add(btnSubmit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(414, 259, 556, 365);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.YELLOW);
		
		JLabel lblSearchNewAchievement = new JLabel("SEARCH  FOR AN ACHIEVEMENT");
		lblSearchNewAchievement.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchNewAchievement.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSearchNewAchievement.setBounds(305, 95, 419, 27);
		contentPane.add(lblSearchNewAchievement);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		button.setBounds(30, 29, 72, 23);
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
		button_1.setBounds(839, 29, 117, 23);
		contentPane.add(button_1);
		
		
				
				
					}
}
