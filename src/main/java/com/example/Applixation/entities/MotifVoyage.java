package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class MotifVoyage {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idMotifVoyage ;
    @Column(name = "nomMotifVoyage")
    private String nomMotifVoyage;

    @OneToMany
    private List<Procedur> procedurMotifVoyageList;

    public MotifVoyage() {
    }

    public MotifVoyage(String nomMotifVoyage, List<Procedur> procedurList) {
        this.nomMotifVoyage = nomMotifVoyage;
        this.procedurMotifVoyageList = procedurList;
    }

    public List<Procedur> getProcedurList() {
        return procedurMotifVoyageList;
    }

    public void setProcedureList(List<Procedur> procedurList) {
        this.procedurMotifVoyageList = procedurList;
    }

    public Long getIdMotifVoyage() {
        return idMotifVoyage;
    }

    public void setIdMotifVoyage(Long idMotifVoyage) {
        this.idMotifVoyage = idMotifVoyage;
    }

    public String getNomMotifVoyage() {
        return nomMotifVoyage;
    }

    public void setNomMotifVoyage(String nomMotifVoyage) {
        this.nomMotifVoyage = nomMotifVoyage;
    }
}
