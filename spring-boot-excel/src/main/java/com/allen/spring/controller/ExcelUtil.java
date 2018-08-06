/**
 * 
 */
package com.chinasofti.mvtm.oms.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * @author first
 *
 */
public class ExcelUtil {

    
    public static CellStyle setStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
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
    
    public static Font setFont(Workbook workbook) {
        Font font = workbook.createFont();
        // 字体颜色
        font.setColor(IndexedColors.WHITE.getIndex());
        // 字体名称
        font.setFontName("黑体");
        // 字体高度
        font.setFontHeightInPoints((short) 11);
//      font.setBold(true);// 是否加粗
        return font;
    }
    
    public static void creatCell(Row row , String value,int cellNumber) {
        Cell cell = row.createCell(cellNumber);
        cell.setCellValue(value);
    }
    
    public static void mergedCell(Sheet sheet , Row row , int rownum , String value, int cellNumber, int endNumber , CellStyle style) {
        Cell cell = row.createCell(cellNumber);
        cell.setCellStyle(style);
        cell.setCellValue(value);
        sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, cellNumber, endNumber));
    }
    
    public static void creatStyleCell(Row row , String value,int cellNumber, CellStyle style) {
        Cell cell = row.createCell(cellNumber);
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }
}
