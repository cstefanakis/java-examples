package org.cstefana.students.controllers;

import org.cstefana.students.Repositories.StudentCardRepository;
import org.cstefana.students.Service.StudentCardService;
import org.cstefana.students.models.StudentCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-card")
public class StudentCardController {

    private final StudentCardService studentCardService;

    @Autowired
    public StudentCardController(StudentCardService studentCardService) {
        this.studentCardService = studentCardService;
    }

    @GetMapping()
    public ResponseEntity<List<StudentCard>> getStudentCards() {
        return ResponseEntity.ok(studentCardService.getStudentCards());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentCard> getStudentCardById(@PathVariable Long id) {
        return ResponseEntity.ok(studentCardService.getStudentCardById(id));
    }
}
