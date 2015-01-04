package kr.co.aegis.patent.excel2;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.util.DateUtil;
import kr.co.aegis.util.FileUtil;
import kr.co.aegis.util.StringUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class HSSExcel extends Excel{
	
	public HSSExcel(String path) {
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

		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
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
		HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));
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
					case HSSFCell.CELL_TYPE_STRING:
						value = cell.getRichStringCellValue().getString();
						break;
					case HSSFCell.CELL_TYPE_NUMERIC:
						value = String.valueOf((long)cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						value = cell.getCellFormula();
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
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
	 * 업로드한 엑셀파일 읽어오기
	 * @param excel
	 * @param kindsDB
	 * @return
	 * @throws IOException
	 */
	public String writeExcelForFamily(String path, String fileName, List<Map<String, String>> list, String[] colList) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		
		HSSFSheet sheet = workbook.createSheet("Sheet1"); 
		  
		//Font 설정. 
		HSSFFont font = workbook.createFont(); 
		font.setFontName(HSSFFont.FONT_ARIAL); 
		
		//제목의 스타일 지정 
		HSSFCellStyle style = workbook.createCellStyle(); 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		style.setFont(font); 
		  
		// cell정보 추가
		for(int i=0; i<colList.length; i++)
			setCellForFamily(sheet, list, i, colList[i], style);
		
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".xls";
		File file = new File(path+"/"+fileName);
		FileOutputStream stream = new FileOutputStream(file);

		workbook.write(stream);
		stream.close();
		
		return fileName;
	}
	
	/**
	 * 누락정보 셋팅
	 * @param sheet
	 * @param list
	 * @param colIndex
	 * @param colInfo
	 * @param style
	 */
	private void setCellForFamily(HSSFSheet sheet, List<Map<String, String>> list, int colIndex, String colInfo, HSSFCellStyle style) {
		HSSFRow row   = sheet.getRow(0) == null ? sheet.createRow((short)(0)) : sheet.getRow(0);
		HSSFCell cell = row.createCell(colIndex); 
		
		String colName[] = colInfo.split(":");
		// 헤더명과 스타일 지정
		cell.setCellValue(colName[1]);
		cell.setCellStyle(style);
		
		int index=0;  
		for(Map<String, String> map : list) {
			if(StringUtil.isNull(map.get(colName[0]))) continue;
			++index;
			row   = sheet.getRow(index) == null ? sheet.createRow((short)(index)) : sheet.getRow(index);

			cell = row.createCell(colIndex); 
			cell.setCellValue(map.get(colName[0])); 
		    cell.setCellStyle(style); 
		}
		sheet.autoSizeColumn(colIndex);
	}
	
	/**
	 * OS매트릭스 다운로드
	 * @param path
	 * @param fileName
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public String writeExcelForOSMatrix(String path, String fileName, List<Map<String, String>> list) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(); 
		
		HSSFSheet sheet = workbook.createSheet("Sheet1"); 
		  
		//Font 설정. 
		HSSFFont font = workbook.createFont(); 
		font.setFontName(HSSFFont.FONT_ARIAL); 
		
		//제목의 스타일 지정 
		HSSFCellStyle style = workbook.createCellStyle(); 
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); 
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setFillForegroundColor(HSSFColor.AQUA.index);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setFont(font); 
		
		HSSFCellStyle style2 = workbook.createCellStyle(); 
		style2.setWrapText(true);
		style2.setAlignment(HSSFCellStyle.ALIGN_LEFT); 
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setFont(font);
		
		HSSFRow row = null;
		HSSFCell cell = null;
		int index =-1;
		int len = 0;
		for(Map<String, String> map : list) {
			row   = sheet.createRow((short)(++index));
			len = map.size();
			for(int i=0; i<len; i++) {
				cell = row.createCell(i); 
				String str = map.get(i+"");
				str = str.replaceAll("<br>", "\n");
				cell.setCellValue(str); 
				if(index == 0 || i == 0)
					cell.setCellStyle(style); 			
				else 
					cell.setCellStyle(style2);
			}		
		}
		
		for(int i=1; i<len; i++) {
			sheet.autoSizeColumn(i);
			if(sheet.getColumnWidth(i) < 3262)
				sheet.setColumnWidth(i, 3262);
		}
		
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".xls";
		File file = new File(path+"/"+fileName);
		FileOutputStream stream = new FileOutputStream(file);

		workbook.write(stream);
		stream.close();
		
		return fileName;
	}
	
	/**
	 * 특허리스트 다운로드
	 * @param path
	 * @param fileName
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public String writeExcelForPatentList(String path, String fileName, List<Map<String, String>> list) throws IOException {
		
		String srcPath = path+"/sample/"+fileName+".xls";
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".xls";
		String dstPath = path+"/"+fileName;
		FileUtil.fileCopy(srcPath, dstPath);
		File file = new File(dstPath);
		
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = workbook.getSheetAt(0); 

		HSSFRow row = null;
		HSSFCell cell = null;
		HSSFCell fCell = sheet.getRow(1).getCell(0);
		HSSFCellStyle style = fCell.getCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		HSSFCellStyle style2 = fCell.getCellStyle();
		style2.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		
		int index = 1;
		String[] headList = ExcelHeader.PATENT_HEADER;
		String str = "";
		for(Map<String, String> map : list) {
			row   = sheet.createRow((short)(++index));
			for(int i=0; i<8; i++) {
				cell = row.createCell(i);
				str = map.get(headList[i]);
				if(i==4)
					str += "|"+map.get(headList[8]);
				if(i==7)
					str += "\n"+map.get(headList[9]);
				
				cell.setCellValue(str);
				
				if(i == 3 || i == 5 || i == 7)
					cell.setCellStyle(style2);
				else 
					cell.setCellStyle(style);
					
			}
		}
		
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
		stream.close();
		
		return fileName;
	}
	
	/**
	 * 특허리스트 전체필드 다운로드
	 * @param path
	 * @param fileName
	 * @param list
	 * @return
	 * @throws IOException
	 */
	public String writeExcelForPatentListAll(String path, String fileName, List<Map<String, String>> list) throws IOException {
		
		String srcPath = path+"/sample/"+fileName+".xls";
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".xls";
		String dstPath = path+"/"+fileName;
		FileUtil.fileCopy(srcPath, dstPath);
		File file = new File(dstPath);
		
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = workbook.getSheetAt(0); 

		HSSFRow row = null;
		HSSFCell cell = null;
		HSSFCell fCell = sheet.getRow(0).getCell(0);
		HSSFCellStyle style = fCell.getCellStyle();
		
		int index = 0;
		String[] headList = ExcelHeader.PATENT_HEADER_ALL;
		String str = "";
		for(Map<String, String> map : list) {
			row   = sheet.createRow((short)(++index));
			for(int i=0; i<headList.length; i++) {
				cell = row.createCell(i);
				str = map.get(headList[i]);
				cell.setCellValue(str);
				cell.setCellStyle(style);
			}
		}
		
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
		stream.close();
		
		return fileName;
	}
	
	
	/**
	 * 특허상세 다운로드
	 * @param path
	 * @param imageDir
	 * @param fileName
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public String writeExcelForPatentDtl(String path, String imageDir, String fileName, Map<String, String> map) throws IOException {
		
		String srcPath = path+"/sample/"+fileName+".xls";
		fileName = fileName+"_"+DateUtil.getDateTimeToString()+".xls";
		String dstPath = path+"/"+fileName;
		FileUtil.fileCopy(srcPath, dstPath);
		File file = new File(dstPath);
		
		HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet = workbook.getSheetAt(0); 

		HSSFRow row = null;
		// row = 1
		row = sheet.getRow(1);
		// 출원국가
		row.getCell(5).setCellValue(map.get("NATL_CODE"));
		// 출원번호
		row.getCell(7).setCellValue(map.get("APPL_NUM"));
		// 공개번호
		row.getCell(9).setCellValue(map.get("LAID_PUBLIC_NUM"));
		// 등록번호
		row.getCell(11).setCellValue(map.get("REGI_NUM"));
		// row = 2
		row = sheet.getRow(2);
		// 대표IPC
		row.getCell(5).setCellValue(map.get("IPC_ALL"));
		// 출원일자
		row.getCell(7).setCellValue(map.get("APPL_DATE"));
		// 공개일자
		row.getCell(9).setCellValue(map.get("LAID_PUBLIC_DATE"));
		// 등록일자
		row.getCell(11).setCellValue(map.get("REGI_DATE"));
		// row = 3
		row = sheet.getRow(3);
		// 출원인
		row.getCell(5).setCellValue(map.get("APPLICANT_RENAME"));
		// 패밀리
		row.getCell(7).setCellValue(map.get("FM_NUM"));
		// row = 4
		row = sheet.getRow(4);
		// 발명명칭
		row.getCell(5).setCellValue(map.get("TITLE"));
		// row = 5
		row = sheet.getRow(5);
		// 관리번호
		row.getCell(3).setCellValue(map.get("SEQ_NUM"));
		// 문헌종류
		row.getCell(5).setCellValue(map.get("KINDS_IP_CODE"));
		// 청구항개수
		row.getCell(7).setCellValue(map.get("FM_COUNT"));
		// 기술등급
		row.getCell(9).setCellValue(map.get("GRADE_OBJ")+"|"+map.get("GRADE_CONST"));
		// 기술분류
		row.getCell(11).setCellValue(map.get("REVIEWER"));
		// row = 6
		row = sheet.getRow(6);
		// 요약
		row.getCell(2).setCellValue(StringUtil.makeSentence(map.get("ABSTRACT")));
		// 대표도
		drawImage(sheet, workbook, map.get("IMAGE_MAIN"), imageDir);
		// row = 22
		row = sheet.getRow(22);
		// 대표독립항
		row.getCell(1).setCellValue(StringUtil.makeSentence(map.get("CLAIM_MAIN")));
		// 검토의견
		row.getCell(7).setCellValue(map.get("CMT_LAW_FIRMS")+"\n"+map.get("CMT_CO"));
		
		FileOutputStream stream = new FileOutputStream(file);
		workbook.write(stream);
		stream.close();
		
		return fileName;
	}
	
	/**
	 * 엑셀파일에 이미지 삽입
	 * @param sheet
	 * @param wb
	 * @param path
	 * @param imageDir
	 * @throws IOException
	 */
	private void drawImage( HSSFSheet sheet, HSSFWorkbook wb, String path, String imageDir) throws IOException {
        // Create the drawing patriarch.  This is the top level container for
        // all shapes. This will clear out any existing shapes for that sheet.
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        HSSFClientAnchor anchor;
        anchor = new HSSFClientAnchor(5,10,1023,255,(short)7,6,(short)11,20); // 이미지 크기조절은 여기서..
        anchor.setAnchorType( 2 );
        
        // 웹이미지와 로컬이미지 구분
        if(path.startsWith("http")) {
        	patriarch.createPicture(anchor, loadPictureForWeb( path, wb )); // 삽입 할 이미지
        } else {
        	patriarch.createPicture(anchor, loadPictureForLocal( imageDir+"/"+path, wb )); // 삽입 할 이미지
        }
    }

	/**
	 * 로컬이미지 삽입
	 * @param path
	 * @param wb
	 * @return
	 * @throws IOException
	 */
	private static int loadPictureForLocal( String path, HSSFWorkbook wb ) throws IOException {
        int pictureIndex;
        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;

        try {
            fis = new FileInputStream( path);
            bos = new ByteArrayOutputStream( );
            int c;
            while ( (c = fis.read()) != -1) {
                bos.write( c );
            }
            pictureIndex = wb.addPicture( bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG  );
        } finally {
            if (fis != null) fis.close();
            if (bos != null) bos.close();
        }
        return pictureIndex;
    }
	
	/**
	 * 웹이미지 삽입
	 * @param path
	 * @param wb
	 * @return
	 * @throws IOException
	 */
	private int loadPictureForWeb( String path, HSSFWorkbook wb ) throws IOException {
    	
    	URL voImageURL = new URL(path);
        int pictureIndex = 0;
        InputStream is = null;
        BufferedInputStream bis = null;
        ByteArrayOutputStream bos = null;

        HttpURLConnection voImageReponse = (HttpURLConnection) voImageURL  
                .openConnection(); 
        if (voImageReponse.getResponseCode() == HttpURLConnection.HTTP_OK) {  
        	is = voImageReponse.getInputStream();  
        	  
            bis = new BufferedInputStream(is);  
            bos = new ByteArrayOutputStream( );
              
            //응답 코드를 1024바이트 단위로 저장  
            int len = 0;  
            byte[] buf = new byte[1024];  
            while ((len = bis.read(buf, 0, 1024)) != -1) {  
                bos.write(buf, 0, len);  
            } 
            pictureIndex = wb.addPicture( bos.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG  );
        }
        if (is != null) is.close();
        if (bis != null) bis.close();
        if (bos != null) bos.close();
        
        return pictureIndex;
    }
	
	/**
	 * KIPRIS 국내/국외 구분 가져오기
	 * @param file
	 * @return
	 * @throws IOException
	 */
	private String getKindNA() throws IOException {

		HSSFWorkbook wb   = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet   = wb.getSheetAt(0);
	    HSSFRow row       = sheet.getRow(0);
	    String headerName = "";
	    String DBName     = "KIPRIS_N";
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case HSSFCell.CELL_TYPE_STRING:
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

		HSSFWorkbook wb   = new HSSFWorkbook(new FileInputStream(file));
		HSSFSheet sheet   = wb.getSheetAt(0);
	    HSSFRow row       = sheet.getRow(0);
	    String headerName = "";
	    for(Cell cell : row) {
	    	switch (cell.getCellType()) {
	    		case HSSFCell.CELL_TYPE_STRING:
	    			headerName = cell.getRichStringCellValue().getString();
	    			titleArr[cell.getColumnIndex()] = headerName;
	    			break;
				default:
					break;					
	    	}
	    }
	}
}