package org.cstefana.schools.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="tables")
public class School extends BaseEntity{
    private String name;
    private String address;
    private String category;
}
