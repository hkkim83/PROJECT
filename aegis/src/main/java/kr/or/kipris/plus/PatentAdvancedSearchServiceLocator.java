/**
 * PatentAdvancedSearchServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class PatentAdvancedSearchServiceLocator extends org.apache.axis.client.Service implements kr.or.kipris.plus.PatentAdvancedSearchService {

    public PatentAdvancedSearchServiceLocator() {
    }


    public PatentAdvancedSearchServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PatentAdvancedSearchServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PatentAdvancedSearchServiceHttpSoap11Endpoint
    private java.lang.String PatentAdvancedSearchServiceHttpSoap11Endpoint_address = "http://plus.kipris.or.kr:80/kiprisplusws/services/PatentAdvancedSearchService.PatentAdvancedSearchServiceHttpSoap11Endpoint/";

    public java.lang.String getPatentAdvancedSearchServiceHttpSoap11EndpointAddress() {
        return PatentAdvancedSearchServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName = "PatentAdvancedSearchServiceHttpSoap11Endpoint";

    public java.lang.String getPatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName() {
        return PatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setPatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        PatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public kr.or.kipris.plus.PatentAdvancedSearchServicePortType getPatentAdvancedSearchServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PatentAdvancedSearchServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPatentAdvancedSearchServiceHttpSoap11Endpoint(endpoint);
    }

    public kr.or.kipris.plus.PatentAdvancedSearchServicePortType getPatentAdvancedSearchServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub _stub = new kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getPatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPatentAdvancedSearchServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        PatentAdvancedSearchServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (kr.or.kipris.plus.PatentAdvancedSearchServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub _stub = new kr.or.kipris.plus.PatentAdvancedSearchServiceSoap11BindingStub(new java.net.URL(PatentAdvancedSearchServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getPatentAdvancedSearchServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("PatentAdvancedSearchServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getPatentAdvancedSearchServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "PatentAdvancedSearchService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "PatentAdvancedSearchServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PatentAdvancedSearchServiceHttpSoap11Endpoint".equals(portName)) {
            setPatentAdvancedSearchServiceHttpSoap11EndpointEndpointAddress(address);
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
