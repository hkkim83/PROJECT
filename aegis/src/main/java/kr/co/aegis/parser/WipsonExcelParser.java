package kr.co.aegis.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.util.StringUtil;

public class WipsonExcelParser extends ExcelParser {
	
	public List<Map<String, String>> parse(List<Map<String, String>> list) {
		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		for(Map<String, String> map : list) {
			Map<String, String> saveMap = copyMap(map, ExcelHeader.DBMAP_WIPSON);
			String regiDate         = saveMap.get("REGI_DATE");				// 등록일자
			String applDate         = saveMap.get("APPL_DATE");				// 출원일자
			String laidPublicDate   = saveMap.get("LAID_PUBLIC_DATE");		// 공개일자
			String natlCode         = saveMap.get("NATL_CODE");				// 국가코드
			String applNum          = saveMap.get("APPL_NUM");				// 출원번호
			String kindsIpType      = saveMap.get("KINDS_IP_TYPE");			// 

			// 날짜 포맷 변경
			saveMap.put("APPL_DATE", replaceString(applDate, "-", ""));
			saveMap.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "-", ""));
			saveMap.put("REGI_DATE", replaceString(regiDate, "-", ""));
			
			// 출원번호_원본(2014.03.12 추가)
			saveMap.put("APPL_NUM_ORG", getApplNumOrg(natlCode, applNum, kindsIpType));	
			
			// 요약, 대표 청구항 정리
			saveList.add(saveMap);
		}
		return saveList;
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
