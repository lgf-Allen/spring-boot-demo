/**
 * 
 */
package com.allen.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author first
 *
 */
@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello boot!";
    }

    public static void main(String[] args) throws IOException {
        // 创建工作薄
        @SuppressWarnings("resource")
        SXSSFWorkbook workbook = new SXSSFWorkbook ();
        // 生成一个表格
        SXSSFSheet sheet = workbook.createSheet("vtm");
        
        
        CellStyle cellStyle = workbook.createCellStyle();
        //设置背景色
        cellStyle.setFillForegroundColor((short) 13);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        
        cellStyle.setWrapText(true);//设置自动换行   
        
        Font font = workbook.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short) 16);//设置字体大小 
        cellStyle.setFont(font);//选择需要用到的字体格式    
        
        //设置列宽
        sheet.setColumnWidth(0, 3766);
        
        SXSSFRow row = sheet.createRow(0);
        SXSSFCell cell1 = row.createCell(0);
        cell1.setCellStyle(cellStyle);
        cell1.setCellValue("HASE");
        
        SXSSFCell cell2 = row.createCell(2);
        cell2.setCellStyle(cellStyle);
        cell2.setCellValue("Client Performance Report");
        //合并单元格
        sheet.addMergedRegion( new CellRangeAddress(0,0,2,7));
        File xlsFile = new File("poi.xlsx");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }
    
}
