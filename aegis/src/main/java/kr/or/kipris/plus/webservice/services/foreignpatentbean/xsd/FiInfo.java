/**
 * FiInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class FiInfo  implements java.io.Serializable {
    private java.lang.String clssCd;

    private java.lang.String publKey;

    public FiInfo() {
    }

    public FiInfo(
           java.lang.String clssCd,
           java.lang.String publKey) {
           this.clssCd = clssCd;
           this.publKey = publKey;
    }


    /**
     * Gets the clssCd value for this FiInfo.
     * 
     * @return clssCd
     */
    public java.lang.String getClssCd() {
        return clssCd;
    }


    /**
     * Sets the clssCd value for this FiInfo.
     * 
     * @param clssCd
     */
    public void setClssCd(java.lang.String clssCd) {
        this.clssCd = clssCd;
    }


    /**
     * Gets the publKey value for this FiInfo.
     * 
     * @return publKey
     */
    public java.lang.String getPublKey() {
        return publKey;
    }


    /**
     * Sets the publKey value for this FiInfo.
     * 
     * @param publKey
     */
    public void setPublKey(java.lang.String publKey) {
        this.publKey = publKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FiInfo)) return false;
        FiInfo other = (FiInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clssCd==null && other.getClssCd()==null) || 
             (this.clssCd!=null &&
              this.clssCd.equals(other.getClssCd()))) &&
            ((this.publKey==null && other.getPublKey()==null) || 
             (this.publKey!=null &&
              this.publKey.equals(other.getPublKey())));
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
        if (getClssCd() != null) {
            _hashCode += getClssCd().hashCode();
        }
        if (getPublKey() != null) {
            _hashCode += getPublKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FiInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FiInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clssCd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "clssCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publKey"));
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
