/**
 * DesignationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DesignationInfo  implements java.io.Serializable {
    private java.lang.String nationalNameCode;

    private java.lang.String nationalNameKR;

    public DesignationInfo() {
    }

    public DesignationInfo(
           java.lang.String nationalNameCode,
           java.lang.String nationalNameKR) {
           this.nationalNameCode = nationalNameCode;
           this.nationalNameKR = nationalNameKR;
    }


    /**
     * Gets the nationalNameCode value for this DesignationInfo.
     * 
     * @return nationalNameCode
     */
    public java.lang.String getNationalNameCode() {
        return nationalNameCode;
    }


    /**
     * Sets the nationalNameCode value for this DesignationInfo.
     * 
     * @param nationalNameCode
     */
    public void setNationalNameCode(java.lang.String nationalNameCode) {
        this.nationalNameCode = nationalNameCode;
    }


    /**
     * Gets the nationalNameKR value for this DesignationInfo.
     * 
     * @return nationalNameKR
     */
    public java.lang.String getNationalNameKR() {
        return nationalNameKR;
    }


    /**
     * Sets the nationalNameKR value for this DesignationInfo.
     * 
     * @param nationalNameKR
     */
    public void setNationalNameKR(java.lang.String nationalNameKR) {
        this.nationalNameKR = nationalNameKR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DesignationInfo)) return false;
        DesignationInfo other = (DesignationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.nationalNameCode==null && other.getNationalNameCode()==null) || 
             (this.nationalNameCode!=null &&
              this.nationalNameCode.equals(other.getNationalNameCode()))) &&
            ((this.nationalNameKR==null && other.getNationalNameKR()==null) || 
             (this.nationalNameKR!=null &&
              this.nationalNameKR.equals(other.getNationalNameKR())));
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
        if (getNationalNameCode() != null) {
            _hashCode += getNationalNameCode().hashCode();
        }
        if (getNationalNameKR() != null) {
            _hashCode += getNationalNameKR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DesignationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DesignationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationalNameCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "nationalNameCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationalNameKR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "nationalNameKR"));
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
