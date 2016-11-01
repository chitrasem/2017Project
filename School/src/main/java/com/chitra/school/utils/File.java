package com.chitra.school.utils;

import org.springframework.web.multipart.MultipartFile;

public class File {
	
	private MultipartFile file;
	
	public void setMultipartFile(MultipartFile file){
		this.file = file;
	}
	public MultipartFile getMultipartFile(){
		return file;
	}

}
