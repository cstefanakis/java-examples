package org.example.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity //Marks this class as a JPA entity, meaning Hibernate will manage it as a database table
@Table(name = "students") //Specifies that this entity maps to a database table named "students". If this annotation is omitted, Hibernate would default to using "student" (lowercase of the class name)
public class Student {

    @Id //Marks the id field as the primary key of the students table
    @GeneratedValue(strategy = GenerationType.AUTO) //Specifies that the database will automatically generate values for the id column (e.g., using an auto-increment mechanism).
    private Long id; //

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentCard studentCard;

    @ManyToMany
    @JoinTable(name = "student_subjects", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Student> students;

    @OneToMany(mappedBy = "student")
    private List<LibraryBook> libraryBooks;
}
