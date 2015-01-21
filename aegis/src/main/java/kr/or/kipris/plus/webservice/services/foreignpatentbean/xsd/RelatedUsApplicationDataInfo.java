/**
 * RelatedUsApplicationDataInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class RelatedUsApplicationDataInfo  implements java.io.Serializable {
    private java.lang.String kind;

    private java.lang.String ltrtnoLink;

    private java.lang.String patDt;

    private java.lang.String patno;

    private java.lang.String stcd;

    public RelatedUsApplicationDataInfo() {
    }

    public RelatedUsApplicationDataInfo(
           java.lang.String kind,
           java.lang.String ltrtnoLink,
           java.lang.String patDt,
           java.lang.String patno,
           java.lang.String stcd) {
           this.kind = kind;
           this.ltrtnoLink = ltrtnoLink;
           this.patDt = patDt;
           this.patno = patno;
           this.stcd = stcd;
    }


    /**
     * Gets the kind value for this RelatedUsApplicationDataInfo.
     * 
     * @return kind
     */
    public java.lang.String getKind() {
        return kind;
    }


    /**
     * Sets the kind value for this RelatedUsApplicationDataInfo.
     * 
     * @param kind
     */
    public void setKind(java.lang.String kind) {
        this.kind = kind;
    }


    /**
     * Gets the ltrtnoLink value for this RelatedUsApplicationDataInfo.
     * 
     * @return ltrtnoLink
     */
    public java.lang.String getLtrtnoLink() {
        return ltrtnoLink;
    }


    /**
     * Sets the ltrtnoLink value for this RelatedUsApplicationDataInfo.
     * 
     * @param ltrtnoLink
     */
    public void setLtrtnoLink(java.lang.String ltrtnoLink) {
        this.ltrtnoLink = ltrtnoLink;
    }


    /**
     * Gets the patDt value for this RelatedUsApplicationDataInfo.
     * 
     * @return patDt
     */
    public java.lang.String getPatDt() {
        return patDt;
    }


    /**
     * Sets the patDt value for this RelatedUsApplicationDataInfo.
     * 
     * @param patDt
     */
    public void setPatDt(java.lang.String patDt) {
        this.patDt = patDt;
    }


    /**
     * Gets the patno value for this RelatedUsApplicationDataInfo.
     * 
     * @return patno
     */
    public java.lang.String getPatno() {
        return patno;
    }


    /**
     * Sets the patno value for this RelatedUsApplicationDataInfo.
     * 
     * @param patno
     */
    public void setPatno(java.lang.String patno) {
        this.patno = patno;
    }


    /**
     * Gets the stcd value for this RelatedUsApplicationDataInfo.
     * 
     * @return stcd
     */
    public java.lang.String getStcd() {
        return stcd;
    }


    /**
     * Sets the stcd value for this RelatedUsApplicationDataInfo.
     * 
     * @param stcd
     */
    public void setStcd(java.lang.String stcd) {
        this.stcd = stcd;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RelatedUsApplicationDataInfo)) return false;
        RelatedUsApplicationDataInfo other = (RelatedUsApplicationDataInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.kind==null && other.getKind()==null) || 
             (this.kind!=null &&
              this.kind.equals(other.getKind()))) &&
            ((this.ltrtnoLink==null && other.getLtrtnoLink()==null) || 
             (this.ltrtnoLink!=null &&
              this.ltrtnoLink.equals(other.getLtrtnoLink()))) &&
            ((this.patDt==null && other.getPatDt()==null) || 
             (this.patDt!=null &&
              this.patDt.equals(other.getPatDt()))) &&
            ((this.patno==null && other.getPatno()==null) || 
             (this.patno!=null &&
              this.patno.equals(other.getPatno()))) &&
            ((this.stcd==null && other.getStcd()==null) || 
             (this.stcd!=null &&
              this.stcd.equals(other.getStcd())));
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
        if (getKind() != null) {
            _hashCode += getKind().hashCode();
        }
        if (getLtrtnoLink() != null) {
            _hashCode += getLtrtnoLink().hashCode();
        }
        if (getPatDt() != null) {
            _hashCode += getPatDt().hashCode();
        }
        if (getPatno() != null) {
            _hashCode += getPatno().hashCode();
        }
        if (getStcd() != null) {
            _hashCode += getStcd().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RelatedUsApplicationDataInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RelatedUsApplicationDataInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("kind");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "kind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltrtnoLink");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ltrtnoLink"));
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
        elemField.setFieldName("patno");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "patno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stcd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "stcd"));
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
