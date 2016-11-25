<%@page import="jex.cooconbill.domain.act.mbill_comm_popup_00012_r002.Dbill_comm_popup_00012_r002_REC_UTIL"%>
<%@page import="jex.cooconbill.domain.act.mbill_comm_popup_00012_r002.Dbill_comm_popup_00012_r002Out"%>
<%@page import="jex.cooconbill.domain.act.mbill_comm_popup_00012_r002.Dbill_comm_popup_00012_r002In"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="kosign.utils.formatUtils"%>
<%@page import="org.apache.poi.ss.usermodel.Row"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFColor"%>
<%@page import="org.apache.poi.ss.usermodel.CellStyle"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFCellStyle"%>
<%@page import="org.apache.poi.hssf.util.HSSFColor"%>
<%@page import="kosign.utils.ExcelUtils"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFFont"%>
<%@page import="org.apache.poi.ss.usermodel.Cell"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFRow"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFSheet"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@page import="jex.resource.cci.ido.JexIDOManager"%>
<%@page import="jex.resource.cci.JexConnection"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="jex.util.DateTime"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html;charset=utf-8" %>
<%@page import="jex.web.JexPTCommonUtil"%>





<%
	// 공통 Util생성
	JexPTCommonUtil util = JexPTCommonUtil.getInstace(request, response);
						
	// Action 결과 추출
	
	
	Dbill_comm_popup_00012_r002In input = (Dbill_comm_popup_00012_r002In)util.getInputDomain();
	Dbill_comm_popup_00012_r002Out result = (Dbill_comm_popup_00012_r002Out)util.getResultData();
	
	try{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		XSSFRow column = sheet.createRow((short) 0);
		Cell cell = null;
		
		sheet.setDefaultColumnWidth(16);
		sheet.setColumnWidth(0, 8000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 5000);
		
		XSSFFont font_head = ExcelUtils.createAndSetFontStyle(workbook,true,10,HSSFColor.BLACK.index);
		XSSFCellStyle style_head = ExcelUtils.cellStyle(workbook);
		style_head.setFont(font_head);
		style_head.setAlignment(CellStyle.ALIGN_CENTER);
	
		//@@ Add column labels
		List<String> columnLabel = new ArrayList<String>();
	
		columnLabel.add("이용기관");
		columnLabel.add("사업자번호");
		columnLabel.add("구분");
		
		XSSFColor cellColor = ExcelUtils.setCellBackgroundColor(255, 255, 153);
		style_head.setFillForegroundColor(cellColor);
		style_head.setFillPattern(CellStyle.SOLID_FOREGROUND);
		
		int colIndex = 0;
		Row row1 = sheet.createRow(0);
		for(int i=0; i<columnLabel.size(); i++){
			cell = row1.createCell(i);
			cell.setCellValue(columnLabel.get(i));
			cell.setCellStyle(style_head);
		}
		
		
  	if(result.getRecUtil().size() > 0) {
		for(int i = 0; i < result.getRecUtil().size(); i++) {			
			Dbill_comm_popup_00012_r002_REC_UTIL utilRec = (Dbill_comm_popup_00012_r002_REC_UTIL)result.getRecUtil().get(i);			
			XSSFRow row = sheet.createRow((short) (i+1));			
			
			row.createCell(0).setCellValue(  utilRec.getUtilOrgNm()  );	
			row.createCell(1).setCellValue(formatUtils.formatBusinessNumber(utilRec.getBusnNo() ));		
			row.createCell(2).setCellValue(utilRec.getUtilOrgTpNm() );			
			
			ExcelUtils.setRowStyle(row,0,3,ExcelUtils.cellStyle(workbook));	
			
			/* XSSFCellStyle style1 = workbook.createCellStyle();
			style1 = ExcelUtils.cellStyle(workbook);
			style1.setAlignment(style1.ALIGN_RIGHT);
			row.getCell(1).setCellStyle(style1); */
			
		}
 	}
	
	//@@Export excel file
	String fileName = "이용기관_조회_"+DateTime.getInstance().getSysDate("YYYYMMDDHH24MISS")+".xlsx";
	response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
	response.setContentType("application/vnd.ms-excel");
	workbook.write(response.getOutputStream());
	workbook.close();	
	response.getOutputStream().flush();
	response.getOutputStream().close();
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<%
/**
 * <pre>
 * (#)
 * JEXSTUDIO PROJECT
 * @COPYRIGHT (c) 2009-2010 WebCash, Inc. All Right Reserved.
 *
 * @File Name    : bill_comm_popup_00023_excel_view.jsp
 * @File path    	 : COOCONBILL_PT/web/cooconbill/common
 * @author       	 : chitrasem ( sabaychitra84@gmail.com )
 * @Description  : Download Excel
 * @History      	 : 20161123035329, chitrasem
 * </pre>
 * 
 **/
%>