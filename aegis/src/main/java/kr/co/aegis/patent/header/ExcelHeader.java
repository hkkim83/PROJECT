package kr.co.aegis.patent.header;

import java.util.HashMap;

public class ExcelHeader {
	
	/**
	 * 엑셀 양식 구분 DB
	 */
	public static final String DB[] = { "WIPSON", "FOCUST", "KIPRIS_N", "KIPRIS_A" };
	
	/**
	 * WIPSON 엑셀 헤더
	 */
	public static final String WIPSON[] = {
		"국가코드",								"DB종류",						"특허/실용 구분",					"문헌종류 코드",									"원문 링크",	
		"번역문 링크",								"출원번호",					"출원일",							"공개번호/공표번호/재공표번호",						"공개일",						
		"등록번호",								"등록일",						"공고번호",						"공고일",										"발명의 명칭",			
		"요약",									"대표청구항",					"청구항 수",						"출원인",										"출원인 국적",		
		"출원인 식별기호 (JP)",						"대표출원인 코드 (KR)",			"대표출원인 명칭 (KR - 국문)",			"대표출원인 명칭 (KR - 영문)", 					"발명자/고안자",					
		"발명자/고안자 국적",							"IPC (Main)",				"IPC (All)",					"우선권 국가",									"우선권 번호",
		"우선권 주장일",								"국제 출원번호",					"국제 출원일",						"국제 공개번호",									"국제 공개일",		
		"지정국 코드",								"테마코드 (JP)",				"F - term (JP)",				"FI 코드 (JP)",								"미국분류 (Current – Main)",		
		"미국분류 (Current – All)",				"미국분류 (Original – Main)",	"미국분류 (Original – All)",		"대리인",										"인용 문헌 수 (B1)",				
		"인용 문헌번호 (B1) + 심사관(BE) 인용 (KR,US)",	"심사관 인용문헌 (B1) (KR, US)",	"인용 문헌 수 (F1)",					"인용 문헌번호 (F1) + 심사관(FE) 인용 (KR,US)",		"심사관 인용문헌 (F1) (KR, US)",	
		"패밀리 문헌번호 (Basic)",					"패밀리 문헌번호 (출원기준)",		"패밀리 문헌 수 (출원기준)",			"DOCDB 법적상태",								"상세보기 링크",		
		"CPC",									"WIPS ON key"
	};
	
	/**
	 * FOCUST 엑셀 헤더
	 */
	public static final String FOCUST[] = {
		"일련번호",			"출원번호",			"출원일",				"출원인",				"출원인영문명",		
		"출원인국가",			"출원인대표명",			"최종권리자-출원인",		"Life Status",		"Final Status",		
		"명칭",				"명칭(원문)",			"요약",				"요약(원문)",			"발명자",		
		"국제특허분류",			"공동특허분류",			"미국특허분류",			"F-Term",			"FI",					
		"심사관",				"대리인",				"공개번호",			"공개일",				"공고번호",				
		"공고일",				"등록번호",			"등록일",				"발행일",				"우선권번호",			
		"지정국가",			"자국인용특허",			"외국인용특허",			"자국피인용특허",		"자국인용횟수",			
		"자국피인용횟수",		"권리만료예상일",		"특허평가등급",			"특허평가점수",			"발명자평가평균등급",	
		"발명자평가평균점수",		"독립 청구항수",			"전체 청구항수",			"대표 청구항",			"대표 청구항(원문)",	
		"전체 청구항",			"전체 청구항(원문)",		"INPADOC 패밀리",		"발명자수",			"소유권이전여부",		
		"소유권최종양도일",		"INPADOC패밀리수",		"INPADOC패밀리국가",	"INPADOC패밀리국가수",	"Genealogy수"
	};

	/**
	 * KIPRIS 국내 엑셀 헤더
	 */
	public static final String KIPRIS_N[] = {
		"순서",				"출원번호",		"출원일자",		"번역문제출일자",	"IPC분류 8판",
		"공개번호",			"공개일자",		"공고번호",		"공고일자",		"등록번호",
		"등록일자",			"원출원권리",		"원출원번호",		"원출원번호일자",	"Family 출원번호",
		"최종처분내용",			"국제출원번호",		"국제출원일자",		"국제공개번호",		"국제공개일자",
		"심사청구일자/항수",		"지정국",			"등록상태",		"출원인",			"발명자/고안자",
		"대리인",				"우선권정보",		"발명의명칭",		"심사청구여부",		"초록",
		"청구항"
	};
	
	/**
	 * KIPRIS 해외 엑셀 헤더
	 */
	public static final String KIPRIS_A[] = {
		"국가",			"출원번호",		"출원일자",		"공개번호",			"공개일자",
		"공보번호",		"공보일자",		"국제출원번호",		"국제출원일자",			"국제공개번호",
		"국제공개일자",		"IPC분류",		"지정국",			"출원인",				"발명자/고안자",
		"대리인",			"우선권정보",		"발명의명칭",		"UPC",				"심사관",
		"EPC",			"초록",			"청구항",			"DOCDB 패밀리정보"
	};

	/**
	 * 가공할 특허 필드 (WIPSON)
	 */
	
	public static final HashMap<String, String> DBMAP_WIPSON = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("NATL_CODE", 	"A_01");	put("KINDS_IP_TYPE", 	"A_03");	put("KINDS_IP_CODE", 	"A_04");	put("APPL_NUM", 		"A_07");	put("APPL_NUM_ORG", 		"A_07");
			put("APPL_DATE", 	"A_08");	put("LAID_PUBLIC_NUM", 	"A_09");	put("LAID_PUBLIC_DATE", "A_10");	put("REGI_NUM", 		"A_11");	put("REGI_DATE", 			"A_12");	
			put("TITLE", 		"A_15");	put("ABSTRACT", 		"A_16");	put("CLAIM_MAIN", 		"A_17");	put("APPLICANT", 		"A_19");	put("APPLICANT_NATL", 		"A_20");	
			put("INVENTOR", 	"A_25");	put("IPC_ALL", 			"A_28");	put("PRIORITY_NATL", 	"A_29");	put("PRIORITY_NUM", 	"A_30");	put("PRIORITY_DATE", 		"A_31");	
			put("F_TERM_JP", 	"A_38");	put("FI_CODE_JP", 		"A_39");	put("UPC_CURRENT_ALL", 	"A_41");	put("BC_COUNT", 		"A_45");	put("BC_BE_NUM", 			"A_46");	
			put("FC_COUNT",		"A_48");	put("FC_FE_NUM", 		"A_49");	put("FM_NUM", 			"A_52");	put("FM_COUNT", 		"A_53");	put("LEGAL_STATUS_DOCDB", 	"A_54");
			
		}
	};
	
	/**
	 * 가공할 특허 필드 (FOCUST)
	 */
	
	public static final HashMap<String, String> DBMAP_FOCUST = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("NATL_CODE", 	"");		put("KINDS_IP_TYPE", 	"");		put("KINDS_IP_CODE", 	"");		put("APPL_NUM", 		"A_02");	put("APPL_NUM_ORG", 		"A_02");	
			put("APPL_DATE", 	"A_03");	put("LAID_PUBLIC_NUM", 	"A_23");	put("LAID_PUBLIC_DATE", "A_24");	put("REGI_NUM", 		"A_27");	put("REGI_DATE", 			"A_28");	
			put("TITLE", 		"A_11");	put("ABSTRACT", 		"A_13");	put("CLAIM_MAIN", 		"A_44");	put("APPLICANT", 		"A_04");	put("APPLICANT_NATL", 		"A_06");	
			put("INVENTOR", 	"A_15");	put("IPC_ALL", 			"A_16");	put("PRIORITY_NATL", 	"A_30");	put("PRIORITY_NUM", 	"A_30");	put("PRIORITY_DATE", 		"A_30");	
			put("F_TERM_JP", 	"A_19");	put("FI_CODE_JP", 		"A_20");	put("UPC_CURRENT_ALL", 	"A_18");	put("BC_COUNT", 		"A_35");	put("BC_BE_NUM", 			"A_32");	
			put("FC_COUNT",		"A_36");	put("FC_FE_NUM", 		"A_34");	put("FM_NUM", 			"A_48");	put("FM_COUNT", 		"A_52");	put("LEGAL_STATUS_DOCDB", 	"A_10");
			
		}
	};
	
	/**
	 * 가공할 특허 필드(KIPRIS_N)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_N = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("NATL_CODE", 	"");		put("KINDS_IP_TYPE", 	"");		put("KINDS_IP_CODE", 	"");		put("APPL_NUM", 		"A_02");	put("APPL_NUM_ORG", 		"A_02");	
			put("APPL_DATE", 	"A_03");	put("LAID_PUBLIC_NUM", 	"A_06");	put("LAID_PUBLIC_DATE", "A_07");	put("REGI_NUM", 		"A_10");	put("REGI_DATE", 			"A_11");	
			put("TITLE", 		"A_28");	put("ABSTRACT", 		"A_30");	put("CLAIM_MAIN", 		"A_31");	put("APPLICANT", 		"A_24");	put("APPLICANT_NATL", 		"");		
			put("INVENTOR", 	"A_25");	put("IPC_ALL", 			"A_05");	put("PRIORITY_NATL", 	"");		put("PRIORITY_NUM", 	"A_13");	put("PRIORITY_DATE", 		"A_14");	
			put("F_TERM_JP", 	"");		put("FI_CODE_JP", 		"");		put("UPC_CURRENT_ALL", 	"");		put("BC_COUNT", 		"");		put("BC_BE_NUM", 			"");		
			put("FC_COUNT",		"");		put("FC_FE_NUM", 		"");		put("FM_NUM", 			"");		put("FM_COUNT", 		"");		put("LEGAL_STATUS_DOCDB", 	"A_23");
			
		}
	};
		
	/**
	 * 가공할 특허 필드(KIPRIS_A)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_A = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;

		{
			put("NATL_CODE", 	"A_01");	put("KINDS_IP_TYPE", 	"");		put("KINDS_IP_CODE", 	"");		put("APPL_NUM", 		"A_02");	put("APPL_NUM_ORG", 		"A_02");	
			put("APPL_DATE", 	"A_03");	put("LAID_PUBLIC_NUM", 	"A_04");	put("LAID_PUBLIC_DATE", "A_05");	put("REGI_NUM", 		"A_06");	put("REGI_DATE", 			"A_07");	
			put("TITLE", 		"A_18");	put("ABSTRACT", 		"A_22");	put("CLAIM_MAIN", 		"A_23");	put("APPLICANT", 		"A_14");	put("APPLICANT_NATL", 		"");		
			put("INVENTOR", 	"A_15");	put("IPC_ALL", 			"A_12");	put("PRIORITY_NATL", 	"");		put("PRIORITY_NUM", 	"A_17");	put("PRIORITY_DATE", 		"");		
			put("F_TERM_JP", 	"");		put("FI_CODE_JP", 		"");		put("UPC_CURRENT_ALL", 	"");		put("BC_COUNT", 		"");		put("BC_BE_NUM", 			"");		
			put("FC_COUNT",		"");		put("FC_FE_NUM", 		"");		put("FM_NUM", 			"A_24");	put("FM_COUNT", 		"");		put("LEGAL_STATUS_DOCDB", 	"");
			
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
