package org.cstefana.students.dataloader;

import org.cstefana.students.Repositories.StudentRepository;
import org.cstefana.students.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DatabaseDataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public DatabaseDataLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0) {
            studentRepository.saveAll(Arrays.asList(
               Student.builder().firstName("Maria").lastName("Novakova").age(15).build(),
               Student.builder().firstName("Xenie").lastName("Nonameova").age(16).build(),
               Student.builder().firstName("Bara").lastName("Konanova").age(17).build(),
               Student.builder().firstName("Giorgos").lastName("Ellinopulos").age(15).build()
            ));
        }

    }
}
