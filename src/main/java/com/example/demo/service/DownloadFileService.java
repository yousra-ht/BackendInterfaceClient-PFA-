package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.DownloadFile;
import com.example.demo.repository.DownloadRepository;

@Service
public class DownloadFileService {
	
	   @Autowired
	  private DownloadRepository downloadRepository;
	 
	  public DownloadFile store(MultipartFile file) throws IOException {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename()); 
		    DownloadFile  FileDB = new DownloadFile (fileName, file.getContentType(), file.getBytes());

		    return downloadRepository.save(FileDB);
		  }
	  
	  public DownloadFile getFile(String id) {
		    return  downloadRepository.findById(id).get();
		  }
	 
	  public Stream<DownloadFile> getAllFiles() {
		    return downloadRepository.findAll().stream();
		  }
}
