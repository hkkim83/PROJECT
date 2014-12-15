package kr.co.aegis.paging;

import java.util.Map;

import kr.co.aegis.patent.header.PatentHeader;
import kr.co.aegis.util.StringUtil;

public class PagingHelper {

	/** default 페이지링크 개수 */
	private final int PAGE_LINK_COUNT = 10;

	/** 페이지의 마지막 포인트 */
	private int epOfTotal = 0;

	/** 조회시 시작 포인트 */
	private int stOfPage = 0;
	
	/** 조회시 마지막 포인트 */
	private int epOfPage = 0;

	/** 현재페이지 */
	private int pageNo;

	/** 페이징네비게이션 저장소 */
	private String pageNav = "";
	
	/** 파라미터 */
	private String requestURI = "";

	/** 쿼리에서 마지막포인트로부터 얻오올 개수 */
	private int cnt;

	/** 한페이지에 표시할 글수 */
	private int numPerPage;

	/** 전체 페이지수 */
	private int totPageCnt;
	
	/** URL 쿼리 스트링 */
	private Map<String, Object> queryMap;
	
	

	/**
	 * 페이징 생성자
	 * 
	 * 페이징에 필요한 인자 셋팅
	 * 
	 * @param totCnt
	 * @param pageNo
	 * @param pageLinkCnt
	 * @param listRows
	 */
	public PagingHelper(int totCnt, int pageNo, int numPerPage, String requestURI, Map<String, Object> queryMap) {

		this.queryMap = queryMap;
		this.requestURI = requestURI;
		
		this.cnt = numPerPage;
		this.epOfTotal = totCnt - ((numPerPage * pageNo) - numPerPage);
		if (this.epOfTotal < numPerPage)
			this.cnt = this.epOfTotal;
		this.numPerPage = numPerPage;
		this.totPageCnt = (int) Math.ceil((double) totCnt/ this.numPerPage);
		this.stOfPage = numPerPage * (pageNo-1);
		this.epOfPage = numPerPage * pageNo;
		this.pageNo = pageNo;
	}

	/**
	 * 페이징처리된 html을 생성하여 문자열로 리턴한다.
	 * 
	 * @return 페이징처리된 html
	 */
	public String getPageNavigation() {
		return this.getPageNavigation(PAGE_LINK_COUNT);
	}

	/**
	 * 페이징처리된 html을 생성하여 문자열로 리턴한다.
	 * 
	 * @param pageLinkCnt
	 *            페이지 링크개수
	 * @return 페이징처리된 html
	 */
	public String getPageNavigation(int pageLinkCnt) {

		String queryString = this.getQueryString();

		int first = 0;
		int last = 0;
		int prev = 0;
		int next = 0;

		if (this.pageNo > pageLinkCnt) {
			first = ((this.pageNo - 1) / pageLinkCnt) * pageLinkCnt + 1;
			last = first + pageLinkCnt - 1;
			if (this.totPageCnt < last)
				last = this.totPageCnt;
		} else {
			first = 1;
			last = pageLinkCnt;
			if (this.totPageCnt < last)
				last = this.totPageCnt;
		}

		prev = this.pageNo - pageLinkCnt - this.pageNo%10 + 1;
		next = this.pageNo + pageLinkCnt - this.pageNo%10 + 1;
		if (next > this.totPageCnt)
			next = this.totPageCnt;

		if (this.totPageCnt > 0) {
			// 첫 페이지( << ) 아이콘 표시
			if (first != 1) {
			    this.pageNav += "<span class=\"btn\"><a href=\"javascript:location.href='"+this.requestURI+"?"
			            + queryString + "&PAGE_NO=" + 1 + "'\" class=\"first\">처음</a></span>";
			}

			// 이전 페이지( < ) 아이콘 표시
			if (first != 1) {
				this.pageNav += "<span class=\"btn\"><a href=\"javascript:location.href='"+this.requestURI+"?"
			            + queryString + "&PAGE_NO=" + prev + "'\" class=\"prev\">이전</a></span>";
			}
			
			// 1 | 2 | 3 | +++ | 10 표시
			this.pageNav += "<span class=\"num\">";
			for (int pi = first; pi <= last; pi++) { // pi =
				if (pi != pageNo) {
					this.pageNav += "<a href=\"javascript:location.href='"+this.requestURI+"?"
							+ queryString + "&PAGE_NO=" + pi + "'\">" + pi + "</a>";
				} else {
					this.pageNav += "<strong class=\"on\">" + pi + "</strong>";
				}
			}
			this.pageNav += "</span>";

			// 다음 페이지 ( > ) 아이콘 표시
			if (last < this.totPageCnt) {
				this.pageNav += "<span class=\"btn\"><a href=\"javascript:location.href='"+this.requestURI+"?"
			            + queryString + "&PAGE_NO=" + next + "'\" class=\"next\">다음</a></span>";
			}

			// 마지막 페이지 ( >> ) 아이콘 표시
			if (last < totPageCnt) {
				this.pageNav += "<span class=\"btn\"><a href=\"javascript:location.href='"+this.requestURI+"?"
			            + queryString + "&PAGE_NO=" + this.totPageCnt + "'\" class=\"last\">마지막</a></span>";
			}
		} else {
			this.pageNav = "<span class=\"num\"><strong class=\"on\">1</strong></span>";
		}
		return this.pageNav;
	}

	/**
	 * 쿼리 스트링 추가
	 * 
	 * @param str
	 *            설정할 쿼리스트링
	 */
	public void addParam(String name, String value) {
		this.queryMap.put(name, value);
	}

	/**
	 * 조회 전체개수의 마지막 번호 게시글의 번호를 구할때 사용
	 * 
	 * @return 전체개수의 마지막번호
	 */
	public int getEpOfTotal() {
		return this.epOfTotal;
	}

	/**
	 * 쿼리에서 마지막포인트로부터 얻오올 개수
	 * 
	 * @return 개수
	 */
	public int getCnt() {
		// 쿼리 조회시 오류때문에 저장
		if (this.cnt == 0)
			this.cnt = 1;
		return this.cnt;
	}

	/**
	 * 쿼리에서 얻어올 시작점이 될 마지막 포인트
	 * 
	 * @return 마지막 포인트번호
	 */
	public int getStOfPage() {
		return this.stOfPage;
	}


	/**
	 * 쿼리에서 얻어올 종료점이 될 마지막 포인트
	 * 
	 * @return 마지막 포인트번호
	 */
	public int getEpOfPage() {
		return this.epOfPage;
	}

	/**
	 * paramMap에있는 param들을 문자열로 리턴한다.
	 * 
	 * @return queryString
	 */
	public String getQueryString() {

		StringBuffer sb = new StringBuffer();
		String queryString = "";
		
		Object[] keys = queryMap.keySet().toArray();
		
		if(keys.length < 1) return queryString;
		
		for (int i = keys.length - 1; i >= 0; i--) {
			String key = (String) keys[i];
			if(key.startsWith("PAGE") || key.startsWith("LOGIN_ID") || key.startsWith("PROJECT_ID") || key.startsWith("ROW_NUM") || key.startsWith("DATA")) continue;		// 페이지번호는 URL에 포함시키지 않는다.
			String value = String.valueOf(queryMap.get(key));
			sb.append(key + "=" + value + "&");
		}
		queryString = sb.toString().substring(0, sb.toString().length() - 1);
		return queryString;
	}
	
	/**
	 * 입력식 만들기
	 * @return
	 */
	public String getInputString() {
		String inputString = "";
		String[][] paramList = PatentHeader.PARAM_LIST;
		for(String[] keyword : paramList){
			if(StringUtil.isNull((String)queryMap.get(keyword[0]))) continue;
			if(keyword[1].indexOf("시작") > -1)
				inputString += keyword[1] +">="+ queryMap.get(keyword[0])+"+";
			else if(keyword[1].indexOf("종료") > -1)
				inputString += keyword[1] +"<="+ queryMap.get(keyword[0])+"+";
			else if(keyword[1].indexOf("검토구분") > -1)
				inputString += keyword[1] +"="+ getReviewFlagName((String)queryMap.get(keyword[0]))+"+";
			else if(keyword[1].indexOf("등급") > -1)
				inputString += keyword[1] +"="+ getGradeName((String)queryMap.get(keyword[0]))+"+";
			else if(keyword[1].indexOf("대분류") > -1)
				inputString += keyword[1] +"="+ getLcateName((String)queryMap.get(keyword[0]))+"+";
			else
				inputString += keyword[1] +"="+ queryMap.get(keyword[0])+"+";
		}
		if(!StringUtil.isNull(inputString))
			inputString = inputString.substring(0, inputString.length()-1);
		return inputString;
	}
	
	/**
	 * 검토구분 콤보값 가져오기
	 * @param reviewFlag
	 * @return
	 */
	private String getReviewFlagName(String reviewFlag) {
		String ret = "";
		if("0".equals(reviewFlag))
			ret = "미검토";
		else if("1".equals(reviewFlag))
			ret = "검토중";
		else if("2".equals(reviewFlag))
			ret = "검토완료";
		return ret;
	}
	
	/**
	 * 등급 콤보값 가져오기
	 * @param reviewFlag
	 * @return
	 */
	private String getGradeName(String grade) {
		String ret = grade;
		if("N".equals(grade))
			ret = "미부여";
		return ret;
	}
	
	
	/**
	 * 등급 콤보값 가져오기
	 * @param reviewFlag
	 * @return
	 */
	private String getLcateName(String lcate) {
		String ret = "";
		if("01".equals(lcate))
			ret = "목적/효과";
		else if("02".equals(lcate))
			ret = "기능";
		else if("03".equals(lcate))
			ret = "구성";
		else if("04".equals(lcate))
			ret = "재료/성분";
		else if("05".equals(lcate))
			ret = "공정/제어";
		else if("06".equals(lcate))
			ret = "동력/원리";
		else if("07".equals(lcate))
			ret = "응용분야";
		else if("08".equals(lcate))
			ret = "기타";
		return ret;
	}
}