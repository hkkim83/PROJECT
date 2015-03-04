package kr.or.kipris.plus;

public class FamilyInfoServicePortTypeProxy implements kr.or.kipris.plus.FamilyInfoServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.FamilyInfoServicePortType familyInfoServicePortType = null;
  
  public FamilyInfoServicePortTypeProxy() {
    _initFamilyInfoServicePortTypeProxy();
  }
  
  public FamilyInfoServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initFamilyInfoServicePortTypeProxy();
  }
  
  private void _initFamilyInfoServicePortTypeProxy() {
    try {
      familyInfoServicePortType = (new kr.or.kipris.plus.FamilyInfoServiceLocator()).getFamilyInfoServiceHttpSoap11Endpoint();
      if (familyInfoServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)familyInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)familyInfoServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (familyInfoServicePortType != null)
      ((javax.xml.rpc.Stub)familyInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.FamilyInfoServicePortType getFamilyInfoServicePortType() {
    if (familyInfoServicePortType == null)
      _initFamilyInfoServicePortTypeProxy();
    return familyInfoServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfoA(java.lang.String applicationCountryCode, java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (familyInfoServicePortType == null)
      _initFamilyInfoServicePortTypeProxy();
    return familyInfoServicePortType.familyInfoA(applicationCountryCode, applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (familyInfoServicePortType == null)
      _initFamilyInfoServicePortTypeProxy();
    return familyInfoServicePortType.familyInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfoP(java.lang.String publicationCountryCode, java.lang.String publicationNumber) throws java.rmi.RemoteException{
    if (familyInfoServicePortType == null)
      _initFamilyInfoServicePortTypeProxy();
    return familyInfoServicePortType.familyInfoP(publicationCountryCode, publicationNumber);
  }
  
  
}