package kr.or.kipris.plus;

public class ForeignPatentImageAndFullTextServicePortTypeProxy implements kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortType foreignPatentImageAndFullTextServicePortType = null;
  
  public ForeignPatentImageAndFullTextServicePortTypeProxy() {
    _initForeignPatentImageAndFullTextServicePortTypeProxy();
  }
  
  public ForeignPatentImageAndFullTextServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initForeignPatentImageAndFullTextServicePortTypeProxy();
  }
  
  private void _initForeignPatentImageAndFullTextServicePortTypeProxy() {
    try {
      foreignPatentImageAndFullTextServicePortType = (new kr.or.kipris.plus.ForeignPatentImageAndFullTextServiceLocator()).getForeignPatentImageAndFullTextServiceHttpSoap11Endpoint();
      if (foreignPatentImageAndFullTextServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foreignPatentImageAndFullTextServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foreignPatentImageAndFullTextServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foreignPatentImageAndFullTextServicePortType != null)
      ((javax.xml.rpc.Stub)foreignPatentImageAndFullTextServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortType getForeignPatentImageAndFullTextServicePortType() {
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[] representationImageInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.representationImageInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo registrationFullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.registrationFullTextInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray registrationNumberLinkInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.registrationNumberLinkInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.fullTextCheck(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo fullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.fullTextInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo revisionAnnounceInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.revisionAnnounceInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo openFullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.openFullTextInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[] fullTextDisplayInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.fullTextDisplayInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[] revisionInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.revisionInfo(literatureNumber, countryCode);
  }
  
  public void setForeignPatentImageAndFullTextService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentImageAndFullTextService foreignPatentImageAndFullTextService) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    foreignPatentImageAndFullTextServicePortType.setForeignPatentImageAndFullTextService(foreignPatentImageAndFullTextService);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray openNumberLinkInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentImageAndFullTextServicePortType == null)
      _initForeignPatentImageAndFullTextServicePortTypeProxy();
    return foreignPatentImageAndFullTextServicePortType.openNumberLinkInfo(literatureNumber, countryCode);
  }
  
  
}