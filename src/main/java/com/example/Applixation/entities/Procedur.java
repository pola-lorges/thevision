package com.example.Applixation.entities;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
public class Procedur {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idProcedur ;
    @Column(name = "etatProcedur")
    private String etatProcedur;
    @Column(name = "dateOuvertur")
    private Date dateOuverture;

    @ManyToOne
    private Client client;

    @ManyToOne
    private MotifVoyage motifVoyage;

    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Destination destination;

    @OneToMany
    private List<Observation> observationList;

    public Procedur() {
    }

    public Procedur(String etatProcedur, Date dateOuverture, Client client, MotifVoyage motifVoyage, Agent agent, Destination destination) {
        this.etatProcedur = etatProcedur;
        this.dateOuverture = dateOuverture;
        this.client = client;
        this.motifVoyage = motifVoyage;
        this.agent = agent;
        this.destination = destination;
    }

    public Long getIdProcedur() {
        return idProcedur;
    }

    public void setIdProcedur(Long idProcedur) {
        this.idProcedur = idProcedur;
    }

    public String getEtatProcedur() {
        return etatProcedur;
    }

    public void setEtatProcedur(String etatProcedur) {
        this.etatProcedur = etatProcedur;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MotifVoyage getMotifVoyage() {
        return motifVoyage;
    }

    public void setMotifVoyage(MotifVoyage motifVoyage) {
        this.motifVoyage = motifVoyage;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<Observation> getObservationList() {
        return observationList;
    }

    public void setObservationList(List<Observation> observationList) {
        this.observationList = observationList;
    }


}
