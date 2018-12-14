

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Research extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	@SuppressWarnings("rawtypes")
	public static JComboBox comboBox;
	private JTextField textField_4;
	private JTextField textField_5;
	public static void main(String[] args)throws Exception {
		
		
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Research frame = new Research(flag);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Research(int flag) throws SQLException {
		
		
		connections pop=new connections(flag);
		
		setBounds(100, 100, 2000, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInformationToSubmit = new JLabel("Information to submit a Research Paper");
		lblInformationToSubmit.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformationToSubmit.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformationToSubmit.setBounds(240, 35, 480, 16);
		contentPane.add(lblInformationToSubmit);
		
		JLabel lblTitle = new JLabel("Title ");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTitle.setBounds(153, 251, 56, 16);
		contentPane.add(lblTitle);
		
		JLabel lblFeild = new JLabel("Feild");
		lblFeild.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFeild.setBounds(916, 251, 56, 16);
		contentPane.add(lblFeild);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(376, 249, 190, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(1134, 249, 190, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblType.setBounds(153, 324, 56, 16);
		contentPane.add(lblType);
		
		JRadioButton rdbtnAnalytical = new JRadioButton("Analytical");
		rdbtnAnalytical.setBackground(Color.WHITE);
		rdbtnAnalytical.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnAnalytical.setBounds(226, 361, 127, 25);
		contentPane.add(rdbtnAnalytical);
		
		JRadioButton rdbtnArgumental = new JRadioButton("Argumental");
		rdbtnArgumental.setBackground(Color.WHITE);
		rdbtnArgumental.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnArgumental.setBounds(226, 429, 127, 25);
		contentPane.add(rdbtnArgumental);
		
		String[] a=new String[50];
		int j=1970;
		for(int i=0;i<50;i++)
		{
			a[i]=Integer.toString(j);
			j++;
		}
		comboBox = new JComboBox(a);
		comboBox.setBounds(343, 161, 103, 22);
		
		JLabel lblContributers = new JLabel("Contributers");
		lblContributers.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContributers.setBounds(153, 497, 127, 16);
		contentPane.add(lblContributers);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(376, 495, 190, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAbstract = new JLabel("Abstract");
		lblAbstract.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAbstract.setBounds(153, 590, 83, 16);
		contentPane.add(lblAbstract);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.LIGHT_GRAY);
		textPane.setContentType("`");
		textPane.setBounds(376, 572, 344, 178);
		contentPane.add(textPane);
		
		JLabel lblDocumentLink = new JLabel("Document Link");
		lblDocumentLink.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDocumentLink.setBounds(916, 833, 138, 16);
		contentPane.add(lblDocumentLink);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(1267, 831, 245, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		ButtonGroup gptype=new ButtonGroup();
		gptype.add(rdbtnArgumental);
		gptype.add(rdbtnAnalytical);
		
		JButton btnSubmit = new JButton("Submit");
		
		
		
		
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().isEmpty()||textField_1.getText().isEmpty()||textField_2.getText().isEmpty()||textField_3.getText().isEmpty()
						||textPane.getText().isEmpty()||(!rdbtnAnalytical.isSelected()&&!rdbtnArgumental.isSelected()))
				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
				else
				{
					String title_st=textField.getText();
					String field_st=textField_1.getText();
					String contributor_st=textField_2.getText();
					String contributor2_st;
					String contributor3_st;
					
					
					String abstract_st=textPane.getText();
					String doc_link=textField_3.getText();
					String rdb_st;
					String s=(String) comboBox.getSelectedItem();
					System.out.println(s);
					if(rdbtnAnalytical.isSelected())
						rdb_st=rdbtnAnalytical.getLabel();
					else
						rdb_st=rdbtnArgumental.getLabel();
			
					int count;
					try {
						count = pop.st.executeUpdate("insert into researchp(title,feild,abstract,link,type_of,year) "
								+ "values('"+title_st+"','"+field_st+"','"+abstract_st+"','"+doc_link+"','"+rdb_st+"','"+s+"')");
						pop.rs=pop.st.executeQuery("select id from researchp where title='"+title_st+"' AND feild='"+field_st+"' AND "
								+ "abstract='"+abstract_st+"' AND link='"+doc_link+"' AND type_of='"+rdb_st+"' "
										+ "AND year='"+s+"'");
						pop.rs.next();
						int id_of=pop.rs.getInt("id");
						int count_2=pop.st.executeUpdate("insert into contributor(id,res_contributor) "
								+ "values("+id_of+",'"+contributor_st+"')");
						System.out.println( "count 2 ="+count_2);
						
						if(!textField_4.getText().isEmpty())
						{
							contributor2_st=textField_4.getText();
							int count_3=pop.st.executeUpdate("insert into contributor(id,res_contributor) "
									+ "values("+id_of+",'"+contributor2_st+"')");
							System.out.println("contributor 2 update"+count_3);
						}
						if(!textField_5.getText().isEmpty())
						{
							contributor3_st=textField_5.getText();
							int count_4=pop.st.executeUpdate("insert into contributor(id,res_contributor) values("+id_of+",'"+contributor3_st+"')");
							System.out.println("contributor 2 update"+count_4);
							
						}
						
						
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					textPane.setText(null);
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					rdbtnAnalytical.setSelected(false);
					rdbtnArgumental.setSelected(false);
					JOptionPane.showMessageDialog(null, "Data pushed");
					
				}
			}
		});
		btnSubmit.setBounds(1052, 607, 97, 25);
		contentPane.add(btnSubmit);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(153, 164, 56, 16);
		contentPane.add(lblYear);
		
		
		contentPane.add(comboBox);
		
		JLabel lblSecondContributor = new JLabel("Second Contributor");
		lblSecondContributor.setBounds(887, 366, 138, 16);
		contentPane.add(lblSecondContributor);
		
		JLabel lblThirdContributor = new JLabel("Third Contributor");
		lblThirdContributor.setBounds(887, 434, 113, 16);
		contentPane.add(lblThirdContributor);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1072, 363, 165, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1072, 431, 165, 22);
		contentPane.add(textField_5);
	}
}
