/**
 * InventorsInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class InventorsInfo  implements java.io.Serializable {
    private java.lang.String inventorAddress;

    private java.lang.String inventorCountry;

    private java.lang.String inventorName;

    public InventorsInfo() {
    }

    public InventorsInfo(
           java.lang.String inventorAddress,
           java.lang.String inventorCountry,
           java.lang.String inventorName) {
           this.inventorAddress = inventorAddress;
           this.inventorCountry = inventorCountry;
           this.inventorName = inventorName;
    }


    /**
     * Gets the inventorAddress value for this InventorsInfo.
     * 
     * @return inventorAddress
     */
    public java.lang.String getInventorAddress() {
        return inventorAddress;
    }


    /**
     * Sets the inventorAddress value for this InventorsInfo.
     * 
     * @param inventorAddress
     */
    public void setInventorAddress(java.lang.String inventorAddress) {
        this.inventorAddress = inventorAddress;
    }


    /**
     * Gets the inventorCountry value for this InventorsInfo.
     * 
     * @return inventorCountry
     */
    public java.lang.String getInventorCountry() {
        return inventorCountry;
    }


    /**
     * Sets the inventorCountry value for this InventorsInfo.
     * 
     * @param inventorCountry
     */
    public void setInventorCountry(java.lang.String inventorCountry) {
        this.inventorCountry = inventorCountry;
    }


    /**
     * Gets the inventorName value for this InventorsInfo.
     * 
     * @return inventorName
     */
    public java.lang.String getInventorName() {
        return inventorName;
    }


    /**
     * Sets the inventorName value for this InventorsInfo.
     * 
     * @param inventorName
     */
    public void setInventorName(java.lang.String inventorName) {
        this.inventorName = inventorName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InventorsInfo)) return false;
        InventorsInfo other = (InventorsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inventorAddress==null && other.getInventorAddress()==null) || 
             (this.inventorAddress!=null &&
              this.inventorAddress.equals(other.getInventorAddress()))) &&
            ((this.inventorCountry==null && other.getInventorCountry()==null) || 
             (this.inventorCountry!=null &&
              this.inventorCountry.equals(other.getInventorCountry()))) &&
            ((this.inventorName==null && other.getInventorName()==null) || 
             (this.inventorName!=null &&
              this.inventorName.equals(other.getInventorName())));
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
        if (getInventorAddress() != null) {
            _hashCode += getInventorAddress().hashCode();
        }
        if (getInventorCountry() != null) {
            _hashCode += getInventorCountry().hashCode();
        }
        if (getInventorName() != null) {
            _hashCode += getInventorName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InventorsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "InventorsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventorAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorCountry");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventorCountry"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventorName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventorName"));
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
