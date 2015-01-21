/**
 * FullTextCheckResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class FullTextCheckResult  implements java.io.Serializable {
    private java.lang.String openFullTextCheckResult;

    private java.lang.String registrationFullTextCheckResult;

    private java.lang.String representationImageInfo;

    private java.lang.String revisionAnnounceFullTextCheckResult;

    public FullTextCheckResult() {
    }

    public FullTextCheckResult(
           java.lang.String openFullTextCheckResult,
           java.lang.String registrationFullTextCheckResult,
           java.lang.String representationImageInfo,
           java.lang.String revisionAnnounceFullTextCheckResult) {
           this.openFullTextCheckResult = openFullTextCheckResult;
           this.registrationFullTextCheckResult = registrationFullTextCheckResult;
           this.representationImageInfo = representationImageInfo;
           this.revisionAnnounceFullTextCheckResult = revisionAnnounceFullTextCheckResult;
    }


    /**
     * Gets the openFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @return openFullTextCheckResult
     */
    public java.lang.String getOpenFullTextCheckResult() {
        return openFullTextCheckResult;
    }


    /**
     * Sets the openFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @param openFullTextCheckResult
     */
    public void setOpenFullTextCheckResult(java.lang.String openFullTextCheckResult) {
        this.openFullTextCheckResult = openFullTextCheckResult;
    }


    /**
     * Gets the registrationFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @return registrationFullTextCheckResult
     */
    public java.lang.String getRegistrationFullTextCheckResult() {
        return registrationFullTextCheckResult;
    }


    /**
     * Sets the registrationFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @param registrationFullTextCheckResult
     */
    public void setRegistrationFullTextCheckResult(java.lang.String registrationFullTextCheckResult) {
        this.registrationFullTextCheckResult = registrationFullTextCheckResult;
    }


    /**
     * Gets the representationImageInfo value for this FullTextCheckResult.
     * 
     * @return representationImageInfo
     */
    public java.lang.String getRepresentationImageInfo() {
        return representationImageInfo;
    }


    /**
     * Sets the representationImageInfo value for this FullTextCheckResult.
     * 
     * @param representationImageInfo
     */
    public void setRepresentationImageInfo(java.lang.String representationImageInfo) {
        this.representationImageInfo = representationImageInfo;
    }


    /**
     * Gets the revisionAnnounceFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @return revisionAnnounceFullTextCheckResult
     */
    public java.lang.String getRevisionAnnounceFullTextCheckResult() {
        return revisionAnnounceFullTextCheckResult;
    }


    /**
     * Sets the revisionAnnounceFullTextCheckResult value for this FullTextCheckResult.
     * 
     * @param revisionAnnounceFullTextCheckResult
     */
    public void setRevisionAnnounceFullTextCheckResult(java.lang.String revisionAnnounceFullTextCheckResult) {
        this.revisionAnnounceFullTextCheckResult = revisionAnnounceFullTextCheckResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullTextCheckResult)) return false;
        FullTextCheckResult other = (FullTextCheckResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.openFullTextCheckResult==null && other.getOpenFullTextCheckResult()==null) || 
             (this.openFullTextCheckResult!=null &&
              this.openFullTextCheckResult.equals(other.getOpenFullTextCheckResult()))) &&
            ((this.registrationFullTextCheckResult==null && other.getRegistrationFullTextCheckResult()==null) || 
             (this.registrationFullTextCheckResult!=null &&
              this.registrationFullTextCheckResult.equals(other.getRegistrationFullTextCheckResult()))) &&
            ((this.representationImageInfo==null && other.getRepresentationImageInfo()==null) || 
             (this.representationImageInfo!=null &&
              this.representationImageInfo.equals(other.getRepresentationImageInfo()))) &&
            ((this.revisionAnnounceFullTextCheckResult==null && other.getRevisionAnnounceFullTextCheckResult()==null) || 
             (this.revisionAnnounceFullTextCheckResult!=null &&
              this.revisionAnnounceFullTextCheckResult.equals(other.getRevisionAnnounceFullTextCheckResult())));
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
        if (getOpenFullTextCheckResult() != null) {
            _hashCode += getOpenFullTextCheckResult().hashCode();
        }
        if (getRegistrationFullTextCheckResult() != null) {
            _hashCode += getRegistrationFullTextCheckResult().hashCode();
        }
        if (getRepresentationImageInfo() != null) {
            _hashCode += getRepresentationImageInfo().hashCode();
        }
        if (getRevisionAnnounceFullTextCheckResult() != null) {
            _hashCode += getRevisionAnnounceFullTextCheckResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FullTextCheckResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openFullTextCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openFullTextCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationFullTextCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "registrationFullTextCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("representationImageInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "representationImageInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisionAnnounceFullTextCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "revisionAnnounceFullTextCheckResult"));
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
