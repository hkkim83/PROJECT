/**
 * AnnualApplicationCountInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class AnnualApplicationCountInfo  implements java.io.Serializable {
    private java.lang.String cn;

    private java.lang.String ep;

    private java.lang.String jp;

    private java.lang.String us;

    private java.lang.String wo;

    private java.lang.String year;

    public AnnualApplicationCountInfo() {
    }

    public AnnualApplicationCountInfo(
           java.lang.String cn,
           java.lang.String ep,
           java.lang.String jp,
           java.lang.String us,
           java.lang.String wo,
           java.lang.String year) {
           this.cn = cn;
           this.ep = ep;
           this.jp = jp;
           this.us = us;
           this.wo = wo;
           this.year = year;
    }


    /**
     * Gets the cn value for this AnnualApplicationCountInfo.
     * 
     * @return cn
     */
    public java.lang.String getCn() {
        return cn;
    }


    /**
     * Sets the cn value for this AnnualApplicationCountInfo.
     * 
     * @param cn
     */
    public void setCn(java.lang.String cn) {
        this.cn = cn;
    }


    /**
     * Gets the ep value for this AnnualApplicationCountInfo.
     * 
     * @return ep
     */
    public java.lang.String getEp() {
        return ep;
    }


    /**
     * Sets the ep value for this AnnualApplicationCountInfo.
     * 
     * @param ep
     */
    public void setEp(java.lang.String ep) {
        this.ep = ep;
    }


    /**
     * Gets the jp value for this AnnualApplicationCountInfo.
     * 
     * @return jp
     */
    public java.lang.String getJp() {
        return jp;
    }


    /**
     * Sets the jp value for this AnnualApplicationCountInfo.
     * 
     * @param jp
     */
    public void setJp(java.lang.String jp) {
        this.jp = jp;
    }


    /**
     * Gets the us value for this AnnualApplicationCountInfo.
     * 
     * @return us
     */
    public java.lang.String getUs() {
        return us;
    }


    /**
     * Sets the us value for this AnnualApplicationCountInfo.
     * 
     * @param us
     */
    public void setUs(java.lang.String us) {
        this.us = us;
    }


    /**
     * Gets the wo value for this AnnualApplicationCountInfo.
     * 
     * @return wo
     */
    public java.lang.String getWo() {
        return wo;
    }


    /**
     * Sets the wo value for this AnnualApplicationCountInfo.
     * 
     * @param wo
     */
    public void setWo(java.lang.String wo) {
        this.wo = wo;
    }


    /**
     * Gets the year value for this AnnualApplicationCountInfo.
     * 
     * @return year
     */
    public java.lang.String getYear() {
        return year;
    }


    /**
     * Sets the year value for this AnnualApplicationCountInfo.
     * 
     * @param year
     */
    public void setYear(java.lang.String year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AnnualApplicationCountInfo)) return false;
        AnnualApplicationCountInfo other = (AnnualApplicationCountInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cn==null && other.getCn()==null) || 
             (this.cn!=null &&
              this.cn.equals(other.getCn()))) &&
            ((this.ep==null && other.getEp()==null) || 
             (this.ep!=null &&
              this.ep.equals(other.getEp()))) &&
            ((this.jp==null && other.getJp()==null) || 
             (this.jp!=null &&
              this.jp.equals(other.getJp()))) &&
            ((this.us==null && other.getUs()==null) || 
             (this.us!=null &&
              this.us.equals(other.getUs()))) &&
            ((this.wo==null && other.getWo()==null) || 
             (this.wo!=null &&
              this.wo.equals(other.getWo()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear())));
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
        if (getCn() != null) {
            _hashCode += getCn().hashCode();
        }
        if (getEp() != null) {
            _hashCode += getEp().hashCode();
        }
        if (getJp() != null) {
            _hashCode += getJp().hashCode();
        }
        if (getUs() != null) {
            _hashCode += getUs().hashCode();
        }
        if (getWo() != null) {
            _hashCode += getWo().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AnnualApplicationCountInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "AnnualApplicationCountInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cn");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "cn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ep");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ep"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jp");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "jp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("us");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "us"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "wo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "year"));
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
