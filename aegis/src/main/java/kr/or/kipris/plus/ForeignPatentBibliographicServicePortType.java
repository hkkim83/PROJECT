/**
 * ForeignPatentBibliographicServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface ForeignPatentBibliographicServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[] inventorsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[] relatedUsApplicationDataInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[] foreignPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[] internationalApplicationOpenInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[] agentInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[] ipcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[] summation(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo bibliographicSummaryInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[] applicantInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[] cpcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[] usPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[] docdbFamilyInfo(java.lang.String literatureNumber, java.lang.String docdb_countryCode_cd) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[] foreignBiblio(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[] priorityNumberDateInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public void setForeignPatentBibliographicService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentBibliographicService foreignPatentBibliographicService) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[] otherPublicationsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[] familyInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber getOpenAnnounceNumber(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[] themeCodeInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[] eclaInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[] ipcVersionInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[] relatedUsApplicationDataDetailInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[] demandParagraphInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[] judgesInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo bibliographicInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[] openNumberInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[] designationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[] ftermInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[] fiInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[] getfield(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[] upcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
}
