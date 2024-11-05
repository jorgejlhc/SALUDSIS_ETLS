/**
 * WsVerificaSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public interface WsVerificaSoap_PortType extends java.rmi.Remote {

    /**
     * Consultar Datos DGSM
     */
    public routines.Consulta_x0020_DatosResponse consultarDatos(routines.Consulta_x0020_Datos parameters) throws java.rmi.RemoteException;

    /**
     * Proceso para verificar el paciente en cita DGSM
     */
    public routines.Verifica_PacienteResponse verificaPaciente(routines.Verifica_Paciente parameters) throws java.rmi.RemoteException;
}
