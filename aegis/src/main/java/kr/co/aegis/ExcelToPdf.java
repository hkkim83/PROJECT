package kr.co.aegis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ExcelToPdf {

    /**
     * @param args
     * @throws Exception
     */

    private static String FILE = "C:/Java/project/patentDir/bbb.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    //Find out number of columns in the excel 
    private static int numberOfColumns;

    public static void main(String[] args) throws DocumentException, IOException {


        BaseFont objBaseFont = BaseFont.createFont("HYGoThic-Medium", "UniKS-UCS2-H", false); 
        Font font = new Font(objBaseFont, 9, Font.NORMAL);
        String excelFile = "C:/Java/project/patentDir/patentList_20140424191555.xls";

        File xlsFile = new File(excelFile);
        Workbook workbook;
        try {
            workbook = loadSpreadSheet(xlsFile);
            readSpreadSheet(workbook, font);
        } catch (FileNotFoundException e) {
            System.err.println("Excel File (or) PDF File is already opened. Please close the file");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readSpreadSheet(Workbook workbook, Font font) throws IOException,
            DocumentException {

        Document document = new Document(PageSize.A4, 0, 0, 50, 50);
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        document.open();
        addMetaData(document);
        addTitlePage(document);
        document.setPageSize(new Rectangle(842,595));
        Anchor anchor = new Anchor("한글한글", font);
        anchor.setName("First Chapter");

        // Second parameter is the number of the chapter
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);

        Paragraph subPara = new Paragraph("Table", font);
        Section subCatPart = catPart.addSection(subPara);
        addEmptyLine(subPara, 5);

        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through each rows from first sheet
        Iterator<Row> rowIterator = sheet.iterator();

        int temp = 0;
        boolean flag = true;
        PdfPTable table = null;

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            int cellNumber = 0;

            if (flag) {
                table = new PdfPTable(row.getLastCellNum());
                flag = false;
            }

            // For each row, iterate through each columns
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                switch (cell.getCellType()) {   
                case Cell.CELL_TYPE_STRING: 
                    if (temp == 0) {            
                        numberOfColumns = row.getLastCellNum();
                        PdfPCell c1 = new PdfPCell(new Phrase(
                                cell.getStringCellValue(), font));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);
                        table.setHeaderRows(1);

                    }else{
                        cellNumber =checkEmptyCellAndAddCellContentToPDFTable(cellNumber,cell,table);
                    } 
                    System.out.println("cell::::"+cell.getStringCellValue());
                    cellNumber++;
                    break;

                case Cell.CELL_TYPE_NUMERIC:
                    cellNumber =checkEmptyCellAndAddCellContentToPDFTable(cellNumber,cell,table);
                    cellNumber++; 
                    break;
                }       
            }
            temp = 1;
            if(numberOfColumns != cellNumber){
                for(int i=0;i<(numberOfColumns-cellNumber);i++){
                    table.addCell(" ");
                }
            }
        }
        subCatPart.add(table);
        // Now add all this to the document
        document.add(catPart);
        document.close();
    }

    private static int checkEmptyCellAndAddCellContentToPDFTable(int cellNumber, Cell cell, PdfPTable table) {
        if (cellNumber == cell.getColumnIndex()) {
            if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                table.addCell(Double.toString(cell.getNumericCellValue()));
            }
            if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                table.addCell(cell.getStringCellValue());
            }

        } else {
            while( cellNumber < cell.getColumnIndex()) {

                    table.addCell(" ");
                    cellNumber++;

            }
            if (cellNumber == cell.getColumnIndex()) {
                if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                    table.addCell(Double.toString(cell.getNumericCellValue()));
                }
                if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                    table.addCell(cell.getStringCellValue());
                }

            }
            cellNumber = cell.getColumnIndex();
        }   

        return cellNumber;
    }

    private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Uvaraj");
        document.addCreator("Uvaraj");
    }

    private static void addTitlePage(Document document)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        // We add one empty line
        addEmptyLine(preface, 1);
        // Lets write a big header
        preface.add(new Paragraph("Title of the document", catFont));

        addEmptyLine(preface, 1);
        // Will create: Report generated by: _name, _date
        preface.add(new Paragraph("Report generated by: " + "Uvaraj" + ", "
                + new Date(), smallBold));
        addEmptyLine(preface, 3);
        preface.add(new Paragraph(
                "This document describes something which is very important ",
                smallBold));

        addEmptyLine(preface, 8);

        preface.add(new Paragraph(
                "This document is a preliminary version  ;-).", redFont));

        document.add(preface);
        // Start a new page
        document.newPage();
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private static Workbook loadSpreadSheet(File xlsFile) throws Exception {
        Workbook workbook = null;

        String ext = getFileExtension(xlsFile.getName());
        if (ext.equalsIgnoreCase("xlsx")) {
            OPCPackage pkg = OPCPackage.open(xlsFile.getAbsolutePath());
            workbook = new XSSFWorkbook(pkg);
            pkg.close();
        } else if (ext.equalsIgnoreCase("xls")) {
            InputStream xlsFIS = new FileInputStream(xlsFile);
            workbook = new HSSFWorkbook(xlsFIS);
            xlsFIS.close();
        } else {
            throw new Exception("FILE EXTENSION NOT RECOGNIZED");
        }
        return workbook;
    }

    private static String getFileExtension(String fileName) {
        String ext = "";
        int mid = fileName.lastIndexOf(".");
        ext = fileName.substring(mid + 1, fileName.length());
        System.out.println("File Extension --" + ext);
        return ext;
    }

}