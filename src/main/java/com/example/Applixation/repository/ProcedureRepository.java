package com.example.Applixation.repository;

import com.example.Applixation.entities.Client;
import com.example.Applixation.entities.Procedur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcedureRepository extends JpaRepository<Procedur, Long> {

    List<Procedur> findAllByClient(Long id);

    List<Procedur>findProcedursByClient(Client client);

}
