package org.cstefana.students.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    @JsonManagedReference
    private StudentCard studentCard;
}
