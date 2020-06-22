package org.tempuri;

public class IUserServiceProxy implements org.tempuri.IUserService_PortType {
  private String _endpoint = null;
  private org.tempuri.IUserService_PortType iUserService_PortType = null;
  
  public IUserServiceProxy() {
    _initIUserServiceProxy();
  }
  
  public IUserServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initIUserServiceProxy();
  }
  
  private void _initIUserServiceProxy() {
    try {
      iUserService_PortType = (new org.tempuri.IUserService_ServiceLocator()).getBasicHttpBinding();
      if (iUserService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iUserService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iUserService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iUserService_PortType != null)
      ((javax.xml.rpc.Stub)iUserService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.IUserService_PortType getIUserService_PortType() {
    if (iUserService_PortType == null)
      _initIUserServiceProxy();
    return iUserService_PortType;
  }
  
  public org.datacontract.schemas._2004._07.ApplicationServices_Entities.UserInfo getUser(java.lang.String name) throws java.rmi.RemoteException{
    if (iUserService_PortType == null)
      _initIUserServiceProxy();
    return iUserService_PortType.getUser(name);
  }
  
  
}