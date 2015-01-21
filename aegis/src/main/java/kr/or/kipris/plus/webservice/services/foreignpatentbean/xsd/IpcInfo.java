/**
 * IpcInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class IpcInfo  implements java.io.Serializable {
    private java.lang.String ipcCd;

    private java.lang.String ipcVersion;

    public IpcInfo() {
    }

    public IpcInfo(
           java.lang.String ipcCd,
           java.lang.String ipcVersion) {
           this.ipcCd = ipcCd;
           this.ipcVersion = ipcVersion;
    }


    /**
     * Gets the ipcCd value for this IpcInfo.
     * 
     * @return ipcCd
     */
    public java.lang.String getIpcCd() {
        return ipcCd;
    }


    /**
     * Sets the ipcCd value for this IpcInfo.
     * 
     * @param ipcCd
     */
    public void setIpcCd(java.lang.String ipcCd) {
        this.ipcCd = ipcCd;
    }


    /**
     * Gets the ipcVersion value for this IpcInfo.
     * 
     * @return ipcVersion
     */
    public java.lang.String getIpcVersion() {
        return ipcVersion;
    }


    /**
     * Sets the ipcVersion value for this IpcInfo.
     * 
     * @param ipcVersion
     */
    public void setIpcVersion(java.lang.String ipcVersion) {
        this.ipcVersion = ipcVersion;
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
            ((this.ipcCd==null && other.getIpcCd()==null) || 
             (this.ipcCd!=null &&
              this.ipcCd.equals(other.getIpcCd()))) &&
            ((this.ipcVersion==null && other.getIpcVersion()==null) || 
             (this.ipcVersion!=null &&
              this.ipcVersion.equals(other.getIpcVersion())));
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
        if (getIpcCd() != null) {
            _hashCode += getIpcCd().hashCode();
        }
        if (getIpcVersion() != null) {
            _hashCode += getIpcVersion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IpcInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "IpcInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipcCd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipcVersion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ipcVersion"));
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
