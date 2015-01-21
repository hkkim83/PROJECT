/**
 * ApplicantInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class ApplicantInfo  implements java.io.Serializable {
    private java.lang.String applicantAddress;

    private java.lang.String applicantCountry;

    private java.lang.String applicantName;

    public ApplicantInfo() {
    }

    public ApplicantInfo(
           java.lang.String applicantAddress,
           java.lang.String applicantCountry,
           java.lang.String applicantName) {
           this.applicantAddress = applicantAddress;
           this.applicantCountry = applicantCountry;
           this.applicantName = applicantName;
    }


    /**
     * Gets the applicantAddress value for this ApplicantInfo.
     * 
     * @return applicantAddress
     */
    public java.lang.String getApplicantAddress() {
        return applicantAddress;
    }


    /**
     * Sets the applicantAddress value for this ApplicantInfo.
     * 
     * @param applicantAddress
     */
    public void setApplicantAddress(java.lang.String applicantAddress) {
        this.applicantAddress = applicantAddress;
    }


    /**
     * Gets the applicantCountry value for this ApplicantInfo.
     * 
     * @return applicantCountry
     */
    public java.lang.String getApplicantCountry() {
        return applicantCountry;
    }


    /**
     * Sets the applicantCountry value for this ApplicantInfo.
     * 
     * @param applicantCountry
     */
    public void setApplicantCountry(java.lang.String applicantCountry) {
        this.applicantCountry = applicantCountry;
    }


    /**
     * Gets the applicantName value for this ApplicantInfo.
     * 
     * @return applicantName
     */
    public java.lang.String getApplicantName() {
        return applicantName;
    }


    /**
     * Sets the applicantName value for this ApplicantInfo.
     * 
     * @param applicantName
     */
    public void setApplicantName(java.lang.String applicantName) {
        this.applicantName = applicantName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ApplicantInfo)) return false;
        ApplicantInfo other = (ApplicantInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicantAddress==null && other.getApplicantAddress()==null) || 
             (this.applicantAddress!=null &&
              this.applicantAddress.equals(other.getApplicantAddress()))) &&
            ((this.applicantCountry==null && other.getApplicantCountry()==null) || 
             (this.applicantCountry!=null &&
              this.applicantCountry.equals(other.getApplicantCountry()))) &&
            ((this.applicantName==null && other.getApplicantName()==null) || 
             (this.applicantName!=null &&
              this.applicantName.equals(other.getApplicantName())));
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
        if (getApplicantAddress() != null) {
            _hashCode += getApplicantAddress().hashCode();
        }
        if (getApplicantCountry() != null) {
            _hashCode += getApplicantCountry().hashCode();
        }
        if (getApplicantName() != null) {
            _hashCode += getApplicantName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ApplicantInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ApplicantInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicantAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicantCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicantName"));
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
