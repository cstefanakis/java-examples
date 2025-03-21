package org.cstefana.students.Service;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.cstefana.students.Repositories.StudentRepository;
import org.cstefana.students.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) {
        return studentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Student not found"));
    }

    public Student getStudentByEmail(String studentEmail) {
        return studentRepository.findByEmail(studentEmail)
                .orElseThrow(()->new EntityNotFoundException("Student not found"));
    }

    public Student createStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new EntityExistsException(String.format("Student with %s already exists", student.getEmail()));
        }else{
            return studentRepository.save(student);
        }
    }

    public Student updateStudent(long id, Student student) {
        Student studentFromDb = getStudentById(id);
        studentFromDb.setFirstName(student.getFirstName());
        studentFromDb.setLastName(student.getLastName());
        studentFromDb.setEmail(student.getEmail());
        studentFromDb.setBirthdate(student.getBirthdate());
        return studentRepository.save(studentFromDb);
    }

    public Student deleteStudent(long id) {
        Student studentFromDb = getStudentById(id);
        studentRepository.delete(studentFromDb);
        return studentFromDb;
    }
}
