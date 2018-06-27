package com.example.demo;


import com.example.demo.model.Client;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class SpringRestTest {

    public static final String REST_SERVICE_URI = "http://localhost:63342/my-first-project/client";

    /** POST */
    private static void createClient(){
        System.out.println("Testing create Client API ------");
        RestTemplate restTemplate = new RestTemplate();
        Client client = new Client("Pablo", "Messi", "Tester");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/client/", client, Client.class);
        System.out.println("Location : " + ((URI) uri).toASCIIString());

    }



    /** MAIN */
    public static void main(String[] args){
        createClient();
    }
}
