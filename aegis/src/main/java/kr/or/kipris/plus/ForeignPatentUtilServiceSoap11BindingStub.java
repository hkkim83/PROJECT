/**
 * ForeignPatentUtilServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class ForeignPatentUtilServiceSoap11BindingStub extends org.apache.axis.client.Stub implements kr.or.kipris.plus.ForeignPatentUtilServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[18];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnualApplicationCountByPublicationDate");
        oper.setReturnType(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", ">getAnnualApplicationCountByPublicationDateResponse"));
//        oper.setReturnClass(kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getAnnualApplicationCountByPublicationDateResponse"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAccumulatedDataInfo");
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AccumulatedInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "accumulatedInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLtrtno");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "openNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "registNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "publicationNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "LtrtnoInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getIpcCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "ipcCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setForeignPatentUtilService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "foreignPatentUtilService"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentUtilService"), kr.or.kipris.plus.webservice.services.xsd.ForeignPatentUtilService.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnualApplicationCountByRegistrationDate");
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "annualApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getCpcCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "cpcCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCpcResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCpcResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMonthlyApplicationCountByApplicationDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "monthlyApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMonthlyApplicationCountByRegistrationDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "monthlyApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFtermCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "ftermCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getFiCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fiCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMonthlyApplicationCountByOpenDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "monthlyApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getUpcCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "upcUspdCd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMonthlyApplicationCountByPublicationDate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "year"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "monthlyApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPopularKeyword");
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PopularKeywordInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "popularKeywordInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnualApplicationCountByApplicationDate");
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "annualApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getEpcCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "epcCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAnnualApplicationCountByOpenDate");
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "annualApplicationCountInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

    }

    public ForeignPatentUtilServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ForeignPatentUtilServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ForeignPatentUtilServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AccumulatedInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AccumulatedInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AccumulatedInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "accumulatedInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "annualApplicationCountInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "LtrtnoInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "MonthlyApplicationCountInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "monthlyApplicationCountInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PopularKeywordInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PopularKeywordInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PopularKeywordInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "popularKeywordInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResult");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResultArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResult");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCodeResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCpcResult");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCpcResultArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCpcResult");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchCpcResult");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentUtilService");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.xsd.ForeignPatentUtilService.class;
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

//    public kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse getAnnualApplicationCountByPublicationDate() throws java.rmi.RemoteException {
//        if (super.cachedEndpoint == null) {
//            throw new org.apache.axis.NoEndPointException();
//        }
//        org.apache.axis.client.Call _call = createCall();
//        _call.setOperation(_operations[0]);
//        _call.setUseSOAPAction(true);
//        _call.setSOAPActionURI("urn:getAnnualApplicationCountByPublicationDate");
//        _call.setEncodingStyle(null);
//        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
//        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
//        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
//
//        setRequestHeaders(_call);
//        setAttachments(_call);
// try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});
//
//        if (_resp instanceof java.rmi.RemoteException) {
//            throw (java.rmi.RemoteException)_resp;
//        }
//        else {
//            extractAttachments(_call);
//            try {
//                return (kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse) _resp;
//            } catch (java.lang.Exception _exception) {
//                return (kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.xsd.GetAnnualApplicationCountByPublicationDateResponse.class);
//            }
//        }
//  } catch (org.apache.axis.AxisFault axisFaultException) {
//  throw axisFaultException;
//}
//    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[] getAccumulatedDataInfo() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getAccumulatedDataInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AccumulatedInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[] getLtrtno(java.lang.String countryCode, java.lang.String applicationNumber, java.lang.String openNumber, java.lang.String registNumber, java.lang.String publicationNumber) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getLtrtno");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getLtrtno"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {countryCode, applicationNumber, openNumber, registNumber, publicationNumber});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.LtrtnoInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getIpcCode(java.lang.String ipcCd) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getIpcCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getIpcCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ipcCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setForeignPatentUtilService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentUtilService foreignPatentUtilService) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:setForeignPatentUtilService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "setForeignPatentUtilService"));

        setRequestHeaders(_call);
        setAttachments(_call);
        _call.invokeOneWay(new java.lang.Object[] {foreignPatentUtilService});

    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByRegistrationDate() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getAnnualApplicationCountByRegistrationDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[] getCpcCode(java.lang.String cpcCd) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getCpcCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getCpcCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {cpcCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCpcResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByApplicationDate(java.lang.String year) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getMonthlyApplicationCountByApplicationDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getMonthlyApplicationCountByApplicationDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {year});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByRegistrationDate(java.lang.String year) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getMonthlyApplicationCountByRegistrationDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getMonthlyApplicationCountByRegistrationDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {year});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFtermCode(java.lang.String ftermCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getFtermCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getFtermCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ftermCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getFiCode(java.lang.String fiCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getFiCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getFiCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {fiCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByOpenDate(java.lang.String year) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getMonthlyApplicationCountByOpenDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getMonthlyApplicationCountByOpenDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {year});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getUpcCode(java.lang.String upcUspdCd) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getUpcCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getUpcCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {upcUspdCd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[] getMonthlyApplicationCountByPublicationDate(java.lang.String year) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getMonthlyApplicationCountByPublicationDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getMonthlyApplicationCountByPublicationDate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {year});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.MonthlyApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[] getPopularKeyword() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getPopularKeyword");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PopularKeywordInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByApplicationDate() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getAnnualApplicationCountByApplicationDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[] getEpcCode(java.lang.String epcCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getEpcCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getEpcCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {epcCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchCodeResult[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[] getAnnualApplicationCountByOpenDate() throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getAnnualApplicationCountByOpenDate");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AnnualApplicationCountInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
