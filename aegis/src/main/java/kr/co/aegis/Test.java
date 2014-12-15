package kr.co.aegis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws Exception {

//    	PatentBibliographicInfoServicePortTypeProxy proxy = new PatentBibliographicInfoServicePortTypeProxy();
//		PatentBibliographicInfoServiceSoap11BindingStub stub =(PatentBibliographicInfoServiceSoap11BindingStub)proxy.getPatentBibliographicInfoServicePortType();
//		
//		String _userId = "airsgroup";
//	 	String _userKey ="d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
//		
//		SOAPHeaderElement id = new SOAPHeaderElement("http://plus.kipris.or.kr","userId");
//		id.setValue(_userId);
//		
//		SOAPHeaderElement userKey = new SOAPHeaderElement("http://plus.kipris.or.kr","userKey");
//		userKey.setValue(_userKey);
//		
//		stub.setHeader(id);
//		stub.setHeader(userKey);
//		AgentInfo[] agentInfos = (AgentInfo[])stub.agentInfo("1020070028743");
//		
//		PatentImageAndFullTextServicePortTypeProxy proxy2 = new PatentImageAndFullTextServicePortTypeProxy();
//		PatentImageAndFullTextServiceSoap11BindingStub stub2 =(PatentImageAndFullTextServiceSoap11BindingStub)proxy2.getPatentImageAndFullTextServicePortType();
//		
//		stub2.setHeader(id);
//		stub2.setHeader(userKey);
//		
//		FilePathInfo filePathInfo = (FilePathInfo)stub2.unexPubfullDocPDFInfo("1020070028743");
//		
//		ImagePathInfo[] imagePathInfos = (ImagePathInfo[])stub2.abstractFigure("1020070028743");
//		
//		ForeignPatentImageAndFullTextServicePortTypeProxy proxy3 = new ForeignPatentImageAndFullTextServicePortTypeProxy();
//		ForeignPatentImageAndFullTextServiceSoap11BindingStub stub3 =(ForeignPatentImageAndFullTextServiceSoap11BindingStub)proxy3.getForeignPatentImageAndFullTextServicePortType();
//		stub3.setHeader(id);
//		stub3.setHeader(userKey);
//		
//		FullTextInfo fullTextInfo = (FullTextInfo)stub3.fullTextInfo("000001731204A1", "EP");;
//		String patentFullText = fullTextInfo.getPath(); 
//		RepresentationImageInfo[] imagePathInfosA = (RepresentationImageInfo[])stub3.representationImageInfo("000003933574A1", "US");
//		String imageMain      = imagePathInfosA[0] == null || imagePathInfosA.length == 0 ? "" : imagePathInfosA[0].getJpgPath();
//		String imageSmall     = imagePathInfosA[0] == null || imagePathInfosA.length == 0 ? "" : imagePathInfosA[0].getJpgPath();
//		
//		
//		System.out.println(agentInfos.length);
//		System.out.println(agentInfos[0].getAddress());
//		System.out.println(filePathInfo.getPath());
//		System.out.println(imagePathInfos[0].getPath());
//		System.out.println(imagePathInfos[0].getLargePath());
//		System.out.println("patentFullText:::::::::"+patentFullText);
//		System.out.println("imageMain::::::::::::::"+imageMain);
//		System.out.println("imageSmall:::::::::::::"+imageSmall);
		System.out.println("System.currentTimeMillis();"+System.currentTimeMillis());
	    long nowmills = System.currentTimeMillis();
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    //String now = sdf.format(new Date(now));  //누군가 소스를 이렇게 올렸는데, 이렇게 하면 에러가 난다. now 이름을 다시 쓸 수 없음.
	    String now = sdf.format(new Date(nowmills));
	    
	    System.out.println("[ " + now + "]");  //출력예시 :  [ 2009-03-07 01:56:50 ]

		
//    	String outputDirectory = "C:/Java/project/uploadDir/user";
//    	FileUtils.deleteDirectory(new File(outputDirectory));

//    	String applNum = "KR20120019366A";
//    	String newApplNum = applNum.replaceAll("[A-z]", "");	// 영문삭제후 숫자만 남은 출원번호
//    	System.out.println(newApplNum);

    }
}
