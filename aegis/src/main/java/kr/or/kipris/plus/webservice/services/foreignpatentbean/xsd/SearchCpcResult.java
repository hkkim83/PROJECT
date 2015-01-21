/**
 * SearchCpcResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class SearchCpcResult  implements java.io.Serializable {
    private java.lang.String mapIPC;

    private java.lang.String originalTextExplanation;

    private java.lang.String section;

    public SearchCpcResult() {
    }

    public SearchCpcResult(
           java.lang.String mapIPC,
           java.lang.String originalTextExplanation,
           java.lang.String section) {
           this.mapIPC = mapIPC;
           this.originalTextExplanation = originalTextExplanation;
           this.section = section;
    }


    /**
     * Gets the mapIPC value for this SearchCpcResult.
     * 
     * @return mapIPC
     */
    public java.lang.String getMapIPC() {
        return mapIPC;
    }


    /**
     * Sets the mapIPC value for this SearchCpcResult.
     * 
     * @param mapIPC
     */
    public void setMapIPC(java.lang.String mapIPC) {
        this.mapIPC = mapIPC;
    }


    /**
     * Gets the originalTextExplanation value for this SearchCpcResult.
     * 
     * @return originalTextExplanation
     */
    public java.lang.String getOriginalTextExplanation() {
        return originalTextExplanation;
    }


    /**
     * Sets the originalTextExplanation value for this SearchCpcResult.
     * 
     * @param originalTextExplanation
     */
    public void setOriginalTextExplanation(java.lang.String originalTextExplanation) {
        this.originalTextExplanation = originalTextExplanation;
    }


    /**
     * Gets the section value for this SearchCpcResult.
     * 
     * @return section
     */
    public java.lang.String getSection() {
        return section;
    }


    /**
     * Sets the section value for this SearchCpcResult.
     * 
     * @param section
     */
    public void setSection(java.lang.String section) {
        this.section = section;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchCpcResult)) return false;
        SearchCpcResult other = (SearchCpcResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mapIPC==null && other.getMapIPC()==null) || 
             (this.mapIPC!=null &&
              this.mapIPC.equals(other.getMapIPC()))) &&
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
        if (getMapIPC() != null) {
            _hashCode += getMapIPC().hashCode();
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
        new org.apache.axis.description.TypeDesc(SearchCpcResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchCpcResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mapIPC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "mapIPC"));
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
