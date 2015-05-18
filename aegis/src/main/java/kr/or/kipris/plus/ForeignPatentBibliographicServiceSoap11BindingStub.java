/**
 * ForeignPatentBibliographicServiceSoap11BindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus;

public class ForeignPatentBibliographicServiceSoap11BindingStub extends org.apache.axis.client.Stub implements kr.or.kipris.plus.ForeignPatentBibliographicServicePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[31];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("relatedUsApplicationDataInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedUsApplicationDataInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("inventorsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InventorsInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventorsInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("internationalApplicationOpenInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalApplicationOpenInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationOpenInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("foreignPatentDocumentsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentDocumentsInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "foreignPatentDocumentsInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ipcInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("agentInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AgentInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "agentInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("summation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SummationArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "summation"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bibliographicSummaryInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "BibliographicSummaryInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("applicantInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ApplicantInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicantInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("cpcInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "CpcInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "cpcInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("priorityNumberDateInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorityNumberDateInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityNumberDateInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("foreignBiblio");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignBiblioArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "foreignBiblio"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("setForeignPatentBibliographicService");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "foreignPatentBibliographicService"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentBibliographicService"), kr.or.kipris.plus.webservice.services.xsd.ForeignPatentBibliographicService.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("usPatentDocumentsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UsPatentDocumentsInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "usPatentDocumentsInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("otherPublicationsInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OtherPublicationsInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "otherPublicationsInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("docdbFamilyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "docdb_countryCode_cd"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocdbFamilyInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbFamilyInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getOpenAnnounceNumber");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "GetOpenAnnounceNumber"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("familyInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "familyInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("themeCodeInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ThemeCodeInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "themeCodeInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("eclaInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "EclaInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "eclaInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ipcVersionInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcVersionInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcVersionInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("demandParagraphInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DemandParagraphInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "demandParagraphInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("relatedUsApplicationDataDetailInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataDetailInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedUsApplicationDataDetailInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("judgesInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "JudgesInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "judgesInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("bibliographicInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "BibliographicInfo"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("openNumberInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openNumberInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ftermInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FtermInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ftermInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("designationInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DesignationInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "designationInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("fiInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FiInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "fiInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getfield");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "GetfieldArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "getfield"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("upcInfo");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UpcInfoArray"));
        oper.setReturnClass(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "upcInfo"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[30] = oper;

    }

    public ForeignPatentBibliographicServiceSoap11BindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ForeignPatentBibliographicServiceSoap11BindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ForeignPatentBibliographicServiceSoap11BindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AgentInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AgentInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AgentInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "agentInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ApplicantInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ApplicantInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ApplicantInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicantInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "BibliographicInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "BibliographicSummaryInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "CpcInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "CpcInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "CpcInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "cpcInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DemandParagraphInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DemandParagraphInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DemandParagraphInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "demandParagraphInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DesignationInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DesignationInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DesignationInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "designationInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocdbFamilyInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocdbFamilyInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocdbFamilyInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbFamilyInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "EclaInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "EclaInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "EclaInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "eclaInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "familyInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FiInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FiInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FiInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "fiInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignBiblio");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignBiblioArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignBiblio");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "foreignBiblio");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentDocumentsInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentDocumentsInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentDocumentsInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "foreignPatentDocumentsInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FtermInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FtermInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FtermInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ftermInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "Getfield");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "GetfieldArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "Getfield");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "getfield");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "GetOpenAnnounceNumber");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalApplicationOpenInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalApplicationOpenInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalApplicationOpenInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationOpenInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InventorsInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InventorsInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InventorsInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventorsInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcVersionInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcVersionInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcVersionInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcVersionInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "JudgesInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "JudgesInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "JudgesInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "judgesInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OpenNumberInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openNumberInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OtherPublicationsInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OtherPublicationsInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "OtherPublicationsInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "otherPublicationsInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorityNumberDateInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorityNumberDateInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorityNumberDateInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityNumberDateInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataDetailInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataDetailInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataDetailInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedUsApplicationDataDetailInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedUsApplicationDataInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RepresentationImageInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "Summation");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SummationArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "Summation");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "summation");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ThemeCodeInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ThemeCodeInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ThemeCodeInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "themeCodeInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UpcInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UpcInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UpcInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "upcInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UsPatentDocumentsInfo");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UsPatentDocumentsInfoArray");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "UsPatentDocumentsInfo");
            qName2 = new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "usPatentDocumentsInfo");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentBibliographicService");
            cachedSerQNames.add(qName);
            cls = kr.or.kipris.plus.webservice.services.xsd.ForeignPatentBibliographicService.class;
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

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[] relatedUsApplicationDataInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:relatedUsApplicationDataInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "relatedUsApplicationDataInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[] inventorsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:inventorsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "inventorsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InventorsInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[] internationalApplicationOpenInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:internationalApplicationOpenInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "internationalApplicationOpenInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.InternationalApplicationOpenInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[] foreignPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:foreignPatentDocumentsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "foreignPatentDocumentsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignPatentDocumentsInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[] ipcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ipcInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "ipcInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[] agentInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:agentInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "agentInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.AgentInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[] summation(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:summation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "summation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Summation[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo bibliographicSummaryInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:bibliographicSummaryInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "bibliographicSummaryInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicSummaryInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[] applicantInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:applicantInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "applicantInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ApplicantInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[] cpcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:cpcInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "cpcInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.CpcInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[] priorityNumberDateInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:priorityNumberDateInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "priorityNumberDateInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.PriorityNumberDateInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[] foreignBiblio(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:foreignBiblio");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "foreignBiblio"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ForeignBiblio[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public void setForeignPatentBibliographicService(kr.or.kipris.plus.webservice.services.xsd.ForeignPatentBibliographicService foreignPatentBibliographicService) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:setForeignPatentBibliographicService");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "setForeignPatentBibliographicService"));

        setRequestHeaders(_call);
        setAttachments(_call);
        _call.invokeOneWay(new java.lang.Object[] {foreignPatentBibliographicService});

    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[] usPatentDocumentsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:usPatentDocumentsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "usPatentDocumentsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UsPatentDocumentsInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[] otherPublicationsInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:otherPublicationsInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "otherPublicationsInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OtherPublicationsInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[] docdbFamilyInfo(java.lang.String literatureNumber, java.lang.String docdb_countryCode_cd) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:docdbFamilyInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "docdbFamilyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, docdb_countryCode_cd});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocdbFamilyInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber getOpenAnnounceNumber(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getOpenAnnounceNumber");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getOpenAnnounceNumber"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.GetOpenAnnounceNumber.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[] familyInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:familyInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "familyInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FamilyInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[] themeCodeInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:themeCodeInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "themeCodeInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.ThemeCodeInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[] eclaInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:eclaInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "eclaInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.EclaInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[] ipcVersionInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ipcVersionInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "ipcVersionInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.IpcVersionInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[] demandParagraphInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:demandParagraphInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "demandParagraphInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DemandParagraphInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[] relatedUsApplicationDataDetailInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:relatedUsApplicationDataDetailInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "relatedUsApplicationDataDetailInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RelatedUsApplicationDataDetailInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[] judgesInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:judgesInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "judgesInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.JudgesInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo bibliographicInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:bibliographicInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "bibliographicInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.BibliographicInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[] openNumberInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:openNumberInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "openNumberInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.OpenNumberInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[] ftermInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ftermInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "ftermInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FtermInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[] designationInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:designationInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "designationInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DesignationInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[] fiInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:fiInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "fiInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.FiInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[] getfield(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:getfield");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "getfield"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.Getfield[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[] upcInfo(java.lang.String literatureNumber, java.lang.String countryCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:upcInfo");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "upcInfo"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {literatureNumber, countryCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.UpcInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
