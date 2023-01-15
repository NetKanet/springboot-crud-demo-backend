package com.netkanet.springboothtml.repository;

import com.netkanet.springboothtml.model.Student;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class StudentRepository {

    public static StudentRepository dbStudent = new StudentRepository();
    private Map<String, Student> dictionary = new HashMap<String, Student>();

    public StudentRepository() {
        dictionary.put("000001", new Student("000001", "John", "Wick", "999 Build 1 Silom Road,","Silom,","Bangkok,","99999"));
        dictionary.put("000002", new Student("000002", "Andy", "Handsome", "999 Build 1 Silom Road,","Silom,","Bangkok,","99999"));
    }

    public Student getStudentRepository (String id) {
        if (dictionary.containsKey(id)) {
            return dictionary.get(id);
        } else {
            return null;
        }
    }

    public Student save (Student student) {
        dictionary.put(student.getId(), new Student(student.getId(), student.getName(), student.getSurname(), student.getAddress1(),student.getDistrict(),student.getProvince(),student.getPostalcode()));
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
            dictionary.put(student.getId(), new Student(student.getId(), student.getName(), student.getSurname(), student.getAddress1(),student.getDistrict(),student.getProvince(),student.getPostalcode()));
            return student;
        } else {
            return null;
        }
    }
}
