/**
 * InternationalInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class InternationalInfo  implements java.io.Serializable {
    private java.lang.String internationOpenDate;

    private java.lang.String internationOpenNumber;

    private java.lang.String internationalApplicationDate;

    private java.lang.String internationalApplicationNumber;

    public InternationalInfo() {
    }

    public InternationalInfo(
           java.lang.String internationOpenDate,
           java.lang.String internationOpenNumber,
           java.lang.String internationalApplicationDate,
           java.lang.String internationalApplicationNumber) {
           this.internationOpenDate = internationOpenDate;
           this.internationOpenNumber = internationOpenNumber;
           this.internationalApplicationDate = internationalApplicationDate;
           this.internationalApplicationNumber = internationalApplicationNumber;
    }


    /**
     * Gets the internationOpenDate value for this InternationalInfo.
     * 
     * @return internationOpenDate
     */
    public java.lang.String getInternationOpenDate() {
        return internationOpenDate;
    }


    /**
     * Sets the internationOpenDate value for this InternationalInfo.
     * 
     * @param internationOpenDate
     */
    public void setInternationOpenDate(java.lang.String internationOpenDate) {
        this.internationOpenDate = internationOpenDate;
    }


    /**
     * Gets the internationOpenNumber value for this InternationalInfo.
     * 
     * @return internationOpenNumber
     */
    public java.lang.String getInternationOpenNumber() {
        return internationOpenNumber;
    }


    /**
     * Sets the internationOpenNumber value for this InternationalInfo.
     * 
     * @param internationOpenNumber
     */
    public void setInternationOpenNumber(java.lang.String internationOpenNumber) {
        this.internationOpenNumber = internationOpenNumber;
    }


    /**
     * Gets the internationalApplicationDate value for this InternationalInfo.
     * 
     * @return internationalApplicationDate
     */
    public java.lang.String getInternationalApplicationDate() {
        return internationalApplicationDate;
    }


    /**
     * Sets the internationalApplicationDate value for this InternationalInfo.
     * 
     * @param internationalApplicationDate
     */
    public void setInternationalApplicationDate(java.lang.String internationalApplicationDate) {
        this.internationalApplicationDate = internationalApplicationDate;
    }


    /**
     * Gets the internationalApplicationNumber value for this InternationalInfo.
     * 
     * @return internationalApplicationNumber
     */
    public java.lang.String getInternationalApplicationNumber() {
        return internationalApplicationNumber;
    }


    /**
     * Sets the internationalApplicationNumber value for this InternationalInfo.
     * 
     * @param internationalApplicationNumber
     */
    public void setInternationalApplicationNumber(java.lang.String internationalApplicationNumber) {
        this.internationalApplicationNumber = internationalApplicationNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InternationalInfo)) return false;
        InternationalInfo other = (InternationalInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.internationOpenDate==null && other.getInternationOpenDate()==null) || 
             (this.internationOpenDate!=null &&
              this.internationOpenDate.equals(other.getInternationOpenDate()))) &&
            ((this.internationOpenNumber==null && other.getInternationOpenNumber()==null) || 
             (this.internationOpenNumber!=null &&
              this.internationOpenNumber.equals(other.getInternationOpenNumber()))) &&
            ((this.internationalApplicationDate==null && other.getInternationalApplicationDate()==null) || 
             (this.internationalApplicationDate!=null &&
              this.internationalApplicationDate.equals(other.getInternationalApplicationDate()))) &&
            ((this.internationalApplicationNumber==null && other.getInternationalApplicationNumber()==null) || 
             (this.internationalApplicationNumber!=null &&
              this.internationalApplicationNumber.equals(other.getInternationalApplicationNumber())));
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
        if (getInternationOpenDate() != null) {
            _hashCode += getInternationOpenDate().hashCode();
        }
        if (getInternationOpenNumber() != null) {
            _hashCode += getInternationOpenNumber().hashCode();
        }
        if (getInternationalApplicationDate() != null) {
            _hashCode += getInternationalApplicationDate().hashCode();
        }
        if (getInternationalApplicationNumber() != null) {
            _hashCode += getInternationalApplicationNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InternationalInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationOpenDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "internationOpenDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationOpenNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "internationOpenNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalApplicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalApplicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationNumber"));
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
