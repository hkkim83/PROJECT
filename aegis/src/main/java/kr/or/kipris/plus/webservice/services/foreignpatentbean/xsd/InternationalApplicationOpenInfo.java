/**
 * InternationalApplicationOpenInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class InternationalApplicationOpenInfo  implements java.io.Serializable {
    private java.lang.String internationPublicationDate;

    private java.lang.String internationPublicationNumber;

    private java.lang.String internationalApplicationDate;

    private java.lang.String internationalApplicationNumber;

    private java.lang.String publKey;

    public InternationalApplicationOpenInfo() {
    }

    public InternationalApplicationOpenInfo(
           java.lang.String internationPublicationDate,
           java.lang.String internationPublicationNumber,
           java.lang.String internationalApplicationDate,
           java.lang.String internationalApplicationNumber,
           java.lang.String publKey) {
           this.internationPublicationDate = internationPublicationDate;
           this.internationPublicationNumber = internationPublicationNumber;
           this.internationalApplicationDate = internationalApplicationDate;
           this.internationalApplicationNumber = internationalApplicationNumber;
           this.publKey = publKey;
    }


    /**
     * Gets the internationPublicationDate value for this InternationalApplicationOpenInfo.
     * 
     * @return internationPublicationDate
     */
    public java.lang.String getInternationPublicationDate() {
        return internationPublicationDate;
    }


    /**
     * Sets the internationPublicationDate value for this InternationalApplicationOpenInfo.
     * 
     * @param internationPublicationDate
     */
    public void setInternationPublicationDate(java.lang.String internationPublicationDate) {
        this.internationPublicationDate = internationPublicationDate;
    }


    /**
     * Gets the internationPublicationNumber value for this InternationalApplicationOpenInfo.
     * 
     * @return internationPublicationNumber
     */
    public java.lang.String getInternationPublicationNumber() {
        return internationPublicationNumber;
    }


    /**
     * Sets the internationPublicationNumber value for this InternationalApplicationOpenInfo.
     * 
     * @param internationPublicationNumber
     */
    public void setInternationPublicationNumber(java.lang.String internationPublicationNumber) {
        this.internationPublicationNumber = internationPublicationNumber;
    }


    /**
     * Gets the internationalApplicationDate value for this InternationalApplicationOpenInfo.
     * 
     * @return internationalApplicationDate
     */
    public java.lang.String getInternationalApplicationDate() {
        return internationalApplicationDate;
    }


    /**
     * Sets the internationalApplicationDate value for this InternationalApplicationOpenInfo.
     * 
     * @param internationalApplicationDate
     */
    public void setInternationalApplicationDate(java.lang.String internationalApplicationDate) {
        this.internationalApplicationDate = internationalApplicationDate;
    }


    /**
     * Gets the internationalApplicationNumber value for this InternationalApplicationOpenInfo.
     * 
     * @return internationalApplicationNumber
     */
    public java.lang.String getInternationalApplicationNumber() {
        return internationalApplicationNumber;
    }


    /**
     * Sets the internationalApplicationNumber value for this InternationalApplicationOpenInfo.
     * 
     * @param internationalApplicationNumber
     */
    public void setInternationalApplicationNumber(java.lang.String internationalApplicationNumber) {
        this.internationalApplicationNumber = internationalApplicationNumber;
    }


    /**
     * Gets the publKey value for this InternationalApplicationOpenInfo.
     * 
     * @return publKey
     */
    public java.lang.String getPublKey() {
        return publKey;
    }


    /**
     * Sets the publKey value for this InternationalApplicationOpenInfo.
     * 
     * @param publKey
     */
    public void setPublKey(java.lang.String publKey) {
        this.publKey = publKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InternationalApplicationOpenInfo)) return false;
        InternationalApplicationOpenInfo other = (InternationalApplicationOpenInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.internationPublicationDate==null && other.getInternationPublicationDate()==null) || 
             (this.internationPublicationDate!=null &&
              this.internationPublicationDate.equals(other.getInternationPublicationDate()))) &&
            ((this.internationPublicationNumber==null && other.getInternationPublicationNumber()==null) || 
             (this.internationPublicationNumber!=null &&
              this.internationPublicationNumber.equals(other.getInternationPublicationNumber()))) &&
            ((this.internationalApplicationDate==null && other.getInternationalApplicationDate()==null) || 
             (this.internationalApplicationDate!=null &&
              this.internationalApplicationDate.equals(other.getInternationalApplicationDate()))) &&
            ((this.internationalApplicationNumber==null && other.getInternationalApplicationNumber()==null) || 
             (this.internationalApplicationNumber!=null &&
              this.internationalApplicationNumber.equals(other.getInternationalApplicationNumber()))) &&
            ((this.publKey==null && other.getPublKey()==null) || 
             (this.publKey!=null &&
              this.publKey.equals(other.getPublKey())));
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
        if (getInternationPublicationDate() != null) {
            _hashCode += getInternationPublicationDate().hashCode();
        }
        if (getInternationPublicationNumber() != null) {
            _hashCode += getInternationPublicationNumber().hashCode();
        }
        if (getInternationalApplicationDate() != null) {
            _hashCode += getInternationalApplicationDate().hashCode();
        }
        if (getInternationalApplicationNumber() != null) {
            _hashCode += getInternationalApplicationNumber().hashCode();
        }
        if (getPublKey() != null) {
            _hashCode += getPublKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InternationalApplicationOpenInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InternationalApplicationOpenInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationPublicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationPublicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationPublicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationPublicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalApplicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("internationalApplicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "internationalApplicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publKey");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publKey"));
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
