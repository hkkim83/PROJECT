/**
 * DocInventionNameInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocInventionNameInfo  implements java.io.Serializable {
    private java.lang.String dbInventionName;

    private java.lang.String publishLanguageCode;

    public DocInventionNameInfo() {
    }

    public DocInventionNameInfo(
           java.lang.String dbInventionName,
           java.lang.String publishLanguageCode) {
           this.dbInventionName = dbInventionName;
           this.publishLanguageCode = publishLanguageCode;
    }


    /**
     * Gets the dbInventionName value for this DocInventionNameInfo.
     * 
     * @return dbInventionName
     */
    public java.lang.String getDbInventionName() {
        return dbInventionName;
    }


    /**
     * Sets the dbInventionName value for this DocInventionNameInfo.
     * 
     * @param dbInventionName
     */
    public void setDbInventionName(java.lang.String dbInventionName) {
        this.dbInventionName = dbInventionName;
    }


    /**
     * Gets the publishLanguageCode value for this DocInventionNameInfo.
     * 
     * @return publishLanguageCode
     */
    public java.lang.String getPublishLanguageCode() {
        return publishLanguageCode;
    }


    /**
     * Sets the publishLanguageCode value for this DocInventionNameInfo.
     * 
     * @param publishLanguageCode
     */
    public void setPublishLanguageCode(java.lang.String publishLanguageCode) {
        this.publishLanguageCode = publishLanguageCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocInventionNameInfo)) return false;
        DocInventionNameInfo other = (DocInventionNameInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbInventionName==null && other.getDbInventionName()==null) || 
             (this.dbInventionName!=null &&
              this.dbInventionName.equals(other.getDbInventionName()))) &&
            ((this.publishLanguageCode==null && other.getPublishLanguageCode()==null) || 
             (this.publishLanguageCode!=null &&
              this.publishLanguageCode.equals(other.getPublishLanguageCode())));
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
        if (getDbInventionName() != null) {
            _hashCode += getDbInventionName().hashCode();
        }
        if (getPublishLanguageCode() != null) {
            _hashCode += getPublishLanguageCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocInventionNameInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocInventionNameInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbInventionName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbInventionName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishLanguageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publishLanguageCode"));
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
