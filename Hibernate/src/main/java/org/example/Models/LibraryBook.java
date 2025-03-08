package org.example.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "library_books")
public class LibraryBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
}
