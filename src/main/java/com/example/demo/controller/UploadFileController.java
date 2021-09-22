package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.message.ResponseMessage;
import com.example.demo.model.UploadFile;
import com.example.demo.service.UploadFileService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class UploadFileController {
	
	@Autowired
  private UploadFileService Uploadfileservice ; 
  
	
	 @GetMapping("/files/{id}")
	  @PreAuthorize("hasRole('ETUDIANT')")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		  UploadFile fileDB = Uploadfileservice.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
	        .body(fileDB.getData());
	  }

  @PostMapping("/upload")
  @PreAuthorize("hasRole('ETUDIANT')")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
    String message = "";
    try {
    	Uploadfileservice.store(file);

      message = "Le fichier :" + file.getOriginalFilename()+ " a été téléchargé avec succès:";
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Impossible de télécharger le fichier! " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
    }
  }


  
 
  
}
