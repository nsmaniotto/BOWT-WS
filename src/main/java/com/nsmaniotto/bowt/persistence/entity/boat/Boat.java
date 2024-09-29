package com.nsmaniotto.bowt.persistence.entity.boat;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "boat")
public class Boat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 3, max = 15)
    private String name;

    @Column(name = "description", nullable = false)
    @Size(min = 5, max = 100)
    private String description;
}
