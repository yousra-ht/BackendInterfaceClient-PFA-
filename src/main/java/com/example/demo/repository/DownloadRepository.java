package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DownloadFile;
@Repository
public interface DownloadRepository extends JpaRepository <DownloadFile, String>{

}
