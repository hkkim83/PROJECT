/**
 * ForeignPatentDocumentsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class ForeignPatentDocumentsInfo  implements java.io.Serializable {
    private java.lang.String clssCd;

    private java.lang.String corgPatno;

    private java.lang.String countryCode;

    private java.lang.String exam;

    private java.lang.String patDt;

    private java.lang.String patTpcd;

    public ForeignPatentDocumentsInfo() {
    }

    public ForeignPatentDocumentsInfo(
           java.lang.String clssCd,
           java.lang.String corgPatno,
           java.lang.String countryCode,
           java.lang.String exam,
           java.lang.String patDt,
           java.lang.String patTpcd) {
           this.clssCd = clssCd;
           this.corgPatno = corgPatno;
           this.countryCode = countryCode;
           this.exam = exam;
           this.patDt = patDt;
           this.patTpcd = patTpcd;
    }


    /**
     * Gets the clssCd value for this ForeignPatentDocumentsInfo.
     * 
     * @return clssCd
     */
    public java.lang.String getClssCd() {
        return clssCd;
    }


    /**
     * Sets the clssCd value for this ForeignPatentDocumentsInfo.
     * 
     * @param clssCd
     */
    public void setClssCd(java.lang.String clssCd) {
        this.clssCd = clssCd;
    }


    /**
     * Gets the corgPatno value for this ForeignPatentDocumentsInfo.
     * 
     * @return corgPatno
     */
    public java.lang.String getCorgPatno() {
        return corgPatno;
    }


    /**
     * Sets the corgPatno value for this ForeignPatentDocumentsInfo.
     * 
     * @param corgPatno
     */
    public void setCorgPatno(java.lang.String corgPatno) {
        this.corgPatno = corgPatno;
    }


    /**
     * Gets the countryCode value for this ForeignPatentDocumentsInfo.
     * 
     * @return countryCode
     */
    public java.lang.String getCountryCode() {
        return countryCode;
    }


    /**
     * Sets the countryCode value for this ForeignPatentDocumentsInfo.
     * 
     * @param countryCode
     */
    public void setCountryCode(java.lang.String countryCode) {
        this.countryCode = countryCode;
    }


    /**
     * Gets the exam value for this ForeignPatentDocumentsInfo.
     * 
     * @return exam
     */
    public java.lang.String getExam() {
        return exam;
    }


    /**
     * Sets the exam value for this ForeignPatentDocumentsInfo.
     * 
     * @param exam
     */
    public void setExam(java.lang.String exam) {
        this.exam = exam;
    }


    /**
     * Gets the patDt value for this ForeignPatentDocumentsInfo.
     * 
     * @return patDt
     */
    public java.lang.String getPatDt() {
        return patDt;
    }


    /**
     * Sets the patDt value for this ForeignPatentDocumentsInfo.
     * 
     * @param patDt
     */
    public void setPatDt(java.lang.String patDt) {
        this.patDt = patDt;
    }


    /**
     * Gets the patTpcd value for this ForeignPatentDocumentsInfo.
     * 
     * @return patTpcd
     */
    public java.lang.String getPatTpcd() {
        return patTpcd;
    }


    /**
     * Sets the patTpcd value for this ForeignPatentDocumentsInfo.
     * 
     * @param patTpcd
     */
    public void setPatTpcd(java.lang.String patTpcd) {
        this.patTpcd = patTpcd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ForeignPatentDocumentsInfo)) return false;
        ForeignPatentDocumentsInfo other = (ForeignPatentDocumentsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.clssCd==null && other.getClssCd()==null) || 
             (this.clssCd!=null &&
              this.clssCd.equals(other.getClssCd()))) &&
            ((this.corgPatno==null && other.getCorgPatno()==null) || 
             (this.corgPatno!=null &&
              this.corgPatno.equals(other.getCorgPatno()))) &&
            ((this.countryCode==null && other.getCountryCode()==null) || 
             (this.countryCode!=null &&
              this.countryCode.equals(other.getCountryCode()))) &&
            ((this.exam==null && other.getExam()==null) || 
             (this.exam!=null &&
              this.exam.equals(other.getExam()))) &&
            ((this.patDt==null && other.getPatDt()==null) || 
             (this.patDt!=null &&
              this.patDt.equals(other.getPatDt()))) &&
            ((this.patTpcd==null && other.getPatTpcd()==null) || 
             (this.patTpcd!=null &&
              this.patTpcd.equals(other.getPatTpcd())));
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
        if (getClssCd() != null) {
            _hashCode += getClssCd().hashCode();
        }
        if (getCorgPatno() != null) {
            _hashCode += getCorgPatno().hashCode();
        }
        if (getCountryCode() != null) {
            _hashCode += getCountryCode().hashCode();
        }
        if (getExam() != null) {
            _hashCode += getExam().hashCode();
        }
        if (getPatDt() != null) {
            _hashCode += getPatDt().hashCode();
        }
        if (getPatTpcd() != null) {
            _hashCode += getPatTpcd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ForeignPatentDocumentsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ForeignPatentDocumentsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clssCd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "clssCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corgPatno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "corgPatno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countryCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "countryCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exam");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "exam"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patDt");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "patDt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patTpcd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "patTpcd"));
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
