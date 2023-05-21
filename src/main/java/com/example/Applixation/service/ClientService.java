package com.example.Applixation.service;

import com.example.Applixation.entities.Client;
import com.example.Applixation.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> clientList(){
        return clientRepository.findAll();
    }

    public void save(Client client){
        clientRepository.save(client);
    }

    public Client getClient(Long id){
        return clientRepository.findById(id).get();
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
}
