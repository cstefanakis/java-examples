package org.example.springboot.services;

import org.example.springboot.models.LibraryBook;
import org.example.springboot.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LibraryBookService {

    void createLibraryBook(LibraryBook libraryBook);

    void deleteLibraryBook(LibraryBook libraryBook);

    void updateLibraryBook(LibraryBook libraryBook);

    LibraryBook getLibraryBookById(Long id);

    LibraryBook getLibraryBookByTitle(String title);

    LibraryBook getLibraryBookByStudent(Student student);

    List<LibraryBook> getAllLibraryBooks();
}
