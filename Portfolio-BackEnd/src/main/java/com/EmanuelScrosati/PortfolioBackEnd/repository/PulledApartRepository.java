
package com.EmanuelScrosati.PortfolioBackEnd.repository;

import com.EmanuelScrosati.PortfolioBackEnd.model.PulledApart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PulledApartRepository extends JpaRepository <PulledApart, Long>{
    
}
