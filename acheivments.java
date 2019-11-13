import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class acheivments extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_achiever;
	private JTextField link;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JButton btnSubmit;
	private JTextPane description;
	private JLabel lblIfOther;
	private JTextField other;
	private JLabel lblOrganizer;
	private JTextField organizer;
	@SuppressWarnings("rawtypes")
	private JComboBox combott;
	private JButton btnClear;
	private JButton button;
	private JButton button_1;
	
	
	public static void main(String[] args) throws SQLException {
		
		
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acheivments frame = new acheivments();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public acheivments(int flag) throws SQLException 
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSubmitAnAcheivment = new JLabel("Submit a achievment");
		lblSubmitAnAcheivment.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubmitAnAcheivment.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSubmitAnAcheivment.setBounds(155, 53, 483, 38);
		contentPane.add(lblSubmitAnAcheivment);
		
		JLabel lblNameOfAchei = new JLabel("Name of achiever");
		lblNameOfAchei.setBounds(155, 192, 116, 16);
		contentPane.add(lblNameOfAchei);
		
		name_achiever = new JTextField();
		name_achiever.setBounds(350, 189, 116, 22);
		contentPane.add(name_achiever);
		name_achiever.setColumns(10);
		
		JLabel lblField = new JLabel("Field");
		lblField.setBounds(155, 277, 56, 16);
		contentPane.add(lblField);
		
		JLabel lblLinkOfCertificateproff = new JLabel("IDProof");
		lblLinkOfCertificateproff.setBounds(155, 380, 141, 16);
		contentPane.add(lblLinkOfCertificateproff);
		
		String []dd2= {"AADHAR CARD" ,"PAN CARD", "VOTER ID"};
		
		//link = new JTextField();
		comboBox = new JComboBox(dd2);
		comboBox.setBounds(360, 377, 190, 22);
		contentPane.add(comboBox);
		//link.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(155, 451, 100, 16);
		contentPane.add(lblDescription);
		
		comboBox = new JComboBox(cc);
		comboBox.setBounds(360, 518, 148, 22);
		contentPane.add(comboBox);
		
		
		
		JLabel lblTypeOfAchievement = new JLabel("Type of achievement");
		lblTypeOfAchievement.setBounds(155, 521, 157, 16);
		contentPane.add(lblTypeOfAchievement);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(name_achiever.getText().isEmpty()||
						organizer.getText().isEmpty()||
						link.getText().isEmpty()||description.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Data missing");
				}
				else
				{
					String iii = (String)comboBox.getSelectedItem();
					String mmm=(String)combott.getSelectedItem();
					System.out.println(iii);
					if(iii.equals("OTHER"))
					{
						if(other.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Data missing");
						else
						{
							int count;
							try {
								count = pop.st.executeUpdate("insert into achievement(achiever_name,field,link,description,type,organizer) "
										+ "values('"+name_achiever.getText()+"','"+mmm+"'"
												+ ",'"+link.getText()+"','"+description.getText()+"','"+other.getText()+"','"+organizer.getText()+"')");
								contentPane.revalidate();
								contentPane.repaint();
								System.out.println("count="+count);
							
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
							
					}
					else
					{
						int count1;
						try {
							count1 = pop.st.executeUpdate("insert into achievement(achiever_name,field,link,description,type,organizer) "
									+ "values('"+name_achiever.getText()+"','"+mmm+"'"
											+ ",'"+link.getText()+"','"+description.getText()+"','"+iii+"','"+organizer.getText()+"')");
							contentPane.revalidate();
							contentPane.repaint();
							System.out.println("count1="+count1);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
				
				
			}
		}
		
				);
		btnSubmit.setBounds(268, 586, 97, 25);
		contentPane.add(btnSubmit);
		
		description = new JTextPane();
		description.setBackground(Color.LIGHT_GRAY);
		description.setBounds(359, 445, 167, 60);
		contentPane.add(description);
		
		lblIfOther = new JLabel("If other");
		lblIfOther.setBounds(601, 521, 56, 16);
		contentPane.add(lblIfOther);
		
		other = new JTextField();
		other.setBounds(691, 518, 116, 22);
		contentPane.add(other);
		other.setColumns(10);
		
		lblOrganizer = new JLabel("Organizer");
		lblOrganizer.setBounds(559, 277, 56, 16);
		contentPane.add(lblOrganizer);
		
		organizer = new JTextField();
		organizer.setBounds(750, 274, 116, 22);
		contentPane.add(organizer);
		organizer.setColumns(10);
		
		other.setEditable(false);
		
		combott = new JComboBox(dd);
		combott.setBounds(350, 274, 141, 22);
		contentPane.add(combott);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(429, 587, 97, 25);
		contentPane.add(btnClear);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		button.setBounds(24, 11, 72, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Log Out");
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
		button_1.setBounds(563, 13, 117, 23);
		contentPane.add(button_1);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name_achiever.setText(null);
				link.setText(null);
				combott.setSelectedItem(false);
				organizer.setText(null);
				other.setText(null);
			}
		});
		
		
		comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
            	
            	if(e.getStateChange() == ItemEvent.SELECTED) 
            	  { 
            
            	    String item = (String) e.getItem();
            	    System.out.println(item);
            	    if(item.equals("OTHER"))
            	    {
            	    	other.setEditable(true);
            	    }
            	    else
            	    	other.setEditable(false);
            	    	
            	  }
            	
       
            }
		});
		
	}
	
}
