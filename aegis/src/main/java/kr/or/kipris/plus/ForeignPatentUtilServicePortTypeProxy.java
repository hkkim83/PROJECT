package kr.or.kipris.plus;

public class ForeignPatentUtilServicePortTypeProxy implements kr.or.kipris.plus.ForeignPatentUtilServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.ForeignPatentUtilServicePortType foreignPatentUtilServicePortType = null;
  
  public ForeignPatentUtilServicePortTypeProxy() {
    _initForeignPatentUtilServicePortTypeProxy();
  }
  
  public ForeignPatentUtilServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initForeignPatentUtilServicePortTypeProxy();
  }
  
  private void _initForeignPatentUtilServicePortTypeProxy() {
    try {
      foreignPatentUtilServicePortType = (new kr.or.kipris.plus.ForeignPatentUtilServiceLocator()).getForeignPatentUtilServiceHttpSoap11Endpoint();
      if (foreignPatentUtilServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foreignPatentUtilServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foreignPatentUtilServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foreignPatentUtilServicePortType != null)
      ((javax.xml.rpc.Stub)foreignPatentUtilServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.ForeignPatentUtilServicePortType getForeignPatentUtilServicePortType() {
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType;
  }
  
//  public kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse getAnnualApplicationCountByPublicationDate() throws java.rmi.RemoteException{
//    if (foreignPatentUtilServicePortType == null)
//      _initForeignPatentUtilServicePortTypeProxy();
//    return foreignPatentUtilServicePortType.getAnnualApplicationCountByPublicationDate();
//  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[] getLtrtno(java.lang.String countryCode, java.lang.String applicationNumber, java.lang.String openNumber, java.lang.String registNumber, java.lang.String publicationNumber) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getLtrtno(countryCode, applicationNumber, openNumber, registNumber, publicationNumber);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[] getAccumulatedDataInfo() throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getAccumulatedDataInfo();
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getIpcCode(java.lang.String ipcCd) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getIpcCode(ipcCd);
  }
  
  public void setForeignPatentUtilService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentUtilService foreignPatentUtilService) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    foreignPatentUtilServicePortType.setForeignPatentUtilService(foreignPatentUtilService);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByRegistrationDate() throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getAnnualApplicationCountByRegistrationDate();
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[] getCpcCode(java.lang.String cpcCd) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getCpcCode(cpcCd);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByApplicationDate(java.lang.String year) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getMonthlyApplicationCountByApplicationDate(year);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFtermCode(java.lang.String ftermCode) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getFtermCode(ftermCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByRegistrationDate(java.lang.String year) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getMonthlyApplicationCountByRegistrationDate(year);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFiCode(java.lang.String fiCode) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getFiCode(fiCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByOpenDate(java.lang.String year) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getMonthlyApplicationCountByOpenDate(year);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getUpcCode(java.lang.String upcUspdCd) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getUpcCode(upcUspdCd);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByPublicationDate(java.lang.String year) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getMonthlyApplicationCountByPublicationDate(year);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[] getPopularKeyword() throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getPopularKeyword();
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByApplicationDate() throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getAnnualApplicationCountByApplicationDate();
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByOpenDate() throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getAnnualApplicationCountByOpenDate();
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getEpcCode(java.lang.String epcCode) throws java.rmi.RemoteException{
    if (foreignPatentUtilServicePortType == null)
      _initForeignPatentUtilServicePortTypeProxy();
    return foreignPatentUtilServicePortType.getEpcCode(epcCode);
  }
  
  
}