/**
 * FamilyInfoV2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class FamilyInfoV2  implements java.io.Serializable {
    private java.lang.String applicationNumber;

    private java.lang.String countryCode;

    private java.lang.String countryName;

    private java.lang.String familyKind;

    private java.lang.String familyNumber;

    private java.lang.String literatureCode;

    private java.lang.String literatureNumber;

    private java.lang.String openNumber;

    public FamilyInfoV2() {
    }

    public FamilyInfoV2(
           java.lang.String applicationNumber,
           java.lang.String countryCode,
           java.lang.String countryName,
           java.lang.String familyKind,
           java.lang.String familyNumber,
           java.lang.String literatureCode,
           java.lang.String literatureNumber,
           java.lang.String openNumber) {
           this.applicationNumber = applicationNumber;
           this.countryCode = countryCode;
           this.countryName = countryName;
           this.familyKind = familyKind;
           this.familyNumber = familyNumber;
           this.literatureCode = literatureCode;
           this.literatureNumber = literatureNumber;
           this.openNumber = openNumber;
    }


    /**
     * Gets the applicationNumber value for this FamilyInfoV2.
     * 
     * @return applicationNumber
     */
    public java.lang.String getApplicationNumber() {
        return applicationNumber;
    }


    /**
     * Sets the applicationNumber value for this FamilyInfoV2.
     * 
     * @param applicationNumber
     */
    public void setApplicationNumber(java.lang.String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }


    /**
     * Gets the countryCode value for this FamilyInfoV2.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this FamilyInfoV2.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the countryName value for this FamilyInfoV2.
     * 
     * @return countryName
     */
    public java.lang.String getCountryName() {
        return countryName;
    }


    /**
     * Sets the countryName value for this FamilyInfoV2.
     * 
     * @param countryName
     */
    public void setCountryName(java.lang.String countryName) {
        this.countryName = countryName;
    }


    /**
     * Gets the familyKind value for this FamilyInfoV2.
     * 
     * @return familyKind
     */
    public java.lang.String getFamilyKind() {
        return familyKind;
    }


    /**
     * Sets the familyKind value for this FamilyInfoV2.
     * 
     * @param familyKind
     */
    public void setFamilyKind(java.lang.String familyKind) {
        this.familyKind = familyKind;
    }


    /**
     * Gets the familyNumber value for this FamilyInfoV2.
     * 
     * @return familyNumber
     */
    public java.lang.String getFamilyNumber() {
        return familyNumber;
    }


    /**
     * Sets the familyNumber value for this FamilyInfoV2.
     * 
     * @param familyNumber
     */
    public void setFamilyNumber(java.lang.String familyNumber) {
        this.familyNumber = familyNumber;
    }


    /**
     * Gets the literatureCode value for this FamilyInfoV2.
     * 
     * @return literatureCode
     */
    public java.lang.String getLiteratureCode() {
        return literatureCode;
    }


    /**
     * Sets the literatureCode value for this FamilyInfoV2.
     * 
     * @param literatureCode
     */
    public void setLiteratureCode(java.lang.String literatureCode) {
        this.literatureCode = literatureCode;
    }


    /**
     * Gets the literatureNumber value for this FamilyInfoV2.
     * 
     * @return literatureNumber
     */
    public java.lang.String getLiteratureNumber() {
        return literatureNumber;
    }


    /**
     * Sets the literatureNumber value for this FamilyInfoV2.
     * 
     * @param literatureNumber
     */
    public void setLiteratureNumber(java.lang.String literatureNumber) {
        this.literatureNumber = literatureNumber;
    }


    /**
     * Gets the openNumber value for this FamilyInfoV2.
     * 
     * @return openNumber
     */
    public java.lang.String getOpenNumber() {
        return openNumber;
    }


    /**
     * Sets the openNumber value for this FamilyInfoV2.
     * 
     * @param openNumber
     */
    public void setOpenNumber(java.lang.String openNumber) {
        this.openNumber = openNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FamilyInfoV2)) return false;
        FamilyInfoV2 other = (FamilyInfoV2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicationNumber==null && other.getApplicationNumber()==null) || 
             (this.applicationNumber!=null &&
              this.applicationNumber.equals(other.getApplicationNumber()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            ((this.countryName==null && other.getCountryName()==null) || 
             (this.countryName!=null &&
              this.countryName.equals(other.getCountryName()))) &&
            ((this.familyKind==null && other.getFamilyKind()==null) || 
             (this.familyKind!=null &&
              this.familyKind.equals(other.getFamilyKind()))) &&
            ((this.familyNumber==null && other.getFamilyNumber()==null) || 
             (this.familyNumber!=null &&
              this.familyNumber.equals(other.getFamilyNumber()))) &&
            ((this.literatureCode==null && other.getLiteratureCode()==null) || 
             (this.literatureCode!=null &&
              this.literatureCode.equals(other.getLiteratureCode()))) &&
            ((this.literatureNumber==null && other.getLiteratureNumber()==null) || 
             (this.literatureNumber!=null &&
              this.literatureNumber.equals(other.getLiteratureNumber()))) &&
            ((this.openNumber==null && other.getOpenNumber()==null) || 
             (this.openNumber!=null &&
              this.openNumber.equals(other.getOpenNumber())));
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
        if (getApplicationNumber() != null) {
            _hashCode += getApplicationNumber().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        if (getCountryName() != null) {
            _hashCode += getCountryName().hashCode();
        }
        if (getFamilyKind() != null) {
            _hashCode += getFamilyKind().hashCode();
        }
        if (getFamilyNumber() != null) {
            _hashCode += getFamilyNumber().hashCode();
        }
        if (getLiteratureCode() != null) {
            _hashCode += getLiteratureCode().hashCode();
        }
        if (getLiteratureNumber() != null) {
            _hashCode += getLiteratureNumber().hashCode();
        }
        if (getOpenNumber() != null) {
            _hashCode += getOpenNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FamilyInfoV2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfoV2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "applicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "countryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "countryName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familyKind");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "familyKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("familyNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "familyNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("literatureCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "literatureCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("literatureNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "literatureNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "openNumber"));
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
