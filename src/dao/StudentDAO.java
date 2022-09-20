package dao;

import dbConnection.DbConnection;
import manageStudent.Student;

import java.sql.*;

public class StudentDAO {
    public static  boolean insertStudent(Student student){
        boolean f = false;
        try {
            Connection connection = DbConnection.getConnection();
            String query = "insert into student1(name,phone,city) values(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,student.getName());
            ps.setString(2,student.getPhone());
            ps.setString(3,student.getCity());

            //execute
            ps.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
    public static  boolean deleteStudent(int id){
        boolean f = false;
        try {
            Connection connection = DbConnection.getConnection();
            String query = "delete from student1 where id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);


            //execute
            ps.executeUpdate();
            f = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    public static void  desplayStudent(){
        try {
            Connection connection = DbConnection.getConnection();

            Statement statement = connection.createStatement();
            String query = "select * from student1";
            ResultSet rs = statement.executeQuery(query);
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();

            for (int i=1 ; i<=columnCount ;i++){
                System.out.print(resultSetMetaData.getColumnName(i) + "\t");
            }
            System.out.println();
            System.out.println("-------------------------");

            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phone = rs.getString(3);
                String city = rs.getString(4);
                System.out.println(id + "\t"+name+ "\t" +phone + "\t"  +city );
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
