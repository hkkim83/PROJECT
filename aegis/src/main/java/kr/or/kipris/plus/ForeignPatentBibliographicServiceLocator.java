/**
 * ForeignPatentBibliographicServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class ForeignPatentBibliographicServiceLocator extends org.apache.axis.client.Service implements kr.or.kipris.plus.ForeignPatentBibliographicService {

    public ForeignPatentBibliographicServiceLocator() {
    }


    public ForeignPatentBibliographicServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ForeignPatentBibliographicServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ForeignPatentBibliographicServiceHttpSoap11Endpoint
    private java.lang.String ForeignPatentBibliographicServiceHttpSoap11Endpoint_address = "http://plus.kipris.or.kr:80/kiprisplusws/services/ForeignPatentBibliographicService.ForeignPatentBibliographicServiceHttpSoap11Endpoint/";

    public java.lang.String getForeignPatentBibliographicServiceHttpSoap11EndpointAddress() {
        return ForeignPatentBibliographicServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName = "ForeignPatentBibliographicServiceHttpSoap11Endpoint";

    public java.lang.String getForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName() {
        return ForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        ForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public kr.or.kipris.plus.ForeignPatentBibliographicServicePortType getForeignPatentBibliographicServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ForeignPatentBibliographicServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getForeignPatentBibliographicServiceHttpSoap11Endpoint(endpoint);
    }

    public kr.or.kipris.plus.ForeignPatentBibliographicServicePortType getForeignPatentBibliographicServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub _stub = new kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setForeignPatentBibliographicServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        ForeignPatentBibliographicServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (kr.or.kipris.plus.ForeignPatentBibliographicServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub _stub = new kr.or.kipris.plus.ForeignPatentBibliographicServiceSoap11BindingStub(new java.net.URL(ForeignPatentBibliographicServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getForeignPatentBibliographicServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("ForeignPatentBibliographicServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getForeignPatentBibliographicServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "ForeignPatentBibliographicService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "ForeignPatentBibliographicServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ForeignPatentBibliographicServiceHttpSoap11Endpoint".equals(portName)) {
            setForeignPatentBibliographicServiceHttpSoap11EndpointEndpointAddress(address);
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
