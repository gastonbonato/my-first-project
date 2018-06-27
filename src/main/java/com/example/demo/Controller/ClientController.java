package com.example.demo.Controller;

import com.example.demo.model.Client;
import com.example.demo.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ClientController {

    @Autowired
    private Service<Client> clientService; ////Service which will do all data retrieval/manipulation work


    //-------Create Client  -----------------
    @RequestMapping(value = "/client/" , method = RequestMethod.POST)
    public ResponseEntity<Void> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder){
        System.out.println("Creating Client " + client.getName());

        clientService.create(client);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------Retrieve Single  ---------------
    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") int id){
        System.out.println("Fletching Client with id " + id);
        Client client = clientService.read(id);
        if (client == null){
            System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    //--------Update Client ------------------
    @RequestMapping(value = "/client/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") int id, @RequestBody Client client){
        System.out.println("Updating Client " + id);

        Client currentClient = clientService.read(id);

         if(currentClient == null){
             System.out.println("Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
         }

        currentClient.setName(client.getName());
        currentClient.setLastName(client.getLastName());
        currentClient.setDescription(client.getDescription());

        clientService.update(currentClient);
        return new ResponseEntity<Client>(currentClient, HttpStatus.OK);

    }

    //--------Delete User------------------------
    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id") int id){
        System.out.println("Fletching & Deleting Client with id " + id);

        Client client = clientService.read(id);
        if(client == null){
            System.out.println("Unable to delete Client with id " + id + " not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        clientService.delete(id);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }
}
