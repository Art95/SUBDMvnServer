package com.wslfinc.server;

import com.wslfinc.ws.SUBDImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Artem on 21.10.2016.
 */
public class Publisher {

    public static void main(String... args) {
        int port = 7777;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        String address = "http://0.0.0.0:" + port + "/subd";
        Endpoint.publish(address, new SUBDImpl());
         //Endpoint.publish("http://localhost:1986/wss/hello", new SUBDImpl());
        System.out.println("Web server running at " + address + "?wsdl");
    }
}
