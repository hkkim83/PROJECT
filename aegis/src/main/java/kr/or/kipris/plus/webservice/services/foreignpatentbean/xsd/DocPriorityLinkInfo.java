/**
 * DocPriorityLinkInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocPriorityLinkInfo  implements java.io.Serializable {
    private java.lang.String docdbContryCode;

    private java.lang.String docdbLiteratureNumber;

    public DocPriorityLinkInfo() {
    }

    public DocPriorityLinkInfo(
           java.lang.String docdbContryCode,
           java.lang.String docdbLiteratureNumber) {
           this.docdbContryCode = docdbContryCode;
           this.docdbLiteratureNumber = docdbLiteratureNumber;
    }


    /**
     * Gets the docdbContryCode value for this DocPriorityLinkInfo.
     * 
     * @return docdbContryCode
     */
    public java.lang.String getDocdbContryCode() {
        return docdbContryCode;
    }


    /**
     * Sets the docdbContryCode value for this DocPriorityLinkInfo.
     * 
     * @param docdbContryCode
     */
    public void setDocdbContryCode(java.lang.String docdbContryCode) {
        this.docdbContryCode = docdbContryCode;
    }


    /**
     * Gets the docdbLiteratureNumber value for this DocPriorityLinkInfo.
     * 
     * @return docdbLiteratureNumber
     */
    public java.lang.String getDocdbLiteratureNumber() {
        return docdbLiteratureNumber;
    }


    /**
     * Sets the docdbLiteratureNumber value for this DocPriorityLinkInfo.
     * 
     * @param docdbLiteratureNumber
     */
    public void setDocdbLiteratureNumber(java.lang.String docdbLiteratureNumber) {
        this.docdbLiteratureNumber = docdbLiteratureNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocPriorityLinkInfo)) return false;
        DocPriorityLinkInfo other = (DocPriorityLinkInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.docdbContryCode==null && other.getDocdbContryCode()==null) || 
             (this.docdbContryCode!=null &&
              this.docdbContryCode.equals(other.getDocdbContryCode()))) &&
            ((this.docdbLiteratureNumber==null && other.getDocdbLiteratureNumber()==null) || 
             (this.docdbLiteratureNumber!=null &&
              this.docdbLiteratureNumber.equals(other.getDocdbLiteratureNumber())));
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
        if (getDocdbContryCode() != null) {
            _hashCode += getDocdbContryCode().hashCode();
        }
        if (getDocdbLiteratureNumber() != null) {
            _hashCode += getDocdbLiteratureNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocPriorityLinkInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocPriorityLinkInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbContryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbContryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docdbLiteratureNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docdbLiteratureNumber"));
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
