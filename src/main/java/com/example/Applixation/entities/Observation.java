package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Observation {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idObservation ;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "dateObservation")
    private Date dateObservation;

    @ManyToOne
    private Procedur procedur;

    @ManyToOne
    private Agent agent;

    public Observation() {
    }

    public Observation(String commentaire, Date dateObservation, Procedur procedur, Agent agent) {
        this.commentaire = commentaire;
        this.dateObservation = dateObservation;
        this.procedur = procedur;
        this.agent = agent;
    }

    public Long getIdObservation() {
        return idObservation;
    }

    public void setIdObservation(Long idObservation) {
        this.idObservation = idObservation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateObservation() {
        return dateObservation;
    }

    public void setDateObservation(Date dateObservation) {
        this.dateObservation = dateObservation;
    }

    public Procedur getProcedur() {
        return procedur;
    }

    public void setProcedure(Procedur procedur) {
        this.procedur = procedur;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
