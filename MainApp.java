package com.hibernate.main;

import com.hibernate.dao.StudentDAO;
import com.hibernate.model.Student;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // 1️⃣ CREATE
        Student s1 = new Student("Aastha Singh", "aastha@example.com", 21);
        dao.saveStudent(s1);

        // 2️⃣ READ
        System.out.println("\n📋 All Students:");
        List<Student> list = dao.getAllStudents();
        for (Student s : list) {
            System.out.println(s);
        }

        // 3️⃣ UPDATE
        Student s2 = dao.getStudentById(1);
        if (s2 != null) {
            s2.setAge(22);
            dao.updateStudent(s2);
        }

        // 4️⃣ DELETE
        dao.deleteStudent(1);
    }
}
