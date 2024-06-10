package com.rca.cics;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Student not found"));
    }

    public Student updateStudent(Student student) {
        var foundStudent = getStudentByEmail(student.getEmail());
        foundStudent.setFirstName(student.getFirstName());
        foundStudent.setLastName(student.getLastName());
        foundStudent.setDateOfBirth(student.getDateOfBirth());
        return studentRepository.save(foundStudent);
    }

    public void deleteStudent(String email) {
        var foundStudent = getStudentByEmail(email);
        studentRepository.deleteById(foundStudent.getId());
    }

}
