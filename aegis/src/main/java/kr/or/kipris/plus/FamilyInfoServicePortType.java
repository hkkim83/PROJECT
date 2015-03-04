/**
 * FamilyInfoServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface FamilyInfoServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfoA(java.lang.String applicationCountryCode, java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd.FamilyInfo[] familyInfoP(java.lang.String publicationCountryCode, java.lang.String publicationNumber) throws java.rmi.RemoteException;
}
