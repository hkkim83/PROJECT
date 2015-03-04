/**
 * FamilyInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.bean.familyInfo.xsd;

public class FamilyInfo  implements java.io.Serializable {
    private java.lang.String applicationCountryCode;

    private java.lang.String applicationDate;

    private java.lang.String applicationKindCode;

    private java.lang.String applicationNumber;

    private java.lang.String docdbFamilyID;

    private java.lang.String publicationCountryCode;

    private java.lang.String publicationDate;

    private java.lang.String publicationKindCode;

    private java.lang.String publicationNumber;

    public FamilyInfo() {
    }

    public FamilyInfo(
           java.lang.String applicationCountryCode,
           java.lang.String applicationDate,
           java.lang.String applicationKindCode,
           java.lang.String applicationNumber,
           java.lang.String docdbFamilyID,
           java.lang.String publicationCountryCode,
           java.lang.String publicationDate,
           java.lang.String publicationKindCode,
           java.lang.String publicationNumber) {
           this.applicationCountryCode = applicationCountryCode;
           this.applicationDate = applicationDate;
           this.applicationKindCode = applicationKindCode;
           this.applicationNumber = applicationNumber;
           this.docdbFamilyID = docdbFamilyID;
           this.publicationCountryCode = publicationCountryCode;
           this.publicationDate = publicationDate;
           this.publicationKindCode = publicationKindCode;
           this.publicationNumber = publicationNumber;
    }


    /**
     * Gets the applicationCountryCode value for this FamilyInfo.
     * 
     * @return applicationCountryCode
     */
    public java.lang.String getApplicationCountryCode() {
        return applicationCountryCode;
    }


    /**
     * Sets the applicationCountryCode value for this FamilyInfo.
     * 
     * @param applicationCountryCode
     */
    public void setApplicationCountryCode(java.lang.String applicationCountryCode) {
        this.applicationCountryCode = applicationCountryCode;
    }


    /**
     * Gets the applicationDate value for this FamilyInfo.
     * 
     * @return applicationDate
     */
    public java.lang.String getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this FamilyInfo.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.lang.String applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationKindCode value for this FamilyInfo.
     * 
     * @return applicationKindCode
     */
    public java.lang.String getApplicationKindCode() {
        return applicationKindCode;
    }


    /**
     * Sets the applicationKindCode value for this FamilyInfo.
     * 
     * @param applicationKindCode
     */
    public void setApplicationKindCode(java.lang.String applicationKindCode) {
        this.applicationKindCode = applicationKindCode;
    }


    /**
     * Gets the applicationNumber value for this FamilyInfo.
     * 
     * @return applicationNumber
     */
    public java.lang.String getApplicationNumber() {
        return applicationNumber;
    }


    /**
     * Sets the applicationNumber value for this FamilyInfo.
     * 
     * @param applicationNumber
     */
    public void setApplicationNumber(java.lang.String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }


    /**
     * Gets the docdbFamilyID value for this FamilyInfo.
     * 
     * @return docdbFamilyID
     */
    public java.lang.String getDocdbFamilyID() {
        return docdbFamilyID;
    }


    /**
     * Sets the docdbFamilyID value for this FamilyInfo.
     * 
     * @param docdbFamilyID
     */
    public void setDocdbFamilyID(java.lang.String docdbFamilyID) {
        this.docdbFamilyID = docdbFamilyID;
    }


    /**
     * Gets the publicationCountryCode value for this FamilyInfo.
     * 
     * @return publicationCountryCode
     */
    public java.lang.String getPublicationCountryCode() {
        return publicationCountryCode;
    }


    /**
     * Sets the publicationCountryCode value for this FamilyInfo.
     * 
     * @param publicationCountryCode
     */
    public void setPublicationCountryCode(java.lang.String publicationCountryCode) {
        this.publicationCountryCode = publicationCountryCode;
    }


    /**
     * Gets the publicationDate value for this FamilyInfo.
     * 
     * @return publicationDate
     */
    public java.lang.String getPublicationDate() {
        return publicationDate;
    }


    /**
     * Sets the publicationDate value for this FamilyInfo.
     * 
     * @param publicationDate
     */
    public void setPublicationDate(java.lang.String publicationDate) {
        this.publicationDate = publicationDate;
    }


    /**
     * Gets the publicationKindCode value for this FamilyInfo.
     * 
     * @return publicationKindCode
     */
    public java.lang.String getPublicationKindCode() {
        return publicationKindCode;
    }


    /**
     * Sets the publicationKindCode value for this FamilyInfo.
     * 
     * @param publicationKindCode
     */
    public void setPublicationKindCode(java.lang.String publicationKindCode) {
        this.publicationKindCode = publicationKindCode;
    }


    /**
     * Gets the publicationNumber value for this FamilyInfo.
     * 
     * @return publicationNumber
     */
    public java.lang.String getPublicationNumber() {
        return publicationNumber;
    }


    /**
     * Sets the publicationNumber value for this FamilyInfo.
     * 
     * @param publicationNumber
     */
    public void setPublicationNumber(java.lang.String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FamilyInfo)) return false;
        FamilyInfo other = (FamilyInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicationCountryCode==null && other.getApplicationCountryCode()==null) || 
             (this.applicationCountryCode!=null &&
              this.applicationCountryCode.equals(other.getApplicationCountryCode()))) &&
            ((this.applicationDate==null && other.getApplicationDate()==null) || 
             (this.applicationDate!=null &&
              this.applicationDate.equals(other.getApplicationDate()))) &&
            ((this.applicationKindCode==null && other.getApplicationKindCode()==null) || 
             (this.applicationKindCode!=null &&
              this.applicationKindCode.equals(other.getApplicationKindCode()))) &&
            ((this.applicationNumber==null && other.getApplicationNumber()==null) || 
             (this.applicationNumber!=null &&
              this.applicationNumber.equals(other.getApplicationNumber()))) &&
            ((this.docdbFamilyID==null && other.getDocdbFamilyID()==null) || 
             (this.docdbFamilyID!=null &&
              this.docdbFamilyID.equals(other.getDocdbFamilyID()))) &&
            ((this.publicationCountryCode==null && other.getPublicationCountryCode()==null) || 
             (this.publicationCountryCode!=null &&
              this.publicationCountryCode.equals(other.getPublicationCountryCode()))) &&
            ((this.publicationDate==null && other.getPublicationDate()==null) || 
             (this.publicationDate!=null &&
              this.publicationDate.equals(other.getPublicationDate()))) &&
            ((this.publicationKindCode==null && other.getPublicationKindCode()==null) || 
             (this.publicationKindCode!=null &&
              this.publicationKindCode.equals(other.getPublicationKindCode()))) &&
            ((this.publicationNumber==null && other.getPublicationNumber()==null) || 
             (this.publicationNumber!=null &&
              this.publicationNumber.equals(other.getPublicationNumber())));
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
        if (getApplicationCountryCode() != null) {
            _hashCode += getApplicationCountryCode().hashCode();
        }
        if (getApplicationDate() != null) {
            _hashCode += getApplicationDate().hashCode();
        }
        if (getApplicationKindCode() != null) {
            _hashCode += getApplicationKindCode().hashCode();
        }
        if (getApplicationNumber() != null) {
            _hashCode += getApplicationNumber().hashCode();
        }
        if (getDocdbFamilyID() != null) {
            _hashCode += getDocdbFamilyID().hashCode();
        }
        if (getPublicationCountryCode() != null) {
            _hashCode += getPublicationCountryCode().hashCode();
        }
        if (getPublicationDate() != null) {
            _hashCode += getPublicationDate().hashCode();
        }
        if (getPublicationKindCode() != null) {
            _hashCode += getPublicationKindCode().hashCode();
        }
        if (getPublicationNumber() != null) {
            _hashCode += getPublicationNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FamilyInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "FamilyInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "applicationCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "applicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationKindCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "applicationKindCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "applicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbFamilyID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "docdbFamilyID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "publicationCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "publicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationKindCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "publicationKindCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://familyInfo.bean.services.webservice.plus.kipris.or.kr/xsd", "publicationNumber"));
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
