package kr.co.aegis.patent.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;

public class Excel {
	
	/**
	 * Excel 행수 구하기
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public int getRowCount(String path)  throws IOException {
		int cnt = 0;
		File file = new File(path);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(path);
		}
		
		String fileName = file.getName();
		if( fileName.indexOf(".xlsx") > -1 || fileName.indexOf(".xlsm") > -1) cnt = new XSSExcel().getRowCount( file );
        else if( fileName.indexOf(".xls") > -1 ) cnt = new HSSExcel().getRowCount( file );
		
		return cnt;
	}
	
	
	/**
	 * DB종류 확인하기
	 * @param excel
	 * @return
	 * @throws IOException
	 */
	public String getKindsDB(String path) throws IOException {
		String kindsDB = "";
		// check file
		File file = new File(path);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(path);
		}
		
		String fileName = file.getName();
		if( fileName.indexOf(".xlsx") > -1 || fileName.indexOf(".xlsm") > -1) kindsDB = new XSSExcel().getKindsDB( file );
        else if( fileName.indexOf(".xls") > -1 ) kindsDB = new HSSExcel().getKindsDB( file );
		
		return kindsDB;
	}

	/**
	 * DB마다 유일한 컬럼 정보
	 * @param headName
	 * @return
	 */
	public String getDBName(String headName) {
		String DBName = "";
		if(headName.equals("WIPS ON key")) {
			DBName = "WIPSON";
		} else if(headName.equals("Final Status")) {
			DBName = "FOCUST";
		} else if(headName.equals("번역문제출일자")) {
			DBName = "KIPRIS_N";
		} else if(headName.equals("UPC")) {
			DBName = "KIPRIS_A";
		}
		return DBName;
	}
	
	/**
	 * 각 DB의 헤더가 제대로 있는지 체크
	 * @param file
	 * @param kindsDB
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean checkHeader(String excel, String kindsDB) throws FileNotFoundException, IOException {
		boolean ret = false;
		
		File file = new File(excel);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(excel);
		}
		
		String headerList[] = null;
		if(kindsDB.equals(ExcelHeader.DB[0])) {	 		// WIPSON
			headerList = ExcelHeader.WIPSON;
		} else if(kindsDB.equals(ExcelHeader.DB[1])) {	// FOCUST
			headerList = ExcelHeader.FOCUST;
		} else if(kindsDB.equals(ExcelHeader.DB[2])) {	// KIPRIS_N
			headerList = ExcelHeader.KIPRIS_N;
		} else if(kindsDB.equals(ExcelHeader.DB[3])) {	// KIPRIS_A
			headerList = ExcelHeader.KIPRIS_A;
		}
		
		String fileName = file.getName();
		if( fileName.indexOf(".xlsx") > -1 || fileName.indexOf(".xlsm") > -1) ret = new XSSExcel().readHeader( file, headerList );
        else if( fileName.indexOf(".xls") > -1 ) ret = new HSSExcel().readHeader( file, headerList );
		
		return ret;
	}
	
	
	/**
	 * 업로드한 엑셀파일 읽어오기
	 * @param excel
	 * @return
	 * @throws IOException
	 */
	public List<Map<String, String>> readExcel(String path) throws IOException {
		// check file
		File file = new File(path);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(path);
		}
		
		String fileName = file.getName();
		String kindsDB = getKindsDB(path);
		List<Map<String, String>> list = null;
		if( fileName.indexOf(".xlsx") > -1 || fileName.indexOf(".xlsm") > -1) list = new XSSExcel().readExcel( path, kindsDB );
        else if( fileName.indexOf(".xls") > -1 ) list = new HSSExcel().readExcel( path, kindsDB );
		
		return list;
	}
	
	/**
	 * 누락정보 셋팅
	 * @param path 파일저장할 디렉토리 경로
	 * @param fileName 저장할 파일명
	 * @param list 테이블 정보
	 * @param colList 저장할 컬럼정보
	 * @throws IOException
	 */
	public String writeExcelForFamily(String path, String fileName, List<Map<String, String>> list, String[] colList) throws IOException {
		String newFileName = "";
		newFileName=  new HSSExcel().writeExcelForFamily( path, fileName, list, colList );
		
		return newFileName;
	}
	
	
	/**
	 * OS매트릭스 엑셀다운
	 * @param path 파일저장할 디렉토리 경로
	 * @param fileName 저장할 파일명
	 * @param list 테이블 정보
	 * @throws IOException
	 */
	public String writeExcelForOSMatrix(String path, String fileName, List<Map<String, String>> list) throws IOException {
		String newFileName = "";
		newFileName = new HSSExcel().writeExcelForOSMatrix( path, fileName, list );
		
		return newFileName;
	}
	
	/**
	 * 특허리스트 다운로드
	 * @param path 파일저장할 디렉토리 경로
	 * @param fileName 저장할 파일명
	 * @param list 테이블 정보
	 * @throws IOException
	 */
	public String writeExcelForPatentList(String path, String fileName, List<Map<String, String>> list) throws IOException {
		String newFileName = "";
		newFileName=  new HSSExcel().writeExcelForPatentList( path, fileName, list );
		
		return newFileName;
	}
	
	/**
	 * 특허리스트 전체필드 다운로드
	 * @param path 파일저장할 디렉토리 경로
	 * @param fileName 저장할 파일명
	 * @param list 테이블 정보
	 * @throws IOException
	 */
	public String writeExcelForPatentListAll(String path, String fileName, List<Map<String, String>> list) throws IOException {
		String newFileName = "";
		newFileName = new HSSExcel().writeExcelForPatentListAll( path, fileName, list );
		
		return newFileName;
	}
	
	/**
	 * 특허상세 다운로드
	 * @param path 파일저장할 디렉토리 경로
	 * @param fileName 저장할 파일명
	 * @param list 테이블 정보
	 * @throws IOException
	 */
	public String writeExcelForPatentDtl(String path, String imageDir, String fileName, Map<String, String> map) throws IOException {
		String newFileName = "";
		newFileName=  new HSSExcel().writeExcelForPatentDtl( path, imageDir, fileName, map );
		return newFileName;
	}
}