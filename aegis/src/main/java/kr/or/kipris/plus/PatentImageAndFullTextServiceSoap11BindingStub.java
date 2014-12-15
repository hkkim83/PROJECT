/**
 * PatentImageAndFullTextServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class PatentImageAndFullTextServiceSoap11BindingStub extends org.apache.axis.client.Stub implements kr.or.kipris.plus.PatentImageAndFullTextServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fullTextCheck");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("unexPubBookInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "filePathInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("examPubBookInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "filePathInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("revisionfullDocPDFInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathRevisionInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "filePathRevisionInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("examPubfullDocPDFInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("abstractFigure");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ImagePathInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "imagePathInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("unexPubfullDocPDFInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

    }

    public PatentImageAndFullTextServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PatentImageAndFullTextServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PatentImageAndFullTextServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathInfo");
            qName2 = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "filePathInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathRevisionInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathRevisionInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FilePathRevisionInfo");
            qName2 = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "filePathRevisionInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ImagePathInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ImagePathInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ImagePathInfo");
            qName2 = new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "imagePathInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:fullTextCheck");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fullTextCheck"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FullTextCheckResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] unexPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:unexPubBookInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "unexPubBookInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[] examPubBookInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:examPubBookInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "examPubBookInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[] revisionfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:revisionfullDocPDFInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "revisionfullDocPDFInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathRevisionInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo examPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:examPubfullDocPDFInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "examPubfullDocPDFInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[] abstractFigure(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:abstractFigure");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "abstractFigure"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.ImagePathInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo unexPubfullDocPDFInfo(java.lang.String applicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:unexPubfullDocPDFInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "unexPubfullDocPDFInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {applicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.patentbean.xsd.FilePathInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
