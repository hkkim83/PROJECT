package kr.co.aegis.patent2.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.co.aegis.patent.header.ExcelHeader;
import kr.co.aegis.util.StringUtil;

public class FocustExcelParser extends ExcelParser {
		
	/**
	 * 업로드 파일이 FOCUST일 경우
	 * @param list
	 * @return
	 */
	
	/**
	 * 업로드 파일이 KIPRIS_A일 경우
	 * @param list
	 * @return
	 */
	public void parse(List<Map<String, String>> list) {
		for(Map<String, String> map : list) {
			String regiNum          = map.get("REGI_NUM");				// 등록번호
			String applNum          = map.get("APPL_NUM");				// 출원번호
			String laidPublicNum    = map.get("LAID_PUBLIC_NUM");		// 공개번호
			String priorityNum      = map.get("PRIORITY_NUM");			// 우선권번호
			String regiDate         = map.get("REGI_DATE");				// 등록일자
			String applDate         = map.get("APPL_DATE");				// 출원일자
			String laidPublicDate   = map.get("LAID_PUBLIC_DATE");		// 공개일자
			String noticePublicDate = map.get("A_26");						// 공고일자(업로드데이터)
			String natlCode         = getNatlCode(applNum);					// 국가코드
			String kindsIpType      = getKindsIpType(natlCode, applNum);	// 특실구분

			// N01. 국가코드
			map.put("NATL_CODE", natlCode);
			// N02. 문헌종류코드
			map.put("KINDS_IP_CODE", getKindsIpCode(regiNum, kindsIpType));
			// N03. 특허/실용 구분
			map.put("KINDS_IP_TYPE", kindsIpType);
			// N04. 출원번호
			map.put("APPL_NUM", getApplNum(natlCode, applNum, applDate));
			// N05. 출원일
			map.put("APPL_DATE", replaceString(applDate,"[.]", ""));
			// N06. 공개번호
			map.put("LAID_PUBLIC_NUM", getLaidPublicNum(natlCode, laidPublicNum, laidPublicDate));
			// N07. 공개일
			map.put("LAID_PUBLIC_DATE", replaceString(laidPublicDate, "[.]", ""));
			// N10. 등록번호
			map.put("REG_NUM", getRegiNum(natlCode, regiNum));
			// N11. 등록일
			map.put("REGI_DATE", getRegiDate(natlCode, regiDate, noticePublicDate));
			// N12. 출원인
			map.put("APPLICANT", getApplicant(natlCode, map));
			// N13. 우선권번호
			map.put("PRIORITY_NUM", getPriorityNum(priorityNum));
			// N14. 우선권국가
			map.put("PRIORITY_NATL", getPriorityNatl(priorityNum));
			// N15. 우선권일자
			map.put("PRIORITY_DATE", getPriorityDate(priorityNum));
			// N16. 자국인용특허
			map.put("BC_BE_NUM", replaceString(map.get("BC_BE_NUM"), ",","|"));			
			// N17. 자국피인용특허
			map.put("FC_FE_NUM", replaceString(map.get("FC_FE_NUM"), ",","|"));		
			// N18. INPADOC 패밀리
			map.put("FM_NUM", replaceString(map.get("FM_NUM"), ",","|"));	
			// 출원번호_원본(2014.03.08 추가)
			map.put("APPL_NUM_ORG", getApplNumOrg(natlCode, applNum, kindsIpType));	
		}
	}
	
	/**
	 * 국가코드
	 * @param applNum
	 * @return
	 */
	private String getNatlCode(String applNum) {
		String result = StringUtil.subStr(applNum, 2);
		return result;
	}
	
	/**
	 * 문헌종류코드
	 * @param natlCode
	 * @param applNum
	 * @return
	 */
	private String getKindsIpCode(String regiNum, String kindsIpType) {
		String result = "";
		if(!StringUtil.isNull(regiNum)) {
			if("P".equals(kindsIpType) || StringUtil.isNull(kindsIpType)) {
				result = "B";
			} else {
				result = "Y";
			} 
		} else {
			if("P".equals(kindsIpType) || StringUtil.isNull(kindsIpType)) {
				result = "A";
			} else {
				result = "U";
			} 
		}
		return result;	
	}


	/**
	 * 특허/실용 구분
	 * @param regiNum
	 * @param laidPublicNum
	 * @return
	 */
	private String getKindsIpType(String natlCode, String applNum) {
		String result = "";
		if(!StringUtil.isNull(applNum) && ("KR".equals(natlCode) || "JP".equals(natlCode))) {
			if("U".equals(StringUtil.subStr(applNum, -1)))
				result = "U";
			else 
				result = "P";
		}
		return result;
	}
	
	/**
	 * 출원번호 
	 * @param natlCode
	 * @param applNum
	 * @param applDate
	 * @return
	 */
	private String getApplNum(String natlCode, String applNum, String applDate) {
		String result = "";
		
		if(StringUtil.isNull(applNum)) {
			result = applNum;
		} else {			
			String newApplNum = applNum.replaceAll("[A-z]", "");	// 영문삭제후 숫자만 남은 출원번호
			if("JP".equals(natlCode)) {
				if(newApplNum.length() == 10) {
					result = StringUtil.subStr(newApplNum, 4)+"-"+StringUtil.subStr(newApplNum, -6);
				} else {
					String YY = StringUtil.subStr(newApplNum, 2);
					int newApplYear = 1988+Integer.parseInt(YY);
					result = String.valueOf(newApplYear)+"-"+StringUtil.subStr(newApplNum, -6);
				}					
			} else if("US".equals(natlCode)) {
				String applYear = applDate.substring(0,4);
				result = applYear+"-"+StringUtil.subStr(newApplNum, -6);
			} else if("EP".equals(natlCode)) {
				result = StringUtil.subStr(newApplNum, 4)+"-"+StringUtil.subStr(newApplNum, -6);
				
			} else if("KR".equals(natlCode)) {
				result = StringUtil.subStr(newApplNum, 4)+"-"+StringUtil.subStr(newApplNum, -7);
				
			} else if("CN".equals(natlCode)) {
				if(newApplNum.length() == 10)
					newApplNum = StringUtil.rpad(newApplNum, 8, "0");
				result = StringUtil.subStr(newApplNum, 4)+"-"+StringUtil.subStr(newApplNum, -8);
			} else {
				result = applNum;
			}
		}
		return result;
	}
	
	/**
	 * 공개번호
	 * @param natlCode
	 * @param laidPublicNum
	 * @param laidPublicDate
	 * @return
	 */
	private String getLaidPublicNum(String natlCode, String laidPublicNum, String laidPublicDate) {
		String result = "";
		
		if(StringUtil.isNull(laidPublicNum)) {
			result = laidPublicNum;
		} else {
			int laidPublicNumLen = laidPublicNum.lastIndexOf("A") > -1 ? laidPublicNum.lastIndexOf("A") : laidPublicNum.length();
			String newLaidPublicNum = (StringUtil.subStr(laidPublicNum, laidPublicNumLen)).replaceAll("[A-z]", "");		// 문자제거	
			
			if("JP".equals(natlCode)) {
				String YY = StringUtil.subStr(newLaidPublicNum, 2);
				int iYY = Integer.parseInt(YY);
				if(laidPublicNum.startsWith("JPWO")) {
					if(iYY < 30)
						result = "WO20"+YY+"-"+StringUtil.subStr(newLaidPublicNum, -6);
					else 
						result = "WO19"+YY+"-"+StringUtil.subStr(newLaidPublicNum, -6);
				} else {
					if(newLaidPublicNum.length() == 10) {
						result = StringUtil.subStr(newLaidPublicNum, 4)+"-"+StringUtil.subStr(newLaidPublicNum, -6);
					} else {
						if(iYY > 40)
							result = String.valueOf(1925+iYY)+"-"+StringUtil.subStr(newLaidPublicNum, -6);
						else 
							result = String.valueOf(1988+iYY)+"-"+StringUtil.subStr(newLaidPublicNum, -6);
					}
				}			
			} else if("US".equals(natlCode)) {
				String laidPublicYear = StringUtil.isNull(laidPublicDate) ? laidPublicDate : laidPublicDate.substring(0,4);
				result = laidPublicYear+"-"+StringUtil.subStr(newLaidPublicNum, -7);
				
			} else if("EP".equals(natlCode)) {
				result = StringUtil.subStr(newLaidPublicNum, -7);
				
			} else if("KR".equals(natlCode)) {
				result = StringUtil.subStr(newLaidPublicNum, 4)+"-"+StringUtil.subStr(newLaidPublicNum, -7);
				
			} else if("CN".equals(natlCode)) {
				newLaidPublicNum = StringUtil.rpad(newLaidPublicNum, 9, "0");
				result = StringUtil.subStr(newLaidPublicNum, -9);
			} else {
				result = laidPublicNum;
			}
		}	
		return result;
	}
	
	/**
	 * 등록번호
	 * @param natlCode
	 * @param regiNum
	 * @return
	 */
	private String getRegiNum(String natlCode, String regiNum) {
		String result = "";
		if(StringUtil.isNull(regiNum)) {
			result = regiNum;
		} else {
			String newRegiNum = regiNum.replaceAll("[A-z]", "");
			if("EP".equals(natlCode) || "KR".equals(natlCode)) {
				result = StringUtil.subStr(regiNum, -2, -9);
			} else if("JP".equals(natlCode)) {
				result = StringUtil.subStr(newRegiNum, 7);
			} else if("US".equals(natlCode)) {
				result = StringUtil.subStr(regiNum, -7);
			} else if("CN".equals(natlCode)) {
				result = StringUtil.lpad(newRegiNum, 9, "0");
			} else {
				result = regiNum;
			}
		}	
		return result;
	}
	
	/**
	 * 등록일자
	 * @param natlCode
	 * @param regiDate
	 * @param noticePublicDate
	 * @return
	 */
	private String getRegiDate(String natlCode, String regiDate, String noticePublicDate) {
		String result = "";
		if("CN".equals(natlCode) && !StringUtil.isNull(noticePublicDate))
			result = noticePublicDate;
		else 
			result = regiDate;
		return StringUtil.isNull(result) ? result : result.replaceAll("[.]", "");
	}
	
	/**
	 * 출원인
	 * @param natlCode
	 * @param param 업로드데이터
	 * @return
	 */
	private String getApplicant(String natlCode, Map<String, String> param) {
		String result = "";
		if(!StringUtil.isNull(param.get("A_08")))
			result = param.get("A_08");			// 최종권리자_출원인
		else if("JP".equals(natlCode) && !StringUtil.isNull(param.get("A_05")))
			result = param.get("A_05");			// 출원인영문명("KR" 제외)
		else if(!StringUtil.isNull(param.get("A_07")))
			result = param.get("A_05");			// 출원인대표명
		else 
			result = param.get("A_04");			// 출원인
		return result;
	}
	
	/**
	 * 우선권번호
	 * @param priorityNum
	 * @return
	 */
	private String getPriorityNum(String priorityNum) {
		String result = "";
		String regex = "[A-z]+\\s[^()]*";
		if(!StringUtil.isNull(priorityNum))
			result = StringUtil.parsePriority(priorityNum, regex);
		return result;
	}
	
	/**
	 * 우선권국가
	 * @param priorityNum
	 * @return
	 */
	private String getPriorityNatl(String priorityNum) {
		String result = "";
		String regex = "[A-z]+\\s";
		if(!StringUtil.isNull(priorityNum))
			result = StringUtil.parsePriority(priorityNum, regex);
		return result;
	}

	/**
	 * 우선권적용일
	 * @param priorityNum
	 * @return
	 */
	private String getPriorityDate(String priorityNum) {
		String result = "";
		String regex = "\\d+\\.+\\d+.\\d*";
		if(!StringUtil.isNull(priorityNum)) {
			result = StringUtil.parsePriority(priorityNum, regex);
			regex = "\\d+\\-+\\d+-\\d*";
			result = StringUtil.parsePriority(priorityNum, regex);
		}
		return StringUtil.isNull(result) ? result : result.replaceAll("[.]", "-");
	}
	
	
	/**
	 * 출원번호 원본
	 * @param natlCode
	 * @param applNum
	 * @return
	 */
	private String getApplNumOrg(String natlCode, String applNum, String kindsIpType) {
		String result = "";
		
		if(StringUtil.isNull(applNum) && !"KR".equals(natlCode)) {
			result = applNum;
		} else {
			String newApplNum = applNum.replaceAll("[A-z]", "");	// 영문삭제후 숫자만 남은 출원번호
			if(kindsIpType.equals("P"))
				result = "10"+newApplNum;
			else
				result = "20"+newApplNum;
		}
		return result;
	}
}
