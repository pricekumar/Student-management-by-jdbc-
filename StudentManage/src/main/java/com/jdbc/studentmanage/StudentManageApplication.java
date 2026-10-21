package com.jdbc.studentmanage;


import com.jdbc.studentmanage.model.Student;
import com.jdbc.studentmanage.studentRepo.StudentRepo;

public class StudentManageApplication {

    public static void main(String[] args) {
        StudentRepo studentRepo = new StudentRepo();
//        studentRepo.createStudent(new Student("piyush","piyush1@gmail.com",21,"cse",65));
//        studentRepo.getAllStudent();
//        studentRepo.getById(3l);
//        studentRepo.deleteStudent(4l);

        studentRepo.updateStudent(new Student("prince",22,"cse",80),1l);

    }

}
