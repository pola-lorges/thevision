package com.example.Applixation.service;


import com.example.Applixation.entities.TypeAgent;
import com.example.Applixation.repository.TypeAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeAgentService {


    @Autowired
    TypeAgentRepository typeAgentRepository;

    public List<TypeAgent> TypeAgentList(){
        return typeAgentRepository.findAll();
    }

    public void save(TypeAgent typeAgent){
        typeAgentRepository.save(typeAgent);
    }

    public TypeAgent getTypeAgent(Long id){
        return typeAgentRepository.findById(id).get();
    }

    public void deleteTypeAgent(Long id){
        typeAgentRepository.deleteById(id);
    }

}
