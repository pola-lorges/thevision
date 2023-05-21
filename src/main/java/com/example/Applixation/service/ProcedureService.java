package com.example.Applixation.service;



import com.example.Applixation.entities.Client;
import com.example.Applixation.entities.Procedur;
import com.example.Applixation.repository.ProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureService {

    @Autowired
    ProcedureRepository procedureRepository;

    public List<Procedur> ProcedureList(){
        return procedureRepository.findAll();
    }

    public void save(Procedur procedure){
        procedureRepository.save(procedure);
    }

    public Procedur getProcedure(Long id){
        return procedureRepository.findById(id).get();
    }

    public void deleteProcedure(Long id){
        procedureRepository.deleteById(id);
    }

    public List<Procedur> ProcedureListClient(Long id){
        return procedureRepository.findAllByClient(id);
    }

    public List<Procedur> ProcedureListClientC(Client client){
       // return procedureRepository.findProcedursByClient(client);
        return null;
    }
}
