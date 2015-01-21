/**
 * ForeignPatentGeneralSearchServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public interface ForeignPatentGeneralSearchServicePortType extends java.rmi.Remote {
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray numberSearch(java.lang.String searchNumber, java.lang.String searchNumberKind, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException;
    public void setForeignPatentGeneralSearchService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentGeneralSearchService foreignPatentGeneralSearchService) throws java.rmi.RemoteException;
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResultArray wordSearch(java.lang.String searchWord, java.lang.String searchWordRange, java.lang.String collectionValues, java.lang.String currentPage, java.lang.String docsCount, java.lang.String sortState, java.lang.String sortField) throws java.rmi.RemoteException;
}
