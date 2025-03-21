package org.cstefana.schools.models;

import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class School extends BaseEntity{
    private String name;
    private String address;
    private String category;
}
