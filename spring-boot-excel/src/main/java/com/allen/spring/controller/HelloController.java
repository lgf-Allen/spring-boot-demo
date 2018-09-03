/**
 * 
 */
package com.allen.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allen.spring.config.Person;

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
        SXSSFWorkbook workbook = new SXSSFWorkbook();
        // 生成一个表格
        SXSSFSheet sheet = workbook.createSheet("vta");
        // 设置表格默认列宽度
//        sheet.setDefaultColumnWidth((short) 20);

        // 设置某列的列宽
        // sheet.setColumnWidth(0, 3766);

        // 生成一个样式
        CellStyle style = workbook.createCellStyle();
        // 设置样式
        setStyle(style);
        // 生成一个字体
        Font font = workbook.createFont();
        // 设置字体
        setFont(font);
        // 将字体应用到当前样式
        style.setFont(font);

        // 设置表头
        writeHeader(sheet, "2018/5/1", "2018/5/3" , style);

        File xlsFile = new File("poi.xlsx");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }

    private static CellStyle setStyle(CellStyle style) {
        //设置背景色
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //设置边框
//        style.setBorderBottom(BorderStyle.THIN);
//        style.setBorderLeft(BorderStyle.THIN);
//        style.setBorderRight(BorderStyle.THIN);
//        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
//        style.setWrapText(true);// 设置自动换行
        return style;
    }

    private static Font setFont(Font font) {
        // 字体颜色
        font.setColor(IndexedColors.WHITE.getIndex());
        // 字体名称
        font.setFontName("黑体");
        // 字体高度
        font.setFontHeightInPoints((short) 11);
//        font.setBold(true);// 是否加粗
        return font;
    }

    private static void writeHeader(SXSSFSheet sheet, String fromDate, String ToDate ,CellStyle style) {
        // 第一行
        SXSSFRow row0 = sheet.createRow(0);
        SXSSFCell cell0_0 = row0.createCell(0);
        // cell1.setCellStyle(cellStyle);
        cell0_0.setCellValue("HASE");

        SXSSFCell cell0_2 = row0.createCell(2);
        // cell2.setCellStyle(cellStyle);
        cell0_2.setCellValue("Agent Performance Report");
        // 合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 43));

        // 第二行
        SXSSFRow row1 = sheet.createRow(1);
        SXSSFCell cell1_15 = row1.createCell(15);
        cell1_15.setCellValue("HACNCAL");
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 15, 18));

        // 第三行
        SXSSFRow row2 = sheet.createRow(2);
        SXSSFCell cell2_0 = row2.createCell(0);
        cell2_0.setCellValue("Department");

        SXSSFCell cell2_3 = row2.createCell(3);
        cell2_3.setCellValue("CAL");

        SXSSFCell cell2_36 = row2.createCell(36);
        cell2_36.setCellValue("From");

        SXSSFCell cell2_41 = row2.createCell(41);
        cell2_41.setCellValue("To");

        // 第五行
        SXSSFRow row4 = sheet.createRow(4);
        SXSSFCell cell4_37 = row4.createCell(37);
        cell4_37.setCellValue(fromDate);

        SXSSFCell cell4_41 = row4.createCell(41);
        cell4_41.setCellValue(ToDate);

        // 第七行
        SXSSFRow row6 = sheet.createRow(6);
        
        creatStyleCell(row6, "Dur.", 4, style);
        creatStyleCell(row6, "Prod.", 41, style);
        creatStyleCell(row6, "RPH", 42, style);
        creatStyleCell(row6, "Number of Business", 43, style);
        
        mergedCell(sheet, row6,"Staff", 0,  1, style);
        
        mergedCell(sheet, row6, "Sign" ,2, 3, style);
        
        mergedCell(sheet, row6, "Talking" , 5 , 8, style);
        
        mergedCell(sheet, row6 , "Available", 9,  12, style);
        
        mergedCell(sheet, row6, "Case Follow Up", 13,  16, style);

        mergedCell(sheet, row6, "Checker" , 17, 20, style);
        
        mergedCell(sheet, row6, "Break" , 21 , 24, style);
        
        mergedCell(sheet, row6, "Training", 25, 28, style);
        
        mergedCell(sheet, row6, "Meeting" , 29, 32, style);
        
        mergedCell(sheet, row6, "Lunch", 33, 36, style);

        mergedCell(sheet, row6, "Miss" , 37, 40, style);
        
        //第八行
        SXSSFRow row7 = sheet.createRow(7);
        List<String> list = generateList();
        for( int i = 0 ;i < list.size();i++) {
            SXSSFCell cell = row7.createCell(i);
            cell.setCellValue(list.get(i));
        }
    }

    private static void creatStyleCell(SXSSFRow row , String value,int cellNumber, CellStyle style) {
        SXSSFCell cell = row.createCell(cellNumber);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }
    
    private static void creatCell(SXSSFRow row , String value,int cellNumber) {
        SXSSFCell cell = row.createCell(cellNumber);
        cell.setCellValue(value);
    }
    
    private static void mergedCell(SXSSFSheet sheet,SXSSFRow row , String value, int cellNumber, int endNumber , CellStyle style) {
        SXSSFCell cell = row.createCell(cellNumber);
        cell.setCellStyle(style);
        cell.setCellValue(value);
        sheet.addMergedRegion(new CellRangeAddress(6, 6, cellNumber, endNumber));
    }
    
    private static List<String> generateList() {
        List<String> items = new ArrayList<String>();
        items.add("Name");
        items.add("ID");
        items.add("On");
        items.add("Off");
        items.add("Sign On (hr)");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");

        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");

        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        
        items.add("Dur.(hr)");
        items.add("Count");
        items.add("Avg.");
        items.add("%");
        return items;
    }
    
    @RequestMapping(path="/user")
    public String get(Person son) {
        return null;
    }
    
}
