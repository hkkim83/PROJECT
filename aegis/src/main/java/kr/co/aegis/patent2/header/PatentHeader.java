package kr.co.aegis.patent2.header;

public class PatentHeader {
	/**
	 * 가공할 특허 필드 (WIPSON)
	 */
	public static final String PARAM_LIST[][] = {
		{"KEYWORD_MAIN", 				"통합검색"},
		{"KEYWORD_TITLE", 	    		"발명의 명칭"},
		{"KEYWORD_ABSTRACT", 			"요약"},
		{"KEYWORD_CLAIM_MAIN", 			"청구범위"},
		{"KEYWORD_APPLICANT", 			"출원인"},
		{"KEYWORD_INVENTOR", 			"발명자"},
		{"KEYWORD_NATL_CODE", 			"출원국가"},
		{"KEYWORD_APPL_NUM", 			"출원번호"},
		{"KEYWORD_LAID_PUBLIC_NUM", 	"공개번호"},
		{"KEYWORD_REGI_NUM", 			"등록번호"},
		{"KEYWORD_SEQ_NUM_FR", 			"연번시작번호"},
		{"KEYWORD_SEQ_NUM_TO", 			"연번종료번호"},
		{"KEYWORD_KINDS_LCATE", 		"대분류"},
		{"KEYWORD_KINDS_MCATE", 		"중분류"},
		{"KEYWORD_GRADE_OBJ", 			"목적등급"},
		{"KEYWORD_GRADE_CONST", 		"해결수단등급"},
		{"KEYWORD_KEYWORD", 			"목적/해결수단"},
		{"KEYWORD_APPL_DATE_FR", 		"출원시작일"},
		{"KEYWORD_APPL_DATE_TO", 		"출원종료일"},
		{"KEYWORD_LAID_PUBLIC_DATE_FR", "공개시작일"},
		{"KEYWORD_LAID_PUBLIC_DATE_TO", "공개종료일"},
		{"KEYWORD_REGI_DATE_FR", 		"등록시작일"},
		{"KEYWORD_REGI_DATE_TO", 		"등록종료일"},
		{"KEYWORD_REVIEWER", 			"검토결과"},
		{"KEYWORD_REVIEW_FLAG", 		"검토구분"}			
	};
}
