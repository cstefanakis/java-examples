package org.example.springboot.repositories;

import org.example.springboot.models.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {
}
