package org.cstefana.students.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StudentCard extends BaseEntity{
    private String schoolName;
    @OneToOne(mappedBy = "studentCard")
    @JsonBackReference
    private Student student;
}
