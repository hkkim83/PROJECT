package kr.co.aegis.patent2.parser;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;

public class WipsonExcelParser extends ExcelParser {
	
	public void parse(List<Map<String, String>> list) {
		for(Map<String, String> map : list) {
			String regiDate         = map.get("REGI_DATE");				// 등록일자
			String applDate         = map.get("APPL_DATE");				// 출원일자
			String openDate   		= map.get("OPEN_DATE");				// 공개일자
			String laidPublicDate   = map.get("LAID_PUBLIC_DATE");		// 공고일자
			String natlCode         = map.get("NATL_CODE");				// 국가코드
			String regiNum          = map.get("REGI_NUM");				// 등록번호
			String applNum          = map.get("APPL_NUM");				// 출원번호
			String openNum          = map.get("OPEN_NUM");				// 공개번호
			String laidPublicNum    = map.get("LAID_PUBLIC_NUM");		// 공고번호
			String kindsIpType      = map.get("KINDS_IP_TYPE");			// 특실구분

			// 날짜 포맷 변경
			map.put("APPL_DATE", StringUtil.replaceString(applDate, "-", ""));
			map.put("OPEN_DATE", StringUtil.replaceString(openDate, "-", ""));
			map.put("LAID_PUBLIC_DATE", StringUtil.replaceString(laidPublicDate, "-", ""));
			map.put("REGI_DATE", StringUtil.replaceString(regiDate, "-", ""));
			
			// 문서번호 조회를 위한 값 설정 (2015.02.02 추가)
			map.put("KIPRIS_APPL_NUM", getKiprisApplNum(natlCode, applNum, kindsIpType));
			map.put("KIPRIS_OPEN_NUM", getKiprisOpenNum(natlCode, openNum));
			map.put("KIPRIS_REGI_NUM", getKiprisRegiNum(natlCode, regiNum));
		}
	}

	/**
	 * API호출을 위한 출원번호 만들기 
	 * @param natlCode
	 * @param applNum
	 * @return
	 */
	private String getKiprisApplNum(String natlCode, String applNum, String kindsIpType) {
		String result = null;
		if(StringUtil.isNull(applNum)) return result;
		String newApplNum = StringUtil.replaceString(applNum,"-", "");	// '-' 삭제후 숫자만 남은 출원번호
		if("KR".equals(natlCode)) {
			if("P".equals(kindsIpType))
				result = "10"+newApplNum;
			else
				result = "20"+newApplNum;			
		} else if("JP".equals(natlCode)) {
			String year = StringUtil.subStr(newApplNum, 4);
			int iYY = Integer.parseInt(year);			
			if(iYY <= 1988) {	// 1988년 이하일 경우 
				iYY -= 1925;
			} else {				// 1988년 초과일 경우 
				iYY -= 1988;
			}
			year = StringUtil.lpad(String.valueOf(iYY), 2, "0");
			result = year + StringUtil.subStr(newApplNum, -6);	// 뒤 6자리 
		} else {
			result = newApplNum;
		}
		return result;
	}
	
	
	/**
	 * API호출을 위한 공개번호 만들기 
	 * @param natlCode
	 * @param applNum
	 * @return
	 */
	private String getKiprisOpenNum(String natlCode, String laidPublicNum) {
		String result = null;
		String newLaidPublicNum = StringUtil.replaceString(laidPublicNum,"-", "");		// 하이픈 제거 후 공개번호
		if(StringUtil.isNull(laidPublicNum)) return result;
		
		if("CN".equals(natlCode)) {
			result = new DecimalFormat("0").format(new BigDecimal(laidPublicNum));		// 앞자리 '0' 없애기  
		} else if("WO".equals(natlCode)) {
			result = newLaidPublicNum.substring(2, newLaidPublicNum.length());	// 앞 2자리 삭제 
		} else {
			result = StringUtil.lpad(newLaidPublicNum, 8, "0");
		}
		return result;
	}
	
	
	/**
	 * API호출을 위한 등록번호 만들기 
	 * @param natlCode
	 * @param applNum
	 * @return
	 */
	private String getKiprisRegiNum(String natlCode, String regiNum) {
		String result = null;
		String newRegiNum = StringUtil.replaceString(regiNum,"-", "");		// 하이픈 제거 후 등록번호 
		if(StringUtil.isNull(regiNum)) return result;
		
		if("CN".equals(natlCode)) {
			result = new DecimalFormat("0").format(new BigDecimal(regiNum));		// 앞자리 '0' 없애기  
		} else {
			result = StringUtil.lpad(newRegiNum, 8, "0");
		}
		return result;
	}
}
