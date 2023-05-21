package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Agent {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idAgent ;
    @Column(name = "nomAgent")
    private String nomAgent;
    @Column(name = "mdpAgent")
    private String mdpAgent;

    @ManyToOne
    private TypeAgent typeAgent;

    @OneToMany
    private List<Procedur> procedureAgentList;

    @OneToMany
    private List<Observation> observations;

    public Agent() {
    }

    public Agent(String nomAgent, String mdpAgent, TypeAgent typeAgent, List<Procedur> procedureList, List<Observation> observations) {
        this.nomAgent = nomAgent;
        this.mdpAgent = mdpAgent;
        this.typeAgent = typeAgent;
        this.procedureAgentList = procedureList;
        this.observations = observations;
    }

    public List<Procedur> getProcedureList() {
        return procedureAgentList;
    }

    public void setProcedureList(List<Procedur> procedureList) {
        this.procedureAgentList = procedureList;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public Long getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Long idAgent) {
        this.idAgent = idAgent;
    }

    public String getNomAgent() {
        return nomAgent;
    }

    public void setNomAgent(String nomAgent) {
        this.nomAgent = nomAgent;
    }

    public String getMdpAgent() {
        return mdpAgent;
    }

    public void setMdpAgent(String mdpAgent) {
        this.mdpAgent = mdpAgent;
    }

    public TypeAgent getTypeAgent() {
        return typeAgent;
    }

    public void setTypeAgent(TypeAgent typeAgent) {
        this.typeAgent = typeAgent;
    }
}
