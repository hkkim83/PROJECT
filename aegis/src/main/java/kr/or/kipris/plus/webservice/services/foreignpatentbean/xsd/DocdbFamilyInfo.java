/**
 * DocdbFamilyInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocdbFamilyInfo  implements java.io.Serializable {
    private java.lang.String docdbCountryCode;

    private java.lang.String docdbLiteratureIdCode;

    private java.lang.String docdbLiteratureNumber;

    private java.lang.String epodocPublicNumber;

    public DocdbFamilyInfo() {
    }

    public DocdbFamilyInfo(
           java.lang.String docdbCountryCode,
           java.lang.String docdbLiteratureIdCode,
           java.lang.String docdbLiteratureNumber,
           java.lang.String epodocPublicNumber) {
           this.docdbCountryCode = docdbCountryCode;
           this.docdbLiteratureIdCode = docdbLiteratureIdCode;
           this.docdbLiteratureNumber = docdbLiteratureNumber;
           this.epodocPublicNumber = epodocPublicNumber;
    }


    /**
     * Gets the docdbCountryCode value for this DocdbFamilyInfo.
     * 
     * @return docdbCountryCode
     */
    public java.lang.String getDocdbCountryCode() {
        return docdbCountryCode;
    }


    /**
     * Sets the docdbCountryCode value for this DocdbFamilyInfo.
     * 
     * @param docdbCountryCode
     */
    public void setDocdbCountryCode(java.lang.String docdbCountryCode) {
        this.docdbCountryCode = docdbCountryCode;
    }


    /**
     * Gets the docdbLiteratureIdCode value for this DocdbFamilyInfo.
     * 
     * @return docdbLiteratureIdCode
     */
    public java.lang.String getDocdbLiteratureIdCode() {
        return docdbLiteratureIdCode;
    }


    /**
     * Sets the docdbLiteratureIdCode value for this DocdbFamilyInfo.
     * 
     * @param docdbLiteratureIdCode
     */
    public void setDocdbLiteratureIdCode(java.lang.String docdbLiteratureIdCode) {
        this.docdbLiteratureIdCode = docdbLiteratureIdCode;
    }


    /**
     * Gets the docdbLiteratureNumber value for this DocdbFamilyInfo.
     * 
     * @return docdbLiteratureNumber
     */
    public java.lang.String getDocdbLiteratureNumber() {
        return docdbLiteratureNumber;
    }


    /**
     * Sets the docdbLiteratureNumber value for this DocdbFamilyInfo.
     * 
     * @param docdbLiteratureNumber
     */
    public void setDocdbLiteratureNumber(java.lang.String docdbLiteratureNumber) {
        this.docdbLiteratureNumber = docdbLiteratureNumber;
    }


    /**
     * Gets the epodocPublicNumber value for this DocdbFamilyInfo.
     * 
     * @return epodocPublicNumber
     */
    public java.lang.String getEpodocPublicNumber() {
        return epodocPublicNumber;
    }


    /**
     * Sets the epodocPublicNumber value for this DocdbFamilyInfo.
     * 
     * @param epodocPublicNumber
     */
    public void setEpodocPublicNumber(java.lang.String epodocPublicNumber) {
        this.epodocPublicNumber = epodocPublicNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocdbFamilyInfo)) return false;
        DocdbFamilyInfo other = (DocdbFamilyInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.docdbCountryCode==null && other.getDocdbCountryCode()==null) || 
             (this.docdbCountryCode!=null &&
              this.docdbCountryCode.equals(other.getDocdbCountryCode()))) &&
            ((this.docdbLiteratureIdCode==null && other.getDocdbLiteratureIdCode()==null) || 
             (this.docdbLiteratureIdCode!=null &&
              this.docdbLiteratureIdCode.equals(other.getDocdbLiteratureIdCode()))) &&
            ((this.docdbLiteratureNumber==null && other.getDocdbLiteratureNumber()==null) || 
             (this.docdbLiteratureNumber!=null &&
              this.docdbLiteratureNumber.equals(other.getDocdbLiteratureNumber()))) &&
            ((this.epodocPublicNumber==null && other.getEpodocPublicNumber()==null) || 
             (this.epodocPublicNumber!=null &&
              this.epodocPublicNumber.equals(other.getEpodocPublicNumber())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDocdbCountryCode() != null) {
            _hashCode += getDocdbCountryCode().hashCode();
        }
        if (getDocdbLiteratureIdCode() != null) {
            _hashCode += getDocdbLiteratureIdCode().hashCode();
        }
        if (getDocdbLiteratureNumber() != null) {
            _hashCode += getDocdbLiteratureNumber().hashCode();
        }
        if (getEpodocPublicNumber() != null) {
            _hashCode += getEpodocPublicNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocdbFamilyInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocdbFamilyInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbLiteratureIdCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbLiteratureIdCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbLiteratureNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbLiteratureNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("epodocPublicNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "epodocPublicNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
