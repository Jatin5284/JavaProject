package JDBC_API;

import JDBC_API.Basic;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class SelectQuery {
	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		Scanner sc=new Scanner(System.in);
		
		try {
		connection=Basic.getJdbcConnection();
		
		if(connection!=null) {
			String mysqlQuery="select * from student where id=?";
			
			preparedStatement=connection.prepareStatement(mysqlQuery);
			
			if(preparedStatement!=null) {
				System.out.println("Enter the id which you want to get from database of MySql");
				int id=sc.nextInt();
				preparedStatement.setInt(1, id);
				
				result=preparedStatement.executeQuery();
				if(result!=null) {
					if(result.next()) {
						System.out.println("ID\tNAME\tROLLNUM\tRESULT");
						System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t "+result.getInt(3)+"\t"+result.getString(4));
					}
					}
					else {
						System.out.println("Row is not inserted");
				}
			}
		}
		}catch(IOException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {   
			Basic.closeResource(connection, preparedStatement,result);
			sc.close();

			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}
}
