/**
 * Verifica_Paciente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public class Verifica_Paciente  implements java.io.Serializable {
    private java.lang.String keyVerificacion;

    private java.lang.String numDocPaciente;

    public Verifica_Paciente() {
    }

    public Verifica_Paciente(
           java.lang.String keyVerificacion,
           java.lang.String numDocPaciente) {
           this.keyVerificacion = keyVerificacion;
           this.numDocPaciente = numDocPaciente;
    }


    /**
     * Gets the keyVerificacion value for this Verifica_Paciente.
     * 
     * @return keyVerificacion
     */
    public java.lang.String getKeyVerificacion() {
        return keyVerificacion;
    }


    /**
     * Sets the keyVerificacion value for this Verifica_Paciente.
     * 
     * @param keyVerificacion
     */
    public void setKeyVerificacion(java.lang.String keyVerificacion) {
        this.keyVerificacion = keyVerificacion;
    }


    /**
     * Gets the numDocPaciente value for this Verifica_Paciente.
     * 
     * @return numDocPaciente
     */
    public java.lang.String getNumDocPaciente() {
        return numDocPaciente;
    }


    /**
     * Sets the numDocPaciente value for this Verifica_Paciente.
     * 
     * @param numDocPaciente
     */
    public void setNumDocPaciente(java.lang.String numDocPaciente) {
        this.numDocPaciente = numDocPaciente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Verifica_Paciente)) return false;
        Verifica_Paciente other = (Verifica_Paciente) obj;
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
            ((this.numDocPaciente==null && other.getNumDocPaciente()==null) || 
             (this.numDocPaciente!=null &&
              this.numDocPaciente.equals(other.getNumDocPaciente())));
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
        if (getNumDocPaciente() != null) {
            _hashCode += getNumDocPaciente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Verifica_Paciente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Verifica_Paciente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("keyVerificacion");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "KeyVerificacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numDocPaciente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "NumDocPaciente"));
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
