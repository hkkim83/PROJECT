/**
 * InventionNameInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.xsd;

public class InventionNameInfo  implements java.io.Serializable {
    private java.lang.String literatureNumber;

    private java.lang.String countryCode;

    public InventionNameInfo() {
    }

    public InventionNameInfo(
           java.lang.String literatureNumber,
           java.lang.String countryCode) {
           this.literatureNumber = literatureNumber;
           this.countryCode = countryCode;
    }


    /**
     * Gets the literatureNumber value for this InventionNameInfo.
     * 
     * @return literatureNumber
     */
    public java.lang.String getLiteratureNumber() {
        return literatureNumber;
    }


    /**
     * Sets the literatureNumber value for this InventionNameInfo.
     * 
     * @param literatureNumber
     */
    public void setLiteratureNumber(java.lang.String literatureNumber) {
        this.literatureNumber = literatureNumber;
    }


    /**
     * Gets the countryCode value for this InventionNameInfo.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this InventionNameInfo.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InventionNameInfo)) return false;
        InventionNameInfo other = (InventionNameInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.literatureNumber==null && other.getLiteratureNumber()==null) || 
             (this.literatureNumber!=null &&
              this.literatureNumber.equals(other.getLiteratureNumber()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode())));
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
        if (getLiteratureNumber() != null) {
            _hashCode += getLiteratureNumber().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InventionNameInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", ">inventionNameInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("literatureNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "literatureNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "countryCode"));
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
