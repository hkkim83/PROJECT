/**
 * FullTextCheckResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class FullTextCheckResult  implements java.io.Serializable {
    private java.lang.String abstractFigureCheckResult;

    private java.lang.String examPubBookCheckResult;

    private java.lang.String examPubfullDocPDFCheckResult;

    private java.lang.String registrationCheckResult;

    private java.lang.String revisionfullDocPDFCheckResult;

    private java.lang.String unexPubBookCheckResult;

    private java.lang.String unexPubfullDocPDFCheckResult;

    public FullTextCheckResult() {
    }

    public FullTextCheckResult(
           java.lang.String abstractFigureCheckResult,
           java.lang.String examPubBookCheckResult,
           java.lang.String examPubfullDocPDFCheckResult,
           java.lang.String registrationCheckResult,
           java.lang.String revisionfullDocPDFCheckResult,
           java.lang.String unexPubBookCheckResult,
           java.lang.String unexPubfullDocPDFCheckResult) {
           this.abstractFigureCheckResult = abstractFigureCheckResult;
           this.examPubBookCheckResult = examPubBookCheckResult;
           this.examPubfullDocPDFCheckResult = examPubfullDocPDFCheckResult;
           this.registrationCheckResult = registrationCheckResult;
           this.revisionfullDocPDFCheckResult = revisionfullDocPDFCheckResult;
           this.unexPubBookCheckResult = unexPubBookCheckResult;
           this.unexPubfullDocPDFCheckResult = unexPubfullDocPDFCheckResult;
    }


    /**
     * Gets the abstractFigureCheckResult value for this FullTextCheckResult.
     * 
     * @return abstractFigureCheckResult
     */
    public java.lang.String getAbstractFigureCheckResult() {
        return abstractFigureCheckResult;
    }


    /**
     * Sets the abstractFigureCheckResult value for this FullTextCheckResult.
     * 
     * @param abstractFigureCheckResult
     */
    public void setAbstractFigureCheckResult(java.lang.String abstractFigureCheckResult) {
        this.abstractFigureCheckResult = abstractFigureCheckResult;
    }


    /**
     * Gets the examPubBookCheckResult value for this FullTextCheckResult.
     * 
     * @return examPubBookCheckResult
     */
    public java.lang.String getExamPubBookCheckResult() {
        return examPubBookCheckResult;
    }


    /**
     * Sets the examPubBookCheckResult value for this FullTextCheckResult.
     * 
     * @param examPubBookCheckResult
     */
    public void setExamPubBookCheckResult(java.lang.String examPubBookCheckResult) {
        this.examPubBookCheckResult = examPubBookCheckResult;
    }


    /**
     * Gets the examPubfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @return examPubfullDocPDFCheckResult
     */
    public java.lang.String getExamPubfullDocPDFCheckResult() {
        return examPubfullDocPDFCheckResult;
    }


    /**
     * Sets the examPubfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @param examPubfullDocPDFCheckResult
     */
    public void setExamPubfullDocPDFCheckResult(java.lang.String examPubfullDocPDFCheckResult) {
        this.examPubfullDocPDFCheckResult = examPubfullDocPDFCheckResult;
    }


    /**
     * Gets the registrationCheckResult value for this FullTextCheckResult.
     * 
     * @return registrationCheckResult
     */
    public java.lang.String getRegistrationCheckResult() {
        return registrationCheckResult;
    }


    /**
     * Sets the registrationCheckResult value for this FullTextCheckResult.
     * 
     * @param registrationCheckResult
     */
    public void setRegistrationCheckResult(java.lang.String registrationCheckResult) {
        this.registrationCheckResult = registrationCheckResult;
    }


    /**
     * Gets the revisionfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @return revisionfullDocPDFCheckResult
     */
    public java.lang.String getRevisionfullDocPDFCheckResult() {
        return revisionfullDocPDFCheckResult;
    }


    /**
     * Sets the revisionfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @param revisionfullDocPDFCheckResult
     */
    public void setRevisionfullDocPDFCheckResult(java.lang.String revisionfullDocPDFCheckResult) {
        this.revisionfullDocPDFCheckResult = revisionfullDocPDFCheckResult;
    }


    /**
     * Gets the unexPubBookCheckResult value for this FullTextCheckResult.
     * 
     * @return unexPubBookCheckResult
     */
    public java.lang.String getUnexPubBookCheckResult() {
        return unexPubBookCheckResult;
    }


    /**
     * Sets the unexPubBookCheckResult value for this FullTextCheckResult.
     * 
     * @param unexPubBookCheckResult
     */
    public void setUnexPubBookCheckResult(java.lang.String unexPubBookCheckResult) {
        this.unexPubBookCheckResult = unexPubBookCheckResult;
    }


    /**
     * Gets the unexPubfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @return unexPubfullDocPDFCheckResult
     */
    public java.lang.String getUnexPubfullDocPDFCheckResult() {
        return unexPubfullDocPDFCheckResult;
    }


    /**
     * Sets the unexPubfullDocPDFCheckResult value for this FullTextCheckResult.
     * 
     * @param unexPubfullDocPDFCheckResult
     */
    public void setUnexPubfullDocPDFCheckResult(java.lang.String unexPubfullDocPDFCheckResult) {
        this.unexPubfullDocPDFCheckResult = unexPubfullDocPDFCheckResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FullTextCheckResult)) return false;
        FullTextCheckResult other = (FullTextCheckResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.abstractFigureCheckResult==null && other.getAbstractFigureCheckResult()==null) || 
             (this.abstractFigureCheckResult!=null &&
              this.abstractFigureCheckResult.equals(other.getAbstractFigureCheckResult()))) &&
            ((this.examPubBookCheckResult==null && other.getExamPubBookCheckResult()==null) || 
             (this.examPubBookCheckResult!=null &&
              this.examPubBookCheckResult.equals(other.getExamPubBookCheckResult()))) &&
            ((this.examPubfullDocPDFCheckResult==null && other.getExamPubfullDocPDFCheckResult()==null) || 
             (this.examPubfullDocPDFCheckResult!=null &&
              this.examPubfullDocPDFCheckResult.equals(other.getExamPubfullDocPDFCheckResult()))) &&
            ((this.registrationCheckResult==null && other.getRegistrationCheckResult()==null) || 
             (this.registrationCheckResult!=null &&
              this.registrationCheckResult.equals(other.getRegistrationCheckResult()))) &&
            ((this.revisionfullDocPDFCheckResult==null && other.getRevisionfullDocPDFCheckResult()==null) || 
             (this.revisionfullDocPDFCheckResult!=null &&
              this.revisionfullDocPDFCheckResult.equals(other.getRevisionfullDocPDFCheckResult()))) &&
            ((this.unexPubBookCheckResult==null && other.getUnexPubBookCheckResult()==null) || 
             (this.unexPubBookCheckResult!=null &&
              this.unexPubBookCheckResult.equals(other.getUnexPubBookCheckResult()))) &&
            ((this.unexPubfullDocPDFCheckResult==null && other.getUnexPubfullDocPDFCheckResult()==null) || 
             (this.unexPubfullDocPDFCheckResult!=null &&
              this.unexPubfullDocPDFCheckResult.equals(other.getUnexPubfullDocPDFCheckResult())));
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
        if (getAbstractFigureCheckResult() != null) {
            _hashCode += getAbstractFigureCheckResult().hashCode();
        }
        if (getExamPubBookCheckResult() != null) {
            _hashCode += getExamPubBookCheckResult().hashCode();
        }
        if (getExamPubfullDocPDFCheckResult() != null) {
            _hashCode += getExamPubfullDocPDFCheckResult().hashCode();
        }
        if (getRegistrationCheckResult() != null) {
            _hashCode += getRegistrationCheckResult().hashCode();
        }
        if (getRevisionfullDocPDFCheckResult() != null) {
            _hashCode += getRevisionfullDocPDFCheckResult().hashCode();
        }
        if (getUnexPubBookCheckResult() != null) {
            _hashCode += getUnexPubBookCheckResult().hashCode();
        }
        if (getUnexPubfullDocPDFCheckResult() != null) {
            _hashCode += getUnexPubfullDocPDFCheckResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FullTextCheckResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "FullTextCheckResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("abstractFigureCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "abstractFigureCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examPubBookCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "examPubBookCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("examPubfullDocPDFCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "examPubfullDocPDFCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "registrationCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("revisionfullDocPDFCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "revisionfullDocPDFCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unexPubBookCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "unexPubBookCheckResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unexPubfullDocPDFCheckResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "unexPubfullDocPDFCheckResult"));
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
