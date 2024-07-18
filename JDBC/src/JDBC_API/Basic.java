package JDBC_API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Basic {
	
	// task to get the properties from the application file and loading the driver with connection
	public static Connection getJdbcConnection() throws FileNotFoundException,IOException , SQLException {
		FileInputStream fis=new FileInputStream("Jdbc_UrlPassword_Resource");
		Properties p=new Properties();
		p.load(fis);
		
		String url=p.getProperty("url");
		String user=p.getProperty("user");
		String password=p.getProperty("password");
		
		System.out.println("url= "+url);
		System.out.println("user= "+user);
		System.out.println("password= "+password);
		
		Connection connection=DriverManager.getConnection(url,user,password);
		return connection;
	}
	
	public static void closeResource(Connection connection,Statement statement) throws SQLException{
		if(connection!=null) {
			connection.close();
		}if(statement!=null) {
			statement.close();
		}
	}
	
	public static void closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet) throws SQLException{
		if(connection!=null) {
			connection.close();
		}if(preparedStatement!=null) {
			preparedStatement.close();
		}
		if(resultSet!=null) {
            resultSet.close();
        }
	}
	
//	public static void closeResource(Connection connection, PreparedStatement preparedStatement,Up) throws SQLException {
//        if (connection != null) {
//            connection.close();
//        }
//        if (preparedStatement != null) {
//            preparedStatement.close();
//        }
//
//    }


}
