package kr.or.kipris.plus;

public class ForeignPatentBibliographicServicePortTypeProxy implements kr.or.kipris.plus.ForeignPatentBibliographicServicePortType {
  private String _endpoint = null;
  private kr.or.kipris.plus.ForeignPatentBibliographicServicePortType foreignPatentBibliographicServicePortType = null;
  
  public ForeignPatentBibliographicServicePortTypeProxy() {
    _initForeignPatentBibliographicServicePortTypeProxy();
  }
  
  public ForeignPatentBibliographicServicePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initForeignPatentBibliographicServicePortTypeProxy();
  }
  
  private void _initForeignPatentBibliographicServicePortTypeProxy() {
    try {
      foreignPatentBibliographicServicePortType = (new kr.or.kipris.plus.ForeignPatentBibliographicServiceLocator()).getForeignPatentBibliographicServiceHttpSoap11Endpoint();
      if (foreignPatentBibliographicServicePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foreignPatentBibliographicServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foreignPatentBibliographicServicePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foreignPatentBibliographicServicePortType != null)
      ((javax.xml.rpc.Stub)foreignPatentBibliographicServicePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public kr.or.kipris.plus.ForeignPatentBibliographicServicePortType getForeignPatentBibliographicServicePortType() {
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType;
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[] inventorsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.inventorsInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[] relatedUsApplicationDataInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.relatedUsApplicationDataInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[] foreignPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.foreignPatentDocumentsInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[] internationalApplicationOpenInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.internationalApplicationOpenInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[] agentInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.agentInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[] ipcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.ipcInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[] summation(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.summation(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo bibliographicSummaryInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.bibliographicSummaryInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[] applicantInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.applicantInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[] cpcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.cpcInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[] usPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.usPatentDocumentsInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[] docdbFamilyInfo(java.lang.String literatureNumber, java.lang.String docdb_countryCode_cd) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.docdbFamilyInfo(literatureNumber, docdb_countryCode_cd);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[] foreignBiblio(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.foreignBiblio(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[] priorityNumberDateInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.priorityNumberDateInfo(literatureNumber, countryCode);
  }
  
  public void setForeignPatentBibliographicService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentBibliographicService foreignPatentBibliographicService) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    foreignPatentBibliographicServicePortType.setForeignPatentBibliographicService(foreignPatentBibliographicService);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[] otherPublicationsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.otherPublicationsInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber getOpenAnnounceNumber(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.getOpenAnnounceNumber(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[] themeCodeInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.themeCodeInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[] eclaInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.eclaInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[] ipcVersionInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.ipcVersionInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[] relatedUsApplicationDataDetailInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.relatedUsApplicationDataDetailInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[] demandParagraphInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.demandParagraphInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[] judgesInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.judgesInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo bibliographicInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.bibliographicInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[] openNumberInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.openNumberInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[] designationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.designationInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[] ftermInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.ftermInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[] fiInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.fiInfo(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[] getfield(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.getfield(literatureNumber, countryCode);
  }
  
  public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[] upcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException{
    if (foreignPatentBibliographicServicePortType == null)
      _initForeignPatentBibliographicServicePortTypeProxy();
    return foreignPatentBibliographicServicePortType.upcInfo(literatureNumber, countryCode);
  }
  
  
}