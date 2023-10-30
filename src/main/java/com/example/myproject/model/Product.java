package com.example.myproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "tables")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @Column(name = "user_name", nullable = false)
    @Size(max = 100)
    private String name;
    @Column(name = "Description", nullable = false)
    @Size(max = 100, min = 30)

    private String description;
    @Size(max = 3, min = 1)
    private BigDecimal price;
}
