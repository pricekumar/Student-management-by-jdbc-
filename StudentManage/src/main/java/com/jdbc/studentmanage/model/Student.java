package com.jdbc.studentmanage.model;

public class Student {
    private Long id;
    private String name;
    private String email;
    private int age;
    private String course;
    private int marks;

    public Student()
    {

    }

    public Student(String name, String email, int age, String course, int marks) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }
//this for update email not change allowed
    public Student(String name,int age, String course, int marks) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
 //when getall then five formate like array otherwise give object type code
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}
