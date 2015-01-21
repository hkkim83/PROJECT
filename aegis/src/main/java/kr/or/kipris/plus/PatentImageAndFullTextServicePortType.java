/**
 * PatentImageAndFullTextServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface PatentImageAndFullTextServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] examPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] unexPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[] revisionfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo examPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo unexPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[] abstractFigure(java.lang.String applicationNumber) throws java.rmi.RemoteException;
}
