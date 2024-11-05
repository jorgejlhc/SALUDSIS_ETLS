/**
 * Verifica_PacienteResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public class Verifica_PacienteResponse  implements java.io.Serializable {
    private routines.Verifica_PacienteResponseVerifica_PacienteResult verifica_PacienteResult;

    public Verifica_PacienteResponse() {
    }

    public Verifica_PacienteResponse(
           routines.Verifica_PacienteResponseVerifica_PacienteResult verifica_PacienteResult) {
           this.verifica_PacienteResult = verifica_PacienteResult;
    }


    /**
     * Gets the verifica_PacienteResult value for this Verifica_PacienteResponse.
     * 
     * @return verifica_PacienteResult
     */
    public routines.Verifica_PacienteResponseVerifica_PacienteResult getVerifica_PacienteResult() {
        return verifica_PacienteResult;
    }


    /**
     * Sets the verifica_PacienteResult value for this Verifica_PacienteResponse.
     * 
     * @param verifica_PacienteResult
     */
    public void setVerifica_PacienteResult(routines.Verifica_PacienteResponseVerifica_PacienteResult verifica_PacienteResult) {
        this.verifica_PacienteResult = verifica_PacienteResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Verifica_PacienteResponse)) return false;
        Verifica_PacienteResponse other = (Verifica_PacienteResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.verifica_PacienteResult==null && other.getVerifica_PacienteResult()==null) || 
             (this.verifica_PacienteResult!=null &&
              this.verifica_PacienteResult.equals(other.getVerifica_PacienteResult())));
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
        if (getVerifica_PacienteResult() != null) {
            _hashCode += getVerifica_PacienteResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Verifica_PacienteResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">Verifica_PacienteResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("verifica_PacienteResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/", "Verifica_PacienteResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/", ">>Verifica_PacienteResponse>Verifica_PacienteResult"));
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
