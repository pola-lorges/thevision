package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class TypeAgent {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idTypeAgent ;
    @Column(name = "nomTypeAgent")
    private String nomTypeAgent;

    @OneToMany
    private List<Agent> agentList;

    public TypeAgent() {
    }

    public TypeAgent(String nomTypeAgent, List<Agent> agentList) {
        this.nomTypeAgent = nomTypeAgent;
        this.agentList = agentList;
    }

    public Long getIdTypeAgent() {
        return idTypeAgent;
    }

    public void setIdTypeAgent(Long idTypeAgent) {
        this.idTypeAgent = idTypeAgent;
    }

    public String getNomTypeAgent() {
        return nomTypeAgent;
    }

    public void setNomTypeAgent(String nomTypeAgent) {
        this.nomTypeAgent = nomTypeAgent;
    }

    public List<Agent> getAgentList() {
        return agentList;
    }

    public void setAgentList(List<Agent> agentList) {
        this.agentList = agentList;
    }
}
