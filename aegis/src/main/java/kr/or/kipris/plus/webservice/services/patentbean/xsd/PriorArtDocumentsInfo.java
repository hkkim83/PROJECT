/**
 * PriorArtDocumentsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class PriorArtDocumentsInfo  implements java.io.Serializable {
    private java.lang.String documentsNumber;

    public PriorArtDocumentsInfo() {
    }

    public PriorArtDocumentsInfo(
           java.lang.String documentsNumber) {
           this.documentsNumber = documentsNumber;
    }


    /**
     * Gets the documentsNumber value for this PriorArtDocumentsInfo.
     * 
     * @return documentsNumber
     */
    public java.lang.String getDocumentsNumber() {
        return documentsNumber;
    }


    /**
     * Sets the documentsNumber value for this PriorArtDocumentsInfo.
     * 
     * @param documentsNumber
     */
    public void setDocumentsNumber(java.lang.String documentsNumber) {
        this.documentsNumber = documentsNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriorArtDocumentsInfo)) return false;
        PriorArtDocumentsInfo other = (PriorArtDocumentsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.documentsNumber==null && other.getDocumentsNumber()==null) || 
             (this.documentsNumber!=null &&
              this.documentsNumber.equals(other.getDocumentsNumber())));
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
        if (getDocumentsNumber() != null) {
            _hashCode += getDocumentsNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriorArtDocumentsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorArtDocumentsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentsNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "documentsNumber"));
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
