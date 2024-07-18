package JDBC_API;

import JDBC_API.Basic;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

public class InsertmySqlQuery {
	public static void main(String[] args) {
		Connection connection=null;
		
//		Statement statement =null;
		PreparedStatement preparedStatement=null;
		
		try {
		connection=Basic.getJdbcConnection();
		
		if(connection!=null) {
//			String myinsertQuery="insert into student(name,rollnum, result) values('Vikram',123,'PASS')";
			String mysqlQuery="insert into student(name,rollnum,result) values(?,?,?)";
			
//			statement=connection.createStatement();
			preparedStatement=connection.prepareStatement(mysqlQuery);
			
			if(preparedStatement!=null) {
				Scanner sc=new Scanner(System.in);
				preparedStatement.setString(1,"Chirag");
				preparedStatement.setInt(2, 124);
				preparedStatement.setString(3, "pass");
				
				int roweffected=preparedStatement.executeUpdate();
				if(roweffected==1) {
					System.out.println("Row Inserted");
					}
					else {
						System.out.println("Row is not inserted");
				}
			}
			
//			int roweffected=statement.executeUpdate(myinsertQuery);
//			if(roweffected==1) {
//				System.out.println("Row Inserted");
//			}
//			else {
//				System.out.println("Row is not inserted");
//			}
			}
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
//			Basic.closeResource(connection, statement);    
			Basic.closeResource(connection, preparedStatement);

			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}
