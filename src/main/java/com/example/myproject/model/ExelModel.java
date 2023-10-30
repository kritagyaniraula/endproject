package com.example.myproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table

public class ExelModel {
    @Id

    private Integer ID;
    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    private String Name;
    @Column(name = "Roll", nullable = false)
    @Size(max = 3, min=1)
    private String Roll;
    @Column(name = "address", nullable = false)
    @Size(max = 100)
    private String Address;

}
