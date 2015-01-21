/**
 * ForeignPatentImageAndFullTextServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class ForeignPatentImageAndFullTextServiceSoap11BindingStub extends org.apache.axis.client.Stub implements kr.or.kipris.plus.ForeignPatentImageAndFullTextServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[11];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("representationImageInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "representationImageInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrationFullTextInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationFullTextInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("registrationNumberLinkInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationNumberLinkInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fullTextCheck");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fullTextInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("openFullTextInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenFullTextInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("revisionAnnounceInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionAnnounceInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fullTextDisplayInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextDisplayInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "fullTextDisplayInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("revisionInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "revisionInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setForeignPatentImageAndFullTextService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "foreignPatentImageAndFullTextService"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentImageAndFullTextService"), kr.or.kipris.plus.webservice.services.xsd.ForeignPatentImageAndFullTextService.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("openNumberLinkInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberLinkInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

    }

    public ForeignPatentImageAndFullTextServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ForeignPatentImageAndFullTextServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ForeignPatentImageAndFullTextServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextDisplayInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextDisplayInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextDisplayInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "fullTextDisplayInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenFullTextInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberLinkInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberLinkInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationFullTextInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationNumberLinkInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationNumberLinkInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "representationImageInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionAnnounceInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RevisionInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "revisionInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentImageAndFullTextService");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.xsd.ForeignPatentImageAndFullTextService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[] representationImageInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:representationImageInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "representationImageInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo registrationFullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:registrationFullTextInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "registrationFullTextInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationFullTextInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray registrationNumberLinkInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:registrationNumberLinkInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "registrationNumberLinkInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfoArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult fullTextCheck(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:fullTextCheck");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fullTextCheck"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextCheckResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo fullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:fullTextInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fullTextInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo openFullTextInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:openFullTextInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "openFullTextInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenFullTextInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo revisionAnnounceInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:revisionAnnounceInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "revisionAnnounceInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionAnnounceInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[] fullTextDisplayInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:fullTextDisplayInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fullTextDisplayInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FullTextDisplayInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[] revisionInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:revisionInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "revisionInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RevisionInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setForeignPatentImageAndFullTextService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentImageAndFullTextService foreignPatentImageAndFullTextService) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:setForeignPatentImageAndFullTextService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "setForeignPatentImageAndFullTextService"));

        setRequestHeaders(_call);
        setAttachments(_call);
        _call.invokeOneWay(new java.lang.Object[] {foreignPatentImageAndFullTextService});

    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray openNumberLinkInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:openNumberLinkInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "openNumberLinkInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberLinkInfoArray.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
