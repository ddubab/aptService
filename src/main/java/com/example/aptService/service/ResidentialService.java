package com.example.aptService.service;

import com.example.aptService.domain.Residential;
import com.example.aptService.repository.ResidentialRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResidentialService {
    private final ResidentialRepository residentialRepository;

    @Transactional
    public void saveAllItems(List<Residential> items) {
        residentialRepository.saveAll(items); // JPA가 내부적으로 Batch Insert 수행
    }

    @Transactional
    public void saveItem(Residential item) {
        residentialRepository.save(item);
    }


}
