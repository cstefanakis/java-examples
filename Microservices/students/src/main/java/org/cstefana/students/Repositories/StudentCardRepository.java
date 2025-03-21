package org.cstefana.students.Repositories;

import org.cstefana.students.models.StudentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentCardRepository extends JpaRepository<StudentCard, Long> {

    @Query("select sc from StudentCard sc where sc.id = :studentId")
    Optional<StudentCard> findByStudentId(@Param("studentId") Long studentId);

    @Query("select sc from StudentCard sc where sc.student.email = :email")
    Optional<StudentCard> findByStudentEmail(@Param("email") String email);
}
