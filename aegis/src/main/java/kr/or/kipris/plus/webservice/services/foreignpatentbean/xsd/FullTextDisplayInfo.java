/**
 * FullTextDisplayInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class FullTextDisplayInfo  implements java.io.Serializable {
    private java.lang.String openNumber;

    private java.lang.String registerNumber;

    private java.lang.String revisionNumber;

    public FullTextDisplayInfo() {
    }

    public FullTextDisplayInfo(
           java.lang.String openNumber,
           java.lang.String registerNumber,
           java.lang.String revisionNumber) {
           this.openNumber = openNumber;
           this.registerNumber = registerNumber;
           this.revisionNumber = revisionNumber;
    }


    /**
     * Gets the openNumber value for this FullTextDisplayInfo.
     * 
     * @return openNumber
     */
    public java.lang.String getOpenNumber() {
        return openNumber;
    }


    /**
     * Sets the openNumber value for this FullTextDisplayInfo.
     * 
     * @param openNumber
     */
    public void setOpenNumber(java.lang.String openNumber) {
        this.openNumber = openNumber;
    }


    /**
     * Gets the registerNumber value for this FullTextDisplayInfo.
     * 
     * @return registerNumber
     */
    public java.lang.String getRegisterNumber() {
        return registerNumber;
    }


    /**
     * Sets the registerNumber value for this FullTextDisplayInfo.
     * 
     * @param registerNumber
     */
    public void setRegisterNumber(java.lang.String registerNumber) {
        this.registerNumber = registerNumber;
    }


    /**
     * Gets the revisionNumber value for this FullTextDisplayInfo.
     * 
     * @return revisionNumber
     */
    public java.lang.String getRevisionNumber() {
        return revisionNumber;
    }


    /**
     * Sets the revisionNumber value for this FullTextDisplayInfo.
     * 
     * @param revisionNumber
     */
    public void setRevisionNumber(java.lang.String revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullTextDisplayInfo)) return false;
        FullTextDisplayInfo other = (FullTextDisplayInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.openNumber==null && other.getOpenNumber()==null) || 
             (this.openNumber!=null &&
              this.openNumber.equals(other.getOpenNumber()))) &&
            ((this.registerNumber==null && other.getRegisterNumber()==null) || 
             (this.registerNumber!=null &&
              this.registerNumber.equals(other.getRegisterNumber()))) &&
            ((this.revisionNumber==null && other.getRevisionNumber()==null) || 
             (this.revisionNumber!=null &&
              this.revisionNumber.equals(other.getRevisionNumber())));
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
        if (getOpenNumber() != null) {
            _hashCode += getOpenNumber().hashCode();
        }
        if (getRegisterNumber() != null) {
            _hashCode += getRegisterNumber().hashCode();
        }
        if (getRevisionNumber() != null) {
            _hashCode += getRevisionNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FullTextDisplayInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextDisplayInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registerNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "registerNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisionNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "revisionNumber"));
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
