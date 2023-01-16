package com.netkanet.springboothtml.repository;

import com.netkanet.springboothtml.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentRepository {

    public static StudentRepository dbStudent = new StudentRepository();
    private Map<String, Student> dictionary = new HashMap<String, Student>();

    public StudentRepository() {

        Student student1 = new Student();
        student1.setId("000001");
        student1.setName("John");
        student1.setSurname("Wick");
        student1.setAddress1("999 Build 1 Silom Road,");
        student1.setDistrict("Silom,");
        student1.setProvince("Bangkok,");
        student1.setPostalCode("99999");
        dictionary.put("000001", student1);
    }

    public boolean checkExistIdStudent (String id) {
        if (dictionary.containsKey(id)) {
            return true;
        } else {
            return false;
        }
    }

    public Student save (Student student) {
        dictionary.put(student.getId(), student);
        return student;
    }

    public List<Student> findAll () {
        List<Student> list = new ArrayList<>(dictionary.values());
        return list;
    }

    public void deleteById(String id) {
        dictionary.remove(id);
    }

    public Student updateStudentUser(Student student) {
        if (dictionary.containsKey(student.getId())) {
            dictionary.put(student.getId(), student);
            return student;
        } else {
            return null;
        }
    }
}
