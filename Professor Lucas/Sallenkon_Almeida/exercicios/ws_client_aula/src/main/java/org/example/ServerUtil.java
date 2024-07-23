package org.example;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

import static java.sql.DriverManager.getConnection;

public class ServerUtil {
    public Service service = getConnection(){
        Service service = null;
        try {
            URL url = new URL("http://localhost:8085/Calculator?wsdl");
            QName qname = new QName("http://service.webservices.com/", "CalculatorService");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
