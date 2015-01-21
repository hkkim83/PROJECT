package kr.or.kipris.plus;

public class PatentAdvancedSearchServicePortTypeProxy implements kr.or.kipris.plus.PatentAdvancedSearchServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.PatentAdvancedSearchServicePortType patentAdvancedSearchServicePortType = null;
  
  public PatentAdvancedSearchServicePortTypeProxy() {
    _initPatentAdvancedSearchServicePortTypeProxy();
  }
  
  public PatentAdvancedSearchServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPatentAdvancedSearchServicePortTypeProxy();
  }
  
  private void _initPatentAdvancedSearchServicePortTypeProxy() {
    try {
      patentAdvancedSearchServicePortType = (new kr.or.kipris.plus.PatentAdvancedSearchServiceLocator()).getPatentAdvancedSearchServiceHttpSoap11Endpoint();
      if (patentAdvancedSearchServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)patentAdvancedSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)patentAdvancedSearchServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (patentAdvancedSearchServicePortType != null)
      ((javax.xml.rpc.Stub)patentAdvancedSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.PatentAdvancedSearchServicePortType getPatentAdvancedSearchServicePortType() {
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray itemTLSearch(java.lang.String inventionTitle, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.itemTLSearch(inventionTitle, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray internationalOpenDateSearch(java.lang.String internationOpenDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.internationalOpenDateSearch(internationOpenDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray registrationNumberSearch(java.lang.String registerNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.registrationNumberSearch(registerNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray internationalOpenNumberSearch(java.lang.String internationOpenNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.internationalOpenNumberSearch(internationOpenNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray freeSearch(java.lang.String word, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.freeSearch(word, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray agentSearch(java.lang.String agent, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.agentSearch(agent, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray inventorSearch(java.lang.String inventors, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.inventorSearch(inventors, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray applicationNumberSearch(java.lang.String applicationNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.applicationNumberSearch(applicationNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray itemCLSearch(java.lang.String claimScope, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.itemCLSearch(claimScope, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray openNumberSearch(java.lang.String openNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.openNumberSearch(openNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray advancedSearch(kr.or.kipris.plus.webservice.services.patentbean.xsd.CategorySearchQuery categorySearchQuery, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.advancedSearch(categorySearchQuery, docsStart, docsCount, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray itemABSearch(java.lang.String astrtCont, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.itemABSearch(astrtCont, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray applicationDateSearch(java.lang.String applicationDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.applicationDateSearch(applicationDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray registrationDateSearch(java.lang.String registerDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.registrationDateSearch(registerDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray priorityDateSearch(java.lang.String priorityApplicationDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.priorityDateSearch(priorityApplicationDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray ipcSearch(java.lang.String ipcNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.ipcSearch(ipcNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray rightHolerSearch(java.lang.String rightHoler, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.rightHolerSearch(rightHoler, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray internationalApplicationDateSearch(java.lang.String internationalApplicationDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.internationalApplicationDateSearch(internationalApplicationDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray priorityNumberSearch(java.lang.String priorityApplicationNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.priorityNumberSearch(priorityApplicationNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray publicationNumberSearch(java.lang.String publicationNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.publicationNumberSearch(publicationNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray internationalApplicationNumberSearch(java.lang.String internationalApplicationNumber, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.internationalApplicationNumberSearch(internationalApplicationNumber, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray openDateSearch(java.lang.String openDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.openDateSearch(openDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray applicantNameSearch(java.lang.String applicant, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.applicantNameSearch(applicant, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearchArray publicationDateSearch(java.lang.String publicationDate, java.lang.Integer docsStart, java.lang.Integer docsCount, java.lang.Boolean patent, java.lang.Boolean utility, java.lang.String lastvalue, java.lang.String sortSpec, java.lang.Boolean descSort) throws java.rmi.RemoteException{
    if (patentAdvancedSearchServicePortType == null)
      _initPatentAdvancedSearchServicePortTypeProxy();
    return patentAdvancedSearchServicePortType.publicationDateSearch(publicationDate, docsStart, docsCount, patent, utility, lastvalue, sortSpec, descSort);
  }
  
  
}