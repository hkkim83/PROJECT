/**
 * SearchCodeResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class SearchCodeResult  implements java.io.Serializable {
    private java.lang.String koreanExplanation;

    private java.lang.String originalTextExplanation;

    private java.lang.String section;

    public SearchCodeResult() {
    }

    public SearchCodeResult(
           java.lang.String koreanExplanation,
           java.lang.String originalTextExplanation,
           java.lang.String section) {
           this.koreanExplanation = koreanExplanation;
           this.originalTextExplanation = originalTextExplanation;
           this.section = section;
    }


    /**
     * Gets the koreanExplanation value for this SearchCodeResult.
     * 
     * @return koreanExplanation
     */
    public java.lang.String getKoreanExplanation() {
        return koreanExplanation;
    }


    /**
     * Sets the koreanExplanation value for this SearchCodeResult.
     * 
     * @param koreanExplanation
     */
    public void setKoreanExplanation(java.lang.String koreanExplanation) {
        this.koreanExplanation = koreanExplanation;
    }


    /**
     * Gets the originalTextExplanation value for this SearchCodeResult.
     * 
     * @return originalTextExplanation
     */
    public java.lang.String getOriginalTextExplanation() {
        return originalTextExplanation;
    }


    /**
     * Sets the originalTextExplanation value for this SearchCodeResult.
     * 
     * @param originalTextExplanation
     */
    public void setOriginalTextExplanation(java.lang.String originalTextExplanation) {
        this.originalTextExplanation = originalTextExplanation;
    }


    /**
     * Gets the section value for this SearchCodeResult.
     * 
     * @return section
     */
    public java.lang.String getSection() {
        return section;
    }


    /**
     * Sets the section value for this SearchCodeResult.
     * 
     * @param section
     */
    public void setSection(java.lang.String section) {
        this.section = section;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchCodeResult)) return false;
        SearchCodeResult other = (SearchCodeResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.koreanExplanation==null && other.getKoreanExplanation()==null) || 
             (this.koreanExplanation!=null &&
              this.koreanExplanation.equals(other.getKoreanExplanation()))) &&
            ((this.originalTextExplanation==null && other.getOriginalTextExplanation()==null) || 
             (this.originalTextExplanation!=null &&
              this.originalTextExplanation.equals(other.getOriginalTextExplanation()))) &&
            ((this.section==null && other.getSection()==null) || 
             (this.section!=null &&
              this.section.equals(other.getSection())));
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
        if (getKoreanExplanation() != null) {
            _hashCode += getKoreanExplanation().hashCode();
        }
        if (getOriginalTextExplanation() != null) {
            _hashCode += getOriginalTextExplanation().hashCode();
        }
        if (getSection() != null) {
            _hashCode += getSection().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchCodeResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCodeResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("koreanExplanation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "koreanExplanation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("originalTextExplanation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "originalTextExplanation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("section");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "section"));
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
