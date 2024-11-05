/**
 * Consulta_x0020_DatosResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public class Consulta_x0020_DatosResponse  implements java.io.Serializable {
    private routines.Consulta_x0020_DatosResponseConsulta_x0020_DatosResult consulta_x0020_DatosResult;

    public Consulta_x0020_DatosResponse() {
    }

    public Consulta_x0020_DatosResponse(
           routines.Consulta_x0020_DatosResponseConsulta_x0020_DatosResult consulta_x0020_DatosResult) {
           this.consulta_x0020_DatosResult = consulta_x0020_DatosResult;
    }


    /**
     * Gets the consulta_x0020_DatosResult value for this Consulta_x0020_DatosResponse.
     * 
     * @return consulta_x0020_DatosResult
     */
    public routines.Consulta_x0020_DatosResponseConsulta_x0020_DatosResult getConsulta_x0020_DatosResult() {
        return consulta_x0020_DatosResult;
    }


    /**
     * Sets the consulta_x0020_DatosResult value for this Consulta_x0020_DatosResponse.
     * 
     * @param consulta_x0020_DatosResult
     */
    public void setConsulta_x0020_DatosResult(routines.Consulta_x0020_DatosResponseConsulta_x0020_DatosResult consulta_x0020_DatosResult) {
        this.consulta_x0020_DatosResult = consulta_x0020_DatosResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Consulta_x0020_DatosResponse)) return false;
        Consulta_x0020_DatosResponse other = (Consulta_x0020_DatosResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consulta_x0020_DatosResult==null && other.getConsulta_x0020_DatosResult()==null) || 
             (this.consulta_x0020_DatosResult!=null &&
              this.consulta_x0020_DatosResult.equals(other.getConsulta_x0020_DatosResult())));
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
        if (getConsulta_x0020_DatosResult() != null) {
            _hashCode += getConsulta_x0020_DatosResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Consulta_x0020_DatosResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Consulta_x0020_DatosResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consulta_x0020_DatosResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Consulta_x0020_DatosResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Consulta_x0020_DatosResponse>Consulta_x0020_DatosResult"));
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
