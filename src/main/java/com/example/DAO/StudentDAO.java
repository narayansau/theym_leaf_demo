package com.example.DAO;

import com.example.Model.StudentEntity;
import com.example.Repository_Interface.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAO {

    @Autowired
    StudentRepository studentRepository;

    // Save an Student

    public StudentEntity save(StudentEntity std) {
        return studentRepository.save(std);
    }

    /* search all Student */

    public List<StudentEntity> findAll(){
        return studentRepository.findAll();
    }
    /*get an Student  by id*/
    public StudentEntity findOne(Integer id) {
        return null;
        //return  studentRepository.findById(id);
    }



    /*delete an Student*/

    public void delete(StudentEntity std) {
        studentRepository.delete(std);
    }


}
