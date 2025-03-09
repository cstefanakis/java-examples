package org.example.springboot.repositories;


import org.example.springboot.models.LibraryBook;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long>{
}
