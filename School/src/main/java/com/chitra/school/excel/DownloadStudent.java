package com.chitra.school.excel;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.chitra.school.model.Student;

public class DownloadStudent extends  AbstractExcelView {
	
	
	
	
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				
				HSSFSheet sheet = workbook.createSheet("Sheet1");
				sheet.setDefaultColumnWidth(16);
				sheet.setColumnWidth(0, 1000);
				sheet.setColumnWidth(1, 4000);
				
				List<String> headLabel = new ArrayList<String>();
				
				headLabel.add("No.");
				headLabel.add("Student ID.");
				headLabel.add("Khmer Name");
				headLabel.add("English Name");
				headLabel.add("Gender");
				headLabel.add("Age");
				headLabel.add("Phone");
				
				Cell cell = null;
				int colIndex = 0;
				Row row1 = sheet.createRow(0);
				for(int i = 0; i < headLabel.size(); i++){
					cell = row1.createCell(i);
					cell.setCellValue(headLabel.get(i));
				}
				
				
				// create style for header cells
				CellStyle style = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setFontName("Arial");
				style.setFillForegroundColor(HSSFColor.BLUE.index);
				
				font.setColor(HSSFColor.WHITE.index);
				style.setFont(font);
				
				// create header row
				HSSFRow header = sheet.createRow(0);
				header.createCell(0).setCellValue("No.");
				header.getCell(0).setCellStyle(style);
				
				header.createCell(1).setCellValue("Student ID");
				header.getCell(1).setCellStyle(style);
				
				header.createCell(2).setCellValue("Khmer Name");
				header.getCell(2).setCellStyle(style);
				
				header.createCell(3).setCellValue("English Name");
				header.getCell(3).setCellStyle(style);			

				header.createCell(4).setCellValue("Gender");
				header.getCell(4).setCellStyle(style);
				
				header.createCell(5).setCellValue("Age");
				header.getCell(5).setCellStyle(style);

				header.createCell(6).setCellValue("Phone1");
				header.getCell(6).setCellStyle(style);
				
				
				
				// create data rows
				int rowCount = 1;
				
				List<Student> students = (List<Student>) model.get("students");
				for (Student student : students) {
					HSSFRow aRow = sheet.createRow(rowCount++);
					aRow.createCell(0).setCellValue( rowCount );
					aRow.createCell(1).setCellValue(student.getId() );
					aRow.createCell(2).setCellValue(student.getKmFirstName() +" "+ student.getKmLastName() );
					aRow.createCell(3).setCellValue(student.getFirstName() + " " + student.getLastName() );
					aRow.createCell(4).setCellValue(student.getGender() );
					aRow.createCell(5).setCellValue(student.getBirthDate() );
					aRow.createCell(6).setCellValue(student.getPhone1() );
				}
			
				String fileName = "ចិត្រា_" + ".xls";
				response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
		
		
		
	}
	

}
