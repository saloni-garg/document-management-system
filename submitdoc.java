import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class submitdoc extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 static JTextField name_txt ;
	 static JTextField fname_txt;
	 @SuppressWarnings("rawtypes")
	static JComboBox day;
	 @SuppressWarnings("rawtypes")
	static JComboBox month;
	 @SuppressWarnings("rawtypes")
	static JComboBox year;
	 @SuppressWarnings("rawtypes")
	static JComboBox day1;
	 @SuppressWarnings("rawtypes")
	static JComboBox month1;
	 @SuppressWarnings("rawtypes")
	static JComboBox year1;
	 static JCheckBox chkbox;
	 static JButton submit_btn;
	 private JTextField tp;
	 public JRadioButton cse1,cse2,cse3,cse4,cc1,cc2,cc3,cc4,ec1,ec2,ec3,ec4,me1,me2,me3,me4;
	 
	 
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					submitdoc frame = new submitdoc("faMukeshJ",1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public submitdoc(String fid,int flag) throws SQLException {
		
		connections pop=new connections(flag);
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type_of FROM document ORDER BY type_of");
		int a=0,i=0;
		while(pop.rs.next())
			a++;
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type_of FROM document ORDER BY type_of");
		String[] cc=new String[a];
		while(pop.rs.next())
		{
			cc[i]=pop.rs.getString("type_of").toUpperCase();
			i++;
		}
		
		pop.rs=pop.st.executeQuery("Select * from  Faculty_user where collegeida='"+fid+"'");
		pop.rs.next();
		String user_name=pop.rs.getString("namea");
		
		System.out.println(user_name);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1000, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		
		JLabel name_lbl=new JLabel("Document Title");
		 name_lbl.setBounds(50,80,131,30); 
		 contentPane.add(name_lbl);
		 // Creating JTextField for Name
		 name_txt=new JTextField();
		 name_txt.setBounds(180,80,214,30);  
		 contentPane.add(name_txt);
		 
		 JLabel fname_lbl=new JLabel("Document Link");
		 fname_lbl.setBounds(50,120,150,30);  
		 contentPane.add(fname_lbl);
		 
		 fname_txt=new JTextField();
		 fname_txt.setBounds(180,120,214,30);
		 contentPane.add(fname_txt);
		 Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		 
		 JLabel dob_lbl=new JLabel("Valid From");
		 dob_lbl.setBounds(50,200,100,30); 
		 contentPane.add(dob_lbl);
		 JLabel lblValidTo = new JLabel("Valid To");
		 lblValidTo.setFont(new Font("Arial", Font.BOLD, 14));
		 lblValidTo.setBounds(50, 241, 100, 30);
		 contentPane.add(lblValidTo);
		 
		 // Creating JComboBox for the day
		 String day_arr[]=new String[31];
		 String day_arr1[]=new String[30];
		 String day_arr2[]=new String[29];
		 for(i=1;i<=31;i++)
			 day_arr[i-1]=Integer.toString(i); 
		 for(i=1;i<=30;i++)
			 day_arr1[i-1]=Integer.toString(i); 
		 for(i=1;i<=29;i++)
			 day_arr2[i-1]=Integer.toString(i); 
		 
		 
	
		 String day1_arr[]=new String[31];
		 for(i=1;i<=30;i++)
		 day1_arr[i-1]=Integer.toString(i); 
		 day1=new JComboBox(day1_arr);
		 day1.setBounds(180, 242, 40, 30);
		 day1.setEnabled(false);
		 contentPane.add(day1);
		 
		 // Creating JComboBox for the month
		 String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		 month=new JComboBox(month_arr);
		 month.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent arg0) {
		 		
		 		
		 		if (arg0.getStateChange() == ItemEvent.SELECTED) 
		 		{
					if(month.getSelectedItem()=="Jan"||month.getSelectedItem()=="March"||month.getSelectedItem()=="May"||month.getSelectedItem()=="July"||month.getSelectedItem()=="Sept"||month.getSelectedItem()=="Oct"||month.getSelectedItem()=="Nov"||month.getSelectedItem()=="Dec")
					{	
						day=new JComboBox(day_arr);
						 day.setBounds(180,200,40,30);
					}
			    }
		 		else if(month.getSelectedItem()=="Feb")
		 		{
		 			day=new JComboBox(day_arr2);
		 			 day.setBounds(180,200,40,30);
		 		}
		 		else 
			    {
		 			day=new JComboBox(day_arr1);
		 			 day.setBounds(180,200,40,30);
			    }
		 		contentPane.add(day);
		 	}
		 });
		 month.setEnabled(false);
		 month.setBounds(230,200,60,30);
		 contentPane.add(month);
		 
		 String month1_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		 month1=new JComboBox(month1_arr);
		 month1.setBounds(230, 242, 60, 30);
		 month1.setEnabled(false);
		 contentPane.add(month1);
		 

		 // Creating JComboBox for the year	
		 String year_arr[]=new String[70];
		 for(i=1951;i<=2020;i++)
		 year_arr[i-1951]=Integer.toString(i);
		 year=new JComboBox(year_arr);
		 year.setBounds(300,200,60,30);
		 contentPane.add(year);
		 year.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) 
		 	{
		 		if (e.getStateChange() == ItemEvent.SELECTED) {
					month.setEnabled(true);
			        
			    } else {
			    	month.setEnabled(false);
			    }
		 	}
		 });
		 
		 String year1_arr[]=new String[70];
		 for(i=1951;i<=2020;i++)
		 year1_arr[i-1951]=Integer.toString(i);
		 year1=new JComboBox(year1_arr);
		 year1.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 	month1.setEnabled(true);
		 	day1.setEnabled(true);
		 	}
		 });
		 year1.setBounds(300, 242, 60, 30);
		 contentPane.add(year1);
		  
		 submit_btn=new JButton("Submit");
		 submit_btn.setBounds(61,617,120,40);
		 submit_btn.setCursor(cur);  // Applying hand cursor on the button
		 contentPane.add(submit_btn);
		 JButton btnCl = new JButton("Clear");
		 btnCl.setBounds(278, 626, 92, 23);
		 contentPane.add(btnCl);
		 
		 JCheckBox chk4 = new JCheckBox("4thYear");
		 chk4.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		
		 		if(chk4.isSelected())
		 		{
		 			cse4.setEnabled(true);
		 			cc4.setEnabled(true);
		 			ec4.setEnabled(true);
		 			me4.setEnabled(true);
		 			
		 		}
		 		else
		 		{
		 			cse4.setEnabled(false);
		 			cc4.setEnabled(false);
		 			ec4.setEnabled(false);
		 			me4.setEnabled(false);
		 		}
		 		
		 	}
		 });
		 
		 chk4.setBounds(32, 496, 97, 23);
		 contentPane.add(chk4);
		 
		 JCheckBox chk1 = new JCheckBox("1stYear");
		 chk1.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		
		 		if(chk1.isSelected())
		 		{
		 			cse1.setEnabled(true);
		 			cc1.setEnabled(true);
		 			ec1.setEnabled(true);
		 			me1.setEnabled(true);
		 			
		 		}
		 		else
		 		{
		 			cse1.setEnabled(false);
		 			cc1.setEnabled(false);
		 			ec1.setEnabled(false);
		 			me1.setEnabled(false);
		 		}
		 		
		 	}
		 });
		 
		 chk1.setBounds(32, 380, 97, 23);
		 contentPane.add(chk1);
		 
		 JCheckBox chk2 = new JCheckBox("2ndYear");
		 chk2.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		
		 		if(chk2.isSelected())
		 		{
		 			cse2.setEnabled(true);
		 			cc2.setEnabled(true);
		 			ec2.setEnabled(true);
		 			me2.setEnabled(true);
		 			
		 		}
		 		else
		 		{
		 			cse2.setEnabled(false);
		 			cc2.setEnabled(false);
		 			ec2.setEnabled(false);
		 			me2.setEnabled(false);
		 		}
		 	}
		 });
		 
		 chk2.setBounds(32, 409, 97, 23);
		contentPane.add(chk2);
		 
		 JCheckBox chk3 = new JCheckBox("3rdYear");
		 chk3.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		
		 		if(chk3.isSelected())
		 		{
		 			cse3.setEnabled(true);
		 			cc3.setEnabled(true);
		 			ec3.setEnabled(true);
		 			me3.setEnabled(true);
		 			
		 		}
		 		else
		 		{
		 			cse3.setEnabled(false);
		 			cc3.setEnabled(false);
		 			ec3.setEnabled(false);
		 			me3.setEnabled(false);
		 		}
		 		
		 	}
		 });
		 
		 chk3.setBounds(32, 448, 97, 23);
		 contentPane.add(chk3);
		 
		 
		 JLabel lblNewLabel = new JLabel("Target Audience");
		 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblNewLabel.setBounds(32, 336, 118, 30);
		 contentPane.add(lblNewLabel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Department");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		 lblNewLabel_1.setBounds(50, 295, 120, 23);
		 contentPane.add(lblNewLabel_1);
		 
		 String branch_arr[]={"CCE","CSE","ECE","MME" };
		 
		 JLabel lblType = new JLabel("Type");
		 lblType.setBounds(480, 120, 56, 16);
		 contentPane.add(lblType);
		 
		 tp = new JTextField();
		 tp.setBounds(449, 263, 116, 22);
		 contentPane.add(tp);
		 tp.setColumns(10);
		 tp.setEditable(false);
		 
		 JComboBox type_combo = new JComboBox(cc);
		 type_combo.addItemListener(new ItemListener() {
		 	public void itemStateChanged(ItemEvent e) {
		 		
		 		
		 		
		 		if(e.getStateChange() == ItemEvent.SELECTED) 
		 		{ 
          
		 			String item = (String) e.getItem();
		 			System.out.println(item);
          	    if(item.equals("OTHER"))
          	    {
          	    	tp.setEditable(true);
          	    }
          	    else
          	    	tp.setEditable(false);
          	    	
          	  }
		 	}
		 });
		 type_combo.setBounds(449, 173, 135, 23);
		 contentPane.add(type_combo);
		 
		 JLabel lblIfOtherMension = new JLabel("If other mension here");
		 lblIfOtherMension.setBounds(449, 227, 135, 16);
		 contentPane.add(lblIfOtherMension);
		 
		 cse1 = new JRadioButton("CSE");
		 cse1.setEnabled(false);
		 cse1.setBounds(137, 379, 127, 25);
		 contentPane.add(cse1);
		 
		 cc1 = new JRadioButton("CCE");
		 cc1.setEnabled(false);
		 cc1.setBounds(267, 379, 127, 25);
		 contentPane.add(cc1);
		 
		 ec1 = new JRadioButton("EC");
		 ec1.setEnabled(false);
		 ec1.setBounds(398, 379, 127, 25);
		 contentPane.add(ec1);
		 
		 me1 = new JRadioButton("ME");
		 me1.setEnabled(false);
		 me1.setBounds(525, 379, 127, 25);
		 contentPane.add(me1);
		 
		 cse2 = new JRadioButton("CSE");
		 cse2.setEnabled(false);
		 cse2.setBounds(137, 408, 127, 25);
		 contentPane.add(cse2);
		 
		 
		 cc2 = new JRadioButton("CCE");
		 cc2.setEnabled(false);
		 cc2.setBounds(267, 408, 127, 25);
		 contentPane.add(cc2);
		 
		 ec2 = new JRadioButton("EC");
		 ec2.setEnabled(false);
		 ec2.setBounds(398, 408, 127, 25);
		 contentPane.add(ec2);
		 
		 me2 = new JRadioButton("ME");
		 me2.setEnabled(false);
		 me2.setBounds(525, 408, 127, 25);
		 contentPane.add(me2);
		 
		 cse3 = new JRadioButton("CSE");
		 cse3.setEnabled(false);
		 cse3.setBounds(137, 447, 127, 25);
		 contentPane.add(cse3);
		 
		 cse4 = new JRadioButton("CSE");
		 cse4.setEnabled(false);
		 cse4.setBounds(137, 495, 127, 25);
		 contentPane.add(cse4);
		 
		 cc3 = new JRadioButton("CCE");
		 cc3.setEnabled(false);
		 cc3.setBounds(267, 447, 127, 25);
		 contentPane.add(cc3);
		 
		 cc4 = new JRadioButton("CCE");
		 cc4.setEnabled(false);
		 cc4.setBounds(267, 495, 127, 25);
		 contentPane.add(cc4);
		 
		 ec3 = new JRadioButton("EC");
		 ec3.setEnabled(false);
		 ec3.setBounds(398, 447, 127, 25);
		 contentPane.add(ec3);
		 
		 ec4 = new JRadioButton("EC");
		 ec4.setEnabled(false);
		 ec4.setBounds(398, 495, 127, 25);
		 contentPane.add(ec4);
		 
		 me3 = new JRadioButton("ME");
		 me3.setEnabled(false);
		 me3.setBounds(525, 447, 127, 25);
		 contentPane.add(me3);
		 
		 me4 = new JRadioButton("ME");
		 me4.setEnabled(false);
		 me4.setBounds(525, 495, 127, 25);
		 contentPane.add(me4);
		 
		 
		 
		 
		
		 
		 
		 // Step 18 :  Adding ActionListener on submit button
		 submit_btn.addActionListener(new ActionListener()
		 {
		 public void actionPerformed(ActionEvent event)
		 {
			 String name=name_txt.getText();
			 String fname=fname_txt.getText();
			 String day_name=(String)day.getSelectedItem();
			 String month_name=(String)month.getSelectedItem();
			 String year_name=(String)year.getSelectedItem();
			 String day1_name=(String)day1.getSelectedItem();
			 String month1_name=(String)month1.getSelectedItem();
			 String year1_name=(String)year1.getSelectedItem();
			 
			 
			 String vr="0000000000000000";
			 char[] vrc = vr.toCharArray();
			 if(cse1.isSelected())
				 vrc[0]='1';
			 if(cc1.isSelected())
				 vrc[1]='1';
			 if(ec1.isSelected())
				 vrc[2]='1';
			 if(me1.isSelected())
				 vrc[3]='1';
			 if(cse2.isSelected())
				 vrc[4]='1';
			 if(cc2.isSelected())
				 vrc[5]='1';
			 if(ec2.isSelected())
				 vrc[6]='1';
			 if(me2.isSelected())
				 vrc[7]='1';
			 if(cse3.isSelected())
				 vrc[8]='1';
			 if(cc3.isSelected())
				 vrc[9]='1';
			 if(ec3.isSelected())
				 vrc[10]='1';
			 if(me3.isSelected())
				 vrc[11]='1';
			 if(cse4.isSelected())
				 vrc[12]='1';
			 if(cc4.isSelected())
				 vrc[12]='1';
			 if(ec4.isSelected())
				 vrc[14]='1';
			 if(me4.isSelected())
				 vrc[15]='1';
			 vr = String.valueOf(vrc);
			 int mmm=0;
			 if(month1_name.equals("Jan"))
					mmm=1;
				else if(month1_name.equals("Feb"))
					mmm=2;
				else if(month1_name.equals("March"))
					mmm=3;
				else if(month1_name.equals("April"))
					mmm=4;
				else if(month1_name.equals("May"))
					mmm=5;
				else if(month1_name.equals("June"))
					mmm=6;
				else if(month1_name.equals("July"))
					mmm=7;
				else if(month1_name.equals("Aug"))
					mmm=8;
				else if(month1_name.equals("Sept"))
					mmm=9;
				else if(month1_name.equals("Oct"))
					mmm=10;
				else if(month1_name.equals("Nov"))
					mmm=11;
				else if(month1_name.equals("Dec"))
					mmm=12;
			 System.out.println(vr);
			 if(day_name.isEmpty()||name.isEmpty()||fname.isEmpty()||month_name.isEmpty()
					 ||year_name.isEmpty()||day1_name.isEmpty()||month1_name.isEmpty()||year1_name.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Data missing");
				}
				else
				{
					String iii = (String)type_combo.getSelectedItem();
					System.out.println(iii);
					if(iii.equals("OTHER"))
					{
						if(tp.getText().equals(""))
							JOptionPane.showMessageDialog(null, "Data missing");
						else
						{
							int count1;
							
							
							
							
							
							try {
								count1 = pop.st.executeUpdate("INSERT INTO "
										+ "document(title,submitter,fromday,frommonth,fromyear,today,tommonth,toyear,link,type_of,viewres)"+ "values('"+name+"','"+user_name+"','"+day_name+"','"+month_name+"','"+year_name+"','"+day1_name+"',"+mmm+",'"+year1_name+"','"+fname+"','"+tp.getText()+"','"+vr+"')");
								System.out.println("count1="+count1);
								JOptionPane.showMessageDialog(null, "Data Pushed");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
						}
							
					}
					else
					{
						
						int count2;
						try {
							count2 = pop.st.executeUpdate("INSERT INTO document(title,submitter,fromday,frommonth,fromyear,today,tommonth,toyear,link,type_of,viewres)"+ "values('"+name+"','"+user_name+"','"+day_name+"','"+month_name+"','"+year_name+"','"+day1_name+"',"+mmm+",'"+year1_name+"','"+fname+"','"+iii+"','"+vr+"')");
							System.out.println("count1="+count2);
							JOptionPane.showMessageDialog(null, "Data Pushed");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				}
			 
		 
		 } 
		 });
		 
		 btnCl.addActionListener(new ActionListener()
		 {
				public void actionPerformed(ActionEvent e) 	{
					name_txt.setText(null);
					fname_txt.setText(null);
					day.setSelectedItem(false);
					day1.setSelectedItem(false);
					year.setSelectedItem(false);
					year1.setSelectedItem(false);
					month.setSelectedItem(false);
					month1.setSelectedItem(false);
				}
			});
		
		
	}
}
