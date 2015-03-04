package kr.or.kipris.plus;

public class DOCDBServicePortTypeProxy implements kr.or.kipris.plus.DOCDBServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.DOCDBServicePortType dOCDBServicePortType = null;
  
  public DOCDBServicePortTypeProxy() {
    _initDOCDBServicePortTypeProxy();
  }
  
  public DOCDBServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initDOCDBServicePortTypeProxy();
  }
  
  private void _initDOCDBServicePortTypeProxy() {
    try {
      dOCDBServicePortType = (new kr.or.kipris.plus.DOCDBServiceLocator()).getDOCDBServiceHttpSoap11Endpoint();
      if (dOCDBServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)dOCDBServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)dOCDBServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (dOCDBServicePortType != null)
      ((javax.xml.rpc.Stub)dOCDBServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.DOCDBServicePortType getDOCDBServicePortType() {
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityLinkInfo[] priorityLinkInfo(java.lang.String epoApplno) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.priorityLinkInfo(epoApplno);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocInventorsInfo[] inventorsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.inventorsInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDemandParagraphInfo[] docDemandParagraphInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.docDemandParagraphInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocAgentInfo[] agentInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.agentInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocIpcInfo[] ipcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.ipcInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocRepresentationImageInfo representationImageInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.representationImageInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDesignationNameInfo[] designationNameInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.designationNameInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocApplicantInfo[] applicantInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.applicantInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocCpcInfo[] cpcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.cpcInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[] familyInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.familyInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocEclaInfo[] eclaInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.eclaInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocFamilySummaryInfo familySummaryInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.familySummaryInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocQuoteLiteraTrueLinkInfo[] quoteLiteraTrueLinkInfo(java.lang.String publicNumber, java.lang.String docdbApplcountryCode, java.lang.String literatureIdCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.quoteLiteraTrueLinkInfo(publicNumber, docdbApplcountryCode, literatureIdCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocSummationInfo[] summationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.summationInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocQuoteLiteraTrueInfo[] quoteLiteraTrueInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.quoteLiteraTrueInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDesignationInfo[] designationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.designationInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocFamilyTotalInfo familyTotalInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException, kr.or.kipris.plus.xsd.ExceptionType0{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.familyTotalInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] priorityInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.priorityInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocInventionNameInfo[] inventionNameInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.inventionNameInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocSummationOtherInfo[] summationOtherInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (dOCDBServicePortType == null)
      _initDOCDBServicePortTypeProxy();
    return dOCDBServicePortType.summationOtherInfo(literatureNumber, countryCode);
  }
  
  
}