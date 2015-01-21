/**
 * LegalStatusInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class LegalStatusInfo  implements java.io.Serializable {
    private java.lang.String commonCodeName;

    private java.lang.String documentEngName;

    private java.lang.String documentName;

    private java.lang.String receiptDate;

    private java.lang.String receiptNumber;

    public LegalStatusInfo() {
    }

    public LegalStatusInfo(
           java.lang.String commonCodeName,
           java.lang.String documentEngName,
           java.lang.String documentName,
           java.lang.String receiptDate,
           java.lang.String receiptNumber) {
           this.commonCodeName = commonCodeName;
           this.documentEngName = documentEngName;
           this.documentName = documentName;
           this.receiptDate = receiptDate;
           this.receiptNumber = receiptNumber;
    }


    /**
     * Gets the commonCodeName value for this LegalStatusInfo.
     * 
     * @return commonCodeName
     */
    public java.lang.String getCommonCodeName() {
        return commonCodeName;
    }


    /**
     * Sets the commonCodeName value for this LegalStatusInfo.
     * 
     * @param commonCodeName
     */
    public void setCommonCodeName(java.lang.String commonCodeName) {
        this.commonCodeName = commonCodeName;
    }


    /**
     * Gets the documentEngName value for this LegalStatusInfo.
     * 
     * @return documentEngName
     */
    public java.lang.String getDocumentEngName() {
        return documentEngName;
    }


    /**
     * Sets the documentEngName value for this LegalStatusInfo.
     * 
     * @param documentEngName
     */
    public void setDocumentEngName(java.lang.String documentEngName) {
        this.documentEngName = documentEngName;
    }


    /**
     * Gets the documentName value for this LegalStatusInfo.
     * 
     * @return documentName
     */
    public java.lang.String getDocumentName() {
        return documentName;
    }


    /**
     * Sets the documentName value for this LegalStatusInfo.
     * 
     * @param documentName
     */
    public void setDocumentName(java.lang.String documentName) {
        this.documentName = documentName;
    }


    /**
     * Gets the receiptDate value for this LegalStatusInfo.
     * 
     * @return receiptDate
     */
    public java.lang.String getReceiptDate() {
        return receiptDate;
    }


    /**
     * Sets the receiptDate value for this LegalStatusInfo.
     * 
     * @param receiptDate
     */
    public void setReceiptDate(java.lang.String receiptDate) {
        this.receiptDate = receiptDate;
    }


    /**
     * Gets the receiptNumber value for this LegalStatusInfo.
     * 
     * @return receiptNumber
     */
    public java.lang.String getReceiptNumber() {
        return receiptNumber;
    }


    /**
     * Sets the receiptNumber value for this LegalStatusInfo.
     * 
     * @param receiptNumber
     */
    public void setReceiptNumber(java.lang.String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LegalStatusInfo)) return false;
        LegalStatusInfo other = (LegalStatusInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.commonCodeName==null && other.getCommonCodeName()==null) || 
             (this.commonCodeName!=null &&
              this.commonCodeName.equals(other.getCommonCodeName()))) &&
            ((this.documentEngName==null && other.getDocumentEngName()==null) || 
             (this.documentEngName!=null &&
              this.documentEngName.equals(other.getDocumentEngName()))) &&
            ((this.documentName==null && other.getDocumentName()==null) || 
             (this.documentName!=null &&
              this.documentName.equals(other.getDocumentName()))) &&
            ((this.receiptDate==null && other.getReceiptDate()==null) || 
             (this.receiptDate!=null &&
              this.receiptDate.equals(other.getReceiptDate()))) &&
            ((this.receiptNumber==null && other.getReceiptNumber()==null) || 
             (this.receiptNumber!=null &&
              this.receiptNumber.equals(other.getReceiptNumber())));
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
        if (getCommonCodeName() != null) {
            _hashCode += getCommonCodeName().hashCode();
        }
        if (getDocumentEngName() != null) {
            _hashCode += getDocumentEngName().hashCode();
        }
        if (getDocumentName() != null) {
            _hashCode += getDocumentName().hashCode();
        }
        if (getReceiptDate() != null) {
            _hashCode += getReceiptDate().hashCode();
        }
        if (getReceiptNumber() != null) {
            _hashCode += getReceiptNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LegalStatusInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "LegalStatusInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commonCodeName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "commonCodeName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentEngName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "documentEngName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "documentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "receiptDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "receiptNumber"));
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
