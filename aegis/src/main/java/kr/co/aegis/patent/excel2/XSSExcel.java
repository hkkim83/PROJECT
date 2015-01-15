package kr.co.aegis.patent.excel2;

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
	
	public XSSExcel(String path) {
		super(path);
	}
	
	/**
	 * Excel 행수 구하기
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public int getRowCount()  throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		int cnt = 0, index = 0;
		String str = "";
		for (Row row : wb.getSheetAt(0)) {
			str = "";
			index = 0;
			for(Cell cell : row) {
				if(index > 3) break;
				switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					str += cell.getRichStringCellValue().getString();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					str += String.valueOf((long)cell.getNumericCellValue());
					break;
				case XSSFCell.CELL_TYPE_FORMULA:
					str += cell.getCellFormula();
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					str += String.valueOf(cell.getBooleanCellValue());
					break;
				default:
					break;
				}
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
	public String getKindsDB() throws IOException {
		
		String fileName = file.getName();
		String DBType = fileName.substring(0,2);
		String DBName = getDBName(DBType);
		setTitleArr();		// 헤더명 배열에 담기
		
	    return DBName;
	}
	

	/**
	 * 업로드한 엑셀파일 읽어오기
	 * @param excel
	 * @param kindsDB
	 * @return
	 * @throws IOException
	 */
	public List<Map<String,String>> readExcel(String kindsDB) throws IOException {

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		String value = "";
		String key   = "";
		
		// DB 매핑정보 가져오기
		getDBMap(kindsDB);
		
		for (Row row : wb.getSheetAt(0)) {
			if(row.getRowNum() < 1) continue;
			Map<String, String> map = new HashMap<String, String>();
			map.put("KINDS_DB", kindsDB);
			StringBuilder sb = new StringBuilder();
			
			for (Cell cell : row) {
				key   = DBMap.get(titleArr[cell.getColumnIndex()]);
				value = "";
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
				if(cell.getColumnIndex() < 3) sb.append(value);
				map.put(key, value);
			}
			// 컬럼값이 존재하지 않으면 루프를 탈출한다.
			if(StringUtil.isNull(sb.toString())) break;
			list.add(map);
		}
		return list;
	}

	/**
	 * KIPRIS 국내/국외 구분 가져오기
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String getKindNA() throws IOException {

		XSSFWorkbook wb   = new XSSFWorkbook(new FileInputStream(file));		
		XSSFSheet sheet   = wb.getSheetAt(0);
	    XSSFRow row       = sheet.getRow(0);
	    String headerName = "";
	    String DBName     = "KIPRIS_N";
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case XSSFCell.CELL_TYPE_STRING:
	    			headerName = cell.getRichStringCellValue().getString();
	    			if("국가".equals(headerName)) {
	    				DBName = "KIPRIS_A";
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
	 * DB마다 유일한 컬럼 정보
	 * @param headName
	 * @return
	 * @throws IOException 
	 */
	private String getDBName(String dbType) throws IOException {
		String DBName = "";
		if(dbType.equals("11")) {
			DBName = "WIPSON";
		} else if(dbType.equals("12")) {
			DBName = "FOCUST";
		} else if(dbType.equals("13")) {
			DBName = getKindNA();
		}
		return DBName;
	}
	
	/**
	 * 배열에 헤더명 기록하기
	 * @param dbType
	 * @throws IOException
	 */
	private void setTitleArr() throws IOException {

		XSSFWorkbook wb   = new XSSFWorkbook(new FileInputStream(file));		
		XSSFSheet sheet   = wb.getSheetAt(0);
	    XSSFRow row       = sheet.getRow(0);
	    String headerName = "";
	    
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case XSSFCell.CELL_TYPE_STRING:
	    			headerName = cell.getRichStringCellValue().getString();
	    			titleArr[cell.getColumnIndex()] = headerName;
	    			break;
				default:
					break;					
	    	}
	    }
	    logger.info("setTitleArr::::::::::::::::::\n");
	    logger.info(titleArr);
	}
}