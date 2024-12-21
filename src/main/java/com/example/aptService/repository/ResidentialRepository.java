package com.example.aptService.repository;

import com.example.aptService.domain.Residential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResidentialRepository extends JpaRepository<Residential, Long> {
    List<Residential> findAllByResidentialIdIn(List<Long> residentialIds);

    Residential save(Residential residential);


}
