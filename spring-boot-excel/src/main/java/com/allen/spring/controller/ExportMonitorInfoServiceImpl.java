package com.chinasofti.mvtm.oms.daoservice.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
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
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;

import com.chinasofti.mvtm.oms.daoservice.ExportMonitorInfoService;
import com.chinasofti.mvtm.oms.daoservice.bean.ExportVtmMonitorDataDomain;
import com.chinasofti.mvtm.oms.util.ExcelUtil;

/**
 * 
 * @author zhangshihao
 *
 */
public class ExportMonitorInfoServiceImpl implements ExportMonitorInfoService {

    
    private static Logger logger = LoggerFactory.getLogger(ExportMonitorInfoServiceImpl.class);
	/**
	 * 标题第一行.
	 */
	@Resource(name = "firstRow")
	private List<String> firstRowList;
	/**
	 * 标题第二行.
	 */
	@Resource(name = "secondRow")
	private List<String> secondRowList;
	/**
	 * 标题第三行.
	 */
	@Resource(name = "thirdRow")
	private List<String> thirdRowList;
	/**
	 * 标题第四行.
	 */
	@Resource(name = "fouthRow")
	private List<String> fouthRowList;
	/**
	 * 标题第六行.
	 */
	@Resource(name = "sixthRow")
	private List<String> sixthRowList;
	
	
	@Resource(name="status")
	private List<String> status;
	
	@Resource(name="items")
    private List<String> items;
	/**
	 * 标题日期格式.
	 */
	private static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void exportVtm(ExportVtmMonitorDataDomain domain) {
		Workbook wb = new SXSSFWorkbook(100);
		
		Sheet sh = wb.createSheet("mVTM");
		setTitle(domain, wb, sh);

	}

	private void setTitle(ExportVtmMonitorDataDomain domain, Workbook wb, Sheet sh) {
		Row titleRow_1 = (Row) sh.createRow(0);
		for (int i = 0; i < firstRowList.size(); i++) {
			Cell cell = titleRow_1.createCell(i);
			cell.setCellValue(firstRowList.get(i));
			if (i == 2) {
				CellStyle style = wb.createCellStyle();
				XSSFFont font = (XSSFFont) wb.createFont();
				font.setFontName("等线");
				font.setFontHeightInPoints((short) 16);
				font.setBold(true);//粗体显示
				style.setFont(font);
				cell.setCellStyle(style);
			}
		}

		Row titleRow_2 = (Row) sh.createRow(1);
		for (int i = 0; i < secondRowList.size(); i++) {
			Cell cell = titleRow_2.createCell(i);
			cell.setCellValue(secondRowList.get(i));
		}

		Row titleRow_3 = (Row) sh.createRow(2);
		String dateFrom = formatter.format(domain.getStartTime());
		String dateTo = formatter.format(domain.getEndTime());
		thirdRowList.set(3, dateFrom);
		thirdRowList.set(5, dateTo);
		for (int i = 0; i < thirdRowList.size(); i++) {
			Cell cell = titleRow_3.createCell(i);
			cell.setCellValue(thirdRowList.get(i));
		}

		Row titleRow_4 = (Row) sh.createRow(3);
		for (int i = 0; i < fouthRowList.size(); i++) {
			Cell cell = titleRow_4.createCell(i);
			cell.setCellValue(fouthRowList.get(i));
		}

		Row titleRow_6 = (Row) sh.createRow(5);
		for (int i = 0; i < sixthRowList.size(); i++) {
			Cell cell = titleRow_6.createCell(i);
			cell.setCellValue(sixthRowList.get(i));
		}
	}

    @Override
    public InputStream exportVta(ExportVtmMonitorDataDomain domain) throws IOException {
        logger.info("Start export vta data");
        Workbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet("VTA");
        setHeader(domain, workbook, sheet);
        DiskFileItemFactory fileFactory = new DiskFileItemFactory();
        FileItem item = fileFactory.createItem("VTA", "xlsx", true, "vta.xlsx");
        OutputStream fos = null;
        InputStream in;
        try{
            fos = item.getOutputStream();
            workbook.write(fos);
            in = item.getInputStream();
        }finally{
            if (fos != null) {
                fos.close();
            }
        }
        logger.info("End export vta data.");
        return in;
    }

    private void setHeader(ExportVtmMonitorDataDomain domain, Workbook workbook, Sheet sheet) {
        CellStyle style = ExcelUtil.setStyle(workbook);
        Font font = ExcelUtil.setFont(workbook);
        // 将字体应用到当前样式
        style.setFont(font);
        
        // 第一行
        Row row0 = sheet.createRow(0);
        ExcelUtil.creatCell(row0, "HASE", 0);
        ExcelUtil.mergedCell(sheet, row0, 0 , "Agent Performance Report", 14, 22, style);

        // 第二行
        Row row1 = sheet.createRow(1);
        ExcelUtil.mergedCell(sheet, row1, 1 , "HACNCAL", 15, 18, style);

        // 第三行
        Row row2 = sheet.createRow(2);
        ExcelUtil.creatCell(row2, "Department", 0);
        ExcelUtil.creatCell(row2, "CAL", 3);
        ExcelUtil.creatCell(row2, "From", 36);
        ExcelUtil.creatCell(row2, "To", 41);

        // 第五行
        Row row4 = sheet.createRow(4);
        String dateFrom = formatter.format(domain.getStartTime());
        String dateTo = formatter.format(domain.getEndTime());
        ExcelUtil.creatCell(row4, dateFrom, 37);
        ExcelUtil.creatCell(row4, dateTo, 41);

        // 第七行
        Row row6 = sheet.createRow(6);
        ExcelUtil.mergedCell(sheet, row6, 6, "Staff", 0,  1, style);
        ExcelUtil.mergedCell(sheet, row6, 6, "Sign" ,2, 3, style);
        
        ExcelUtil.creatStyleCell(row6, "Dur.", 4, style);
        ExcelUtil.creatStyleCell(row6, "Prod.", 41, style);
        ExcelUtil.creatStyleCell(row6, "RPH", 42, style);
        ExcelUtil.creatStyleCell(row6, "Number of Business", 43, style);
        
        int j = 5;
        for (int i = 0;i<status.size();i++) {
            ExcelUtil.mergedCell(sheet,row6 ,6, status.get(i) , j , j +3 , style);
            j = j +4 ;
        }
        
        //第八行
        Row row7 = sheet.createRow(7);
        for( int i = 0 ;i < items.size();i++) {
            ExcelUtil.creatCell(row7, items.get(i), i);
        }
    }
    

}
