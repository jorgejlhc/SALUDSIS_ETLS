/**
 * Consulta_x0020_Datos.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public class Consulta_x0020_Datos  implements java.io.Serializable {
    private java.lang.String keyVerificacion;

    private java.lang.String sConsulta;

    public Consulta_x0020_Datos() {
    }

    public Consulta_x0020_Datos(
           java.lang.String keyVerificacion,
           java.lang.String sConsulta) {
           this.keyVerificacion = keyVerificacion;
           this.sConsulta = sConsulta;
    }


    /**
     * Gets the keyVerificacion value for this Consulta_x0020_Datos.
     * 
     * @return keyVerificacion
     */
    public java.lang.String getKeyVerificacion() {
        return keyVerificacion;
    }


    /**
     * Sets the keyVerificacion value for this Consulta_x0020_Datos.
     * 
     * @param keyVerificacion
     */
    public void setKeyVerificacion(java.lang.String keyVerificacion) {
        this.keyVerificacion = keyVerificacion;
    }


    /**
     * Gets the sConsulta value for this Consulta_x0020_Datos.
     * 
     * @return sConsulta
     */
    public java.lang.String getSConsulta() {
        return sConsulta;
    }


    /**
     * Sets the sConsulta value for this Consulta_x0020_Datos.
     * 
     * @param sConsulta
     */
    public void setSConsulta(java.lang.String sConsulta) {
        this.sConsulta = sConsulta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Consulta_x0020_Datos)) return false;
        Consulta_x0020_Datos other = (Consulta_x0020_Datos) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.keyVerificacion==null && other.getKeyVerificacion()==null) || 
             (this.keyVerificacion!=null &&
              this.keyVerificacion.equals(other.getKeyVerificacion()))) &&
            ((this.sConsulta==null && other.getSConsulta()==null) || 
             (this.sConsulta!=null &&
              this.sConsulta.equals(other.getSConsulta())));
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
        if (getKeyVerificacion() != null) {
            _hashCode += getKeyVerificacion().hashCode();
        }
        if (getSConsulta() != null) {
            _hashCode += getSConsulta().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Consulta_x0020_Datos.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Consulta_x0020_Datos"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyVerificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "KeyVerificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "sConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
