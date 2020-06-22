/**
 * IUserService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class IUserService_ServiceLocator extends org.apache.axis.client.Service implements org.tempuri.IUserService_Service {

    public IUserService_ServiceLocator() {
    }


    public IUserService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IUserService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding
    private java.lang.String BasicHttpBinding_address = "http://192.168.1.60/WebSite/integration/user";

    public java.lang.String getBasicHttpBindingAddress() {
        return BasicHttpBinding_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBindingWSDDServiceName = "BasicHttpBinding";

    public java.lang.String getBasicHttpBindingWSDDServiceName() {
        return BasicHttpBindingWSDDServiceName;
    }

    public void setBasicHttpBindingWSDDServiceName(java.lang.String name) {
        BasicHttpBindingWSDDServiceName = name;
    }

    public org.tempuri.IUserService_PortType getBasicHttpBinding() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding(endpoint);
    }

    public org.tempuri.IUserService_PortType getBasicHttpBinding(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.BasicHttpBindingStub _stub = new org.tempuri.BasicHttpBindingStub(portAddress, this);
            _stub.setPortName(getBasicHttpBindingWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBindingEndpointAddress(java.lang.String address) {
        BasicHttpBinding_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.IUserService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.BasicHttpBindingStub _stub = new org.tempuri.BasicHttpBindingStub(new java.net.URL(BasicHttpBinding_address), this);
                _stub.setPortName(getBasicHttpBindingWSDDServiceName());
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
        if ("BasicHttpBinding".equals(inputPortName)) {
            return getBasicHttpBinding();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "IUserService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding".equals(portName)) {
            setBasicHttpBindingEndpointAddress(address);
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
