import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.awt.Font;
import javax.swing.SwingConstants;  

@SuppressWarnings("serial")
public class dexter extends JFrame {
	
	String ll="________________";

	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dexter frame = new dexter("faMukeshJ",1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public dexter(String fid,int flag) throws SQLException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd");  
	    Date date = new Date();  
	    String dy=formatter.format(date);
	    int day_today=Integer.parseInt(dy);
	    System.out.println(day_today);
	    formatter = new SimpleDateFormat("MM");  
	   date = new Date();  
	    String dy1=formatter.format(date);
	    int month_today=Integer.parseInt(dy1);
	    System.out.println(month_today);
	   formatter = new SimpleDateFormat("yyyy");  
	     date = new Date();  
	    String dy2=formatter.format(date);
	    int year_today=Integer.parseInt(dy2);
	    System.out.println(dy2);
	    
	    
	    String two_char=fid.substring(0,2);
	    System.out.println(two_char);
	    String deep=fid.substring(3,5);
	    System.out.println(deep);
	    
	    char[] llc = ll.toCharArray();

	    if(two_char.equals("18"))
	    {
	    	if(deep.equals("cs"))
	    	{
	    		llc[0]='1';
	    	}
	    	else if(deep.equals("cc"))
	    	{
	    		llc[1]='1';
	    	}
	    	else if(deep.equals("ec"))
	    	{
	    		llc[2]='1';
	    	}
	    	else if(deep.equals("me"))
	    	{
	    		llc[3]='1';
	    	}
	    	
	    	
	    }
	    else if(two_char.equals("17"))
	    {
	    	if(deep.equals("cs"))
	    	{
	    		llc[4]='1';
	    	}
	    	else if(deep.equals("cc"))
	    	{
	    		llc[5]='1';
	    	}
	    	else if(deep.equals("ec"))
	    	{
	    		llc[6]='1';
	    	}
	    	else if(deep.equals("me"))
	    	{
	    		llc[7]='1';
	    	}
	    }
	    else if(two_char.equals("16"))
	    {
	    	if(deep.equals("cs"))
	    	{
	    		llc[8]='1';
	    	}
	    	else if(deep.equals("cc"))
	    	{
	    		llc[9]='1';
	    	}
	    	else if(deep.equals("ec"))
	    	{
	    		llc[10]='1';
	    	}
	    	else if(deep.equals("me"))
	    	{
	    		llc[11]='1';
	    	}
	    }
	    else if(two_char.equals("15"))
	    {
	    	if(deep.equals("cs"))
	    	{
	    		llc[12]='1';
	    	}
	    	else if(deep.equals("cc"))
	    	{
	    		llc[13]='1';
	    	}
	    	else if(deep.equals("ec"))
	    	{
	    		llc[14]='1';
	    	}
	    	else if(deep.equals("me"))
	    	{
	    		llc[15]='1';
	    	}
	    }
	    
	    ll = String.valueOf(llc);
	    System.out.println(ll);
	    
	    	
		
		connections pop=new connections(flag);
		
		pop.rs=pop.st.executeQuery("SELECT DISTINCT submitter FROM document ORDER BY submitter");
		int a=0,i=0;
		while(pop.rs.next())
			a++;
		pop.rs=pop.st.executeQuery("SELECT DISTINCT submitter FROM document ORDER BY submitter");
		String[] cc=new String[a];
		while(pop.rs.next())
		{
			cc[i]=pop.rs.getString("submitter").toUpperCase();
			i++;
		}
		
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type_of FROM document ORDER BY type_of");
		 a=0;
		 i=0;
		while(pop.rs.next())
			a++;
		pop.rs=pop.st.executeQuery("SELECT DISTINCT type_of FROM document ORDER BY type_of");
		String[] cc2=new String[a];
		while(pop.rs.next())
		{
			cc2[i]=pop.rs.getString("type_of").toUpperCase();
			i++;
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnAll = new JRadioButton("All");
		rdbtnAll.setBounds(85, 60, 183, 23);
		contentPane.add(rdbtnAll);
		
		JRadioButton rdbtnSearchByField = new JRadioButton("Search By field");
		rdbtnSearchByField.setBounds(85, 117, 196, 23);
		contentPane.add(rdbtnSearchByField);
		
		ButtonGroup gp=new ButtonGroup();
		gp.add(rdbtnAll);
		gp.add(rdbtnSearchByField);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox(cc);
		comboBox.setEnabled(false);
		comboBox.setBounds(193, 182, 88, 20);
		contentPane.add(comboBox);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox(cc2);
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(193, 233, 88, 20);
		contentPane.add(comboBox_1);
		
		
		rdbtnSearchByField.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
			        
			    } else {
			    	comboBox.setEnabled(false);
			    	comboBox_1.setEnabled(false);
			    }
			}
		});
		
		
		JLabel lblSubmittor = new JLabel("Submittor");
		lblSubmittor.setBounds(29, 182, 111, 30);
		contentPane.add(lblSubmittor);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(29, 233, 111, 17);
		contentPane.add(lblType);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(rdbtnAll.isSelected())
				{
					try {
						pop.rs=pop.st.executeQuery("select * from document where ( toyear>"+year_today+" or (toyear="+year_today+" and tommonth>"+month_today+") or (toyear="+year_today+" and tommonth="+month_today+" and today>="+day_today+")) and viewres LIKE '"+ll+"'");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					table.setModel(DbUtils.resultSetToTableModel(pop.rs));
				}
				else
				{
					String s1=(String) comboBox.getSelectedItem();
					String s2=(String) comboBox_1.getSelectedItem();
					try {
						pop.rs=pop.st.executeQuery("select * from document where ( toyear>"+year_today+" or (toyear="+year_today+" and tommonth>"+month_today+") or (toyear="+year_today+" and tommonth="+month_today+" and today>="+day_today+")) and viewres LIKE '"+ll+"' and (submitter='"+s1+"' AND type_of='"+s2+"')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					table.setModel(DbUtils.resultSetToTableModel(pop.rs));
					
				}
				
			}
		});
		btnView.setBounds(147, 331, 97, 25);
		contentPane.add(btnView);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 96, 766, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
				
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.awt.Window win[] = java.awt.Window.getWindows(); 
				for(int i=0;i<win.length;i++){ 
				win[i].dispose(); 
				}
				try {
					Login looo = new Login(flag);
					looo.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnLogOut.setBounds(842, 28, 117, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblViewSubmittedDocs = new JLabel("VIEW SUBMITTED DOCS");
		lblViewSubmittedDocs.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewSubmittedDocs.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblViewSubmittedDocs.setBounds(274, 43, 320, 27);
		contentPane.add(lblViewSubmittedDocs);
	}
}