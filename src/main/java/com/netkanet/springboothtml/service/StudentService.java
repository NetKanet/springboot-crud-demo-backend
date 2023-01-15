package com.netkanet.springboothtml.service;

import com.netkanet.springboothtml.exception.NotFoundException;
import com.netkanet.springboothtml.model.Student;
import com.netkanet.springboothtml.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void register(Student studentUser) {
        Student studentDbId = StudentRepository.dbStudent.getStudentRepository(studentUser.getId());
        if (studentUser.getId().isEmpty() || studentDbId.getId().equals(studentUser.getId())) {
            throw new NotFoundException("ID must be null or ID used");
        } else if (studentUser.getName().isEmpty()) {
            throw new NotFoundException("Name must be null");
        } else if (studentUser.getSurname().isEmpty()) {
            throw new NotFoundException("Sername must be null");
        } else if (studentUser.getAddress1().isEmpty()) {
            throw new NotFoundException("Address1 must be null");
        } else if (studentUser.getDistrict().isEmpty()) {
            throw new NotFoundException("District must be null");
        } else if (studentUser.getProvince().isEmpty()) {
            throw new NotFoundException("Province must be null");
        } else if (studentUser.getPostalcode().isEmpty() || studentUser.getPostalcode().length()!=5) {
            throw new NotFoundException("Postalcode must be null or must more or less length");
        }
        studentRepository.save(studentUser);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public boolean deleteStudent(String id) {
        try {
            if (!id.isEmpty()) {
                studentRepository.deleteById(id);
                return true;
            }
        } catch (Exception ex) {
            throw new NotFoundException("Don't have id: " + id + " to delete");
        }
        return false;
    }

    public Student updateStudentUser(Student student) {
        Student studentDbId = StudentRepository.dbStudent.getStudentRepository(student.getId());
        if (studentDbId.getId().equals(student.getId())) {
            Student findStudentUser = studentRepository.updateStudentUser(student);
            return findStudentUser != null ? findStudentUser : null;
        } else {
            throw new NotFoundException("Don't change ID");
        }
    }
}
