/**
 * SearchResultArray.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd;

public class SearchResultArray  implements java.io.Serializable {
    private java.lang.String colString;

    private kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult[] searchTestResult;

    private java.lang.String totalSearchCount;

    public SearchResultArray() {
    }

    public SearchResultArray(
           java.lang.String colString,
           kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult[] searchTestResult,
           java.lang.String totalSearchCount) {
           this.colString = colString;
           this.searchTestResult = searchTestResult;
           this.totalSearchCount = totalSearchCount;
    }


    /**
     * Gets the colString value for this SearchResultArray.
     * 
     * @return colString
     */
    public java.lang.String getColString() {
        return colString;
    }


    /**
     * Sets the colString value for this SearchResultArray.
     * 
     * @param colString
     */
    public void setColString(java.lang.String colString) {
        this.colString = colString;
    }


    /**
     * Gets the searchTestResult value for this SearchResultArray.
     * 
     * @return searchTestResult
     */
    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult[] getSearchTestResult() {
        return searchTestResult;
    }


    /**
     * Sets the searchTestResult value for this SearchResultArray.
     * 
     * @param searchTestResult
     */
    public void setSearchTestResult(kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult[] searchTestResult) {
        this.searchTestResult = searchTestResult;
    }

    public kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult getSearchTestResult(int i) {
        return this.searchTestResult[i];
    }

    public void setSearchTestResult(int i, kr.or.kipris.plus.webservice.services.foreignpatentbean.xsd.SearchResult _value) {
        this.searchTestResult[i] = _value;
    }


    /**
     * Gets the totalSearchCount value for this SearchResultArray.
     * 
     * @return totalSearchCount
     */
    public java.lang.String getTotalSearchCount() {
        return totalSearchCount;
    }


    /**
     * Sets the totalSearchCount value for this SearchResultArray.
     * 
     * @param totalSearchCount
     */
    public void setTotalSearchCount(java.lang.String totalSearchCount) {
        this.totalSearchCount = totalSearchCount;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchResultArray)) return false;
        SearchResultArray other = (SearchResultArray) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.colString==null && other.getColString()==null) || 
             (this.colString!=null &&
              this.colString.equals(other.getColString()))) &&
            ((this.searchTestResult==null && other.getSearchTestResult()==null) || 
             (this.searchTestResult!=null &&
              java.util.Arrays.equals(this.searchTestResult, other.getSearchTestResult()))) &&
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
        if (getColString() != null) {
            _hashCode += getColString().hashCode();
        }
        if (getSearchTestResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSearchTestResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSearchTestResult(), i);
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
        new org.apache.axis.description.TypeDesc(SearchResultArray.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchResultArray"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("colString");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "colString"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("searchTestResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "searchTestResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://foreignpatentbean.services.webservice.plus.kipris.or.kr/xsd", "SearchResult"));
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
