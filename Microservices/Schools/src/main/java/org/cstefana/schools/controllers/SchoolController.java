package org.cstefana.schools.controllers;

import org.cstefana.schools.models.School;
import org.cstefana.schools.services.SchoolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping()
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.getSchools());
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.getSchoolById(id));
    }

    @GetMapping("/school-name")
    public ResponseEntity<School> getSchoolByName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(schoolService.getSchoolByName(name));
    }

    @PostMapping()
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schoolService.createSchool(school));
    }

    @PutMapping("{id}")
    public ResponseEntity<School> updateSchool(@PathVariable long id, @RequestBody School school) {
        schoolService.updateSchool(id, school);
        return ResponseEntity.status(HttpStatus.OK).body(school);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<School> deleteSchool(@PathVariable long id) {
        schoolService.deleteSchool(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
