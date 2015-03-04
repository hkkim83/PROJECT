/**
 * FamilyInfoServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class FamilyInfoServiceLocator extends org.apache.axis.client.Service implements kr.or.kipris.plus.FamilyInfoService {

    public FamilyInfoServiceLocator() {
    }


    public FamilyInfoServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public FamilyInfoServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for FamilyInfoServiceHttpSoap11Endpoint
    private java.lang.String FamilyInfoServiceHttpSoap11Endpoint_address = "http://plus.kipris.or.kr:80/kiprisplusws/services/FamilyInfoService.FamilyInfoServiceHttpSoap11Endpoint/";

    public java.lang.String getFamilyInfoServiceHttpSoap11EndpointAddress() {
        return FamilyInfoServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String FamilyInfoServiceHttpSoap11EndpointWSDDServiceName = "FamilyInfoServiceHttpSoap11Endpoint";

    public java.lang.String getFamilyInfoServiceHttpSoap11EndpointWSDDServiceName() {
        return FamilyInfoServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setFamilyInfoServiceHttpSoap11EndpointWSDDServiceName(java.lang.String name) {
        FamilyInfoServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public kr.or.kipris.plus.FamilyInfoServicePortType getFamilyInfoServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(FamilyInfoServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getFamilyInfoServiceHttpSoap11Endpoint(endpoint);
    }

    public kr.or.kipris.plus.FamilyInfoServicePortType getFamilyInfoServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            kr.or.kipris.plus.FamilyInfoServiceSoap11BindingStub _stub = new kr.or.kipris.plus.FamilyInfoServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getFamilyInfoServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setFamilyInfoServiceHttpSoap11EndpointEndpointAddress(java.lang.String address) {
        FamilyInfoServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (kr.or.kipris.plus.FamilyInfoServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                kr.or.kipris.plus.FamilyInfoServiceSoap11BindingStub _stub = new kr.or.kipris.plus.FamilyInfoServiceSoap11BindingStub(new java.net.URL(FamilyInfoServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getFamilyInfoServiceHttpSoap11EndpointWSDDServiceName());
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
        if ("FamilyInfoServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getFamilyInfoServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "FamilyInfoService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://plus.kipris.or.kr/", "FamilyInfoServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("FamilyInfoServiceHttpSoap11Endpoint".equals(portName)) {
            setFamilyInfoServiceHttpSoap11EndpointEndpointAddress(address);
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
