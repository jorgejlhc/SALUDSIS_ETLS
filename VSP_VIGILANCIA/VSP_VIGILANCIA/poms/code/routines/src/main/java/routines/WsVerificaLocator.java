/**
 * WsVerificaLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package routines;

public class WsVerificaLocator extends org.apache.axis.client.Service implements routines.WsVerifica {

    public WsVerificaLocator() {
    }


    public WsVerificaLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WsVerificaLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for wsVerificaSoap
    private java.lang.String wsVerificaSoap_address = "http://172.20.18.180:2121/SOAP/AFI/wsVerifica.asmx";

    public java.lang.String getwsVerificaSoapAddress() {
        return wsVerificaSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String wsVerificaSoapWSDDServiceName = "wsVerificaSoap";

    public java.lang.String getwsVerificaSoapWSDDServiceName() {
        return wsVerificaSoapWSDDServiceName;
    }

    public void setwsVerificaSoapWSDDServiceName(java.lang.String name) {
        wsVerificaSoapWSDDServiceName = name;
    }

    public routines.WsVerificaSoap_PortType getwsVerificaSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(wsVerificaSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getwsVerificaSoap(endpoint);
    }

    public routines.WsVerificaSoap_PortType getwsVerificaSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            routines.WsVerificaSoap_BindingStub _stub = new routines.WsVerificaSoap_BindingStub(portAddress, this);
            _stub.setPortName(getwsVerificaSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setwsVerificaSoapEndpointAddress(java.lang.String address) {
        wsVerificaSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (routines.WsVerificaSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                routines.WsVerificaSoap_BindingStub _stub = new routines.WsVerificaSoap_BindingStub(new java.net.URL(wsVerificaSoap_address), this);
                _stub.setPortName(getwsVerificaSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("wsVerificaSoap".equals(inputPortName)) {
            return getwsVerificaSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "wsVerifica");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "wsVerificaSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("wsVerificaSoap".equals(portName)) {
            setwsVerificaSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
