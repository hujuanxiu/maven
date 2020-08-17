package com.yc.springmvc.web;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("0817")
public class UploadAction {

	@PostMapping(value = "upload",produces = "text/html;charset=utf-8")
	public String upload(@RequestParam("file")MultipartFile files) throws IllegalStateException, IOException {
		String diskpath="F:/Tomcat/webapps/photo/images/fulls/";
		String filename=files.getOriginalFilename();
		files.transferTo(new File(diskpath+filename));
		return "success:"+"photo/"+filename;
	}
}
