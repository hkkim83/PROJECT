/**
 * RepresentationImageInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class RepresentationImageInfo  implements java.io.Serializable {
    private java.lang.String jpgFileName;

    private java.lang.String jpgPath;

    private java.lang.String tifFileName;

    private java.lang.String tifPath;

    public RepresentationImageInfo() {
    }

    public RepresentationImageInfo(
           java.lang.String jpgFileName,
           java.lang.String jpgPath,
           java.lang.String tifFileName,
           java.lang.String tifPath) {
           this.jpgFileName = jpgFileName;
           this.jpgPath = jpgPath;
           this.tifFileName = tifFileName;
           this.tifPath = tifPath;
    }


    /**
     * Gets the jpgFileName value for this RepresentationImageInfo.
     * 
     * @return jpgFileName
     */
    public java.lang.String getJpgFileName() {
        return jpgFileName;
    }


    /**
     * Sets the jpgFileName value for this RepresentationImageInfo.
     * 
     * @param jpgFileName
     */
    public void setJpgFileName(java.lang.String jpgFileName) {
        this.jpgFileName = jpgFileName;
    }


    /**
     * Gets the jpgPath value for this RepresentationImageInfo.
     * 
     * @return jpgPath
     */
    public java.lang.String getJpgPath() {
        return jpgPath;
    }


    /**
     * Sets the jpgPath value for this RepresentationImageInfo.
     * 
     * @param jpgPath
     */
    public void setJpgPath(java.lang.String jpgPath) {
        this.jpgPath = jpgPath;
    }


    /**
     * Gets the tifFileName value for this RepresentationImageInfo.
     * 
     * @return tifFileName
     */
    public java.lang.String getTifFileName() {
        return tifFileName;
    }


    /**
     * Sets the tifFileName value for this RepresentationImageInfo.
     * 
     * @param tifFileName
     */
    public void setTifFileName(java.lang.String tifFileName) {
        this.tifFileName = tifFileName;
    }


    /**
     * Gets the tifPath value for this RepresentationImageInfo.
     * 
     * @return tifPath
     */
    public java.lang.String getTifPath() {
        return tifPath;
    }


    /**
     * Sets the tifPath value for this RepresentationImageInfo.
     * 
     * @param tifPath
     */
    public void setTifPath(java.lang.String tifPath) {
        this.tifPath = tifPath;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RepresentationImageInfo)) return false;
        RepresentationImageInfo other = (RepresentationImageInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.jpgFileName==null && other.getJpgFileName()==null) || 
             (this.jpgFileName!=null &&
              this.jpgFileName.equals(other.getJpgFileName()))) &&
            ((this.jpgPath==null && other.getJpgPath()==null) || 
             (this.jpgPath!=null &&
              this.jpgPath.equals(other.getJpgPath()))) &&
            ((this.tifFileName==null && other.getTifFileName()==null) || 
             (this.tifFileName!=null &&
              this.tifFileName.equals(other.getTifFileName()))) &&
            ((this.tifPath==null && other.getTifPath()==null) || 
             (this.tifPath!=null &&
              this.tifPath.equals(other.getTifPath())));
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
        if (getJpgFileName() != null) {
            _hashCode += getJpgFileName().hashCode();
        }
        if (getJpgPath() != null) {
            _hashCode += getJpgPath().hashCode();
        }
        if (getTifFileName() != null) {
            _hashCode += getTifFileName().hashCode();
        }
        if (getTifPath() != null) {
            _hashCode += getTifPath().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RepresentationImageInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "RepresentationImageInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jpgFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "jpgFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jpgPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "jpgPath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tifFileName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "tifFileName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tifPath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "tifPath"));
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
