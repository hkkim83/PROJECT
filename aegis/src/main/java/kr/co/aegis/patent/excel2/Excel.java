package kr.co.aegis.patent.excel2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.patent.parser.FocustExcelParser;
import kr.co.aegis.patent.parser.KiprisAExcelParser;
import kr.co.aegis.patent.parser.KiprisNExcelParser;
import kr.co.aegis.patent.parser.WipsonExcelParser;

abstract public class Excel {
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	protected String path;
	protected File file;
	protected Map<String, String> DBMap = null;
	protected String[] titleArr = new String[100];
	
	public Excel(String path) {
		this.path = path;
		this.file = new File(path);
	}	

	/**
	 * Excel 행수 구하기
	 * @param path
	 * @return
	 * @throws IOException
	 */
	abstract public int getRowCount()  throws IOException;
	
	
	/**
	 * DB종류 확인하기
	 * @param excel
	 * @return
	 * @throws IOException
	 */
	abstract public String getKindsDB() throws IOException;

	
	/**
	 * 업로드한 엑셀파일 읽어오기
	 * @param excel
	 * @return
	 * @throws IOException
	 */
	abstract public List<Map<String, String>> readExcel(String kindsDB) throws IOException;

	/**
	 * DB컬럼정보와 헤더정보 매핑한 값 가져오기
	 * @param kindsDB
	 */
	protected void getDBMap(String kindsDB) {
		if(kindsDB.equals(ExcelHeader.DB[0])) {			// WIPSON
			DBMap =  Header.DBMAP_WIPSON;
		} else if(kindsDB.equals(ExcelHeader.DB[1])) {	// FOCUST
			DBMap =  Header.DBMAP_FOCUST;
		} else if(kindsDB.equals(ExcelHeader.DB[2])) {	// KIPRIS_N
			DBMap =  Header.DBMAP_KIPRIS_N;
		} else if(kindsDB.equals(ExcelHeader.DB[3])) {	// KIPRIS_A
			DBMap =  Header.DBMAP_KIPRIS_A;
		}
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
		newFileName=  new HSSExcel(path).writeExcelForFamily( path, fileName, list, colList );
		
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
		newFileName = new HSSExcel(path).writeExcelForOSMatrix( path, fileName, list );
		
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
		newFileName=  new HSSExcel(path).writeExcelForPatentList( path, fileName, list );
		
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
		newFileName = new HSSExcel(path).writeExcelForPatentListAll( path, fileName, list );
		
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
		newFileName=  new HSSExcel(path).writeExcelForPatentDtl( path, imageDir, fileName, map );
		return newFileName;
	}
}