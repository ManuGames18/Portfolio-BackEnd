
package com.EmanuelScrosati.PortfolioBackEnd.repository;

import com.EmanuelScrosati.PortfolioBackEnd.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository <Slot, Long>{
    
}
