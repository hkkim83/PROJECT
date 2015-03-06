package kr.co.aegis.patent2.parser;

import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;

public class KiprisAExcelParser extends ExcelParser {
	
	/**
	 * 업로드 파일이 KIPRIS_A일 경우
	 * @param list
	 * @return
	 */
	public void parse(List<Map<String, String>> list) {
		for(Map<String, String> map : list) {
			String regiNum          	= map.get("REGI_NUM");					// 등록번호
			String applNum          	= map.get("APPL_NUM");					// 출원번호
			String openNum			= map.get("OPEN_NUM");					// 공개번호
			String laidPublicNum    	= map.get("LAID_PUBLIC_NUM");			// 공고번호
			String regiDate         	= map.get("REGI_DATE");					// 등록일자
			String applDate         	= map.get("APPL_DATE");					// 출원일자
			String openDate   		= map.get("OPEN_DATE");					// 공고일자
			String laidPublicDate   	= map.get("LAID_PUBLIC_DATE");			// 공개일자
			String natlCode         	= getNatlCode(map.get("NATL_CODE"));		// 국가코드
			String kindsIpType      	= getKindsIpType(natlCode);				// 특실구분

			// N01. 국가코드
			map.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			map.put("KINDS_IP_CODE", getKindsIpCode(regiNum, natlCode));
			// N03. 특허/실용 구분
			map.put("KINDS_IP_TYPE", kindsIpType);
			// N05. 출원일
			map.put("APPL_DATE", StringUtil.replaceString(applDate, "[.]", ""));
			// N06. 공개일
			map.put("OPEN_DATE", StringUtil.replaceString(openDate, "[.]", ""));
			// N07. 공고일
			map.put("LAID_PUBLIC_DATE", StringUtil.replaceString(laidPublicDate, "[.]", ""));
			// N11. 등록일
			map.put("REGI_DATE", StringUtil.replaceString(regiDate, "[.]", ""));
			// N11. 우선권주장일 
			map.put("PRIORITY_DATE", StringUtil.replaceString(map.get("PRIORITY_DATE"), "[.]", ""));
			
			// 문서번호 조회를 위한 값 설정 (2015.02.02 추가)
			map.put("KIPRIS_APPL_NUM", null);
			map.put("KIPRIS_OPEN_NUM", getKiprisOpenNum(natlCode, openNum));
			map.put("KIPRIS_REGI_NUM", getKiprisRegiNum(natlCode, regiNum));
		}
	}
	
	/**
	 * 국가번호
	 * @param natlCode
	 * @return
	 */
	private String getNatlCode(String natlCode) {
		return "PJ".equals(natlCode) ? "JP" : natlCode;
	}
	
	/**
	 * 문헌종류코드
	 * @param regiNum
	 * @param natlCode
	 * @return
	 */
	private String getKindsIpCode(String regiNum, String natlCode) {
		String result = "";
		if("WO".equals(natlCode))
			result = "A";
		else
			result = !StringUtil.isNull(regiNum) ? "B" : "A";
		return result;
	}
	
	/**
	 * 특허/실용 구분
	 * @param natlCode
	 * @return
	 */
	private String getKindsIpType(String natlCode) {
		return "P";
	}
	
	/**
	 * API호출을 위한 공개번호 만들기 
	 * @param natlCode
	 * @param openNum
	 * @return
	 */
	private String getKiprisOpenNum(String natlCode, String openNum) {
		String result = null;
		if(StringUtil.isNull(openNum)) return result;
		
		if("US".equals(natlCode) || "WO".equals(natlCode) || "CN".equals(natlCode)) {
			result = openNum;
		} else if("EP".equals(natlCode) || "JP".equals(natlCode)) {
			result = StringUtil.lpad(openNum, 8, "0");
		}
		return result;
	}
	
	/**
	 * API호출을 위한 등록번호 만들기 
	 * @param natlCode
	 * @param regiNum
	 * @return
	 */
	private String getKiprisRegiNum(String natlCode, String regiNum) {
		String result = null;
		if(StringUtil.isNull(regiNum)) return result;
		
		if("CN".equals(natlCode)) {
			result = regiNum;
		} else if("EP".equals(natlCode) || "US".equals(natlCode) || "JP".equals(natlCode)) {
			result = StringUtil.lpad(regiNum, 8, "0");
		}
		return result;
	}
}
