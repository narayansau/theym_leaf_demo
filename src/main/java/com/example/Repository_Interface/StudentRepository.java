package com.example.Repository_Interface;

import com.example.Model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer> {

}
