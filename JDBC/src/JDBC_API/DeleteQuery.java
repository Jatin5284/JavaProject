package JDBC_API;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteQuery {
	public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            connection=Basic.getJdbcConnection();

            if(connection!=null) {
                String mysqlQuery="delete from student  where id=?";

                preparedStatement=connection.prepareStatement(mysqlQuery);

                if(preparedStatement!=null) {
                    Scanner sc=new Scanner(System.in);
                    System.out.println("Enter the id which you want to delete");
                    String id=sc.nextLine();
     
                    preparedStatement.setString(1,id);
                    
                    int roweffected=preparedStatement.executeUpdate();
                    if(roweffected==1) {
                        System.out.println("Row is deleted");
                    }
                    else {
                        System.out.println("Row is not deleted");
                    }
                }

            }
        }catch(IOException | SQLException e) {
//            e.printStackTrace();
            System.out.print(e);
        }finally {
            try {
                Basic.closeResource(connection, preparedStatement);

            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
