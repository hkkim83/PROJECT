/**
 * BibliographicSummaryInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class BibliographicSummaryInfo  implements java.io.Serializable {
    private java.lang.String applicationDate;

    private java.lang.String applicationNumber;

    private java.lang.String imageStandardCode;

    private java.lang.String inventionTitle;

    private java.lang.String ltrtNo;

    private java.lang.String openDate;

    private java.lang.String openNumber;

    private java.lang.String patTpcd;

    private java.lang.String publicationNumber;

    private java.lang.String publishDate;

    public BibliographicSummaryInfo() {
    }

    public BibliographicSummaryInfo(
           java.lang.String applicationDate,
           java.lang.String applicationNumber,
           java.lang.String imageStandardCode,
           java.lang.String inventionTitle,
           java.lang.String ltrtNo,
           java.lang.String openDate,
           java.lang.String openNumber,
           java.lang.String patTpcd,
           java.lang.String publicationNumber,
           java.lang.String publishDate) {
           this.applicationDate = applicationDate;
           this.applicationNumber = applicationNumber;
           this.imageStandardCode = imageStandardCode;
           this.inventionTitle = inventionTitle;
           this.ltrtNo = ltrtNo;
           this.openDate = openDate;
           this.openNumber = openNumber;
           this.patTpcd = patTpcd;
           this.publicationNumber = publicationNumber;
           this.publishDate = publishDate;
    }


    /**
     * Gets the applicationDate value for this BibliographicSummaryInfo.
     * 
     * @return applicationDate
     */
    public java.lang.String getApplicationDate() {
        return applicationDate;
    }


    /**
     * Sets the applicationDate value for this BibliographicSummaryInfo.
     * 
     * @param applicationDate
     */
    public void setApplicationDate(java.lang.String applicationDate) {
        this.applicationDate = applicationDate;
    }


    /**
     * Gets the applicationNumber value for this BibliographicSummaryInfo.
     * 
     * @return applicationNumber
     */
    public java.lang.String getApplicationNumber() {
        return applicationNumber;
    }


    /**
     * Sets the applicationNumber value for this BibliographicSummaryInfo.
     * 
     * @param applicationNumber
     */
    public void setApplicationNumber(java.lang.String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }


    /**
     * Gets the imageStandardCode value for this BibliographicSummaryInfo.
     * 
     * @return imageStandardCode
     */
    public java.lang.String getImageStandardCode() {
        return imageStandardCode;
    }


    /**
     * Sets the imageStandardCode value for this BibliographicSummaryInfo.
     * 
     * @param imageStandardCode
     */
    public void setImageStandardCode(java.lang.String imageStandardCode) {
        this.imageStandardCode = imageStandardCode;
    }


    /**
     * Gets the inventionTitle value for this BibliographicSummaryInfo.
     * 
     * @return inventionTitle
     */
    public java.lang.String getInventionTitle() {
        return inventionTitle;
    }


    /**
     * Sets the inventionTitle value for this BibliographicSummaryInfo.
     * 
     * @param inventionTitle
     */
    public void setInventionTitle(java.lang.String inventionTitle) {
        this.inventionTitle = inventionTitle;
    }


    /**
     * Gets the ltrtNo value for this BibliographicSummaryInfo.
     * 
     * @return ltrtNo
     */
    public java.lang.String getLtrtNo() {
        return ltrtNo;
    }


    /**
     * Sets the ltrtNo value for this BibliographicSummaryInfo.
     * 
     * @param ltrtNo
     */
    public void setLtrtNo(java.lang.String ltrtNo) {
        this.ltrtNo = ltrtNo;
    }


    /**
     * Gets the openDate value for this BibliographicSummaryInfo.
     * 
     * @return openDate
     */
    public java.lang.String getOpenDate() {
        return openDate;
    }


    /**
     * Sets the openDate value for this BibliographicSummaryInfo.
     * 
     * @param openDate
     */
    public void setOpenDate(java.lang.String openDate) {
        this.openDate = openDate;
    }


    /**
     * Gets the openNumber value for this BibliographicSummaryInfo.
     * 
     * @return openNumber
     */
    public java.lang.String getOpenNumber() {
        return openNumber;
    }


    /**
     * Sets the openNumber value for this BibliographicSummaryInfo.
     * 
     * @param openNumber
     */
    public void setOpenNumber(java.lang.String openNumber) {
        this.openNumber = openNumber;
    }


    /**
     * Gets the patTpcd value for this BibliographicSummaryInfo.
     * 
     * @return patTpcd
     */
    public java.lang.String getPatTpcd() {
        return patTpcd;
    }


    /**
     * Sets the patTpcd value for this BibliographicSummaryInfo.
     * 
     * @param patTpcd
     */
    public void setPatTpcd(java.lang.String patTpcd) {
        this.patTpcd = patTpcd;
    }


    /**
     * Gets the publicationNumber value for this BibliographicSummaryInfo.
     * 
     * @return publicationNumber
     */
    public java.lang.String getPublicationNumber() {
        return publicationNumber;
    }


    /**
     * Sets the publicationNumber value for this BibliographicSummaryInfo.
     * 
     * @param publicationNumber
     */
    public void setPublicationNumber(java.lang.String publicationNumber) {
        this.publicationNumber = publicationNumber;
    }


    /**
     * Gets the publishDate value for this BibliographicSummaryInfo.
     * 
     * @return publishDate
     */
    public java.lang.String getPublishDate() {
        return publishDate;
    }


    /**
     * Sets the publishDate value for this BibliographicSummaryInfo.
     * 
     * @param publishDate
     */
    public void setPublishDate(java.lang.String publishDate) {
        this.publishDate = publishDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BibliographicSummaryInfo)) return false;
        BibliographicSummaryInfo other = (BibliographicSummaryInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.applicationDate==null && other.getApplicationDate()==null) || 
             (this.applicationDate!=null &&
              this.applicationDate.equals(other.getApplicationDate()))) &&
            ((this.applicationNumber==null && other.getApplicationNumber()==null) || 
             (this.applicationNumber!=null &&
              this.applicationNumber.equals(other.getApplicationNumber()))) &&
            ((this.imageStandardCode==null && other.getImageStandardCode()==null) || 
             (this.imageStandardCode!=null &&
              this.imageStandardCode.equals(other.getImageStandardCode()))) &&
            ((this.inventionTitle==null && other.getInventionTitle()==null) || 
             (this.inventionTitle!=null &&
              this.inventionTitle.equals(other.getInventionTitle()))) &&
            ((this.ltrtNo==null && other.getLtrtNo()==null) || 
             (this.ltrtNo!=null &&
              this.ltrtNo.equals(other.getLtrtNo()))) &&
            ((this.openDate==null && other.getOpenDate()==null) || 
             (this.openDate!=null &&
              this.openDate.equals(other.getOpenDate()))) &&
            ((this.openNumber==null && other.getOpenNumber()==null) || 
             (this.openNumber!=null &&
              this.openNumber.equals(other.getOpenNumber()))) &&
            ((this.patTpcd==null && other.getPatTpcd()==null) || 
             (this.patTpcd!=null &&
              this.patTpcd.equals(other.getPatTpcd()))) &&
            ((this.publicationNumber==null && other.getPublicationNumber()==null) || 
             (this.publicationNumber!=null &&
              this.publicationNumber.equals(other.getPublicationNumber()))) &&
            ((this.publishDate==null && other.getPublishDate()==null) || 
             (this.publishDate!=null &&
              this.publishDate.equals(other.getPublishDate())));
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
        if (getApplicationDate() != null) {
            _hashCode += getApplicationDate().hashCode();
        }
        if (getApplicationNumber() != null) {
            _hashCode += getApplicationNumber().hashCode();
        }
        if (getImageStandardCode() != null) {
            _hashCode += getImageStandardCode().hashCode();
        }
        if (getInventionTitle() != null) {
            _hashCode += getInventionTitle().hashCode();
        }
        if (getLtrtNo() != null) {
            _hashCode += getLtrtNo().hashCode();
        }
        if (getOpenDate() != null) {
            _hashCode += getOpenDate().hashCode();
        }
        if (getOpenNumber() != null) {
            _hashCode += getOpenNumber().hashCode();
        }
        if (getPatTpcd() != null) {
            _hashCode += getPatTpcd().hashCode();
        }
        if (getPublicationNumber() != null) {
            _hashCode += getPublicationNumber().hashCode();
        }
        if (getPublishDate() != null) {
            _hashCode += getPublishDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BibliographicSummaryInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "BibliographicSummaryInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "applicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imageStandardCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "imageStandardCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventionTitle");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "inventionTitle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ltrtNo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "ltrtNo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("openNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "openNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patTpcd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "patTpcd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publicationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publicationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("publishDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "publishDate"));
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
