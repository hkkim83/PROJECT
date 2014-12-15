package kr.co.aegis.patent.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSExcel extends Excel{
	
	/**
	 * Excel 행수 구하기
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount(File file) throws FileNotFoundException, IOException {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		int cnt = 0, index = 0;
		String str = "";
		for (Row row : wb.getSheetAt(0)) {
			str = "";
			index = 0;
			for(Cell cell : row) {
				if(index > 3) break;
				str += cell.getStringCellValue();
				index++;
			}
			if(StringUtil.isNull(str)) break;
			cnt++;
		}
		return cnt;
	}
	
	/**
	 * DB구분 가져오기
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String getKindsDB(File file) throws FileNotFoundException, IOException {

		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));		
		XSSFSheet sheet = wb.getSheetAt(0);
	    XSSFRow row     = sheet.getRow(0);
	    String headName = "";
	    String DBName   = "";
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case XSSFCell.CELL_TYPE_STRING:
	    			headName = cell.getRichStringCellValue().getString();
	    			if(!"".equals(DBName = getDBName(headName))) {
	    				return DBName;
	    			}
	    			break;
				default:
					break;					
	    	}
	    }
	    return DBName;
	}

	/**
	 * 파일 정합성 체크 - DB별 엑셀 헤더가 일치하는치 체크
	 * @param file
	 * @param headerList
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean readHeader(File file, String[] headerList) throws FileNotFoundException, IOException {

		int cnt = 0;
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));		
		XSSFSheet sheet = wb.getSheetAt(0);
	    XSSFRow row     = sheet.getRow(0);
	    String headName = "";
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case XSSFCell.CELL_TYPE_STRING:
	    			headName = cell.getRichStringCellValue().getString();
	    			if(headName.equals(headerList[cell.getColumnIndex()])) cnt++;
	    			break;
				default:
					break;					
	    	}
	    }

	    return (headerList.length == cnt );
	}

	/**
	 * 업로드한 엑셀파일 읽어오기
	 * @param excel
	 * @param kindsDB
	 * @return
	 * @throws IOException
	 */
	public List<Map<String,String>> readExcel(String excel, String kindsDB) throws IOException {
		// check file
		File file = new File(excel);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(excel);
		}
		
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		String value = null;
		for (Row row : wb.getSheetAt(0)) {
			if(row.getRowNum() < 1) continue;
			Map<String, String> map = new HashMap<String, String>();
			map.put("KINDS_DB", kindsDB);
			for (Cell cell : row) {
				value = null;
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					value = cell.getRichStringCellValue().getString();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					value = String.valueOf((long)cell.getNumericCellValue());
					break;
				case XSSFCell.CELL_TYPE_FORMULA:
					value = cell.getCellFormula();
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
				map.put("A_"+StringUtil.lpad(String.valueOf(cell.getColumnIndex()+1), 2, "0"), value);
			}
			// 컬럼값이 존재하지 않으면 루프를 탈출한다.
			if(StringUtil.isNull(map.get("A_01")) && StringUtil.isNull(map.get("A_02")) && StringUtil.isNull(map.get("A_03"))) break;
			list.add(map);
		}
		return list;
	}
}