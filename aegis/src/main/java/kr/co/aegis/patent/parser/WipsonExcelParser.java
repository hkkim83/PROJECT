package kr.co.aegis.patent.parser;

import java.util.List;
import java.util.Map;

import kr.co.aegis.util.StringUtil;

public class WipsonExcelParser extends ExcelParser {
	
	public void parse(List<Map<String, String>> list) {
		for(Map<String, String> map : list) {
			String regiDate         = map.get("REGI_DATE");				// 등록일자
			String applDate         = map.get("APPL_DATE");				// 출원일자
			String laidPublicDate   = map.get("LAID_PUBLIC_DATE");		// 공개일자
			String natlCode         = map.get("NATL_CODE");				// 국가코드
			String applNum          = map.get("APPL_NUM");				// 출원번호
			String kindsIpType      = map.get("KINDS_IP_TYPE");			// 

			// 날짜 포맷 변경
			map.put("APPL_DATE", replaceString(applDate, "-", ""));
			map.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "-", ""));
			map.put("REGI_DATE", replaceString(regiDate, "-", ""));
			
			// 출원번호_원본(2014.03.12 추가)
			map.put("APPL_NUM_ORG", getApplNumOrg(natlCode, applNum, kindsIpType));	
		}
	}
	
	/**
	 * 출원번호 원본
	 * @param natlCode
	 * @param applNum
	 * @param applDate
	 * @return
	 */
	private String getApplNumOrg(String natlCode, String applNum, String kindsIpType) {
		String result = "";
		if(StringUtil.isNull(applNum) && !"KR".equals(natlCode)) {
			result = applNum;
		} else {
			String newApplNum = applNum.replaceAll("-", "");	// '-' 삭제후 숫자만 남은 출원번호
			if(kindsIpType.equals("P"))
				result = "10"+newApplNum;
			else
				result = "20"+newApplNum;
		}
		return result;
	}
}
