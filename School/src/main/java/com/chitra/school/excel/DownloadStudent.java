package com.chitra.school.excel;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.chitra.school.model.Student;
import com.chitra.school.utils.StringUtils;

public class DownloadStudent extends  AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	
		
				
				HSSFSheet sheet = workbook.createSheet("Sheet1");
				
				// Set Column width
				sheet.setDefaultColumnWidth(16);
				sheet.setColumnWidth(0, 1000);
				sheet.setColumnWidth(1, 4000);
				
				//Setup the Page margins - Left, Right, Top and Bottom
				   sheet.setMargin(Sheet.LeftMargin, 0.25);
				   sheet.setMargin(Sheet.RightMargin, 0.25);
				   sheet.setMargin(Sheet.TopMargin, 0.75);
				   sheet.setMargin(Sheet.BottomMargin, 0.75);
				 
				   //Setup the Header and Footer Margins
				   sheet.setMargin(Sheet.HeaderMargin, 0.25);
				   sheet.setMargin(Sheet.FooterMargin, 0.25);
				
				List<String> headLabel = new ArrayList<String>();
				
				headLabel.add("No.");
				headLabel.add("Student ID");
				headLabel.add("Khmer Name");
				headLabel.add("English Name");
				headLabel.add("Gender");
				headLabel.add("Age");
				headLabel.add("Phone");
				
				// create style for header cells
				CellStyle style = workbook.createCellStyle();
				Font font = workbook.createFont();
				font.setFontName("Arial");				
				font.setColor(HSSFColor.BLUE_GREY.index);
				font.setBold(true);				
				style.setFont(font);
				
				style.setFillForegroundColor(HSSFColor.BLUE.index);
				
				style.setBorderBottom(CellStyle.BORDER_THIN);
				
				  style.setBorderBottom(CellStyle.BORDER_THIN);
				    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				    style.setBorderLeft(CellStyle.BORDER_THIN);
				    style.setLeftBorderColor(IndexedColors.GREEN.getIndex());
				    style.setBorderRight(CellStyle.BORDER_THIN);
				    style.setRightBorderColor(IndexedColors.BLUE.getIndex());
				    style.setBorderTop(CellStyle.BORDER_MEDIUM_DASHED);
				    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
				
				
				Cell cell = null;
				
				Row row1 = sheet.createRow(0);
				for(int i = 0; i < headLabel.size(); i++){
					cell = row1.createCell(i);
					cell.setCellValue(headLabel.get(i));
					cell.setCellStyle(style);
				}
				
				
				
				
				// create data rows
				int rowCount = 1;
				
				@SuppressWarnings("unchecked")
				List<Student> students = (List<Student>) model.get("students");
				for (Student student : students) {
					HSSFRow aRow = sheet.createRow(rowCount++);
					aRow.createCell(0).setCellValue( rowCount-1 );
					aRow.createCell(1).setCellValue(student.getId() );
					aRow.createCell(2).setCellValue( student.getKmLastName()+ " " + student.getKmFirstName() );
					aRow.createCell(3).setCellValue(student.getFirstName() + " " + student.getLastName() );
					if(student.getGender().equals("M")){
						aRow.createCell(4).setCellValue( "Male" );
					}else{
						aRow.createCell(4).setCellValue( "Female" );
					}
					
					aRow.createCell(5).setCellValue(student.getBirthDate() );
					aRow.createCell(6).setCellValue(student.getPhone1() );
				}
			
				String fileName = "ចិត្រា_" + StringUtils.getSystemDate() + ".xls";
				response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
		
		
		
	}
	

}
