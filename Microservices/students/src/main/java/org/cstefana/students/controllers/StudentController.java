package org.cstefana.students.controllers;

import org.cstefana.students.Service.StudentCardService;
import org.cstefana.students.Service.StudentService;
import org.cstefana.students.models.Student;
import org.cstefana.students.models.StudentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentCardService studentCardService;

    @Autowired
    public StudentController(StudentService studentService, StudentCardService studentCardService) {
        this.studentService = studentService;
        this.studentCardService = studentCardService;
    }

    @GetMapping()
    public ResponseEntity<List<Student>>  getStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam String studentEmail) {
        return ResponseEntity.ok(studentService.getStudentByEmail(studentEmail));
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        Student deleteStudent = studentService.deleteStudent(id);
        return ResponseEntity.ok(deleteStudent);
    }

    @PostMapping("/{studentId}/student-card")
    public ResponseEntity<Void> createStudentCardByStudentId(@PathVariable Long studentId, @RequestParam String schoolName) {
        StudentCard studentCard = new StudentCard();
        studentCard.setSchoolName(schoolName);
        studentCardService.createUpdateStudentCardByStudentId(studentId, studentCard);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/email/student-card")
    public ResponseEntity<Void> createStudentCardByStudentId(@RequestParam String studentEmail, @RequestParam String schoolName) {
        StudentCard studentCard = new StudentCard();
        studentCard.setSchoolName(schoolName);
        studentCardService.createUpdateStudentCardByStudentEmail(studentEmail, studentCard);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{studentId}/student-card")
    public ResponseEntity<Void> deleteStudentCardByStudentId(@PathVariable long studentId) {
        studentCardService.deleteStudentCardByStudentId(studentId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/email/student-card")
    public ResponseEntity<Void> deleteStudentCardByStudentEmail(@RequestParam String studentEmail) {
        studentCardService.deleteStudentCardByStudentEmail(studentEmail);
        return ResponseEntity.ok().build();
    }
}
