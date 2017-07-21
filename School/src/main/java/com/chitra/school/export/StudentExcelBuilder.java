package com.chitra.school.export;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.chitra.school.entities.Student;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * @author www.codejava.net
 *
 */
public class StudentExcelBuilder extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<Student> listStudents = (List<Student>) model.get("students");
		
		// create a new Excel sheet
		HSSFSheet sheet = workbook.createSheet("Students");
		sheet.setDefaultColumnWidth(30);
		
		// create style for header cells
		CellStyle style = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setFontName("Arial");
		style.setFillForegroundColor(HSSFColor.BLUE.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setColor(HSSFColor.WHITE.index);
		style.setFont(font);
		
		// create header row
		HSSFRow header = sheet.createRow(0);
		
		header.createCell(0).setCellValue("First Name");
		header.getCell(0).setCellStyle(style);
		
		header.createCell(1).setCellValue("Last Name");
		header.getCell(1).setCellStyle(style);
		
		header.createCell(2).setCellValue("Gender");
		header.getCell(2).setCellStyle(style);
		// create data rows
		int rowCount = 1;
		
		for (Student aStudent : listStudents) {
			HSSFRow aRow = sheet.createRow(rowCount++);
			/*aRow.createCell(0).setCellValue(aStudent.getFirstName() );
			aRow.createCell(1).setCellValue(aStudent.getLastName() );
			aRow.createCell(2).setCellValue(aStudent.getGender() );*/
		}
	}

}