package org.example.springboot.services;

import org.example.springboot.models.Student;

public interface StudentService {

    void createStudent(Student student);

    void deleteStudent(Student student);

    void updateStudent(Student student);


}
