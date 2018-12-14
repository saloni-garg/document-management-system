import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class application extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					application frame = new application(1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public application(int flag) {
		System.out.println("Le karva diyaa print");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NOC Application");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NOC noco;
				try {
					noco = new NOC(flag);
					noco.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		rdbtnNewRadioButton.setBounds(18, 95, 205, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Leave Application");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leaveAppl lao;
				try {
					lao = new leaveAppl(flag);
					lao.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		rdbtnNewRadioButton_1.setBounds(252, 95, 169, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnMakeupExam = new JRadioButton("Make-Up Exam Application ");
		rdbtnMakeupExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Makeupex meo;
				try {
					meo = new Makeupex(flag);
					meo.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		rdbtnMakeupExam.setBounds(18, 134, 232, 23);
		contentPane.add(rdbtnMakeupExam);
		
		JRadioButton rdbtnSemesterLongInternship = new JRadioButton("Semester Long Internship Notification");
		rdbtnSemesterLongInternship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sli_not sno;
				try {
					sno = new sli_not(flag);
					sno.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		rdbtnSemesterLongInternship.setBounds(252, 134, 249, 23);
		contentPane.add(rdbtnSemesterLongInternship);
		
		JLabel lblSelectTheType = new JLabel("Select the type of application you want to submit:");
		lblSelectTheType.setBounds(30, 56, 360, 14);
		contentPane.add(lblSelectTheType);
		
		ButtonGroup gp = new ButtonGroup();
		gp.add(rdbtnSemesterLongInternship);
		gp.add(rdbtnMakeupExam);
		gp.add(rdbtnNewRadioButton_1);
		gp.add(rdbtnNewRadioButton);

		}
	}

