package com.example.myproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name", nullable = false)
    @Size(max = 100)
    private String fullName;
    @Column(name = "user_name", nullable = false)
    @Size(max = 100)
    private String userName;
    @Column(name = "emal", nullable = false)
    @Size(max = 100)
    private String email;
    @Column(nullable = false)
    @Size(max = 100, min = 8)
    private String password;

    @Size(max = 100, min = 4)
    private String roles;



}
