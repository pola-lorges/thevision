package com.example.Applixation.service;


import com.example.Applixation.entities.Destination;
import com.example.Applixation.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    public List<Destination> destinationList(){
        return destinationRepository.findAll();
    }

    public void save(Destination destination){
        destinationRepository.save(destination);
    }

    public Destination getDestination(Long id){
        return destinationRepository.findById(id).get();
    }

    public void deleteDestination(Long id){
        destinationRepository.deleteById(id);
    }
}
