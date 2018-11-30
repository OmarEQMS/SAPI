/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

/**
 *
 * @author Raul Orihuela
 */
public class ExcelExport {
    public static void export(OutputStream myOutputStream, ArrayList<ArrayList<String>> myData) throws IOException{
        // CREAR LIBRO Y HOJA DE EXCEL
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        
        // CREAR FORMATO PARA HOJAS
        DataFormat textFormat = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(textFormat.getFormat("text"));
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        
        //IMPRIMIR CONTENIDO
        for (int rowNumber = 0; rowNumber<myData.size();rowNumber++){
            HSSFRow row = sheet.createRow(rowNumber); 
            for (int columnNumber = 0; columnNumber<myData.get(rowNumber).size();columnNumber++){
                HSSFCell cell = row.createCell(columnNumber);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(myData.get(rowNumber).get(columnNumber));
            } 
        }
        
        workbook.write(myOutputStream);
        workbook.close();
    }
    public static void export(String sheetName, OutputStream myOutputStream, ArrayList<ArrayList<String>> myData) throws IOException{
        // CREAR LIBRO Y HOJA DE EXCEL
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        
        // CREAR FORMATO PARA HOJAS
        DataFormat textFormat = workbook.createDataFormat();
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(textFormat.getFormat("text"));
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        
        //IMPRIMIR CONTENIDO
        for (int rowNumber = 0; rowNumber<myData.size();rowNumber++){
            HSSFRow row = sheet.createRow(rowNumber); 
            for (int columnNumber = 0; columnNumber<myData.get(rowNumber).size();columnNumber++){
                HSSFCell cell = row.createCell(columnNumber);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(myData.get(rowNumber).get(columnNumber));
            } 
        }
        
        workbook.write(myOutputStream);
        workbook.close();
    }
}
