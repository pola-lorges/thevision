package com.example.Applixation.repository;

import com.example.Applixation.entities.Observation;
import com.example.Applixation.entities.Procedur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ObservationRepository extends JpaRepository<Observation,Long> {
    List<Observation> findAllByProcedur(Procedur procedur);
}
