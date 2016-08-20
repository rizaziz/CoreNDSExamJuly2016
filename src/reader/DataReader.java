package reader;

import java.io.*;
import java.sql.*;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */
		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";

		BufferedReader br=null;
		StringBuilder sb=new StringBuilder();

		try{
			br=new BufferedReader(new FileReader(textFile));
			String temp=null;
			while((temp=br.readLine())!=null){
				sb.append(temp);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
			}catch(Exception e){}
		}

		final String url="jdbc:oracle:thin:@localhost:1521:orcl";
		final String user="system";
		final String pass="oracle";

		try(Connection conn=DriverManager.getConnection(url, user, pass);
		    Statement stmt=conn.createStatement()){

			DatabaseMetaData meta=conn.getMetaData();

			try{
				int result=stmt.executeUpdate("CREATE table bigText(column1 CLOB)");
			}catch(SQLException e){}

			int result=stmt.executeUpdate("INSERT INTO bigText VALUES('"+sb+"')");

		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
