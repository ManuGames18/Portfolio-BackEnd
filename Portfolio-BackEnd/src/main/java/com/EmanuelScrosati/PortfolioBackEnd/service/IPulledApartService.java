
package com.EmanuelScrosati.PortfolioBackEnd.service;

import com.EmanuelScrosati.PortfolioBackEnd.model.PulledApart;
import java.util.List;

public interface IPulledApartService {
    
    public List<PulledApart> getPulledAparts();
    public void createPulledApart(PulledApart pulledApart);
    public void deletePulledApart(Long id);
}
