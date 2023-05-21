package com.example.Applixation.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
public class Destination {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idDestination ;
    @Column(name = "nomDestination")
    private String nomDestination;

    @OneToMany
    private List<Procedur> procedureDestinationList;

    public Destination() {
    }

    public Destination(String nomDestination, List<Procedur> procedureList) {
        this.nomDestination = nomDestination;
        this.procedureDestinationList = procedureList;
    }

    public List<Procedur> getProcedureList() {
        return procedureDestinationList;
    }

    public void setProcedureList(List<Procedur> procedureList) {
        this.procedureDestinationList = procedureList;
    }

    public Long getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(Long idDestination) {
        this.idDestination = idDestination;
    }

    public String getNomDestination() {
        return nomDestination;
    }

    public void setNomDestination(String nomDestination) {
        this.nomDestination = nomDestination;
    }


}
