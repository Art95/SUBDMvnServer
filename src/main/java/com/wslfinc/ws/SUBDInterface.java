package com.wslfinc.ws;

/**
 * Created by Artem on 15.10.2016.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface SUBDInterface {
    @WebMethod
    void createDataBase(String name);

    @WebMethod
    void dropDataBase(String name);

    @WebMethod
    void saveDataBase(String name, String data);

    @WebMethod
    String getDataBaseData(String name);

    @WebMethod
    String[] getDataBasesNames();
}
