package com.wslfinc.server;

import com.wslfinc.ws.SUBDImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Artem on 21.10.2016.
 */
public class Publisher {

    public static void main(String... args) {
        int port = 7777;
        //String address = "http://0.0.0.0:" + port + "/wss/subd";
        //Endpoint.publish(address, new SUBDService());
         Endpoint.publish("http://localhost:1986/wss/hello", new SUBDImpl());
        //System.out.println("Web server running at " + address);
    }
}
