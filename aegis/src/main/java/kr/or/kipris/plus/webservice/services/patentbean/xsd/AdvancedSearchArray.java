/**
 * AdvancedSearchArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.patentbean.xsd;

public class AdvancedSearchArray  implements java.io.Serializable {
    private kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch[] advancedSearch;

    private java.lang.Integer docsStart;

    private java.lang.Integer totalSearchCount;

    public AdvancedSearchArray() {
    }

    public AdvancedSearchArray(
           kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch[] advancedSearch,
           java.lang.Integer docsStart,
           java.lang.Integer totalSearchCount) {
           this.advancedSearch = advancedSearch;
           this.docsStart = docsStart;
           this.totalSearchCount = totalSearchCount;
    }


    /**
     * Gets the advancedSearch value for this AdvancedSearchArray.
     * 
     * @return advancedSearch
     */
    public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch[] getAdvancedSearch() {
        return advancedSearch;
    }


    /**
     * Sets the advancedSearch value for this AdvancedSearchArray.
     * 
     * @param advancedSearch
     */
    public void setAdvancedSearch(kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch[] advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    public kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch getAdvancedSearch(int i) {
        return this.advancedSearch[i];
    }

    public void setAdvancedSearch(int i, kr.or.kipris.plus.webservice.services.patentbean.xsd.AdvancedSearch _value) {
        this.advancedSearch[i] = _value;
    }


    /**
     * Gets the docsStart value for this AdvancedSearchArray.
     * 
     * @return docsStart
     */
    public java.lang.Integer getDocsStart() {
        return docsStart;
    }


    /**
     * Sets the docsStart value for this AdvancedSearchArray.
     * 
     * @param docsStart
     */
    public void setDocsStart(java.lang.Integer docsStart) {
        this.docsStart = docsStart;
    }


    /**
     * Gets the totalSearchCount value for this AdvancedSearchArray.
     * 
     * @return totalSearchCount
     */
    public java.lang.Integer getTotalSearchCount() {
        return totalSearchCount;
    }


    /**
     * Sets the totalSearchCount value for this AdvancedSearchArray.
     * 
     * @param totalSearchCount
     */
    public void setTotalSearchCount(java.lang.Integer totalSearchCount) {
        this.totalSearchCount = totalSearchCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AdvancedSearchArray)) return false;
        AdvancedSearchArray other = (AdvancedSearchArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.advancedSearch==null && other.getAdvancedSearch()==null) || 
             (this.advancedSearch!=null &&
              java.util.Arrays.equals(this.advancedSearch, other.getAdvancedSearch()))) &&
            ((this.docsStart==null && other.getDocsStart()==null) || 
             (this.docsStart!=null &&
              this.docsStart.equals(other.getDocsStart()))) &&
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
        if (getAdvancedSearch() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAdvancedSearch());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAdvancedSearch(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocsStart() != null) {
            _hashCode += getDocsStart().hashCode();
        }
        if (getTotalSearchCount() != null) {
            _hashCode += getTotalSearchCount().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AdvancedSearchArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "AdvancedSearchArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("advancedSearch");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "advancedSearch"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "AdvancedSearch"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docsStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "docsStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalSearchCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://patentbean.services.webservice.plus.kipris.or.kr/xsd", "totalSearchCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
