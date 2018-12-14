import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connections {

	public String url;
	public String uname;
	public  String pass;  
	public Connection con;
	public Statement st;
	public ResultSet rs;
	public static void main(String[] args) {
		
	}
	public	connections(int flag) throws SQLException
	 {
		if(flag==1)
		{
			url="jdbc:mysql://rds-mysql-10mintutorial.cafxu18krhjr.us-east-1.rds.amazonaws.com:3306/masterUsername";
			uname="masterUsername";
			pass="akanksha";  
		}
		else
		{
			url="jdbc:mysql://localhost:3306/Project";
			uname="root";
			pass="tusharb104";
		}
		
		con= DriverManager.getConnection(url,uname,pass);
		st=con.createStatement();
	 }

}
