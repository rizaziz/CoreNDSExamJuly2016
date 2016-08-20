package datastructure;
import java.util.*;
import math.*;
import java.sql.*;
public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */

		Map<String, List<String>> map=new HashMap<>();

		List<String> lang=new ArrayList<>();
		lang.addAll(Arrays.asList("Java", "C","C++", "C#", "Python","Visual Basic"));

		List<String> operSys=new ArrayList<>();
		operSys.addAll(Arrays.asList(new String[]{"Windows","iOS","Linux","Unix"}));

		List<String> browsers=new LinkedList<>(Arrays.asList("Internet Explorer","Safari","Chrome","FireFox"));

		List<String> databases=new LinkedList<>();
		databases.add("Oracle");
		databases.add("SQL Server");
		databases.add("DB2");
		databases.add("MySQL");
		databases.add("MonoDB");

		map.put("Programming Languages", lang);
		map.put("Operating Systems", operSys);
		map.put("Internet Browsers", browsers);
		map.put("DBMS", databases);

		//Printing map//////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println(map);
		System.out.println();

		//Retreiving map content through entrySet///////////////////////////////////////////////////////////////////
		for(Map.Entry<String, List<String>> entry:map.entrySet()){
			System.out.println(entry.getKey().toUpperCase()+":");
			for(String str:entry.getValue()){
				System.out.println("  -"+str);
			}
		}

		//Retreiving map content through keySet//////////////////////////////////////////////////////////////////////
		for(String key:map.keySet()){
			System.out.println(key+":");
			for(String value:map.get(key)){
				System.out.println("  -"+value);
			}
		}

		//Retreiving map content through keySet Iterator object//////////////////////////////////////////////////////
		Iterator<String> iter=map.keySet().iterator();
		String str;
		while(iter.hasNext()){
			System.out.println((str=iter.next())+": "+map.get(str));
		}

		//Creating table in Oracle DB
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=Pattern.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			DatabaseMetaData meta=conn.getMetaData();

			//Creating tables
			stmt.addBatch("CREATE TABLE tbl_INV(" +
						  "Invironment VARCHAR2(40)," +
					      " CONSTRAINT inv_pk primary key (Invironment))");

			stmt.addBatch("CREATE TABLE tbl_TECH(" +
					      "Technologies VARCHAR2(40)," +
					      "Invironment VARCHAR2(40),"+
					      "CONSTRAINT tech_pk primary key (Technologies)," +
					      "CONSTRAINT tech_fk foreign key (Invironment) references tbl_INV(Invironment))");

			stmt.executeBatch();

			//Populating tables
			rs=stmt.executeQuery("SELECT Invironment FROM tbl_INV");
			for(String s:map.keySet()){
				rs.moveToInsertRow();
				rs.updateString(1, s);
				rs.insertRow();
			}
			rs=stmt.executeQuery("SELECT Technologies, Invironment FROM tbl_TECH");
			for(Map.Entry<String, List<String>> entry:map.entrySet()){
				for(String s:entry.getValue()){
					rs.moveToInsertRow();
					rs.updateString(1, s);
					rs.updateString(2, entry.getKey());
					rs.insertRow();
				}
			}

			//Displaying tables
			rs=stmt.executeQuery("SELECT invironment, technologies from tbl_INV " +
						         "LEFT JOIN (SELECT technologies, tbl_TECH.invironment inv from tbl_TECH) " +
							     "on tbl_INV.invironment=inv");

			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}

			rs.close();
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
}
