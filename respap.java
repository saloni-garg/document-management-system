import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;


public class respap extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static JLabel label_1;
	
	
	private JTable table;
	private JScrollPane scrollPane;
	
	public static void main(String[] args) throws SQLException {
		
		
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					respap frame = new respap();
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
	public respap(int flag) throws SQLException {
		
		connections pop=new connections(flag);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResearchPaperPortal = new JLabel("RESEARCH PAPER PORTAL");
		lblResearchPaperPortal.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResearchPaperPortal.setBounds(227, 30, 274, 14);
		contentPane.add(lblResearchPaperPortal);
		
		JLabel lblFieldOfResearch = new JLabel("Field of Research:");
		lblFieldOfResearch.setBounds(51, 167, 146, 14);
		contentPane.add(lblFieldOfResearch);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(180, 164, 187, 20);
		contentPane.add(textField_2);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!(textField.getText().isEmpty()&&textField_1.getText().isEmpty()&&textField_2.getText().isEmpty()))
				{
					if(!textField.getText().isEmpty())
					{
						String tf=textField.getText();
						if(!textField_1.getText().isEmpty())
						{
							String tf1=textField_1.getText();
							if(!textField_2.getText().isEmpty())
							{
								String tf2=textField_2.getText();
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  contributor.res_contributor='"+tf+"'AND "
													+ "researchp.title='"+tf1+"'AND researchp.feild='"+tf2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  contributor.res_contributor='"+tf+"'AND "
													+ "researchp.title='"+tf1+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						else
						{
							if(!textField_2.getText().isEmpty())
							{
								String tf2=textField_2.getText();
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  contributor.res_contributor='"+tf+"'AND researchp.feild='"+tf2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  contributor.res_contributor='"+tf+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					else
					{
						if(!textField_1.getText().isEmpty())
						{
							String tf1=textField_1.getText();
							if(!textField_2.getText().isEmpty())
							{
								String tf2=textField_2.getText();
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  researchp.title='"+tf1+"'AND researchp.feild='"+tf2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							else
							{
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  researchp.title='"+tf1+"'");
								
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						else
						{
							if(!textField_2.getText().isEmpty())
							{
								String tf2=textField_2.getText();
								try {
									pop.rs=pop.st.executeQuery("SELECT researchp.title,researchp.feild,researchp.abstract,researchp.link,researchp.type_of,researchp.year,contributor.res_contributor  FROM researchp INNER JOIN  contributor ON researchp.id=contributor.id "
											+ "WHERE  researchp.feild='"+tf2+"'");
									
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
					}
					
				
				}
					
					table.setModel(DbUtils.resultSetToTableModel(pop.rs));
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Data Missing");
				}
			}
		});
		btnSearch.setBounds(51, 228, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel lblAuthorName = new JLabel("Author Name:");
		lblAuthorName.setBounds(42, 89, 117, 14);
		contentPane.add(lblAuthorName);
		
		textField = new JTextField();
		textField.setBounds(180, 89, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTitleOfPaper = new JLabel("Title of Paper:");
		lblTitleOfPaper.setBounds(42, 125, 117, 14);
		contentPane.add(lblTitleOfPaper);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(180, 125, 187, 20);
		contentPane.add(textField_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(451, 16, 639, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
}
}




