package org.cstefana.students.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "students")
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    @OneToOne
    @JoinColumn(name = "student_id", unique = true, nullable = false)
    private Student student;
}
