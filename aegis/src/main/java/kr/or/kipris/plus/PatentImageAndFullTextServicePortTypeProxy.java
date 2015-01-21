package kr.or.kipris.plus;

public class PatentImageAndFullTextServicePortTypeProxy implements kr.or.kipris.plus.PatentImageAndFullTextServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.PatentImageAndFullTextServicePortType patentImageAndFullTextServicePortType = null;
  
  public PatentImageAndFullTextServicePortTypeProxy() {
    _initPatentImageAndFullTextServicePortTypeProxy();
  }
  
  public PatentImageAndFullTextServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPatentImageAndFullTextServicePortTypeProxy();
  }
  
  private void _initPatentImageAndFullTextServicePortTypeProxy() {
    try {
      patentImageAndFullTextServicePortType = (new kr.or.kipris.plus.PatentImageAndFullTextServiceLocator()).getPatentImageAndFullTextServiceHttpSoap11Endpoint();
      if (patentImageAndFullTextServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)patentImageAndFullTextServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)patentImageAndFullTextServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (patentImageAndFullTextServicePortType != null)
      ((javax.xml.rpc.Stub)patentImageAndFullTextServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.PatentImageAndFullTextServicePortType getPatentImageAndFullTextServicePortType() {
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.fullTextCheck(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] examPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.examPubBookInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] unexPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.unexPubBookInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[] revisionfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.revisionfullDocPDFInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo examPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.examPubfullDocPDFInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo unexPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.unexPubfullDocPDFInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[] abstractFigure(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentImageAndFullTextServicePortType == null)
      _initPatentImageAndFullTextServicePortTypeProxy();
    return patentImageAndFullTextServicePortType.abstractFigure(applicationNumber);
  }
  
  
}