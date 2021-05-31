package com.fissport.blog.service;

import com.fissport.blog.models.Client;
import com.fissport.blog.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void saveClientToDB(String clientName, String email, String number)
    {
        Client client=new Client();
        client.setClientName(clientName);
        client.setEmail(email);
        client.setNumber(number);
        clientRepository.save(client);

    }
}
