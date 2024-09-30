package com.nsmaniotto.bowt.persistence.entity.user;

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
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, max = 20)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, max = 20)
    private String lastName;

    @Column(nullable = false)
    @Size(min = 2, max = 10)
    private String login;

    @Column(nullable = false)
    @Size(max = 100)
    private String password;
}
