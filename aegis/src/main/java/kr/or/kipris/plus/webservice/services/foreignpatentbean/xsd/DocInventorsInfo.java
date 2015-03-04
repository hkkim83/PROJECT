/**
 * DocInventorsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocInventorsInfo  implements java.io.Serializable {
    private java.lang.String dbRelatedInventorsName;

    private java.lang.String dbaRelatedInventorsName;

    private java.lang.String originalInventorsName;

    private java.lang.String relatedCountryCode;

    private java.lang.String relatedNumber;

    public DocInventorsInfo() {
    }

    public DocInventorsInfo(
           java.lang.String dbRelatedInventorsName,
           java.lang.String dbaRelatedInventorsName,
           java.lang.String originalInventorsName,
           java.lang.String relatedCountryCode,
           java.lang.String relatedNumber) {
           this.dbRelatedInventorsName = dbRelatedInventorsName;
           this.dbaRelatedInventorsName = dbaRelatedInventorsName;
           this.originalInventorsName = originalInventorsName;
           this.relatedCountryCode = relatedCountryCode;
           this.relatedNumber = relatedNumber;
    }


    /**
     * Gets the dbRelatedInventorsName value for this DocInventorsInfo.
     * 
     * @return dbRelatedInventorsName
     */
    public java.lang.String getDbRelatedInventorsName() {
        return dbRelatedInventorsName;
    }


    /**
     * Sets the dbRelatedInventorsName value for this DocInventorsInfo.
     * 
     * @param dbRelatedInventorsName
     */
    public void setDbRelatedInventorsName(java.lang.String dbRelatedInventorsName) {
        this.dbRelatedInventorsName = dbRelatedInventorsName;
    }


    /**
     * Gets the dbaRelatedInventorsName value for this DocInventorsInfo.
     * 
     * @return dbaRelatedInventorsName
     */
    public java.lang.String getDbaRelatedInventorsName() {
        return dbaRelatedInventorsName;
    }


    /**
     * Sets the dbaRelatedInventorsName value for this DocInventorsInfo.
     * 
     * @param dbaRelatedInventorsName
     */
    public void setDbaRelatedInventorsName(java.lang.String dbaRelatedInventorsName) {
        this.dbaRelatedInventorsName = dbaRelatedInventorsName;
    }


    /**
     * Gets the originalInventorsName value for this DocInventorsInfo.
     * 
     * @return originalInventorsName
     */
    public java.lang.String getOriginalInventorsName() {
        return originalInventorsName;
    }


    /**
     * Sets the originalInventorsName value for this DocInventorsInfo.
     * 
     * @param originalInventorsName
     */
    public void setOriginalInventorsName(java.lang.String originalInventorsName) {
        this.originalInventorsName = originalInventorsName;
    }


    /**
     * Gets the relatedCountryCode value for this DocInventorsInfo.
     * 
     * @return relatedCountryCode
     */
    public java.lang.String getRelatedCountryCode() {
        return relatedCountryCode;
    }


    /**
     * Sets the relatedCountryCode value for this DocInventorsInfo.
     * 
     * @param relatedCountryCode
     */
    public void setRelatedCountryCode(java.lang.String relatedCountryCode) {
        this.relatedCountryCode = relatedCountryCode;
    }


    /**
     * Gets the relatedNumber value for this DocInventorsInfo.
     * 
     * @return relatedNumber
     */
    public java.lang.String getRelatedNumber() {
        return relatedNumber;
    }


    /**
     * Sets the relatedNumber value for this DocInventorsInfo.
     * 
     * @param relatedNumber
     */
    public void setRelatedNumber(java.lang.String relatedNumber) {
        this.relatedNumber = relatedNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocInventorsInfo)) return false;
        DocInventorsInfo other = (DocInventorsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbRelatedInventorsName==null && other.getDbRelatedInventorsName()==null) || 
             (this.dbRelatedInventorsName!=null &&
              this.dbRelatedInventorsName.equals(other.getDbRelatedInventorsName()))) &&
            ((this.dbaRelatedInventorsName==null && other.getDbaRelatedInventorsName()==null) || 
             (this.dbaRelatedInventorsName!=null &&
              this.dbaRelatedInventorsName.equals(other.getDbaRelatedInventorsName()))) &&
            ((this.originalInventorsName==null && other.getOriginalInventorsName()==null) || 
             (this.originalInventorsName!=null &&
              this.originalInventorsName.equals(other.getOriginalInventorsName()))) &&
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
        if (getDbRelatedInventorsName() != null) {
            _hashCode += getDbRelatedInventorsName().hashCode();
        }
        if (getDbaRelatedInventorsName() != null) {
            _hashCode += getDbaRelatedInventorsName().hashCode();
        }
        if (getOriginalInventorsName() != null) {
            _hashCode += getOriginalInventorsName().hashCode();
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
        new org.apache.axis.description.TypeDesc(DocInventorsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocInventorsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbRelatedInventorsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbRelatedInventorsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbaRelatedInventorsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbaRelatedInventorsName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalInventorsName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "originalInventorsName"));
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
