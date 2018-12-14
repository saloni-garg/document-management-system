import java.awt.EventQueue;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class submittedApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					submittedApplication frame = new submittedApplication("registrar",1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public submittedApplication(String fid,int flag) throws SQLException {
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLeaveApplication = new JButton("Leave Application");
		btnLeaveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewLeaveApp lea;
				try {
					lea = new viewLeaveApp(fid,flag);
					lea.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnLeaveApplication.setBounds(51, 112, 145, 25);
		contentPane.add(btnLeaveApplication);
		
		JButton btnNocApplication = new JButton("NOC Application");
		btnNocApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewNOCAPP nop;
				try {
					nop = new viewNOCAPP(fid,flag);
					nop.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNocApplication.setBounds(51, 162, 145, 25);
		contentPane.add(btnNocApplication);
		
		JButton btnMakeupApplication = new JButton("MakeUp Exam Application");
		btnMakeupApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewMakeupAPP map;
				try {
					map = new viewMakeupAPP(fid,flag);
					map.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnMakeupApplication.setBounds(51, 200, 145, 25);
		contentPane.add(btnMakeupApplication);
		
		JButton btnSliApplication = new JButton("SLI  Application");
		btnSliApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewSLIAPP vvv;
				try {
					System.out.println(fid);
					vvv = new viewSLIAPP(fid,flag);
					vvv.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSliApplication.setBounds(51, 62, 145, 25);
		contentPane.add(btnSliApplication);
		
		
		
	}

}
