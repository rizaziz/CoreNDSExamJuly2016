package math;
import java.sql.*;

public class Pattern {

	private static class TblBody{

	}

	public static Connection getConnection() throws SQLException{
		final String url="jdbc:oracle:thin:@localhost:1521:orcl";
		final String user="system";
		final String pass="oracle";
		return DriverManager.getConnection(url, user, pass);
	}

	//public static void createTable(String tblName, );

	public static void createTable(String tblName){
		Connection conn=null;
		Statement stmt=null;
		try{
			conn=getConnection();
			stmt=conn.createStatement();
			int result=stmt.executeUpdate("CREATE TABLE "+tblName+"(column1 number primary key)");
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
			}catch(SQLException e){}
			try{
				conn.close();
			}catch(SQLException e){}
		}
	}

	public static void populateTable(String tblName, int[] data){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			//conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","oracle");
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("SELECT column1 FROM "+tblName);
			for(int i:data){
				rs.moveToInsertRow();
				rs.updateInt(1,i);
				rs.insertRow();
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
			}catch(SQLException e){}
			try{
				stmt.close();
			}catch(SQLException e){}
			try{
				conn.close();
			}catch(SQLException e){}
		}
	}

	public static void showTable(String tblName){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery("SELECT *  FROM "+ tblName);
			while(rs.next()){
				System.out.println(rs.getInt(1));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		//the pattern is number-=1;

		int[] data=new int[100];
		int number=100;

		for(int i=0; i<100; i++){
			data[i]=number;
			number-=1;
		}

		String tblName="NUMBERS";
		//String query="CREATE TABLE "+tblName+"(column1 number primary key)";

		createTable(tblName);
		populateTable(tblName, data);
		showTable(tblName);
	}
}
