/**
 * PriorityInfoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.xsd;

public class PriorityInfoResponse  implements java.io.Serializable {
    private kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] _return;

    public PriorityInfoResponse() {
    }

    public PriorityInfoResponse(
           kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] _return) {
           this._return = _return;
    }


    /**
     * Gets the _return value for this PriorityInfoResponse.
     * 
     * @return _return
     */
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this PriorityInfoResponse.
     * 
     * @param _return
     */
    public void set_return(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.DocPriorityInfo[] _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PriorityInfoResponse)) return false;
        PriorityInfoResponse other = (PriorityInfoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._return==null && other.get_return()==null) || 
             (this._return!=null &&
              java.util.Arrays.equals(this._return, other.get_return())));
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
        if (get_return() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_return());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_return(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PriorityInfoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", ">priorityInfoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_return");
        elemField.setXmlName(new javax.xml.namespace.QName("http://plus.kipris.or.kr/xsd", "return"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "DocPriorityInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "docPriorityInfo"));
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
