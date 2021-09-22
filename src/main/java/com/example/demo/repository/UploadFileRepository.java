package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UploadFile;
@Repository
public interface UploadFileRepository extends JpaRepository <UploadFile  ,String>{

}
