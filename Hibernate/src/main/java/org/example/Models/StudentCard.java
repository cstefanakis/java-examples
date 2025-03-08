package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "student_cards")
public class StudentCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "student") //map from StudentCard model,  Student student
    private Student student;

}
