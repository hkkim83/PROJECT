/**
 * DocApplicantInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocApplicantInfo  implements java.io.Serializable {
    private java.lang.String dbRelatedApplicantName;

    private java.lang.String dbaRelatedApplicantName;

    private java.lang.String originalApplicantName;

    private java.lang.String relatedCountryCode;

    private java.lang.String relatedNumber;

    public DocApplicantInfo() {
    }

    public DocApplicantInfo(
           java.lang.String dbRelatedApplicantName,
           java.lang.String dbaRelatedApplicantName,
           java.lang.String originalApplicantName,
           java.lang.String relatedCountryCode,
           java.lang.String relatedNumber) {
           this.dbRelatedApplicantName = dbRelatedApplicantName;
           this.dbaRelatedApplicantName = dbaRelatedApplicantName;
           this.originalApplicantName = originalApplicantName;
           this.relatedCountryCode = relatedCountryCode;
           this.relatedNumber = relatedNumber;
    }


    /**
     * Gets the dbRelatedApplicantName value for this DocApplicantInfo.
     * 
     * @return dbRelatedApplicantName
     */
    public java.lang.String getDbRelatedApplicantName() {
        return dbRelatedApplicantName;
    }


    /**
     * Sets the dbRelatedApplicantName value for this DocApplicantInfo.
     * 
     * @param dbRelatedApplicantName
     */
    public void setDbRelatedApplicantName(java.lang.String dbRelatedApplicantName) {
        this.dbRelatedApplicantName = dbRelatedApplicantName;
    }


    /**
     * Gets the dbaRelatedApplicantName value for this DocApplicantInfo.
     * 
     * @return dbaRelatedApplicantName
     */
    public java.lang.String getDbaRelatedApplicantName() {
        return dbaRelatedApplicantName;
    }


    /**
     * Sets the dbaRelatedApplicantName value for this DocApplicantInfo.
     * 
     * @param dbaRelatedApplicantName
     */
    public void setDbaRelatedApplicantName(java.lang.String dbaRelatedApplicantName) {
        this.dbaRelatedApplicantName = dbaRelatedApplicantName;
    }


    /**
     * Gets the originalApplicantName value for this DocApplicantInfo.
     * 
     * @return originalApplicantName
     */
    public java.lang.String getOriginalApplicantName() {
        return originalApplicantName;
    }


    /**
     * Sets the originalApplicantName value for this DocApplicantInfo.
     * 
     * @param originalApplicantName
     */
    public void setOriginalApplicantName(java.lang.String originalApplicantName) {
        this.originalApplicantName = originalApplicantName;
    }


    /**
     * Gets the relatedCountryCode value for this DocApplicantInfo.
     * 
     * @return relatedCountryCode
     */
    public java.lang.String getRelatedCountryCode() {
        return relatedCountryCode;
    }


    /**
     * Sets the relatedCountryCode value for this DocApplicantInfo.
     * 
     * @param relatedCountryCode
     */
    public void setRelatedCountryCode(java.lang.String relatedCountryCode) {
        this.relatedCountryCode = relatedCountryCode;
    }


    /**
     * Gets the relatedNumber value for this DocApplicantInfo.
     * 
     * @return relatedNumber
     */
    public java.lang.String getRelatedNumber() {
        return relatedNumber;
    }


    /**
     * Sets the relatedNumber value for this DocApplicantInfo.
     * 
     * @param relatedNumber
     */
    public void setRelatedNumber(java.lang.String relatedNumber) {
        this.relatedNumber = relatedNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocApplicantInfo)) return false;
        DocApplicantInfo other = (DocApplicantInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbRelatedApplicantName==null && other.getDbRelatedApplicantName()==null) || 
             (this.dbRelatedApplicantName!=null &&
              this.dbRelatedApplicantName.equals(other.getDbRelatedApplicantName()))) &&
            ((this.dbaRelatedApplicantName==null && other.getDbaRelatedApplicantName()==null) || 
             (this.dbaRelatedApplicantName!=null &&
              this.dbaRelatedApplicantName.equals(other.getDbaRelatedApplicantName()))) &&
            ((this.originalApplicantName==null && other.getOriginalApplicantName()==null) || 
             (this.originalApplicantName!=null &&
              this.originalApplicantName.equals(other.getOriginalApplicantName()))) &&
            ((this.relatedCountryCode==null && other.getRelatedCountryCode()==null) || 
             (this.relatedCountryCode!=null &&
              this.relatedCountryCode.equals(other.getRelatedCountryCode()))) &&
            ((this.relatedNumber==null && other.getRelatedNumber()==null) || 
             (this.relatedNumber!=null &&
              this.relatedNumber.equals(other.getRelatedNumber())));
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
        if (getDbRelatedApplicantName() != null) {
            _hashCode += getDbRelatedApplicantName().hashCode();
        }
        if (getDbaRelatedApplicantName() != null) {
            _hashCode += getDbaRelatedApplicantName().hashCode();
        }
        if (getOriginalApplicantName() != null) {
            _hashCode += getOriginalApplicantName().hashCode();
        }
        if (getRelatedCountryCode() != null) {
            _hashCode += getRelatedCountryCode().hashCode();
        }
        if (getRelatedNumber() != null) {
            _hashCode += getRelatedNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocApplicantInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocApplicantInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbRelatedApplicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbRelatedApplicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbaRelatedApplicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbaRelatedApplicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalApplicantName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "originalApplicantName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedCountryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedCountryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("relatedNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "relatedNumber"));
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
