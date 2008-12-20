
// Generated file. Do not edit by hand.

package com.microsoft.msnsearch;

@SuppressWarnings({ "unchecked", "unused", "serial" })
public class SafeSearchOptions implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected SafeSearchOptions(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Moderate = "Moderate";
    public static final java.lang.String _Strict = "Strict";
    public static final java.lang.String _Off = "Off";
    public static final SafeSearchOptions Moderate = new SafeSearchOptions(_Moderate);
    public static final SafeSearchOptions Strict = new SafeSearchOptions(_Strict);
    public static final SafeSearchOptions Off = new SafeSearchOptions(_Off);
    public java.lang.String getValue() { return _value_;}
    public static SafeSearchOptions fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        SafeSearchOptions enumeration = (SafeSearchOptions)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static SafeSearchOptions fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SafeSearchOptions.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.microsoft.com/MSNSearch/2005/09/fex", "SafeSearchOptions"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
