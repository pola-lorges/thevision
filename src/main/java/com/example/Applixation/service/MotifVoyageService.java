package com.example.Applixation.service;

import com.example.Applixation.entities.MotifVoyage;
import com.example.Applixation.repository.MotifVoyageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotifVoyageService {
    @Autowired
    MotifVoyageRepository motifVoyageRepository;

    public List<MotifVoyage> motifVoyageList(){
        return motifVoyageRepository.findAll();
    }

    public void save(MotifVoyage motifVoyage){
        motifVoyageRepository.save(motifVoyage);
    }

    public MotifVoyage getMotifVoyage(Long id){
        return motifVoyageRepository.findById(id).get();
    }

    public void deleteMotifVoyage(Long id){
        motifVoyageRepository.deleteById(id);
    }
}
