package lesson5;

import lesson5.entity.Student;
import lesson5.manager.EntityManager;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Log
public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = new EntityManager();

        List<Student> students = new ArrayList<>();
        Random random = new Random();

//        for (int i = 0; i < 1000; i++) {
//            Student student = new Student();
//            student.setName("Студент_" + i);
//            student.setMark(random.nextInt(11));
//            students.add(student);
//        }
//        entityManager.save(students);

        students = entityManager.findAll();
//        students.forEach(System.out::println);
        Student student = entityManager.findById(4L);
        System.out.println(student);
        student.setName("Вася");
        entityManager.save(student);

        student = entityManager.findById(4L);
        System.out.println(student);

        entityManager.delete(student);

        student = entityManager.findById(4L);
        System.out.println(student);
    }
}
