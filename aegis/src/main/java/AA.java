import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;


public class AA {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) 
	{
		//해외특허 > 서지정보 > 서지상세정보 REST API 호출 URL. URL은 홈페이지 DATA 상세정보에서 확인 가능.
		//[도메인/openapi/rest/서비스명/오퍼레이션명]으로 구성.
		// String apiUrl = "http://plus.kipris.or.kr/openapi/rest/ForeignPatentBibliographicService/bibliographicInfo";
		// String apiUrl = "http://kipo-api.kipi.or.kr/openapi/service/patUtiModInfoSearchSevice/getBibliographySumryInfoSearch?applicationNumber=1020050050026&accessKey=pkUQM5e0Bwlpk/v7gM9ngP9LYOPcQMKFepkKNpFb1EE=";
		String apiUrl = "http://plus.kipris.or.kr/openapi/rest/ForeignPatentBibliographicService/bibliographicInfo?literatureNumber=201210040148A0&countryCode=CN&accessKey=pkUQM5e0Bwlpk/v7gM9ngP9LYOPcQMKFepkKNpFb1EE=";
		//해당 상품 승인 접근키. 회원가입 후 자동발급되며 마이페이지에서 확인 가능.
		String accessKey = "pkUQM5e0Bwlpk/v7gM9ngP9LYOPcQMKFepkKNpFb1EE=";
		//입력값 문헌번호 & 국가코드
		String literatureNumber = "201210040148A0";
		String countryCode = "CN";
		
		// apiUrl += "?accessKey="+accessKey+"&literatureNumber="+literatureNumber+"&countryCode="+countryCode;
		
		try {
			//REST API URL을 읽어들여 결과 출력한다
			URL url = new URL(apiUrl);
			
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is,"utf-8");	//인코딩
			BufferedReader reader = new BufferedReader(isr);
			StringBuffer buffer = new StringBuffer();
			String line = null;
			String tmpStr = null;
			while((line = reader.readLine()) != null){
				tmpStr = line.toString();
				tmpStr = tmpStr.replaceAll(" ", "");
				
				if(!tmpStr.equals("")) buffer.append(line).append("\r\n");
			}
			reader.close();
			
			//REST API 결과값
			String xmlResult = buffer.toString();
			
			System.out.println("ForeignPatentBibliographicService/bibliographicInfo RESULT => " + xmlResult);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
