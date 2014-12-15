package kr.or.kipris.plus;

public class ForeignPatentAdvencedSearchServicePortTypeProxy implements kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortType foreignPatentAdvencedSearchServicePortType = null;
  
  public ForeignPatentAdvencedSearchServicePortTypeProxy() {
    _initForeignPatentAdvencedSearchServicePortTypeProxy();
  }
  
  public ForeignPatentAdvencedSearchServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initForeignPatentAdvencedSearchServicePortTypeProxy();
  }
  
  private void _initForeignPatentAdvencedSearchServicePortTypeProxy() {
    try {
      foreignPatentAdvencedSearchServicePortType = (new kr.or.kipris.plus.ForeignPatentAdvencedSearchServiceLocator()).getForeignPatentAdvencedSearchServiceHttpSoap11Endpoint();
      if (foreignPatentAdvencedSearchServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foreignPatentAdvencedSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foreignPatentAdvencedSearchServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foreignPatentAdvencedSearchServicePortType != null)
      ((javax.xml.rpc.Stub)foreignPatentAdvencedSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.ForeignPatentAdvencedSearchServicePortType getForeignPatentAdvencedSearchServicePortType() {
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray detailsDescriptionSearch(java.lang.String detailsDescription, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.detailsDescriptionSearch(detailsDescription, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray ftermSearch(java.lang.String fterm, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.ftermSearch(fterm, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray internationalOpenNumberSearch(java.lang.String internationalOpenNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.internationalOpenNumberSearch(internationalOpenNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray freeSearch(java.lang.String free, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.freeSearch(free, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray claimExtendSearch(java.lang.String claimExtend, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.claimExtendSearch(claimExtend, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray applicationdateSearch(java.lang.String applicationdate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.applicationdateSearch(applicationdate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray applicationNumberSearch(java.lang.String applicationNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.applicationNumberSearch(applicationNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public void setForeignPatentItemSearchService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentItemSearchService foreignPatentItemSearchService) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    foreignPatentAdvencedSearchServicePortType.setForeignPatentItemSearchService(foreignPatentItemSearchService);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray usPatentDocumentSearch(java.lang.String usPatentDocument, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.usPatentDocumentSearch(usPatentDocument, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray agentsSearch(java.lang.String agents, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.agentsSearch(agents, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray openNumberSearch(java.lang.String openNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.openNumberSearch(openNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray inventorsSearch(java.lang.String inventors, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.inventorsSearch(inventors, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray advancedSearch(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FpatBeanItem fpatBean) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.advancedSearch(fpatBean);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray registerNumberSearch(java.lang.String registerNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.registerNumberSearch(registerNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray upcSearch(java.lang.String upc, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.upcSearch(upc, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray foreignRefNumberSearch(java.lang.String foreignRefNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.foreignRefNumberSearch(foreignRefNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray epcSearch(java.lang.String epc, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.epcSearch(epc, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray otherRefSearch(java.lang.String otherRef, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.otherRefSearch(otherRef, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray publishrDateSearch(java.lang.String publishrDate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.publishrDateSearch(publishrDate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray priorityDateSearch(java.lang.String priorityDate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.priorityDateSearch(priorityDate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray ipcSearch(java.lang.String ipc, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.ipcSearch(ipc, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray abstractSearch(java.lang.String abstracts, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.abstractSearch(abstracts, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray fieldSearch(java.lang.String field, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.fieldSearch(field, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray internationalApplicationDateSearch(java.lang.String internationalApplicationDate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.internationalApplicationDateSearch(internationalApplicationDate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray publishrNoSearch(java.lang.String publishrNo, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.publishrNoSearch(publishrNo, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray priorityNumberSearch(java.lang.String priorityNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.priorityNumberSearch(priorityNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray registerDateSearch(java.lang.String registerDate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.registerDateSearch(registerDate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray openDateSearch(java.lang.String openDate, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.openDateSearch(openDate, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray applicantSearch(java.lang.String applicant, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.applicantSearch(applicant, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray internationalApplicationNumberSearch(java.lang.String internationalApplicationNumber, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.internationalApplicationNumberSearch(internationalApplicationNumber, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray inventionNameSearch(java.lang.String invention, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.inventionNameSearch(invention, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray fiSearch(java.lang.String fi, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.fiSearch(fi, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray relationUSSearch(java.lang.String relationUS, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentAdvencedSearchServicePortType == null)
      _initForeignPatentAdvencedSearchServicePortTypeProxy();
    return foreignPatentAdvencedSearchServicePortType.relationUSSearch(relationUS, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  
}