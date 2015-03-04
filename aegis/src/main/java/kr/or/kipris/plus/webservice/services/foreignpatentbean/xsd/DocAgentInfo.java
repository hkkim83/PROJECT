/**
 * DocAgentInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocAgentInfo  implements java.io.Serializable {
    private java.lang.String dbRelatedAgentName;

    private java.lang.String dbaRelatedAgentName;

    private java.lang.String originalAgentName;

    private java.lang.String originalName;

    private java.lang.String relatedCountryCode;

    private java.lang.String relatedNumber;

    public DocAgentInfo() {
    }

    public DocAgentInfo(
           java.lang.String dbRelatedAgentName,
           java.lang.String dbaRelatedAgentName,
           java.lang.String originalAgentName,
           java.lang.String originalName,
           java.lang.String relatedCountryCode,
           java.lang.String relatedNumber) {
           this.dbRelatedAgentName = dbRelatedAgentName;
           this.dbaRelatedAgentName = dbaRelatedAgentName;
           this.originalAgentName = originalAgentName;
           this.originalName = originalName;
           this.relatedCountryCode = relatedCountryCode;
           this.relatedNumber = relatedNumber;
    }


    /**
     * Gets the dbRelatedAgentName value for this DocAgentInfo.
     * 
     * @return dbRelatedAgentName
     */
    public java.lang.String getDbRelatedAgentName() {
        return dbRelatedAgentName;
    }


    /**
     * Sets the dbRelatedAgentName value for this DocAgentInfo.
     * 
     * @param dbRelatedAgentName
     */
    public void setDbRelatedAgentName(java.lang.String dbRelatedAgentName) {
        this.dbRelatedAgentName = dbRelatedAgentName;
    }


    /**
     * Gets the dbaRelatedAgentName value for this DocAgentInfo.
     * 
     * @return dbaRelatedAgentName
     */
    public java.lang.String getDbaRelatedAgentName() {
        return dbaRelatedAgentName;
    }


    /**
     * Sets the dbaRelatedAgentName value for this DocAgentInfo.
     * 
     * @param dbaRelatedAgentName
     */
    public void setDbaRelatedAgentName(java.lang.String dbaRelatedAgentName) {
        this.dbaRelatedAgentName = dbaRelatedAgentName;
    }


    /**
     * Gets the originalAgentName value for this DocAgentInfo.
     * 
     * @return originalAgentName
     */
    public java.lang.String getOriginalAgentName() {
        return originalAgentName;
    }


    /**
     * Sets the originalAgentName value for this DocAgentInfo.
     * 
     * @param originalAgentName
     */
    public void setOriginalAgentName(java.lang.String originalAgentName) {
        this.originalAgentName = originalAgentName;
    }


    /**
     * Gets the originalName value for this DocAgentInfo.
     * 
     * @return originalName
     */
    public java.lang.String getOriginalName() {
        return originalName;
    }


    /**
     * Sets the originalName value for this DocAgentInfo.
     * 
     * @param originalName
     */
    public void setOriginalName(java.lang.String originalName) {
        this.originalName = originalName;
    }


    /**
     * Gets the relatedCountryCode value for this DocAgentInfo.
     * 
     * @return relatedCountryCode
     */
    public java.lang.String getRelatedCountryCode() {
        return relatedCountryCode;
    }


    /**
     * Sets the relatedCountryCode value for this DocAgentInfo.
     * 
     * @param relatedCountryCode
     */
    public void setRelatedCountryCode(java.lang.String relatedCountryCode) {
        this.relatedCountryCode = relatedCountryCode;
    }


    /**
     * Gets the relatedNumber value for this DocAgentInfo.
     * 
     * @return relatedNumber
     */
    public java.lang.String getRelatedNumber() {
        return relatedNumber;
    }


    /**
     * Sets the relatedNumber value for this DocAgentInfo.
     * 
     * @param relatedNumber
     */
    public void setRelatedNumber(java.lang.String relatedNumber) {
        this.relatedNumber = relatedNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocAgentInfo)) return false;
        DocAgentInfo other = (DocAgentInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dbRelatedAgentName==null && other.getDbRelatedAgentName()==null) || 
             (this.dbRelatedAgentName!=null &&
              this.dbRelatedAgentName.equals(other.getDbRelatedAgentName()))) &&
            ((this.dbaRelatedAgentName==null && other.getDbaRelatedAgentName()==null) || 
             (this.dbaRelatedAgentName!=null &&
              this.dbaRelatedAgentName.equals(other.getDbaRelatedAgentName()))) &&
            ((this.originalAgentName==null && other.getOriginalAgentName()==null) || 
             (this.originalAgentName!=null &&
              this.originalAgentName.equals(other.getOriginalAgentName()))) &&
            ((this.originalName==null && other.getOriginalName()==null) || 
             (this.originalName!=null &&
              this.originalName.equals(other.getOriginalName()))) &&
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
        if (getDbRelatedAgentName() != null) {
            _hashCode += getDbRelatedAgentName().hashCode();
        }
        if (getDbaRelatedAgentName() != null) {
            _hashCode += getDbaRelatedAgentName().hashCode();
        }
        if (getOriginalAgentName() != null) {
            _hashCode += getOriginalAgentName().hashCode();
        }
        if (getOriginalName() != null) {
            _hashCode += getOriginalName().hashCode();
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
        new org.apache.axis.description.TypeDesc(DocAgentInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocAgentInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbRelatedAgentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbRelatedAgentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dbaRelatedAgentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "dbaRelatedAgentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalAgentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "originalAgentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "originalName"));
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
