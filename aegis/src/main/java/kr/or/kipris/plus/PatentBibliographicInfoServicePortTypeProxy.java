package kr.or.kipris.plus;

public class PatentBibliographicInfoServicePortTypeProxy implements kr.or.kipris.plus.PatentBibliographicInfoServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.PatentBibliographicInfoServicePortType patentBibliographicInfoServicePortType = null;
  
  public PatentBibliographicInfoServicePortTypeProxy() {
    _initPatentBibliographicInfoServicePortTypeProxy();
  }
  
  public PatentBibliographicInfoServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPatentBibliographicInfoServicePortTypeProxy();
  }
  
  private void _initPatentBibliographicInfoServicePortTypeProxy() {
    try {
      patentBibliographicInfoServicePortType = (new kr.or.kipris.plus.PatentBibliographicInfoServiceLocator()).getPatentBibliographicInfoServiceHttpSoap11Endpoint();
      if (patentBibliographicInfoServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)patentBibliographicInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)patentBibliographicInfoServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (patentBibliographicInfoServicePortType != null)
      ((javax.xml.rpc.Stub)patentBibliographicInfoServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.PatentBibliographicInfoServicePortType getPatentBibliographicInfoServicePortType() {
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AgentInfo[] agentInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.agentInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo[] ipcInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.ipcInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.LegalStatusInfo[] legalStatusInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.legalStatusInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.InternationalInfo[] internationalInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.internationalInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo[] claimInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.claimInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo[] applicantInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.applicantInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.DesignatedStateInfo[] designatedStateInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.designatedStateInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.FamilyInfo[] familyInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.familyInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo[] abstractInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.abstractInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo[] biblioSummaryInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.biblioSummaryInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo[] priorArtDocumentsInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.priorArtDocumentsInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.BibliographicInfoArray bibliographicInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.bibliographicInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo[] inventorInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.inventorInfo(applicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo[] priorityInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException{
    if (patentBibliographicInfoServicePortType == null)
      _initPatentBibliographicInfoServicePortTypeProxy();
    return patentBibliographicInfoServicePortType.priorityInfo(applicationNumber);
  }
  
  
}