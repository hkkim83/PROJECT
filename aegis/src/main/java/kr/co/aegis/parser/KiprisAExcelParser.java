package kr.co.aegis.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.util.StringUtil;

public class KiprisAExcelParser extends ExcelParser {
	
	/**
	 * 업로드 파일이 KIPRIS_A일 경우
	 * @param list
	 * @return
	 */
	public List<Map<String, String>> parse(List<Map<String, String>> list) {

		List<Map<String, String>> saveList = new ArrayList<Map<String, String>>();
		for(Map<String, String> map : list) {
			Map<String, String> saveMap = copyMap(map, ExcelHeader.DBMAP_KIPRIS_A);

			String regiNum          = saveMap.get("REGI_NUM");					// 등록번호
			String applNum          = saveMap.get("APPL_NUM");					// 출원번호
			String laidPublicNum    = saveMap.get("LAID_PUBLIC_NUM");			// 공개번호
			String regiDate         = saveMap.get("REGI_DATE");					// 등록일자
			String applDate         = saveMap.get("APPL_DATE");					// 출원일자
			String laidPublicDate   = saveMap.get("LAID_PUBLIC_DATE");			// 공개일자
			String natlCode         = getNatlCode(saveMap.get("NATL_CODE"));	// 국가코드
			String kindsIpType      = getKindsIpType(natlCode, applNum);		// 특실구분

			// N01. 국가코드
			saveMap.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			saveMap.put("KINDS_IP_CODE", getKindsIpCode(regiNum, laidPublicNum, kindsIpType));
			// N03. 특허/실용 구분
			saveMap.put("KINDS_IP_TYPE", kindsIpType);
			// N04. 출원번호
			saveMap.put("APPL_NUM", getApplNum(natlCode, applNum, applDate));
			// N05. 출원일
			saveMap.put("APPL_DATE", replaceString(applDate, "[.]", ""));
			// N06. 공개번호
			saveMap.put("LAID_PUBLIC_NUM", getLaidPublicNum(natlCode, laidPublicNum, laidPublicDate, applNum));
			// N07. 공개일
			saveMap.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "[.]", ""));
			// N10. 등록번호
			saveMap.put("REG_NUM", getRegiNum(natlCode, regiNum, regiDate, laidPublicNum));
			// N11. 등록일
			saveMap.put("REGI_DATE", replaceString(regiDate, "[.]", ""));
			// N12. 출원인
			saveMap.put("APPLICANT", getApplicant(saveMap.get("APPLICANT")));
			// N22. IPC-ALL
			saveMap.put("IPC_ALL", getIpcAll(saveMap.get("IPC_ALL")));
			
			saveList.add(saveMap);
		}
		return saveList;
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
	private String getKindsIpType(String natlCode, String applNum) {
		String result = "";
		if(!StringUtil.isNull(applNum))
		{
			if("CN".equals(natlCode)) {
				if("20".equals(StringUtil.subStr(applNum, 2)) || "0020".equals(StringUtil.subStr(applNum, 4)))
					result = "U";
				else
					result = "P";
			} else {
				result = "P";
			}
		}
		return result;
	}
	
	/**
	 * 출원번호
	 * @param applNum
	 * @return
	 */
	private String getApplNum(String natlCode, String applNum, String applDate) {
		String result = "";
		if(!StringUtil.isNull(natlCode) && !StringUtil.isNull(applNum)) {
			String applYear = StringUtil.subStr(applDate, 4);
			if("EP".equals(natlCode)){
				int len = applNum.lastIndexOf(".") > -1 ? applNum.lastIndexOf(".") : applNum.length();
				String newApplNum = StringUtil.subStr(applNum, len);
				if(newApplNum.length() == 8) {
					if(Integer.parseInt(StringUtil.subStr(applNum,1)) < 3)
						applYear = "20"+StringUtil.subStr(applNum,2);
					else 
						applYear = "19"+StringUtil.subStr(applNum, 2);
				} else if(newApplNum.length() == 7) {
					if(Integer.parseInt(applYear) > 1990)
						applYear = "200"+StringUtil.subStr(applNum, 1);
					else if(Integer.parseInt(StringUtil.subStr(applNum,1)) >= 3)
						applYear = "19"+StringUtil.subStr(applNum, 2);
					else 	
						applYear = "20"+StringUtil.subStr(applNum,2);
				}
				result = applYear+"-"+StringUtil.subStr(applNum, -6);
			} else if("US".equals(natlCode)){	
				result = applYear+"-"+StringUtil.subStr(applNum, -6);
			} else if("WO".equals(natlCode)){	
				result = "PCT-"+StringUtil.subStr(applNum, 6)+"-"+StringUtil.subStr(applNum, -6);
			} else if("JP".equals(natlCode)){	
				if(applNum.length() < 8) 
					result = 1988+Integer.parseInt(StringUtil.subStr(applNum,1))+"-"+StringUtil.subStr(applNum, -6);
				else 
				{
					if(applNum.length() == 8 && Integer.parseInt(StringUtil.subStr(applNum,2)) < 30)
						result = 1988+Integer.parseInt(StringUtil.subStr(applNum,2))+"-"+StringUtil.subStr(applNum, -6);
					else 
						result = 1925+Integer.parseInt(StringUtil.subStr(applNum,2))+"-"+StringUtil.subStr(applNum, -6);
				}				
			} else if("CN".equals(natlCode)){	
				if(applNum.length() > 10)
					result = StringUtil.subStr(applNum, 4)+"-"+StringUtil.subStr(applNum, -8);
				else 
					result = "19"+StringUtil.subStr(applNum, 2)+"-"+StringUtil.lpad(StringUtil.subStr(applNum, -6), 8, "0");
			} else {
				result = applNum;
			}
		}
	
		return result;
	}
	
	/**
	 * 공개번호
	 * @param laidPublicNum
	 * @return
	 */
	private String getLaidPublicNum(String natlCode, String laidPublicNum, String laidPublicDate, String applNum) {
		String result = "";
		if(!StringUtil.isNull(laidPublicNum)) {
			String laidPublicYear = StringUtil.subStr(laidPublicDate, 4); 
			if("JP".equals(natlCode)){
				if(laidPublicNum.length() < 8) 
					result = 1988+Integer.parseInt(StringUtil.subStr(laidPublicNum,1))+"-"+StringUtil.subStr(laidPublicNum, -6);
				else 
				{
					if(laidPublicNum.length() == 8 && Integer.parseInt(StringUtil.subStr(laidPublicNum,2)) < 30)
						result = 1988+Integer.parseInt(StringUtil.subStr(laidPublicNum,2))+"-"+StringUtil.subStr(laidPublicNum, -6);
					else 
						result = 1925+Integer.parseInt(StringUtil.subStr(laidPublicNum,2))+"-"+StringUtil.subStr(laidPublicNum, -6);
				}
			} else if("US".equals(natlCode)){	
				result = laidPublicYear+"-"+StringUtil.subStr(laidPublicNum, -7);
			} else if("EP".equals(natlCode)){	
				result = StringUtil.lpad(laidPublicNum, 7, "0");
			} else if("WO".equals(natlCode)){	
				result = "WO"+StringUtil.subStr(laidPublicNum, 4)+"-"+StringUtil.subStr(laidPublicNum, -6);			
			} else if("CN".equals(natlCode)){	
				if(Integer.parseInt(laidPublicYear) < 1990) {
					result = applNum;
				} else {
					result = StringUtil.lpad(laidPublicNum, 9, "0");
				}
			} else {
				result = laidPublicNum;
			}
		}
		return result;
	}
	
	/**
	 * 등록번호
	 * @param regiNum
	 * @return
	 */
	private String getRegiNum(String natlCode, String regiNum, String regiDate, String laidPublicNum) {
		String result = "";
		if(!StringUtil.isNull(regiNum) && !regiNum.equals(laidPublicNum)) {
			if("CN".equals(natlCode)) {
				result = StringUtil.lpad(regiNum, 9, "0");
			} else if("US".equals(natlCode)) {
				result = regiNum;
			} else if("EP".equals(natlCode)) {
				result = StringUtil.lpad(regiNum, 7, "0");
			}
		}
		return result;
	}
	
	/**
	 * 출원인
	 * @param applicant
	 * @return
	 */
	private String getApplicant(String applicant) {
		String result = "";
		if(!StringUtil.isNull(applicant)) {
			result = StringUtil.subStr(applicant, applicant.indexOf('(') > -1 ? applicant.indexOf('(') : applicant.length());
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
			result = StringUtil.subStr(first, first.indexOf('(') > -1 ? first.indexOf('(') : first.length());
		}
		return result;
	}
}
