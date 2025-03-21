package org.cstefana.students.Service;

import jakarta.persistence.EntityNotFoundException;
import org.cstefana.students.Repositories.StudentCardRepository;
import org.cstefana.students.Repositories.StudentRepository;
import org.cstefana.students.models.Student;
import org.cstefana.students.models.StudentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StudentCardService {

    private final StudentCardRepository studentCardRepository;
    private final StudentService studentService;
    private final StudentRepository studentRepository;

    @Autowired
    public StudentCardService(StudentCardRepository studentCardRepository, StudentService studentService, StudentRepository studentRepository) {
        this.studentCardRepository = studentCardRepository;
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    public List<StudentCard> getStudentCards() {
        return studentCardRepository.findAll();
    }

    public StudentCard getStudentCardById(Long studentCardId) {
        return studentCardRepository.findById(studentCardId)
                .orElseThrow(() -> new EntityNotFoundException("Student card not found"));
    }

    public StudentCard getStudentCardByStudentId(Long studentId) {
        return studentCardRepository.findByStudentId(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student card not found"));
    }

    public StudentCard getStudentCardByStudentEmail(String studentEmail) {
        return studentCardRepository.findByStudentEmail(studentEmail)
                .orElseThrow(() -> new EntityNotFoundException("Student card not found"));
    }

    public void deleteStudentCardByStudentId(Long studentId) {
        StudentCard studentCard = getStudentCardByStudentId(studentId);
        studentCardRepository.delete(studentCard);
    }

    public void deleteStudentCardByStudentEmail(String studentEmail) {
        StudentCard studentCard = getStudentCardByStudentEmail(studentEmail);
        studentCardRepository.delete(studentCard);
    }

    public void deleteStudentCardById(Long studentCardId) {
        StudentCard studentCard = getStudentCardById(studentCardId);
        studentCardRepository.delete(studentCard);
    }

    public void createUpdateStudentCardByStudentId(Long studentId, StudentCard studentCard) {
        Student student = studentService.getStudentById(studentId);
        createUpdateStudentCard(student, studentCard);
        student.setStudentCard(studentCard);
        studentRepository.save(student);
    }

    public void createUpdateStudentCardByStudentEmail(String studentEmail, StudentCard studentCard) {
        Student student = studentService.getStudentByEmail(studentEmail);
        createUpdateStudentCard(student, studentCard);
        student.setStudentCard(studentCard);
        studentRepository.save(student);
    }

    private void createUpdateStudentCard(Student student, StudentCard studentCard) {
        StudentCard studentCardFromDb = studentCardRepository.findByStudentId(student.getId()).orElse(null);
        if(studentCardFromDb == null) {
            studentCardFromDb = new StudentCard();
            studentCardFromDb.setSchoolName(studentCard.getSchoolName());
            studentCardFromDb.setStudent(studentCard.getStudent());
            studentCardRepository.save(studentCardFromDb);
        }else{
            if(studentCard.getSchoolName() != null || !studentCard.getSchoolName().isBlank()) {
                studentCardFromDb.setSchoolName(studentCard.getSchoolName());
            }
            studentCardRepository.save(studentCardFromDb);
        }
    }
}
