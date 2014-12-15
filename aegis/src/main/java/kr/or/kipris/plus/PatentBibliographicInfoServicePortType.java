/**
 * PatentBibliographicInfoServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface PatentBibliographicInfoServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.AgentInfo[] agentInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.IpcInfo[] ipcInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.LegalStatusInfo[] legalStatusInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.InternationalInfo[] internationalInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.ClaimInfo[] claimInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.ApplicantInfo[] applicantInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.DesignatedStateInfo[] designatedStateInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FamilyInfo[] familyInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.AbstractInfo[] abstractInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.BiblioSummaryInfo[] biblioSummaryInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorArtDocumentsInfo[] priorArtDocumentsInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.BibliographicInfoArray bibliographicInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.InventorInfo[] inventorInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.PriorityInfo[] priorityInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
}
