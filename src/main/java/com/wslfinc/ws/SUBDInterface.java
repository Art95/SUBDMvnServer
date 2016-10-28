package com.wslfinc.ws;

/**
 * Created by Artem on 15.10.2016.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.rmi.Remote;
import java.rmi.RemoteException;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SUBDInterface extends Remote{
    @WebMethod
    void createDataBase(String name) throws RemoteException;

    @WebMethod
    void dropDataBase(String name) throws RemoteException;

    @WebMethod
    void saveDataBase(String name, String data) throws RemoteException;

    @WebMethod
    String getDataBaseData(String name) throws RemoteException;

    @WebMethod
    String[] getDataBasesNames() throws RemoteException;
}
