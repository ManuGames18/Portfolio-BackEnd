
package com.EmanuelScrosati.PortfolioBackEnd.service;

import com.EmanuelScrosati.PortfolioBackEnd.model.Slot;
import java.util.List;

public interface ISlotService {
    
    public List<Slot> getSlot();
    public void createSlot(Slot slot);
    public void deleteSlot(Long id);
}
