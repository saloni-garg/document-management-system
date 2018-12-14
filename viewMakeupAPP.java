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

public class viewMakeupAPP extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMakeupAPP frame = new viewMakeupAPP("registrar",1);
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
	public viewMakeupAPP(String fid,int flag) throws SQLException {
		
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
			pop.rs=pop.st.executeQuery("select * from Make_up_exam");
		}
		else
		{
			pop.rs=pop.st.executeQuery("select * from Make_up_exam where rollno='"+fid+"'");
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
		
		JLabel lblYourMakeupExam = new JLabel("YOUR MAKE-UP EXAM APPLICATIONS");
		lblYourMakeupExam.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourMakeupExam.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblYourMakeupExam.setBounds(173, 84, 433, 27);
		contentPane.add(lblYourMakeupExam);
		
	}
}
