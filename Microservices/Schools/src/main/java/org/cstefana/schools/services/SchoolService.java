package org.cstefana.schools.services;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.cstefana.schools.models.School;
import org.cstefana.schools.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(long id) {
        return schoolRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("School not found"));
    }

    public School getSchoolByName(String name) {
        return schoolRepository.findByName(name).orElseThrow(()-> new EntityNotFoundException("School not found"));
    }


    public School createSchool(School school) {
        School schoolFromDB = schoolRepository.findByName(school.getName()).orElse(null);
        if (schoolFromDB == null) {
            return schoolRepository.save(school);
        }throw new EntityExistsException(String.format("School with name %s already exists", school.getName()));
    }

    public void updateSchool(long id, School school) {
        School schoolFromDB = getSchoolById(id);
        if (schoolFromDB != null) {
            schoolFromDB.setName(school.getName());
            schoolFromDB.setAddress(school.getAddress());
            schoolFromDB.setCategory(school.getCategory());
            schoolRepository.save(schoolFromDB);
        }
    }

    public void deleteSchool(long id) {
        School schoolFromDB = getSchoolById(id);
        if (schoolFromDB != null) {
            schoolRepository.delete(schoolFromDB);
        }
    }
}
