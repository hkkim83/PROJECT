/**
 * ForeignPatentGeneralSearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class ForeignPatentGeneralSearchServiceLocator extends org.apache.axis.client.Service implements kr.or.kipris.plus.ForeignPatentGeneralSearchService {

    public ForeignPatentGeneralSearchServiceLocator() {
    }


    public ForeignPatentGeneralSearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ForeignPatentGeneralSearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ForeignPatentGeneralSearchServiceHttpSoap11Endpoint
    private java.lang.String ForeignPatentGeneralSearchServiceHttpSoap11Endpoint_address = "http://plus.kipris.or.kr:80/kiprisplusws/services/ForeignPatentGeneralSearchService.ForeignPatentGeneralSearchServiceHttpSoap11Endpoint/";

    public java.lang.String getForeignPatentGeneralSearchServiceHttpSoap11EndpointAddress() {
        return ForeignPatentGeneralSearchServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName = "ForeignPatentGeneralSearchServiceHttpSoap11Endpoint";

    public java.lang.String getForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName() {
        return ForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType getForeignPatentGeneralSearchServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ForeignPatentGeneralSearchServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getForeignPatentGeneralSearchServiceHttpSoap11Endpoint(endpoint);
    }

    public kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType getForeignPatentGeneralSearchServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            kr.or.kipris.plus.ForeignPatentGeneralSearchServiceSoap11BindingStub _stub = new kr.or.kipris.plus.ForeignPatentGeneralSearchServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setForeignPatentGeneralSearchServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ForeignPatentGeneralSearchServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (kr.or.kipris.plus.ForeignPatentGeneralSearchServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                kr.or.kipris.plus.ForeignPatentGeneralSearchServiceSoap11BindingStub _stub = new kr.or.kipris.plus.ForeignPatentGeneralSearchServiceSoap11BindingStub(new java.net.URL(ForeignPatentGeneralSearchServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getForeignPatentGeneralSearchServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ForeignPatentGeneralSearchServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getForeignPatentGeneralSearchServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "ForeignPatentGeneralSearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "ForeignPatentGeneralSearchServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ForeignPatentGeneralSearchServiceHttpSoap11Endpoint".equals(portName)) {
            setForeignPatentGeneralSearchServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
