
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
public class Slot {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Basic
    private int pulledApartId;
    private String name;
    private String imageUrl;
    private String text;
    private String urlLink;
    
    public Slot(){
        
    }

    public Slot (Long id, int pulledApartId, String name, String imageUrl, String text, String urlLink) {
        this.id = id;
        this.pulledApartId = pulledApartId;
        this.name = name;
        this.imageUrl = imageUrl;
        this.text = text;
        this.urlLink = urlLink;
    }
    
    
}
