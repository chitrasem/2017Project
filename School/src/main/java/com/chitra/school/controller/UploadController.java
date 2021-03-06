package com.chitra.school.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	

	@RequestMapping(value="/test")
	public Map<Object, Object> getFile(){
		Map<Object, Object> map = new HashMap<Object, Object>();	
		map.put("TESTING", "TEST");
		return map;
		
	}
	@RequestMapping(value="/test", method = RequestMethod.POST)
	public Map<Object, Object> uploadFile(HttpServletRequest request, 
			HttpServletResponse response )throws Exception{
		
		
		Map<Object, Object> map = new HashMap<Object, Object>();		
		
		//String testPath = request.getSession().getServletContext().getRealPath(arg0)
		
		
		String fileUploadPath = request.getSession().getServletContext().getRealPath("\\");

		System.out.println("=======================================================Path 1");
		System.out.println(fileUploadPath);
		System.out.println("=======================================================Path 1");
		
		
		
//		fileUploadPath = fileUploadPath.substring(0,fileUploadPath.lastIndexOf("\\.metadata"));
		//fileUploadPath = fileUploadPath+"\\web\\static\\images";

		fileUploadPath = fileUploadPath+"\\static\\images";
			
	//fileUploadPath += "\\2017Project\\School\\src\\main\\webapp\\static\\temp";
		

	System.out.println("=======================================================Path 2");
		System.out.println(fileUploadPath);
	System.out.println("=======================================================Path 2");
		
		File file;
    	
    	String newFilename;
	  	String oldFilename;
    	String contentType = request.getContentType();
    	if ((contentType.indexOf("multipart/form-data") >= 0)) {
    		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
    		//PrintWriter writer = response.getWriter();
    		response.setContentType("application/octet-stream");
    		
    		try {
    			List<FileItem> items = uploadHandler.parseRequest(request);
    			/* System.out.println("============================MyFileName===========================");
    			System.out.println(items.get(0).getFieldName());
    			System.out.println(items);
    			System.out.println("============================MyFielName==========================="); */
    			for (FileItem item : items) {
    				
    				if (!item.isFormField()) {
    					
    					//File file = new File(fileUploadPath, item.getName());
    					String fileName=item.getName();
    					
    					
    					if( fileName.lastIndexOf("\\") >= 0 ){
    						file = new File(fileUploadPath, fileName.substring( fileName.lastIndexOf("\\")));
    						 // Create directory if it not exists.
    						if(!file.exists()){
    							file.mkdirs();
    						}
  						}else{
  							file = new File(fileUploadPath, fileName.substring( fileName.lastIndexOf("\\")+1));
  							if(!file.exists()){
    							file.mkdirs();
    						}
  						}
    					// rename if file exists
  						int i = 0;
  						while (file.exists()) { 

							String path = file.getAbsolutePath();
						    int iDot = path.lastIndexOf(".");
						    if(path.contains("_(")){
						    	System.out.println("Yes");
						    	file = new File(path.substring(0, path.lastIndexOf("_(")+2) + ++i + path.substring(path.lastIndexOf(")")));
						    }else{
						    	file = new File(path.substring(0, iDot) + "_(" + ++i + ")" + path.substring(iDot));
						    }
  						}		
  						oldFilename=file.getCanonicalPath();
					   	newFilename=oldFilename.substring(15);
    					item.write(file);
    					
    					fileUploadPath = fileUploadPath.substring(fileUploadPath.indexOf("\\static"));
    					System.out.println("File Part");
    					System.out.println(fileUploadPath);
    					System.out.println("File Part");
    					
    					newFilename = newFilename.substring(newFilename.lastIndexOf("\\"));

    					System.out.println("FILE NAME");
    					System.out.println(newFilename);
    					System.out.println("File Part");
    					
    							
    					map.put("name", newFilename);
    					map.put("size", item.getSize());
    					map.put("path", fileUploadPath );
    				}
    			}
	
    		}catch(Exception e){
    			e.printStackTrace();
    		}   		
    	}		
		return map;
	}
}
