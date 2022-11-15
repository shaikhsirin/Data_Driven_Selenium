package com.keyworddriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtils {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;
    public static void setExcelFile(String path, String sheetName) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook = new XSSFWorkbook(fis);
        sheet= (XSSFSheet) workbook.getSheet(sheetName);
    }
    public static String getCellData(int row, int column)
    {
        Cell cell = sheet.getRow(row).getCell(column);
        String cellData=cell.getStringCellValue();
        return cellData;
    }

    }

