package kr.co.aegis.patent2.parser;

import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;

public class KiprisNExcelParser extends ExcelParser {
	
	/**
	 * 업로드 파일이 KIPRIS_N일 경우
	 * @param list
	 * @return
	 */
	public void parse(List<Map<String, String>> list) {
		for(Map<String, String> map : list) {
			String regiNum          	= map.get("REGI_NUM");				// 등록번호
			String applNum         	= map.get("APPL_NUM");				// 출원번호
			String openNum			= map.get("OPEN_NUM");				// 공개번호
			String laidPublicNum    	= map.get("LAID_PUBLIC_NUM");		// 공고번호
			String regiDate        	= map.get("REGI_DATE");				// 등록일자
			String applDate         	= map.get("APPL_DATE");				// 출원일자
			String openDate   		= map.get("OPEN_DATE");				// 공고일자
			String laidPublicDate   	= map.get("LAID_PUBLIC_DATE");		// 공개일자
			String natlCode         	= getNatlCode(applNum);				// 국가코드
			String kindsIpType      	= getKindsIpType(applNum);			// 특실구분

			// N01. 국가코드
			map.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			map.put("KINDS_IP_CODE", getKindsIpCode(regiNum));
			// N03. 특허/실용 구분
			map.put("KINDS_IP_TYPE", kindsIpType);
			// N05. 출원일
			map.put("APPL_DATE", replaceString(applDate, "[.]", ""));
			// N07. 공개일
			map.put("OPEN_DATE", replaceString(openDate, "[.]", ""));
			// N05. 공고일
			map.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "[.]", ""));
			// N11. 등록일
			map.put("REGI_DATE", replaceString(regiDate, "[.]", ""));
			
			// 문서번호 조회를 위한 값 설정 (2015.02.02 추가)
			map.put("KIPRIS_APPL_NUM", replaceString(applNum, "-", ""));
			map.put("KIPRIS_OPEN_NUM", null);
			map.put("KIPRIS_REGI_NUM", null);
		}
	}
	
	/**
	 * 국가번호
	 * @param applNum
	 * @return
	 */
	private String getNatlCode(String applNum) {
		return StringUtil.isNull(applNum) ? "" : "KR";
	}
	
	/**
	 * 특허/실용 구분
	 * @param applNum
	 * @return
	 */
	private String getKindsIpType(String applNum) {
		String result = "";
		if(!StringUtil.isNull(applNum)) {
			result = applNum.startsWith("10") ? "P" : "U";
		}
		return result;
	}
	
	/**
	 * 문헌종류코드
	 * @param regiNum
	 * @return
	 */
	private String getKindsIpCode(String regiNum) {
		return !StringUtil.isNull(regiNum) ? "B" : "A";
	}
}
