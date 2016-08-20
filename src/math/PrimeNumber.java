package math;

import java.sql.*;
import java.util.*;
import math.*;

public class PrimeNumber {

	public static List<Integer> primeList=new LinkedList<>();

	public PrimeNumber(){
		primeList.add(2);//Adding first prime number
	}

	public boolean isPrime(int number){
		for(int i:primeList){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}

	public void addPrime(int number){
		primeList.add(number);
	}

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

		PrimeNumber pr=new PrimeNumber();

		long startTime=System.currentTimeMillis();
		for(int number=2; number<=1_000_000; number++){
			if(pr.isPrime(number)){
				pr.addPrime(number);
			}
		}
		long endTime=System.currentTimeMillis();
		System.out.println("Calculation time: "+(endTime-startTime)/1000+" seconds "+(endTime-startTime)%1000+" milliseconds");
		System.out.println(pr.primeList);
		System.out.println(pr.primeList.size());

		System.out.println("Creating table in Oracle database....");
		Pattern.createTable("PRIME_NUMBERS");

		System.out.println("Populating table with data......");
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try{
			conn=Pattern.getConnection();
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs=stmt.executeQuery("SELECT column1 from PRIME_NUMBERS");
			for(int i:primeList){
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

		System.out.println("Displaying data from database....");
		Pattern.showTable("PRIME_NUMBERS");
	}
}
