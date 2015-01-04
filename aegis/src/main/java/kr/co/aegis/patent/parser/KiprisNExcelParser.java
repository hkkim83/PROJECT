package kr.co.aegis.patent.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.util.StringUtil;

public class KiprisNExcelParser extends ExcelParser {
	
	/**
	 * 업로드 파일이 KIPRIS_N일 경우
	 * @param list
	 * @return
	 */
	public List<Map<String, String>> parse(List<Map<String, String>> list) {
		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		for(Map<String, String> map : list) {
			Map<String, String> saveMap = copyMap(map, ExcelHeader.DBMAP_KIPRIS_N);

			String regiNum          = saveMap.get("REGI_NUM");				// 등록번호
			String applNum          = saveMap.get("APPL_NUM");				// 출원번호
			String laidPublicNum    = saveMap.get("LAID_PUBLIC_NUM");		// 공개번호
			String regiDate         = saveMap.get("REGI_DATE");				// 등록일자
			String applDate         = saveMap.get("APPL_DATE");				// 출원일자
			String laidPublicDate   = saveMap.get("LAID_PUBLIC_DATE");		// 공개일자
			String natlCode         = getNatlCode(applNum);					// 국가코드
			String kindsIpType      = getKindsIpType(applNum);				// 특실구분

			// N01. 국가코드
			saveMap.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			saveMap.put("KINDS_IP_CODE", getKindsIpCode(regiNum, laidPublicNum, kindsIpType));
			// N03. 특허/실용 구분
			saveMap.put("KINDS_IP_TYPE", kindsIpType);
			// N04. 출원번호
			saveMap.put("APPL_NUM", getApplNum(applNum));
			// N05. 출원일
			saveMap.put("APPL_DATE", replaceString(applDate, "[.]", ""));
			// N06. 공개번호
			saveMap.put("LAID_PUBLIC_NUM", getLaidPublicNum(laidPublicNum));
			// N07. 공개일
			saveMap.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "[.]", ""));
			// N10. 등록번호
			saveMap.put("REG_NUM", getRegiNum(regiNum));
			// N11. 등록일
			saveMap.put("REGI_DATE", replaceString(regiDate, "[.]", ""));
			// N12. 출원인
			saveMap.put("APPLICANT", getApplicant(saveMap.get("APPLICANT")));
			// N22. IPC-ALL
			saveMap.put("IPC_ALL", getIpcAll(saveMap.get("IPC_ALL")));
			// N23. 대표청구항
			saveMap.put("CLAIM_MAIN", getClaimMain(saveMap.get("CLAIM_MAIN")));
			
			// 출원번호_원본(2014.03.17추가)
			saveMap.put("APPL_NUM_ORG", replaceString(applNum, "-", ""));
			saveList.add(saveMap);
		}
		return saveList;
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
			String first = applicant.split("|")[0];
			result = StringUtil.subStr(first, first.lastIndexOf('(') > -1 ? first.lastIndexOf('(') : first.length());
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
		if(StringUtil.isNull(ipcAll)) {
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
