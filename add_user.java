
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

public class add_user extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name_field;
	private JTextField address_field;
	private JTextField college_id_field;
	private JTextField contact_field;
	private JButton submit_btn;
	private JLabel type_field;
	private JLabel contact_label;
	private JCheckBox faculty_cb;
	private JLabel collge_id_label;
	private JCheckBox studnet_cb;
	private JLabel address_label;
	private JLabel name_label;
	private JLabel lblPassword;
	private JLabel lblReenterPassword;
	private JPasswordField pass1;
	private JPasswordField pass2;
	@SuppressWarnings("rawtypes")
	private JComboBox branch;
	private JLabel lblDepartment;
	@SuppressWarnings("rawtypes")
	private JComboBox year;
	private JButton btnClear;
	private JLabel lblAddANew;
	private JButton button;
	private JButton button_1;
	
	public static void main(String[] args) throws SQLException {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					add_user frame = new add_user(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public add_user(int flag) throws SQLException
	{
		connections pop=new connections(flag);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000 , 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name_label = new JLabel("Name");
		name_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		name_label.setBounds(158, 139, 35, 16);
		contentPane.add(name_label);
		
		name_field = new JTextField();
		name_field.setBounds(300, 138, 86, 20);
		contentPane.add(name_field);
		name_field.setColumns(10);
		
		address_label = new JLabel("Address");
		address_label.setFont(new Font("Tahoma", Font.BOLD, 13));
		address_label.setBounds(158, 201, 54, 16);
		contentPane.add(address_label);
		
		address_field = new JTextField();
		address_field.setBounds(300, 199, 86, 20);
		contentPane.add(address_field);
		address_field.setColumns(10);
		
		 type_field = new JLabel("Type of user");
		 type_field.setFont(new Font("Sylfaen", Font.BOLD, 13));
		type_field.setBounds(158, 285, 79, 18);
		contentPane.add(type_field);
		
		studnet_cb = new JCheckBox("Student");
		studnet_cb.setBounds(300, 280, 100, 23);
		contentPane.add(studnet_cb);
		
		String branch_arr[]={"CCE","CSE","ECE","MME" }; 
		 branch=new JComboBox(branch_arr);
		 branch.setBounds(300, 374, 86, 20);
		 contentPane.add(branch);
		
		 
		 String year_arr[]={"1stYear","2ndYear","3rdYear","4thYear" }; 
		 	year=new JComboBox(year_arr);
		 	year.setEnabled(false);
			year.setBounds(300, 312, 100, 20);
			contentPane.add(year);
			
			
		studnet_cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					year.setEnabled(true);
			        
			    } else {
			    	year.setEnabled(false);
			    }
			}
		});
		
		
		 
		faculty_cb = new JCheckBox("Faculty");
		faculty_cb.setBounds(500, 280, 100, 23);
		contentPane.add(faculty_cb);
		
		collge_id_label = new JLabel("College ID");
		collge_id_label.setBounds(158, 442, 79, 14);
		contentPane.add(collge_id_label);
		
		college_id_field = new JTextField();
		college_id_field.setBounds(300, 439, 86, 20);
		contentPane.add(college_id_field);
		college_id_field.setColumns(10);
		
		contact_label = new JLabel("Contact No");
		contact_label.setBounds(158, 494, 100, 14);
		contentPane.add(contact_label);
		
		contact_field = new JTextField();
		contact_field.setBounds(300, 491, 86, 20);
		contentPane.add(contact_field);
		contact_field.setColumns(10);
		
		submit_btn = new JButton("Submit");
		submit_btn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(!(name_field.getText().isEmpty()&&address_field.getText().isEmpty()&&type_field.getText().isEmpty()&&college_id_field.getText().isEmpty()&&contact_field.getText().isEmpty()&&(!(faculty_cb.isSelected()||studnet_cb.isSelected()))))
				{	
					if(pass1.getText().equals(pass2.getText())==true)
					{
					System.out.println("HIIIII");
				
				String nf = name_field.getText();
				String af = address_field.getText();
				String pass_sd=pass1.getText();
				String coll_id_f = college_id_field.getText();
				String conf = contact_field.getText();
				String department=(String)branch.getSelectedItem();
				String batch=(String)year.getSelectedItem();
				String tf="";
				if(studnet_cb.isSelected()) tf = "student";
				if(faculty_cb.isSelected()) tf = "faculty";
				
				try {
					if(tf.equals("student"))
					{
					int countt =pop.st.executeUpdate("INSERT INTO user(namea,addressa,typea, collegeida, contacta,password,department,batch) VALUES('"+nf+"','"+af+"','"+tf+"','"+coll_id_f+"','"+conf+"','"+pass_sd+"','"+department+"','"+batch+"')");
					System.out.println(countt);
					JOptionPane.showMessageDialog(null, "Data Pushed");
					}
					else
					{
						int countt =pop.st.executeUpdate("INSERT INTO Faculty_user(namea,addressa,typea, collegeida, contacta,password,department) VALUES('"+nf+"','"+af+"','"+tf+"','"+coll_id_f+"','"+conf+"','"+pass_sd+"','"+department+"')");
						JOptionPane.showMessageDialog(null, "Data Pushed");
						System.out.println(countt);
					}	
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
					else
						JOptionPane.showMessageDialog(null, "Password does not match");
			}
				else
					JOptionPane.showMessageDialog(null, "Data Missing");
			}});
		submit_btn.setBounds(158, 576, 65, 23);
		contentPane.add(submit_btn);
		
		ButtonGroup gp=new ButtonGroup();
		gp.add(studnet_cb);
		gp.add(faculty_cb);	 
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(500, 137, 63, 16);
		contentPane.add(lblPassword);
		
		lblReenterPassword = new JLabel("ReEnter Password");
		lblReenterPassword.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblReenterPassword.setBounds(500, 202, 100, 16);
		contentPane.add(lblReenterPassword);
		
		pass1 = new JPasswordField();
		pass1.setBounds(626, 134, 100, 20);
		contentPane.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(626, 199, 100, 20);
		contentPane.add(pass2);
		
		lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(158, 377, 86, 14);
		contentPane.add(lblDepartment);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(300, 576, 57, 23);
		contentPane.add(btnClear);
		
		lblAddANew = new JLabel("ADD A NEW USER");
		lblAddANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddANew.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddANew.setBounds(276, 72, 320, 27);
		contentPane.add(lblAddANew);
		
		button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button.setBounds(25, 24, 55, 23);
		contentPane.add(button);
		
		button_1 = new JButton("Log Out");
		button_1.setBounds(889, 24, 71, 23);
		contentPane.add(button_1);
		btnClear.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				name_field.setText(null);
				address_field.setText(null);
				college_id_field.setText(null);
				contact_field.setText(null);
				studnet_cb.setSelected(false);
				branch.setSelectedItem(null);
				year.setEnabled(false);
				faculty_cb.setSelected(false);
			}
		});
		
		
	}
}
