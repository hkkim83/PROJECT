/**
 * IpcInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class IpcInfo  implements java.io.Serializable {
    private java.lang.String ipcDate;

    private java.lang.String ipcNumber;

    public IpcInfo() {
    }

    public IpcInfo(
           java.lang.String ipcDate,
           java.lang.String ipcNumber) {
           this.ipcDate = ipcDate;
           this.ipcNumber = ipcNumber;
    }


    /**
     * Gets the ipcDate value for this IpcInfo.
     * 
     * @return ipcDate
     */
    public java.lang.String getIpcDate() {
        return ipcDate;
    }


    /**
     * Sets the ipcDate value for this IpcInfo.
     * 
     * @param ipcDate
     */
    public void setIpcDate(java.lang.String ipcDate) {
        this.ipcDate = ipcDate;
    }


    /**
     * Gets the ipcNumber value for this IpcInfo.
     * 
     * @return ipcNumber
     */
    public java.lang.String getIpcNumber() {
        return ipcNumber;
    }


    /**
     * Sets the ipcNumber value for this IpcInfo.
     * 
     * @param ipcNumber
     */
    public void setIpcNumber(java.lang.String ipcNumber) {
        this.ipcNumber = ipcNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IpcInfo)) return false;
        IpcInfo other = (IpcInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ipcDate==null && other.getIpcDate()==null) || 
             (this.ipcDate!=null &&
              this.ipcDate.equals(other.getIpcDate()))) &&
            ((this.ipcNumber==null && other.getIpcNumber()==null) || 
             (this.ipcNumber!=null &&
              this.ipcNumber.equals(other.getIpcNumber())));
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
        if (getIpcDate() != null) {
            _hashCode += getIpcDate().hashCode();
        }
        if (getIpcNumber() != null) {
            _hashCode += getIpcNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IpcInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipcDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipcNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcNumber"));
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
