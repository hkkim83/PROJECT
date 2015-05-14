import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.axis.message.SOAPHeaderElement;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.ForeignPatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo;
import kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo;


public class ForeignPatentFulltextInfo {
	/**
	 * @param args
	 * @throws RemoteException 
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ForeignPatentImageAndFullTextServicePortTypeProxy proxy = new ForeignPatentImageAndFullTextServicePortTypeProxy();
		ForeignPatentImageAndFullTextServiceSoap11BindingStub stub =(ForeignPatentImageAndFullTextServiceSoap11BindingStub)proxy.getForeignPatentImageAndFullTextServicePortType();
		String patentFullText = null; 
		String imageMain      = null;
		String imageSmall     = null;
		String openTextYn     = null;
		String regiTextYn     = null;
		String reviTextYn     = null;
		String imageMainYn    = null;
		
		try {
			String _userId = "airsgroup";
			String _userKey = "d73f2580c4a0b15f915c27009834c75f29992aac1f25a0a1";
			String _kiprisUrl = "http://plus.kipris.or.kr";
			SOAPHeaderElement _soapId = new SOAPHeaderElement(_kiprisUrl,"userId");
			_soapId.setValue(_userId);
			
			SOAPHeaderElement _soapKey = new SOAPHeaderElement(_kiprisUrl,"userKey");
			_soapKey.setValue(_userKey);
			stub.setHeader(_soapId);
			stub.setHeader(_soapKey);
			
			String applNum  = "200500065206A3";
			String natlCode = "WO";
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			// 대표전문, 대표도면 유무 조회 
			FullTextCheckResult checkResult = (FullTextCheckResult)stub.fullTextCheck(applNum, natlCode);
			
			// 공개전문 
			openTextYn = checkResult.getOpenFullTextCheckResult();
			// 등록전문 
			regiTextYn = checkResult.getRegistrationFullTextCheckResult();
			// 정정전문 
			reviTextYn = checkResult.getRevisionAnnounceFullTextCheckResult();
			// 대표도면
			imageMainYn = checkResult.getRepresentationImageInfo();
			
			System.out.println(openTextYn+","+regiTextYn+","+reviTextYn+","+imageMainYn);
			
			if("Y".equals(openTextYn)) {
				OpenFullTextInfo openFullTextInfo = (OpenFullTextInfo)stub.openFullTextInfo(applNum, natlCode);
				patentFullText = openFullTextInfo.getPath();
			} else if("Y".equals(regiTextYn)) {
				RegistrationFullTextInfo regiFullTextInfo = (RegistrationFullTextInfo)stub.registrationFullTextInfo(applNum, natlCode);
				patentFullText = regiFullTextInfo.getPath();
			} else if("Y".equals(reviTextYn)) {
			} else {
				FullTextInfo fullTextInfo = (FullTextInfo)stub.fullTextInfo(applNum, natlCode);
				patentFullText = fullTextInfo.getPath();
			} 	
			
			if("Y".equals(imageMainYn)) {
				RepresentationImageInfo[] imagePathInfos = stub.representationImageInfo(applNum, natlCode);
				if(imagePathInfos != null)
					imageMain = imagePathInfos[0] == null ? "" : imagePathInfos[0].getJpgPath(); 
			} 
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			System.out.println(openTextYn+","+regiTextYn+","+reviTextYn+","+imageMainYn);
			System.out.println("patentFullText::::"+patentFullText);
			System.out.println("imageMain::::"+imageMain);
		}		
		
	}
}
