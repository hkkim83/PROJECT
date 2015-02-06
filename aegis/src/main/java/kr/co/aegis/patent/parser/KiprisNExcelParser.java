package kr.co.aegis.patent.parser;

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
			String regiNum          = map.get("REGI_NUM");				// 등록번호
			String applNum          = map.get("APPL_NUM");				// 출원번호
			String laidPublicNum    = map.get("LAID_PUBLIC_NUM");		// 공개번호
			String regiDate         = map.get("REGI_DATE");				// 등록일자
			String applDate         = map.get("APPL_DATE");				// 출원일자
			String laidPublicDate   = map.get("LAID_PUBLIC_DATE");		// 공개일자
			String natlCode         = getNatlCode(applNum);				// 국가코드
			String kindsIpType      = getKindsIpType(applNum);			// 특실구분

			// N01. 국가코드
			map.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			map.put("KINDS_IP_CODE", getKindsIpCode(regiNum, laidPublicNum, kindsIpType));
			// N03. 특허/실용 구분
			map.put("KINDS_IP_TYPE", kindsIpType);
			// N04. 출원번호
			map.put("APPL_NUM", getApplNum(applNum));
			// N05. 출원일
			map.put("APPL_DATE", replaceString(applDate, "[.]", ""));
			// N06. 공개번호
			map.put("LAID_PUBLIC_NUM", getLaidPublicNum(laidPublicNum));
			// N07. 공개일
			map.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "[.]", ""));
			// N10. 등록번호
			map.put("REGI_NUM", getRegiNum(regiNum));
			// N11. 등록일
			map.put("REGI_DATE", replaceString(regiDate, "[.]", ""));
			// N12. 출원인
			map.put("APPLICANT", getApplicant(map.get("APPLICANT")));
			// N22. IPC-ALL
			map.put("IPC_ALL", getIpcAll(map.get("IPC_ALL")));
			// N23. 대표청구항
			map.put("CLAIM_MAIN", getClaimMain(map.get("CLAIM_MAIN")));
			
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
	 * 문헌종류코드
	 * @param regiNum
	 * @param laidPublicNum
	 * @param kindsIpType
	 * @return
	 */
	private String getKindsIpCode(String regiNum, String laidPublicNum, String kindsIpType) {
		String result = "";
		if(!StringUtil.isNull(regiNum)) {
			result = "P".equals(kindsIpType) ? "B" : "Y";
		} else if(!StringUtil.isNull(laidPublicNum)) {
			result = "P".equals(kindsIpType) ? "A" : "U";
		}
		return result;
	}
	
	/**
	 * 특허/실용 구분
	 * @param applNum
	 * @return
	 */
	private String getKindsIpType(String applNum) {
		String result = "";
		if(!StringUtil.isNull(applNum))
		{
			result = applNum.startsWith("10") ? "P" : "U";
		}
		return result;
	}
	
	/**
	 * 출원번호
	 * @param applNum
	 * @return
	 */
	private String getApplNum(String applNum) {
		return StringUtil.isNull(applNum) ? "" : StringUtil.subStr(applNum, -12);
	}
	
	/**
	 * 공개번호
	 * @param laidPublicNum
	 * @return
	 */
	private String getLaidPublicNum(String laidPublicNum) {
		return StringUtil.isNull(laidPublicNum) ? "" : StringUtil.subStr(laidPublicNum, -12);
	}
	
	/**
	 * 등록번호
	 * @param regiNum
	 * @return
	 */
	private String getRegiNum(String regiNum) {
		return StringUtil.isNull(regiNum) ? "" : StringUtil.subStr(regiNum, 4, 10);
	}
	
	/**
	 * 출원인
	 * @param applicant
	 * @return
	 */
	private String getApplicant(String applicant) {
		String result = "";
		if(!StringUtil.isNull(applicant)) {
			String first = applicant.split("[|]")[0];
			result = StringUtil.subStr(first, first.lastIndexOf('(') > -1 ? first.lastIndexOf('(') : first.length());
			// 2015.01.12 추가, ()가 2개 이상이고, (주)로 시작하지 않으면 나머지 괄호도 삭제
			if(result.lastIndexOf('(') > 0)
				result = StringUtil.subStr(result, result.lastIndexOf('('));
		}
		return result;
	}
	
	/**
	 * IPC-ALL
	 * @param ipcAll
	 * @return
	 */
	private String getIpcAll(String ipcAll) {
		String result = "";
		if(!StringUtil.isNull(ipcAll)) {
			String first = ipcAll.split(",")[0];
			result = StringUtil.subStr(first, first.lastIndexOf('(') > -1 ? first.lastIndexOf('(') : first.length());
		}
		return result;
	}

	/**
	 * 대표청구항
	 * @param claimMain
	 * @return
	 */
	private String getClaimMain(String claimMain) {
		return StringUtil.isNull(claimMain) ? "" : StringUtil.parseClaim(claimMain);
	}
}
