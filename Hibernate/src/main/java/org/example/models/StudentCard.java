package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student_cards")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "studentCard") //map from StudentCard model,  Student student
    private Student student;
}
