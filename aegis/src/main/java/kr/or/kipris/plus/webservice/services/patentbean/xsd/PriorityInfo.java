/**
 * PriorityInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class PriorityInfo  implements java.io.Serializable {
    private java.lang.String priorityApplicationCountry;

    private java.lang.String priorityApplicationDate;

    private java.lang.String priorityApplicationNumber;

    public PriorityInfo() {
    }

    public PriorityInfo(
           java.lang.String priorityApplicationCountry,
           java.lang.String priorityApplicationDate,
           java.lang.String priorityApplicationNumber) {
           this.priorityApplicationCountry = priorityApplicationCountry;
           this.priorityApplicationDate = priorityApplicationDate;
           this.priorityApplicationNumber = priorityApplicationNumber;
    }


    /**
     * Gets the priorityApplicationCountry value for this PriorityInfo.
     * 
     * @return priorityApplicationCountry
     */
    public java.lang.String getPriorityApplicationCountry() {
        return priorityApplicationCountry;
    }


    /**
     * Sets the priorityApplicationCountry value for this PriorityInfo.
     * 
     * @param priorityApplicationCountry
     */
    public void setPriorityApplicationCountry(java.lang.String priorityApplicationCountry) {
        this.priorityApplicationCountry = priorityApplicationCountry;
    }


    /**
     * Gets the priorityApplicationDate value for this PriorityInfo.
     * 
     * @return priorityApplicationDate
     */
    public java.lang.String getPriorityApplicationDate() {
        return priorityApplicationDate;
    }


    /**
     * Sets the priorityApplicationDate value for this PriorityInfo.
     * 
     * @param priorityApplicationDate
     */
    public void setPriorityApplicationDate(java.lang.String priorityApplicationDate) {
        this.priorityApplicationDate = priorityApplicationDate;
    }


    /**
     * Gets the priorityApplicationNumber value for this PriorityInfo.
     * 
     * @return priorityApplicationNumber
     */
    public java.lang.String getPriorityApplicationNumber() {
        return priorityApplicationNumber;
    }


    /**
     * Sets the priorityApplicationNumber value for this PriorityInfo.
     * 
     * @param priorityApplicationNumber
     */
    public void setPriorityApplicationNumber(java.lang.String priorityApplicationNumber) {
        this.priorityApplicationNumber = priorityApplicationNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriorityInfo)) return false;
        PriorityInfo other = (PriorityInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.priorityApplicationCountry==null && other.getPriorityApplicationCountry()==null) || 
             (this.priorityApplicationCountry!=null &&
              this.priorityApplicationCountry.equals(other.getPriorityApplicationCountry()))) &&
            ((this.priorityApplicationDate==null && other.getPriorityApplicationDate()==null) || 
             (this.priorityApplicationDate!=null &&
              this.priorityApplicationDate.equals(other.getPriorityApplicationDate()))) &&
            ((this.priorityApplicationNumber==null && other.getPriorityApplicationNumber()==null) || 
             (this.priorityApplicationNumber!=null &&
              this.priorityApplicationNumber.equals(other.getPriorityApplicationNumber())));
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
        if (getPriorityApplicationCountry() != null) {
            _hashCode += getPriorityApplicationCountry().hashCode();
        }
        if (getPriorityApplicationDate() != null) {
            _hashCode += getPriorityApplicationDate().hashCode();
        }
        if (getPriorityApplicationNumber() != null) {
            _hashCode += getPriorityApplicationNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriorityInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "PriorityInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityApplicationCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityApplicationCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityApplicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityApplicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priorityApplicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "priorityApplicationNumber"));
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
