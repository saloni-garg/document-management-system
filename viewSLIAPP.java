import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
public class viewSLIAPP extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewSLIAPP frame = new viewSLIAPP("registrar",1);
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
	public viewSLIAPP(String fid,int flag) throws SQLException {
		
		connections pop = new connections(flag);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(132, 137, 579, 352);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		if(fid.equals("registrar"))
		{
			pop.rs=pop.st.executeQuery("select * from sli");
		}
		else
		{
			pop.rs=pop.st.executeQuery("select * from sli where rollno='"+fid+"'");
		}
		table.setModel(DbUtils.resultSetToTableModel(pop.rs));
		
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
		btnLogOut.setBounds(559, 27, 117, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblYourSliApplications = new JLabel("YOUR SLI APPLICATIONS");
		lblYourSliApplications.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourSliApplications.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYourSliApplications.setBounds(229, 88, 320, 27);
		contentPane.add(lblYourSliApplications);
		
		
	}
}
