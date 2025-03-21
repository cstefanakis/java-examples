package org.cstefana.schools.dataloader;

import org.cstefana.schools.models.School;
import org.cstefana.schools.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Arrays;


@Component
public class DatabaseDataLoader implements CommandLineRunner {

    private final SchoolRepository schoolRepository;

    @Autowired
    public DatabaseDataLoader(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (schoolRepository.count() == 0) {
            schoolRepository.saveAll(Arrays.asList(
                    School.builder().name("Little Stars Academy").category("Preschool").build(),
                    School.builder().name("Greenwood Primary School").category("Elementary ").build(),
                    School.builder().name("GRiverside High School").category("Middle").build(),
                    School.builder().name("Harvard University").category("College").build()
            ));
        }
    }
}
