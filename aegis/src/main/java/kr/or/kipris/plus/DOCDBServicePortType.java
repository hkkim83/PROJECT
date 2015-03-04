/**
 * DOCDBServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface DOCDBServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityLinkInfo[] priorityLinkInfo(java.lang.String epoApplno) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocInventorsInfo[] inventorsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDemandParagraphInfo[] docDemandParagraphInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocAgentInfo[] agentInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocIpcInfo[] ipcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocRepresentationImageInfo representationImageInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDesignationNameInfo[] designationNameInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocApplicantInfo[] applicantInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocCpcInfo[] cpcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[] familyInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocEclaInfo[] eclaInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocFamilySummaryInfo familySummaryInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocQuoteLiteraTrueLinkInfo[] quoteLiteraTrueLinkInfo(java.lang.String publicNumber, java.lang.String docdbApplcountryCode, java.lang.String literatureIdCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocSummationInfo[] summationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocQuoteLiteraTrueInfo[] quoteLiteraTrueInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocDesignationInfo[] designationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocFamilyTotalInfo familyTotalInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException, kr.or.kipris.plus.xsd.ExceptionType0;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] priorityInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocInventionNameInfo[] inventionNameInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocSummationOtherInfo[] summationOtherInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
}
