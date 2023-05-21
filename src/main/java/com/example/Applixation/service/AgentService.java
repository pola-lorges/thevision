package com.example.Applixation.service;


import com.example.Applixation.entities.Agent;
import com.example.Applixation.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    AgentRepository agentRepository;

    public List<Agent> agentList(){
        return agentRepository.findAll();
    }

    public void save(Agent agent){
        agentRepository.save(agent);
    }

    public Agent getAgent(Long id){
        return agentRepository.findById(id).get();
    }

    public void deleteAgent(Long id){
        agentRepository.deleteById(id);
    }
}
