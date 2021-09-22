package com.example.demo.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.UploadFile;
import com.example.demo.repository.UploadFileRepository;



@Service
public class UploadFileService {
	
	 @Autowired
	  private UploadFileRepository Uploadfilerepository;
	 
	 
	 
	 public UploadFile  store (MultipartFile file) throws IOException 
	 	  {
		    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		  
		    UploadFile  UploadFile = new  UploadFile (fileName, file.getContentType(), file.getBytes());

		    return Uploadfilerepository.save(UploadFile);
		  }
	 
	 
	 public UploadFile getFile(String id) {
		    return Uploadfilerepository.findById(id).get();
		  }
	 
	 public Stream<UploadFile> getAllFiles() {
		    return Uploadfilerepository.findAll().stream();
		  }
}
