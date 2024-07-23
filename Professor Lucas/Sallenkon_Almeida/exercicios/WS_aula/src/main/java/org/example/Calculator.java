package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Calculator {
    @WebMethod
    public double add(double x, double y);
    @WebMethod
    public double sub(double x, double y);
    @WebMethod
    public double div(double x, double y);
    @WebMethod
    public double multi(double x, double y);
}
