package kr.co.aegis.patent.legal;

import java.io.IOException;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class KrLegalStatus implements LegalStatus{
	
	private Map<String, String> map;
	private String url;
	
	public KrLegalStatus(String url, Map<String, String> map) {
		this.map = map;
		this.url = url;
	}
	
	/*
	 * 한국 법적상태 가져오기
	 * html 페이지에서 th 태그의 값 중 등록상태를 찾고, 다음 형제 태그의 값을 반환한다.
	 * ex) http://file.wipson.com/kipoinfo/kipoInfo_appl.asp?applNo=1020060119654
	 */
	public String getLegalStatus() throws IOException {
		String legalStatus = "";
		String newUrl = url+"10";
		if("U".startsWith(map.get("KINDS_IP_TYPE")) || "U".startsWith(map.get("KINDS_IP_CODE")) || "Y".startsWith(map.get("KINDS_IP_CODE")))
			newUrl = url+"20";
		newUrl += (map.get("APPL_NUM")).replaceAll("-", "");
		Connection con = Jsoup.connect(newUrl);
		con.timeout(1000*30);	// 최대 연결 지연시간 30초로 지정
		Document doc = con.get();
		Elements elements = doc.select("th");
 
		//print all titles in main page
		for(Element e: elements){
			legalStatus = "";
			if("등록상태".equals(e.text())) {
				legalStatus = e.nextElementSibling().text();
				return legalStatus;				
			}
		}	
		return legalStatus;		
	}
}
