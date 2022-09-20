import dao.StudentDAO;
import manageStudent.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Student Management System..");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to exit app");
            int n = Integer.parseInt(br.readLine());

            if (n==1){
                //add student
                System.out.printf("Enter your name : ");
                String name = br.readLine();
                System.out.printf("Enter your phone no : ");
                String phone = br.readLine();
                System.out.printf("Enter your city : ");
                String city = br.readLine();

                Student student = new Student(name,phone,city);
             boolean reslt =    StudentDAO.insertStudent(student);
             if (reslt){
                 System.out.println("Student add successfully done ..");
             }else {
                 System.out.println("failed insert");
             }



            }else if (n == 2){
                //delete student
                System.out.printf("Enter student id : ");
                int id = Integer.parseInt(br.readLine());
                boolean rslt = StudentDAO.deleteStudent(id);
                if (rslt){
                    System.out.println("Student delete successfully done ..");
                }else {
                    System.out.println("failed delete");
                }
            }else if (n == 3){
                //display Student
                StudentDAO.desplayStudent();
                System.out.println("---------------------------------");

            } else if (n == 4) {
                //exit app
                break;
            }

        }
    }
}
