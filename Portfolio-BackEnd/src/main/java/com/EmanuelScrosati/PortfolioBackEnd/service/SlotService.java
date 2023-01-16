
package com.EmanuelScrosati.PortfolioBackEnd.service;

import com.EmanuelScrosati.PortfolioBackEnd.model.Slot;
import com.EmanuelScrosati.PortfolioBackEnd.repository.SlotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlotService implements ISlotService{
    
    @Autowired
    public SlotRepository repository;
    
    @Override
    public List<Slot> getSlot() {
        return repository.findAll();
    }

    @Override
    public void createSlot(Slot slot) {
        repository.save(slot);
    }

    @Override
    public void deleteSlot(Long id) {
        repository.deleteById(id);
    }
    
}
