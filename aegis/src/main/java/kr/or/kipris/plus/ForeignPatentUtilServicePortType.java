/**
 * ForeignPatentUtilServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface ForeignPatentUtilServicePortType extends java.rmi.Remote {
//    public kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse getAnnualApplicationCountByPublicationDate() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[] getLtrtno(java.lang.String countryCode, java.lang.String applicationNumber, java.lang.String openNumber, java.lang.String registNumber, java.lang.String publicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[] getAccumulatedDataInfo() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getIpcCode(java.lang.String ipcCd) throws java.rmi.RemoteException;
    public void setForeignPatentUtilService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentUtilService foreignPatentUtilService) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByRegistrationDate() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[] getCpcCode(java.lang.String cpcCd) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByApplicationDate(java.lang.String year) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFtermCode(java.lang.String ftermCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByRegistrationDate(java.lang.String year) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFiCode(java.lang.String fiCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByOpenDate(java.lang.String year) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getUpcCode(java.lang.String upcUspdCd) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByPublicationDate(java.lang.String year) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[] getPopularKeyword() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByApplicationDate() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByOpenDate() throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getEpcCode(java.lang.String epcCode) throws java.rmi.RemoteException;
}
