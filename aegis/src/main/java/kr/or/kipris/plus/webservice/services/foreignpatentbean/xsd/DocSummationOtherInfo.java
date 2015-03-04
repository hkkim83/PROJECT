/**
 * DocSummationOtherInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class DocSummationOtherInfo  implements java.io.Serializable {
    private java.lang.String astrtCont;

    private java.lang.String publishLanguageCode;

    public DocSummationOtherInfo() {
    }

    public DocSummationOtherInfo(
           java.lang.String astrtCont,
           java.lang.String publishLanguageCode) {
           this.astrtCont = astrtCont;
           this.publishLanguageCode = publishLanguageCode;
    }


    /**
     * Gets the astrtCont value for this DocSummationOtherInfo.
     * 
     * @return astrtCont
     */
    public java.lang.String getAstrtCont() {
        return astrtCont;
    }


    /**
     * Sets the astrtCont value for this DocSummationOtherInfo.
     * 
     * @param astrtCont
     */
    public void setAstrtCont(java.lang.String astrtCont) {
        this.astrtCont = astrtCont;
    }


    /**
     * Gets the publishLanguageCode value for this DocSummationOtherInfo.
     * 
     * @return publishLanguageCode
     */
    public java.lang.String getPublishLanguageCode() {
        return publishLanguageCode;
    }


    /**
     * Sets the publishLanguageCode value for this DocSummationOtherInfo.
     * 
     * @param publishLanguageCode
     */
    public void setPublishLanguageCode(java.lang.String publishLanguageCode) {
        this.publishLanguageCode = publishLanguageCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocSummationOtherInfo)) return false;
        DocSummationOtherInfo other = (DocSummationOtherInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.astrtCont==null && other.getAstrtCont()==null) || 
             (this.astrtCont!=null &&
              this.astrtCont.equals(other.getAstrtCont()))) &&
            ((this.publishLanguageCode==null && other.getPublishLanguageCode()==null) || 
             (this.publishLanguageCode!=null &&
              this.publishLanguageCode.equals(other.getPublishLanguageCode())));
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
        if (getAstrtCont() != null) {
            _hashCode += getAstrtCont().hashCode();
        }
        if (getPublishLanguageCode() != null) {
            _hashCode += getPublishLanguageCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocSummationOtherInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocSummationOtherInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("astrtCont");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "astrtCont"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishLanguageCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publishLanguageCode"));
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
