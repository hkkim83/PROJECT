/**
 * DocDesignationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocDesignationInfo  implements java.io.Serializable {
    private java.lang.String itaplDsgnCntryCode;

    private java.lang.String itaplDsgnCntryGrpCd;

    public DocDesignationInfo() {
    }

    public DocDesignationInfo(
           java.lang.String itaplDsgnCntryCode,
           java.lang.String itaplDsgnCntryGrpCd) {
           this.itaplDsgnCntryCode = itaplDsgnCntryCode;
           this.itaplDsgnCntryGrpCd = itaplDsgnCntryGrpCd;
    }


    /**
     * Gets the itaplDsgnCntryCode value for this DocDesignationInfo.
     * 
     * @return itaplDsgnCntryCode
     */
    public java.lang.String getItaplDsgnCntryCode() {
        return itaplDsgnCntryCode;
    }


    /**
     * Sets the itaplDsgnCntryCode value for this DocDesignationInfo.
     * 
     * @param itaplDsgnCntryCode
     */
    public void setItaplDsgnCntryCode(java.lang.String itaplDsgnCntryCode) {
        this.itaplDsgnCntryCode = itaplDsgnCntryCode;
    }


    /**
     * Gets the itaplDsgnCntryGrpCd value for this DocDesignationInfo.
     * 
     * @return itaplDsgnCntryGrpCd
     */
    public java.lang.String getItaplDsgnCntryGrpCd() {
        return itaplDsgnCntryGrpCd;
    }


    /**
     * Sets the itaplDsgnCntryGrpCd value for this DocDesignationInfo.
     * 
     * @param itaplDsgnCntryGrpCd
     */
    public void setItaplDsgnCntryGrpCd(java.lang.String itaplDsgnCntryGrpCd) {
        this.itaplDsgnCntryGrpCd = itaplDsgnCntryGrpCd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocDesignationInfo)) return false;
        DocDesignationInfo other = (DocDesignationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.itaplDsgnCntryCode==null && other.getItaplDsgnCntryCode()==null) || 
             (this.itaplDsgnCntryCode!=null &&
              this.itaplDsgnCntryCode.equals(other.getItaplDsgnCntryCode()))) &&
            ((this.itaplDsgnCntryGrpCd==null && other.getItaplDsgnCntryGrpCd()==null) || 
             (this.itaplDsgnCntryGrpCd!=null &&
              this.itaplDsgnCntryGrpCd.equals(other.getItaplDsgnCntryGrpCd())));
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
        if (getItaplDsgnCntryCode() != null) {
            _hashCode += getItaplDsgnCntryCode().hashCode();
        }
        if (getItaplDsgnCntryGrpCd() != null) {
            _hashCode += getItaplDsgnCntryGrpCd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocDesignationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocDesignationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itaplDsgnCntryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "itaplDsgnCntryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itaplDsgnCntryGrpCd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "itaplDsgnCntryGrpCd"));
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
