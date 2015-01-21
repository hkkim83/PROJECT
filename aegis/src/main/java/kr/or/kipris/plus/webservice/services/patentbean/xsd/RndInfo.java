/**
 * RndInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class RndInfo  implements java.io.Serializable {
    private java.lang.String rndDepartmentName;

    private java.lang.String rndDuration;

    private java.lang.String rndManagingInstituteName;

    private java.lang.String rndProjectName;

    private java.lang.String rndSpecialInstituteName;

    private java.lang.String rndTaskContribution;

    private java.lang.String rndTaskName;

    private java.lang.String rndTaskNumber;

    public RndInfo() {
    }

    public RndInfo(
           java.lang.String rndDepartmentName,
           java.lang.String rndDuration,
           java.lang.String rndManagingInstituteName,
           java.lang.String rndProjectName,
           java.lang.String rndSpecialInstituteName,
           java.lang.String rndTaskContribution,
           java.lang.String rndTaskName,
           java.lang.String rndTaskNumber) {
           this.rndDepartmentName = rndDepartmentName;
           this.rndDuration = rndDuration;
           this.rndManagingInstituteName = rndManagingInstituteName;
           this.rndProjectName = rndProjectName;
           this.rndSpecialInstituteName = rndSpecialInstituteName;
           this.rndTaskContribution = rndTaskContribution;
           this.rndTaskName = rndTaskName;
           this.rndTaskNumber = rndTaskNumber;
    }


    /**
     * Gets the rndDepartmentName value for this RndInfo.
     * 
     * @return rndDepartmentName
     */
    public java.lang.String getRndDepartmentName() {
        return rndDepartmentName;
    }


    /**
     * Sets the rndDepartmentName value for this RndInfo.
     * 
     * @param rndDepartmentName
     */
    public void setRndDepartmentName(java.lang.String rndDepartmentName) {
        this.rndDepartmentName = rndDepartmentName;
    }


    /**
     * Gets the rndDuration value for this RndInfo.
     * 
     * @return rndDuration
     */
    public java.lang.String getRndDuration() {
        return rndDuration;
    }


    /**
     * Sets the rndDuration value for this RndInfo.
     * 
     * @param rndDuration
     */
    public void setRndDuration(java.lang.String rndDuration) {
        this.rndDuration = rndDuration;
    }


    /**
     * Gets the rndManagingInstituteName value for this RndInfo.
     * 
     * @return rndManagingInstituteName
     */
    public java.lang.String getRndManagingInstituteName() {
        return rndManagingInstituteName;
    }


    /**
     * Sets the rndManagingInstituteName value for this RndInfo.
     * 
     * @param rndManagingInstituteName
     */
    public void setRndManagingInstituteName(java.lang.String rndManagingInstituteName) {
        this.rndManagingInstituteName = rndManagingInstituteName;
    }


    /**
     * Gets the rndProjectName value for this RndInfo.
     * 
     * @return rndProjectName
     */
    public java.lang.String getRndProjectName() {
        return rndProjectName;
    }


    /**
     * Sets the rndProjectName value for this RndInfo.
     * 
     * @param rndProjectName
     */
    public void setRndProjectName(java.lang.String rndProjectName) {
        this.rndProjectName = rndProjectName;
    }


    /**
     * Gets the rndSpecialInstituteName value for this RndInfo.
     * 
     * @return rndSpecialInstituteName
     */
    public java.lang.String getRndSpecialInstituteName() {
        return rndSpecialInstituteName;
    }


    /**
     * Sets the rndSpecialInstituteName value for this RndInfo.
     * 
     * @param rndSpecialInstituteName
     */
    public void setRndSpecialInstituteName(java.lang.String rndSpecialInstituteName) {
        this.rndSpecialInstituteName = rndSpecialInstituteName;
    }


    /**
     * Gets the rndTaskContribution value for this RndInfo.
     * 
     * @return rndTaskContribution
     */
    public java.lang.String getRndTaskContribution() {
        return rndTaskContribution;
    }


    /**
     * Sets the rndTaskContribution value for this RndInfo.
     * 
     * @param rndTaskContribution
     */
    public void setRndTaskContribution(java.lang.String rndTaskContribution) {
        this.rndTaskContribution = rndTaskContribution;
    }


    /**
     * Gets the rndTaskName value for this RndInfo.
     * 
     * @return rndTaskName
     */
    public java.lang.String getRndTaskName() {
        return rndTaskName;
    }


    /**
     * Sets the rndTaskName value for this RndInfo.
     * 
     * @param rndTaskName
     */
    public void setRndTaskName(java.lang.String rndTaskName) {
        this.rndTaskName = rndTaskName;
    }


    /**
     * Gets the rndTaskNumber value for this RndInfo.
     * 
     * @return rndTaskNumber
     */
    public java.lang.String getRndTaskNumber() {
        return rndTaskNumber;
    }


    /**
     * Sets the rndTaskNumber value for this RndInfo.
     * 
     * @param rndTaskNumber
     */
    public void setRndTaskNumber(java.lang.String rndTaskNumber) {
        this.rndTaskNumber = rndTaskNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RndInfo)) return false;
        RndInfo other = (RndInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.rndDepartmentName==null && other.getRndDepartmentName()==null) || 
             (this.rndDepartmentName!=null &&
              this.rndDepartmentName.equals(other.getRndDepartmentName()))) &&
            ((this.rndDuration==null && other.getRndDuration()==null) || 
             (this.rndDuration!=null &&
              this.rndDuration.equals(other.getRndDuration()))) &&
            ((this.rndManagingInstituteName==null && other.getRndManagingInstituteName()==null) || 
             (this.rndManagingInstituteName!=null &&
              this.rndManagingInstituteName.equals(other.getRndManagingInstituteName()))) &&
            ((this.rndProjectName==null && other.getRndProjectName()==null) || 
             (this.rndProjectName!=null &&
              this.rndProjectName.equals(other.getRndProjectName()))) &&
            ((this.rndSpecialInstituteName==null && other.getRndSpecialInstituteName()==null) || 
             (this.rndSpecialInstituteName!=null &&
              this.rndSpecialInstituteName.equals(other.getRndSpecialInstituteName()))) &&
            ((this.rndTaskContribution==null && other.getRndTaskContribution()==null) || 
             (this.rndTaskContribution!=null &&
              this.rndTaskContribution.equals(other.getRndTaskContribution()))) &&
            ((this.rndTaskName==null && other.getRndTaskName()==null) || 
             (this.rndTaskName!=null &&
              this.rndTaskName.equals(other.getRndTaskName()))) &&
            ((this.rndTaskNumber==null && other.getRndTaskNumber()==null) || 
             (this.rndTaskNumber!=null &&
              this.rndTaskNumber.equals(other.getRndTaskNumber())));
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
        if (getRndDepartmentName() != null) {
            _hashCode += getRndDepartmentName().hashCode();
        }
        if (getRndDuration() != null) {
            _hashCode += getRndDuration().hashCode();
        }
        if (getRndManagingInstituteName() != null) {
            _hashCode += getRndManagingInstituteName().hashCode();
        }
        if (getRndProjectName() != null) {
            _hashCode += getRndProjectName().hashCode();
        }
        if (getRndSpecialInstituteName() != null) {
            _hashCode += getRndSpecialInstituteName().hashCode();
        }
        if (getRndTaskContribution() != null) {
            _hashCode += getRndTaskContribution().hashCode();
        }
        if (getRndTaskName() != null) {
            _hashCode += getRndTaskName().hashCode();
        }
        if (getRndTaskNumber() != null) {
            _hashCode += getRndTaskNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RndInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "RndInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndDepartmentName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndDepartmentName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndManagingInstituteName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndManagingInstituteName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndProjectName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndProjectName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndSpecialInstituteName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndSpecialInstituteName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndTaskContribution");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndTaskContribution"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndTaskName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndTaskName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rndTaskNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "rndTaskNumber"));
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
