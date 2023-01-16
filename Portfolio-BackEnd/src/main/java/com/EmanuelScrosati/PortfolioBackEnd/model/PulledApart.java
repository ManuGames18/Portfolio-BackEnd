
package com.EmanuelScrosati.PortfolioBackEnd.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class PulledApart {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Basic
    private String name;
    public Slot[] slots;

    public PulledApart() {
    }
    
    

    public PulledApart(Long id, String name, Slot[] slots) {
        this.id = id;
        this.name = name;
        this.slots = slots;
    }
}
