package kr.or.kipris.plus;

public class ForeignPatentGeneralSearchServicePortTypeProxy implements kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType foreignPatentGeneralSearchServicePortType = null;
  
  public ForeignPatentGeneralSearchServicePortTypeProxy() {
    _initForeignPatentGeneralSearchServicePortTypeProxy();
  }
  
  public ForeignPatentGeneralSearchServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initForeignPatentGeneralSearchServicePortTypeProxy();
  }
  
  private void _initForeignPatentGeneralSearchServicePortTypeProxy() {
    try {
      foreignPatentGeneralSearchServicePortType = (new kr.or.kipris.plus.ForeignPatentGeneralSearchServiceLocator()).getForeignPatentGeneralSearchServiceHttpSoap11Endpoint();
      if (foreignPatentGeneralSearchServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foreignPatentGeneralSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foreignPatentGeneralSearchServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foreignPatentGeneralSearchServicePortType != null)
      ((javax.xml.rpc.Stub)foreignPatentGeneralSearchServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType getForeignPatentGeneralSearchServicePortType() {
    if (foreignPatentGeneralSearchServicePortType == null)
      _initForeignPatentGeneralSearchServicePortTypeProxy();
    return foreignPatentGeneralSearchServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray numberSearch(java.lang.String searchNumber, java.lang.String searchNumberKind, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentGeneralSearchServicePortType == null)
      _initForeignPatentGeneralSearchServicePortTypeProxy();
    return foreignPatentGeneralSearchServicePortType.numberSearch(searchNumber, searchNumberKind, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  public void setForeignPatentGeneralSearchService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentGeneralSearchService foreignPatentGeneralSearchService) throws java.rmi.RemoteException{
    if (foreignPatentGeneralSearchServicePortType == null)
      _initForeignPatentGeneralSearchServicePortTypeProxy();
    foreignPatentGeneralSearchServicePortType.setForeignPatentGeneralSearchService(foreignPatentGeneralSearchService);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray wordSearch(java.lang.String searchWord, java.lang.String searchWordRange, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException{
    if (foreignPatentGeneralSearchServicePortType == null)
      _initForeignPatentGeneralSearchServicePortTypeProxy();
    return foreignPatentGeneralSearchServicePortType.wordSearch(searchWord, searchWordRange, collectionValues, currentPage, docsCount, sortState, sortField);
  }
  
  
}