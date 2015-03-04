package kr.co.aegis.patent2.header;

import java.util.HashMap;

public class ExcelHeader {
	
	/**
	 * 엑셀 양식 구분 DB
	 */
	public static final String DB[] = { "WIPSON", "FOCUST", "KIPRIS_N", "KIPRIS_A" };
	
	/**
	 * 가공할 특허 필드 (WIPSON)
	 */
	
	public static final HashMap<String, String> DBMAP_WIPSON = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("NATL_CODE", 		"국가코드");								put("KINDS_IP_TYPE", 	"특허/실용 구분"); 				put("KINDS_IP_CODE", 		"문헌종류 코드");	
			put("APPL_NUM", 		"출원번호");								put("APPL_NUM_ORG", 	"출원번호");					put("APPL_DATE", 			"출원일");			
			put("LAID_PUBLIC_NUM", 	"공개번호/공표번호/재공표번호");					put("LAID_PUBLIC_DATE", "공개일");					put("REGI_NUM", 			"등록번호");	
			put("REGI_DATE", 		"등록일");								put("TITLE", 	 		"발명의 명칭");					put("ABSTRACT", 			"요약");										
			put("CLAIM_MAIN", 		"대표청구항");								put("APPLICANT", 		"출원인");					put("APPLICANT_NATL", 		"출원인 국적");	
			put("INVENTOR",  		"발명자/고안자");							put("IPC_ALL", 			"IPC (All)");				put("PRIORITY_NATL", 		"우선권 국가");	
			put("PRIORITY_NUM", 	"우선권 번호");								put("PRIORITY_DATE", 	"우선권 주장일");				put("F_TERM_JP", 			"F - term (JP)");	
			put("FI_CODE_JP", 		"FI 코드 (JP)");							put("UPC_CURRENT_ALL", 	"미국분류 (Current – All)");	put("BC_COUNT", 			"인용 문헌 수 (B1)");		
			put("BC_BE_NUM", 		"인용 문헌번호 (B1) + 심사관(BE) 인용 (KR,US)");	put("FC_COUNT",	 		"인용 문헌 수 (F1)");			put("FC_FE_NUM", 			"인용 문헌번호 (F1) + 심사관(FE) 인용 (KR,US)");	
			put("FM_NUM", 			"패밀리 문헌번호 (출원기준)");					put("FM_COUNT", 		"패밀리 문헌 수 (출원기준)");		put("LEGAL_STATUS_DOCDB", 	"DOCDB 법적상태");
		}
	};

	/**
	 * 가공할 특허 필드 (FOCUST)
	 */
	
	public static final HashMap<String, String> DBMAP_FOCUST = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("NATL_CODE", 		"");					put("KINDS_IP_TYPE", 	""); 					put("KINDS_IP_CODE", 		"");	
			put("APPL_NUM", 		"출원번호");				put("APPL_NUM_ORG", 	"출원번호");				put("APPL_DATE", 			"출원일");			
			put("LAID_PUBLIC_NUM", 	"공개번호");				put("LAID_PUBLIC_DATE", "공개일");				put("REGI_NUM", 			"등록번호");	
			put("REGI_DATE", 		"등록일");				put("TITLE", 	 		"명칭");					put("ABSTRACT", 			"요약");										
			put("CLAIM_MAIN", 		"대표청구항");				put("APPLICANT", 		"출원인");				put("APPLICANT_NATL", 		"출원인국가");	
			put("INVENTOR",  		"발명자");				put("IPC_ALL", 			"국제특허분류");			put("PRIORITY_NATL", 		"우선권번호");	
			put("PRIORITY_NUM", 	"우선권번호");				put("PRIORITY_DATE", 	"우선권번호");				put("F_TERM_JP", 			"F-Term");	
			put("FI_CODE_JP", 		"FI");					put("UPC_CURRENT_ALL", 	"미국특허분류");			put("BC_COUNT", 			"자국인용횟수");
			put("BC_BE_NUM", 		"자국인용특허");			put("FC_COUNT",	 		"자국피인용횟수");			put("FC_FE_NUM", 			"자국피인용특허");		
			put("FM_NUM", 			"전체 청구항수");			put("FM_COUNT", 		"전체 청구항(원문)");		put("LEGAL_STATUS_DOCDB", 	"Final Status");
		}
	};

	/**
	 * 가공할 특허 필드(KIPRIS_N)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_N = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("NATL_CODE", 		"");					put("KINDS_IP_TYPE", 	"");			put("KINDS_IP_CODE", 		"");		
			put("APPL_NUM", 		"출원번호");				put("APPL_NUM_ORG", 	"출원번호");		put("APPL_DATE", 			"출원일자");	
			put("LAID_PUBLIC_NUM", 	"공개번호");				put("LAID_PUBLIC_DATE", "공개일자");		put("REGI_NUM", 			"등록번호");	
			put("REGI_DATE", 		"등록일자");				put("TITLE", 			"발명의명칭");		put("ABSTRACT", 			"초록");	
			put("CLAIM_MAIN", 		"청구항");				put("APPLICANT", 		"출원인");		put("APPLICANT_NATL", 		"");		
			put("INVENTOR", 		"발명자/고안자");			put("IPC_ALL", 			"IPC분류 8판");	put("PRIORITY_NATL", 		"");		
			put("PRIORITY_NUM", 	"원출원번호");				put("PRIORITY_DATE", 	"원출원번호일자");	put("F_TERM_JP", 			"");		
			put("FI_CODE_JP", 		"");					put("UPC_CURRENT_ALL", 	"");			put("BC_COUNT", 			"");		
			put("BC_BE_NUM", 		"");					put("FC_COUNT",			"");			put("FC_FE_NUM", 			"");		
			put("FM_NUM", 			"");					put("FM_COUNT", 		"");			put("LEGAL_STATUS_DOCDB", 	"등록상태");
		}
	};

		
	/**
	 * 가공할 특허 필드(KIPRIS_A)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_A = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("NATL_CODE", 		"국가");				put("KINDS_IP_TYPE", 	"");			put("KINDS_IP_CODE", 		"");		
			put("APPL_NUM", 		"출원번호");			put("APPL_NUM_ORG", 	"출원번호");		put("APPL_DATE", 			"출원일자");	
			put("LAID_PUBLIC_NUM", 	"공개번호");			put("LAID_PUBLIC_DATE", "공개일자");		put("REGI_NUM", 			"공보번호");	
			put("REGI_DATE", 		"공보일자");			put("TITLE", 			"발명의명칭");		put("ABSTRACT", 			"초록");	
			put("CLAIM_MAIN", 		"청구항");			put("APPLICANT", 		"출원인");		put("APPLICANT_NATL", 		"");		
			put("INVENTOR", 		"발명자/고안자");		put("IPC_ALL", 			"IPC분류");		put("PRIORITY_NATL", 		"");		
			put("PRIORITY_NUM", 	"우선권정보");			put("PRIORITY_DATE", 	"");			put("F_TERM_JP", 			"");		
			put("FI_CODE_JP", 		"");				put("UPC_CURRENT_ALL", 	"");			put("BC_COUNT", 			"");		
			put("BC_BE_NUM", 		"");				put("FC_COUNT",			"");			put("FC_FE_NUM", 			"");		
			put("FM_NUM", 			"DOCDB 패밀리정보");	put("FM_COUNT", 		"");			put("LEGAL_STATUS_DOCDB", 	"");
		}
	};
	
	/**
	 * 리스트 다운로드 헤더
	 */
	public static final String PATENT_HEADER[] = {
		"SEQ_NUM",			"NATL_CODE",	"APPL_NUM",			"TITLE",		"GRADE_OBJ",
		"APPLICANT_RENAME",	"REVIEWER",		"CMT_LAW_FIRMS", 	"GRADE_CONST",  "CMT_CO"
	};
	
	/**
	 * 전체 리스트 다운로드 헤더
	 */
	public static final String PATENT_HEADER_ALL[] = {
		"SEQ_NUM",				"NATL_CODE",		"KINDS_IP_TYPE",	"KINDS_IP_CODE",	"TITLE",
		"APPL_NUM",				"APPL_DATE",		"APPLICANT", 		"APPLICANT_RENAME", "APPLICANT_NATL",	
		"PRIORITY_NATL",		"PRIORITY_NUM",		"PRIORITY_DATE", 	"ABSTRACT", 		"CLAIM_MAIN",	
		"LAID_PUBLIC_NUM",		"LAID_PUBLIC_DATE",	"REGI_NUM", 		"REGI_DATE", 		"INVENTOR",	
		"IPC_ALL",				"F_TERM_JP",		"FI_CODE_JP",		"UPC_CURRENT_ALL", 	"BC_COUNT",	
		"BC_BE_NUM",			"FC_COUNT",			"FC_FE_NUM", 		"FM_COUNT",			"FM_NUM", 				
		"LEGAL_STATUS_DOCDB",	"FM_TYPE",			"FM_SEQ_NUM", 		"IMAGE_MAIN", 		"PATENT_FULLTXT",	
		"REVIEWER",				"REVIEW_DATE",		"REVIEW_FLAG_NM", 	"KINDS_TECH", 		"GRADE_OBJ",	
		"GRADE_CONST",			"CMT_LAW_FIRMS",	"CMT_CO", 			"IMPORTANT_YN_NM"
	};
}
