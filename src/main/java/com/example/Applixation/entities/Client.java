package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Client {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idClient ;
    @Column(name = "nomClient")
    private String nomClient;
    @Column(name= "prenomClient")
    private String prenomClient;
    @Column(name = "emailClient")
    private String emailClient;
    @Column(name = "emailClientThevision")
    private String emailClientThevision;
    @Column(name = "dateCreation")
    private String dateCreation;

    @OneToMany
    private List<Procedur> procedurList;

    public Client() {
    }

    public Client(String nomClient, String prenomClient, String emailClient, String emailClientThevision, String dateCreation, List<Procedur> procedurList) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.emailClientThevision = emailClientThevision;
        this.dateCreation = dateCreation;
        this.procedurList = procedurList;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public List<Procedur> getProcedureList() {
        return procedurList;
    }

    public void setProcedureList(List<Procedur> procedureList) {
        this.procedurList = procedureList;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getNomCient() {
        return nomClient;
    }

    public void setNomCient(String nomCient) {
        this.nomClient = nomCient;
    }


    public String getEmailClient() {
        return emailClient;
    }

    public void setEmailClient(String emailClient) {
        this.emailClient = emailClient;
    }

    public String getEmailClientThevision() {
        return emailClientThevision;
    }

    public void setEmailClientThevision(String emailClientThevision) {
        this.emailClientThevision = emailClientThevision;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}
