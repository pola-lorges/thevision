package com.example.Applixation.service;

import com.example.Applixation.entities.Observation;
import com.example.Applixation.entities.Procedur;
import com.example.Applixation.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    public List<Observation> ObservationList(){
        return observationRepository.findAll();
    }

    public void save(Observation observation){
        observationRepository.save(observation);
    }

    public Observation getObservation(Long id){
        return observationRepository.findById(id).get();
    }

    public void deleteObservation(Long id){
        observationRepository.deleteById(id);
    }

    public List<Observation> ObservationListProcedur(Procedur procedur){
        return observationRepository.findAllByProcedur(procedur);
    }
}
