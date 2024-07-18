package JDBC_API;

import java.sql.*;
import java.util.*;
import java.io.*;
import JDBC_API.Basic;

public class UpdateQuery {
	public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            connection=Basic.getJdbcConnection();

            if(connection!=null) {
                String mysqlQuery="update student set result=? where id=?";

                preparedStatement=connection.prepareStatement(mysqlQuery);

                if(preparedStatement!=null) {
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Enter the id which you want to update");
                    String id=sc.nextLine();
                    
                    System.out.println("Enter the updated result");
                    String result=sc.nextLine();

                    preparedStatement.setString(1, result);
                    preparedStatement.setString(2,id);
                    
                    int roweffected=preparedStatement.executeUpdate();
                    if(roweffected==1) {
                        System.out.println("Data is updated");
                    }
                    else {
                        System.out.println("Data is not updated");
                    }
                }

            }
        }catch(IOException | SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                Basic.closeResource(connection, preparedStatement);

            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
