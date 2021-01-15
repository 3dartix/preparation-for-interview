package lesson5.manager;

import lesson5.config.HibernateConfig;
import lesson5.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class EntityManager {

    private Session session;

    public EntityManager() {
        session = HibernateConfig.getSessionFactory().openSession();
    }

    public List<Student> findAll() {
        session.beginTransaction();
        List<Student> result = session.createQuery("from Student", Student.class).list();
        session.getTransaction().commit();
        return result;
    }

    public Student findById (Long id) {
        return session.get(Student.class, id);
    }

    public void save(Student student) {
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }

    public void save(List<Student> student) {
        session.beginTransaction();
        student.forEach(s -> session.save(s));
        session.getTransaction().commit();
    }

    public void delete(Student student) {
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }
}
