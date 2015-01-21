/**
 * RegistrationNumberLinkInfoArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class RegistrationNumberLinkInfoArray  implements java.io.Serializable {
    private kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo[] registrationNumberLinkInfo;

    private java.lang.String totalSearchCount;

    public RegistrationNumberLinkInfoArray() {
    }

    public RegistrationNumberLinkInfoArray(
           kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo[] registrationNumberLinkInfo,
           java.lang.String totalSearchCount) {
           this.registrationNumberLinkInfo = registrationNumberLinkInfo;
           this.totalSearchCount = totalSearchCount;
    }


    /**
     * Gets the registrationNumberLinkInfo value for this RegistrationNumberLinkInfoArray.
     * 
     * @return registrationNumberLinkInfo
     */
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo[] getRegistrationNumberLinkInfo() {
        return registrationNumberLinkInfo;
    }


    /**
     * Sets the registrationNumberLinkInfo value for this RegistrationNumberLinkInfoArray.
     * 
     * @param registrationNumberLinkInfo
     */
    public void setRegistrationNumberLinkInfo(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo[] registrationNumberLinkInfo) {
        this.registrationNumberLinkInfo = registrationNumberLinkInfo;
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo getRegistrationNumberLinkInfo(int i) {
        return this.registrationNumberLinkInfo[i];
    }

    public void setRegistrationNumberLinkInfo(int i, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.RegistrationNumberLinkInfo _value) {
        this.registrationNumberLinkInfo[i] = _value;
    }


    /**
     * Gets the totalSearchCount value for this RegistrationNumberLinkInfoArray.
     * 
     * @return totalSearchCount
     */
    public java.lang.String getTotalSearchCount() {
        return totalSearchCount;
    }


    /**
     * Sets the totalSearchCount value for this RegistrationNumberLinkInfoArray.
     * 
     * @param totalSearchCount
     */
    public void setTotalSearchCount(java.lang.String totalSearchCount) {
        this.totalSearchCount = totalSearchCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistrationNumberLinkInfoArray)) return false;
        RegistrationNumberLinkInfoArray other = (RegistrationNumberLinkInfoArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.registrationNumberLinkInfo==null && other.getRegistrationNumberLinkInfo()==null) || 
             (this.registrationNumberLinkInfo!=null &&
              java.util.Arrays.equals(this.registrationNumberLinkInfo, other.getRegistrationNumberLinkInfo()))) &&
            ((this.totalSearchCount==null && other.getTotalSearchCount()==null) || 
             (this.totalSearchCount!=null &&
              this.totalSearchCount.equals(other.getTotalSearchCount())));
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
        if (getRegistrationNumberLinkInfo() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRegistrationNumberLinkInfo());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRegistrationNumberLinkInfo(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotalSearchCount() != null) {
            _hashCode += getTotalSearchCount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistrationNumberLinkInfoArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationNumberLinkInfoArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationNumberLinkInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "registrationNumberLinkInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RegistrationNumberLinkInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSearchCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "totalSearchCount"));
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
