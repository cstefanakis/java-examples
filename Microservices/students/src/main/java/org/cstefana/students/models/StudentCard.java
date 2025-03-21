package org.cstefana.students.models;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class StudentCard extends BaseEntity{
    private String schoolName;
}
