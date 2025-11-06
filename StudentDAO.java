package com.hibernate.dao;

import com.hibernate.model.Student;
import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class StudentDAO {

    // CREATE
    public void saveStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.persist(student);
            tx.commit();
            System.out.println("✅ Student added successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // READ (All)
    public List<Student> getAllStudents() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    // READ (by ID)
    public Student getStudentById(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Student.class, id);
        }
    }

    // UPDATE
    public void updateStudent(Student student) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            session.merge(student);
            tx.commit();
            System.out.println("📝 Student updated successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();
            Student s = session.get(Student.class, id);
            if (s != null) {
                session.remove(s);
                System.out.println("🗑️ Student deleted successfully!");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
