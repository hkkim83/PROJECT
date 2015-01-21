/**
 * GetOpenAnnounceNumber.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class GetOpenAnnounceNumber  implements java.io.Serializable {
    private java.lang.String openAnnounceNumber;

    public GetOpenAnnounceNumber() {
    }

    public GetOpenAnnounceNumber(
           java.lang.String openAnnounceNumber) {
           this.openAnnounceNumber = openAnnounceNumber;
    }


    /**
     * Gets the openAnnounceNumber value for this GetOpenAnnounceNumber.
     * 
     * @return openAnnounceNumber
     */
    public java.lang.String getOpenAnnounceNumber() {
        return openAnnounceNumber;
    }


    /**
     * Sets the openAnnounceNumber value for this GetOpenAnnounceNumber.
     * 
     * @param openAnnounceNumber
     */
    public void setOpenAnnounceNumber(java.lang.String openAnnounceNumber) {
        this.openAnnounceNumber = openAnnounceNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetOpenAnnounceNumber)) return false;
        GetOpenAnnounceNumber other = (GetOpenAnnounceNumber) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.openAnnounceNumber==null && other.getOpenAnnounceNumber()==null) || 
             (this.openAnnounceNumber!=null &&
              this.openAnnounceNumber.equals(other.getOpenAnnounceNumber())));
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
        if (getOpenAnnounceNumber() != null) {
            _hashCode += getOpenAnnounceNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetOpenAnnounceNumber.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "GetOpenAnnounceNumber"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openAnnounceNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openAnnounceNumber"));
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
