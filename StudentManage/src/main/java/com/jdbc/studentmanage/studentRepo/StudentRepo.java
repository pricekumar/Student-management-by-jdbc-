package com.jdbc.studentmanage.studentRepo;

import com.jdbc.studentmanage.model.Student;

import java.sql.*;

public class StudentRepo {

    String db_url="url";
    String user_name="username";
    String password="passward";

    public void createStudent(Student student) {
        String sql= """
                      INSERT INTO student (name,email,age,course,marks)
                      VALUES (?,?,?,?,?)
                        """;
        try(Connection conn= DriverManager.getConnection(db_url,user_name,password);
              PreparedStatement prep=conn.prepareStatement(sql);)
        {
            prep.setString(1,student.getName());
            prep.setString(2,student.getEmail());
            prep.setInt(3,student.getAge());
            prep.setString(4,student.getCourse());
            prep.setInt(5,student.getMarks());

           int re= prep.executeUpdate();

           if(re==1)
           {
               System.out.println("Student created successfully");
           }
           else
           {
               System.out.println("Error in creating student");
           }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void getAllStudent() {
        String sql= """
                    SELECT id,name,email,age,course,marks 
                    FROM student
                    """;

        try(Connection conn=DriverManager.getConnection(db_url,user_name,password);
             PreparedStatement prep=conn.prepareStatement(sql))
        {
//            Isse try-with-resources kehte hain.
//Iska main kaam hai: kaam khatam hone par ResultSet ko automatically
// close karna, chahe code normally complete ho ya exception aa jaye use in three place= prep,conn,get
            try(ResultSet res=prep.executeQuery())
            {
                while(res.next())
                {
                    Student student=maptoStudent(res);
                    System.out.println(student);
                }
            }
//             use loop for all row print from result set

        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void getById(Long id)
    {
        String sql= """
                   SELECT id,name,email,age,course,marks 
                   from student 
                   where id=?
                   """;

        try(Connection conn=DriverManager.getConnection(db_url,user_name,password);
             PreparedStatement prep=conn.prepareStatement(sql))
        {
          prep.setLong(1,id);

           try( ResultSet res=prep.executeQuery();) // free resourde when work end
           {
               if(res.next())// inittal phase m ye heading ko idicate krta h like this so move row one
               {
                   Student student=maptoStudent(res);
                   System.out.println(student);
               }
              else
                  {
                   System.out.println("Student not found");
                  }
           }


        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteStudent(Long id)
    {
        String sql= """
                    DELETE FROM student
                    WHERE id=?
                         """;

        try(Connection conn=DriverManager.getConnection(db_url,user_name,password);
            PreparedStatement prep=conn.prepareStatement(sql))
        {
            prep.setLong(1,id);
           int res= prep.executeUpdate();
           if(res==1)
           {
               System.out.println("Student deleted successfully");
           }
           else
           {
               System.out.println("Error in deleting student");
           }
        }
        catch (SQLException e)
            {
            e.printStackTrace();
            }
    }

    public void updateStudent(Student student,Long id)
    {
        String sql= """
                    UPDATE student
                    Set name=?,
                         age=?,
                         course=?,
                         marks=?
                    WHERE id=?
                     """;
        try(Connection conn=DriverManager.getConnection(db_url,user_name,password);
            PreparedStatement prep=conn.prepareStatement(sql))
        {
            prep.setString(1,student.getName());
            prep.setInt(2,student.getAge());
            prep.setString(3,student.getCourse());
            prep.setInt(4,student.getMarks());
            prep.setLong(5,id);

            int res= prep.executeUpdate();
            if(res==1)
                {
                System.out.println("Student updated successfully");

                }
            else
            {
                System.out.println("Error in updating student");
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private Student maptoStudent(ResultSet res) throws SQLException {

        Student student=new Student();
        student.setId(res.getLong("id"));
        student.setName(res.getString("name"));
        student.setEmail(res.getString("email"));
        student.setAge(res.getInt("age"));
        student.setCourse(res.getString("course"));
        student.setMarks(res.getInt("marks"));
        return student;


    }
}
