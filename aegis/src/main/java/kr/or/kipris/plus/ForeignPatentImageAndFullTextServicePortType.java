/**
 * ForeignPatentImageAndFullTextServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface ForeignPatentImageAndFullTextServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[] representationImageInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo registrationFullTextInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray registrationNumberLinkInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo fullTextInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo revisionAnnounceInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo openFullTextInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[] fullTextDisplayInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[] revisionInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
    public void setForeignPatentImageAndFullTextService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentImageAndFullTextService foreignPatentImageAndFullTextService) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray openNumberLinkInfo(java.lang.String applicationNumber, java.lang.String countryCode) throws java.rmi.RemoteException;
}
