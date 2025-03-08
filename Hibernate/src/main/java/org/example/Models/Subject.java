package org.example.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "entities")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "students")
    private List <Student> Students;
}
