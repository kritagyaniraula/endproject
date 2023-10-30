package com.example.myproject.repository;

import com.example.myproject.model.ExelModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ExelRepository extends JpaRepository<ExelModel, Serializable> {

}
