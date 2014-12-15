package kr.co.aegis.patent.legal;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JpLegalStatus implements LegalStatus{
	
	private Map<String, String> map;
	private String url1;
	private String url2;
	private int index;
	
	public JpLegalStatus(String url1, String url2, int index, Map<String, String> map) {
		this.map = map;
		this.url1 = url1;
		this.url2 = url2;
		this.index = index;
	}
	/*
	 * 일본 법적상태 가져오기
	 * html 페이지에 td태그의 속성 width 중 370을 찾고, 해당 태그의 값을 반환한다.
	 * ex) http://www1.ipdl.inpit.go.jp/SA1/sa_list_table.cgi?TYPE=001&POS=1&GC=1&DC1=1&DN1=2001-025262
	 * &DC2=1&DN2=&DC3=1&DN3=&DC4=1&DN4=&DC5=1&DN5=&DC6=1&DN6=&DC7=1&DN7=&DC8=1&DN8=&DC9=1&DN9=&DC10=1&DN10=&DC11=1&DN11=&DC12=1&DN12=&sTime=13646535242002
	 */
	public String getLegalStatus() throws IOException {
		String legalStatus = "";
		String newUrl = url1+map.get("APPL_NUM")+url2+index;
		Connection con = Jsoup.connect(newUrl);
		con.timeout(1000*30);	// 최대 연결 지연시간 30초로 지정
		Document doc = con.get();
		Elements elements = doc.select("td");
		
		//print all titles in main page
		for(Element e: elements){
			legalStatus = "";
			if("370".equals(e.attr("width"))) {
				legalStatus = e.text();
				return legalStatus;			
			}
		}	
		return legalStatus;
	}
}
