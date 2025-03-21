package org.cstefana.students.dataloader;

import org.cstefana.students.Repositories.StudentRepository;
import org.cstefana.students.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
               Student.builder().firstName("Maria").lastName("Novakova").birthdate(LocalDate.of(2010, 10, 20)).email("maria.novakona@gmail.com").build(),
               Student.builder().firstName("Xenie").lastName("Nonameova").birthdate(LocalDate.of(2009, 5, 12)).email("xenie.nonamova@gmail").build(),
               Student.builder().firstName("Bara").lastName("Konanova").birthdate(LocalDate.of(2008, 7, 2)).email("bara.konanova@gmail.com").build(),
               Student.builder().firstName("Giorgos").lastName("Ellinopulos").birthdate(LocalDate.of(2007, 4, 7)).email("giorgos@ellinopulos.com").build()
            ));
        }

    }
}
