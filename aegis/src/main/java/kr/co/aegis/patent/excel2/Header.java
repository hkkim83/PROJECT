package kr.co.aegis.patent.excel2;

import java.util.HashMap;

public class Header {
	
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
			put("국가코드", "NATL_CODE");									put("특허/실용 구분", "KINDS_IP_TYPE"); 					put("문헌종류 코드", "KINDS_IP_CODE");	
			put("출원번호", "APPL_NUM");									put("출원일", "APPL_DATE");			
			put("공개번호/공표번호/재공표번호", "LAID_PUBLIC_NUM");				put("공개일", "LAID_PUBLIC_DATE");					put("등록번호", "REGI_NUM");	
			put("등록일", "REGI_DATE");									put("발명의 명칭", "TITLE");							put("요약", "ABSTRACT");										
			put("대표청구항", "CLAIM_MAIN");								put("출원인", "APPLICANT");							put("출원인 국적", "APPLICANT_NATL");	
			put("발명자/고안자", "INVENTOR");								put("IPC (All)", "IPC_ALL");						put("우선권 국가", "PRIORITY_NATL");	
			put("우선권 번호", "PRIORITY_NUM");								put("우선권 주장일", "PRIORITY_DATE");					put("F - term (JP)", "F_TERM_JP");	
			put("FI 코드 (JP)", "FI_CODE_JP");							put("미국분류 (Current – All)", "UPC_CURRENT_ALL");	put("인용 문헌 수 (B1)", "BC_COUNT");		
			put("인용 문헌번호 (B1) + 심사관(BE) 인용 (KR,US)", "BC_BE_NUM");	put("인용 문헌 수 (F1)", "FC_COUNT");					put("인용 문헌번호 (F1) + 심사관(FE) 인용 (KR,US)", "FC_FE_NUM");	
			put("패밀리 문헌번호 (출원기준)", "FM_NUM");						put("패밀리 문헌 수 (출원기준)", "FM_COUNT");				put("DOCDB 법적상태", "LEGAL_STATUS_DOCDB");
		}
	};

	/**
	 * 가공할 특허 필드 (FOCUST)
	 */
	
	public static final HashMap<String, String> DBMAP_FOCUST = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("출원번호", "APPL_NUM");				put("출원일", "APPL_DATE");				put("공개번호", "LAID_PUBLIC_NUM");		
			put("공개일", "LAID_PUBLIC_DATE");		put("등록번호", "REGI_NUM");				put("등록일", "REGI_DATE");				
			put("명칭", "TITLE");						put("요약", "ABSTRACT");					put("대표 청구항", "CLAIM_MAIN");			
			put("출원인", "APPLICANT");				put("출원인국가", "APPLICANT_NATL");	 	put("발명자", "INVENTOR");				
			put("국제특허분류", "IPC_ALL");				put("우선권번호", "PRIORITY_NUM");			put("F-Term", "F_TERM_JP");	
			put("FI", "FI_CODE_JP");				put("미국특허분류", "UPC_CURRENT_ALL");		put("자국인용횟수", "BC_COUNT");
			put("자국인용특허", "BC_BE_NUM");			put("자국피인용횟수", "FC_COUNT");			put("자국피인용특허", "FC_FE_NUM");		
			put("전체 청구항수", "FM_NUM");				put("전체 청구항(원문)", "FM_COUNT");		put("Final Status", "LEGAL_STATUS_DOCDB");
			// ------------------------------------ DB 컬럼이 존재하지 않는 데이터, 가공시에만 사용된다. --------------------------------------------
			put("공고일", "NOTICE_PUBLIC_DATE");		put("출원인영문명", "EN_APPLICANT");		put("출원인대표명", "RE_APPLICANT");
			put("최종권리자-출원인", "LAST_APPLICANT");
		}
	};

	/**
	 * 가공할 특허 필드(KIPRIS_N)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_N = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("출원번호", "APPL_NUM");			put("출원일자", "APPL_DATE");				put("공개번호", "LAID_PUBLIC_NUM");				
			put("공개일자", "LAID_PUBLIC_DATE");	put("등록번호", "REGI_NUM");				put("등록일자", "REGI_DATE");				
			put("발명의명칭", "TITLE");				put("초록", "ABSTRACT");					put("청구항", "CLAIM_MAIN");		
			put("출원인", "APPLICANT");			put("발명자/고안자", "INVENTOR");			put("IPC분류 8판", "IPC_ALL");	
			put("원출원번호", "PRIORITY_NUM");		put("원출원번호일자", "PRIORITY_DATE");		put("등록상태", "LEGAL_STATUS_DOCDB");
		}
	};

		
	/**
	 * 가공할 특허 필드(KIPRIS_A)
	 */
	public static final HashMap<String, String> DBMAP_KIPRIS_A = new HashMap<String, String>() {

		private static final long serialVersionUID = 1L;
		{
			put("국가", "NATL_CODE");				put("출원번호", "APPL_NUM");				put("출원일자", "APPL_DATE");	
			put("공개번호", "LAID_PUBLIC_NUM");	put("공개일자", "LAID_PUBLIC_DATE");		put("공보번호", "REGI_NUM");	
			put("공보일자", "REGI_DATE");			put("발명의명칭", "TITLE");					put("초록", "ABSTRACT");	
			put("청구항", "CLAIM_MAIN");			put("출원인", "APPLICANT");				put("발명자/고안자", "INVENTOR");		
			put("IPC분류", "IPC_ALL");			put("우선권정보", "PRIORITY_NUM");			put("DOCDB 패밀리정보", "INVENTOR");	
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
