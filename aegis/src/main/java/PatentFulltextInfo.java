import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.axis.message.SOAPHeaderElement;

import kr.co.aegis.util.StringUtil;
import kr.or.kipris.plus.PatentImageAndFullTextServicePortTypeProxy;
import kr.or.kipris.plus.PatentImageAndFullTextServiceSoap11BindingStub;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult;
import kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo;


public class PatentFulltextInfo {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) 
	{
		PatentImageAndFullTextServicePortTypeProxy proxy = new PatentImageAndFullTextServicePortTypeProxy();
		PatentImageAndFullTextServiceSoap11BindingStub stub =(PatentImageAndFullTextServiceSoap11BindingStub)proxy.getPatentImageAndFullTextServicePortType();
		String patentFullText = null; 
		String imageMain      = null;
		String imageSmall     = null;
		String openTextYn     = null;
		String regiTextYn     = null;
		String reviTextYn     = null;
		String imageMainYn    = null;
		FilePathInfo filePathInfo = null;
		
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
			
			String applNum = "1020070078143";
			
			if(StringUtil.isNull(applNum)) 
				return;
			
			// 대표전문, 대표도면 유무 조회 
			FullTextCheckResult checkResult = (FullTextCheckResult)stub.fullTextCheck(applNum);
			// 공개전문 
			openTextYn = checkResult.getUnexPubfullDocPDFCheckResult();
			// 등록전문 
			regiTextYn = checkResult.getExamPubfullDocPDFCheckResult();
			// 정정전문 
			reviTextYn = checkResult.getRevisionfullDocPDFCheckResult();
			// 대표도면
			imageMainYn = checkResult.getAbstractFigureCheckResult();			
			
			if("Y".equals(openTextYn)) {
				filePathInfo = (FilePathInfo)stub.unexPubfullDocPDFInfo(applNum);
				patentFullText = filePathInfo.getPath();
			} else if("Y".equals(regiTextYn)) {
				filePathInfo = (FilePathInfo)stub.examPubfullDocPDFInfo(applNum);
				patentFullText = filePathInfo.getPath();
			} else if("Y".equals(reviTextYn)) {
				FilePathRevisionInfo[] array = (FilePathRevisionInfo[])stub.revisionfullDocPDFInfo(applNum);
				if(array != null) {
					patentFullText = array[0] == null ? "" : array[0].getPath();
				}
			} 
			
			if("Y".equals(imageMainYn)) {
				ImagePathInfo[] imagePathInfos = (ImagePathInfo[])stub.abstractFigure(applNum);
				System.out.println("imagePathInfos:::"+imagePathInfos);
				System.out.println("imagePathInfos:::"+imagePathInfos.length);
				if(imagePathInfos != null) {
					imageMain  = imagePathInfos[0] == null ? "" : imagePathInfos[0].getLargePath(); 
					imageSmall = imagePathInfos[0] == null ? "" : imagePathInfos[0].getPath(); 
				}
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
