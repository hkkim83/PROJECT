/**
 * DocPriorityInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocPriorityInfo  implements java.io.Serializable {
    private java.lang.String epodocpriorityClaimNumber;

    private java.lang.String priorityApplKindCode;

    private java.lang.String priorityClaimApplDate;

    private java.lang.String priorityClaimApplNationalCode;

    private java.lang.String priorityClaimNumber;

    public DocPriorityInfo() {
    }

    public DocPriorityInfo(
           java.lang.String epodocpriorityClaimNumber,
           java.lang.String priorityApplKindCode,
           java.lang.String priorityClaimApplDate,
           java.lang.String priorityClaimApplNationalCode,
           java.lang.String priorityClaimNumber) {
           this.epodocpriorityClaimNumber = epodocpriorityClaimNumber;
           this.priorityApplKindCode = priorityApplKindCode;
           this.priorityClaimApplDate = priorityClaimApplDate;
           this.priorityClaimApplNationalCode = priorityClaimApplNationalCode;
           this.priorityClaimNumber = priorityClaimNumber;
    }


    /**
     * Gets the epodocpriorityClaimNumber value for this DocPriorityInfo.
     * 
     * @return epodocpriorityClaimNumber
     */
    public java.lang.String getEpodocpriorityClaimNumber() {
        return epodocpriorityClaimNumber;
    }


    /**
     * Sets the epodocpriorityClaimNumber value for this DocPriorityInfo.
     * 
     * @param epodocpriorityClaimNumber
     */
    public void setEpodocpriorityClaimNumber(java.lang.String epodocpriorityClaimNumber) {
        this.epodocpriorityClaimNumber = epodocpriorityClaimNumber;
    }


    /**
     * Gets the priorityApplKindCode value for this DocPriorityInfo.
     * 
     * @return priorityApplKindCode
     */
    public java.lang.String getPriorityApplKindCode() {
        return priorityApplKindCode;
    }


    /**
     * Sets the priorityApplKindCode value for this DocPriorityInfo.
     * 
     * @param priorityApplKindCode
     */
    public void setPriorityApplKindCode(java.lang.String priorityApplKindCode) {
        this.priorityApplKindCode = priorityApplKindCode;
    }


    /**
     * Gets the priorityClaimApplDate value for this DocPriorityInfo.
     * 
     * @return priorityClaimApplDate
     */
    public java.lang.String getPriorityClaimApplDate() {
        return priorityClaimApplDate;
    }


    /**
     * Sets the priorityClaimApplDate value for this DocPriorityInfo.
     * 
     * @param priorityClaimApplDate
     */
    public void setPriorityClaimApplDate(java.lang.String priorityClaimApplDate) {
        this.priorityClaimApplDate = priorityClaimApplDate;
    }


    /**
     * Gets the priorityClaimApplNationalCode value for this DocPriorityInfo.
     * 
     * @return priorityClaimApplNationalCode
     */
    public java.lang.String getPriorityClaimApplNationalCode() {
        return priorityClaimApplNationalCode;
    }


    /**
     * Sets the priorityClaimApplNationalCode value for this DocPriorityInfo.
     * 
     * @param priorityClaimApplNationalCode
     */
    public void setPriorityClaimApplNationalCode(java.lang.String priorityClaimApplNationalCode) {
        this.priorityClaimApplNationalCode = priorityClaimApplNationalCode;
    }


    /**
     * Gets the priorityClaimNumber value for this DocPriorityInfo.
     * 
     * @return priorityClaimNumber
     */
    public java.lang.String getPriorityClaimNumber() {
        return priorityClaimNumber;
    }


    /**
     * Sets the priorityClaimNumber value for this DocPriorityInfo.
     * 
     * @param priorityClaimNumber
     */
    public void setPriorityClaimNumber(java.lang.String priorityClaimNumber) {
        this.priorityClaimNumber = priorityClaimNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocPriorityInfo)) return false;
        DocPriorityInfo other = (DocPriorityInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.epodocpriorityClaimNumber==null && other.getEpodocpriorityClaimNumber()==null) || 
             (this.epodocpriorityClaimNumber!=null &&
              this.epodocpriorityClaimNumber.equals(other.getEpodocpriorityClaimNumber()))) &&
            ((this.priorityApplKindCode==null && other.getPriorityApplKindCode()==null) || 
             (this.priorityApplKindCode!=null &&
              this.priorityApplKindCode.equals(other.getPriorityApplKindCode()))) &&
            ((this.priorityClaimApplDate==null && other.getPriorityClaimApplDate()==null) || 
             (this.priorityClaimApplDate!=null &&
              this.priorityClaimApplDate.equals(other.getPriorityClaimApplDate()))) &&
            ((this.priorityClaimApplNationalCode==null && other.getPriorityClaimApplNationalCode()==null) || 
             (this.priorityClaimApplNationalCode!=null &&
              this.priorityClaimApplNationalCode.equals(other.getPriorityClaimApplNationalCode()))) &&
            ((this.priorityClaimNumber==null && other.getPriorityClaimNumber()==null) || 
             (this.priorityClaimNumber!=null &&
              this.priorityClaimNumber.equals(other.getPriorityClaimNumber())));
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
        if (getEpodocpriorityClaimNumber() != null) {
            _hashCode += getEpodocpriorityClaimNumber().hashCode();
        }
        if (getPriorityApplKindCode() != null) {
            _hashCode += getPriorityApplKindCode().hashCode();
        }
        if (getPriorityClaimApplDate() != null) {
            _hashCode += getPriorityClaimApplDate().hashCode();
        }
        if (getPriorityClaimApplNationalCode() != null) {
            _hashCode += getPriorityClaimApplNationalCode().hashCode();
        }
        if (getPriorityClaimNumber() != null) {
            _hashCode += getPriorityClaimNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocPriorityInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocPriorityInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("epodocpriorityClaimNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "epodocpriorityClaimNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityApplKindCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityApplKindCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityClaimApplDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityClaimApplDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityClaimApplNationalCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityClaimApplNationalCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityClaimNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityClaimNumber"));
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
