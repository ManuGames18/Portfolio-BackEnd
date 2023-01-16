
package com.EmanuelScrosati.PortfolioBackEnd.service;

import com.EmanuelScrosati.PortfolioBackEnd.model.PulledApart;
import com.EmanuelScrosati.PortfolioBackEnd.repository.PulledApartRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PulledApartService implements IPulledApartService{

    @Autowired
    public PulledApartRepository repository;
    
    @Override
    public List<PulledApart> getPulledAparts() {
        return repository.findAll();
    }

    @Override
    public void createPulledApart(PulledApart pulledApart) {
        repository.save(pulledApart);
    }

    @Override
    public void deletePulledApart(Long id) {
        repository.deleteById(id);
    }
}
