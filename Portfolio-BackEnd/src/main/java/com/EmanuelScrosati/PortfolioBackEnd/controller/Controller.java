
package com.EmanuelScrosati.PortfolioBackEnd.controller;

import com.EmanuelScrosati.PortfolioBackEnd.model.PulledApart;
import com.EmanuelScrosati.PortfolioBackEnd.model.Slot;
import com.EmanuelScrosati.PortfolioBackEnd.service.IPulledApartService;
import com.EmanuelScrosati.PortfolioBackEnd.service.ISlotService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @Autowired
    private IPulledApartService pulledApartService;
    
    @Autowired
    private ISlotService slotService;
    
    @GetMapping
    @ResponseBody
    public List<PulledApart> getPulledAparts(){
        List<PulledApart> pulledAparts =  pulledApartService.getPulledAparts();
        List<Slot> slots = slotService.getSlot();   
        
        for (int i = 0; i < slots.size(); i++) {
            int pulledApartId = slots.get(i).getPulledApartId();
            
            int pulledApartIndex = getIndexById(pulledAparts, pulledApartId);
            if (pulledApartIndex == -1){
                deleteSlot(slots.get(i).getId());
            }else{
                pulledAparts.get(pulledApartIndex).slots = addSlot(pulledAparts.get(pulledApartIndex).slots, slots.get(i));   
            }
        }
        
        return pulledAparts;
    }
    
    
    private int getIndexById(List<PulledApart> pulledAparts, int pulledApartId) {
        int index = -1;
        for (int i = 0; i < pulledAparts.size(); i++){
            if (pulledAparts.get(i).getId() == pulledApartId){
                index = i;
                break;
            }
        }
        return index;
    }
    
    private Slot[] addSlot(Slot[] slots, Slot slot){
        Slot[] newSlots = new Slot[slots.length+1];
        
        for (int i = 0; i < slots.length; i++) {
            newSlots[i] = slots[i];
        }
        
        newSlots[newSlots.length-1] = slot;
        return newSlots;
    }
    
    @PostMapping("/create/pulled-apart")
    public void createPulledApart(@RequestBody PulledApart pulledApart){
        pulledApartService.createPulledApart(pulledApart);
    }
    
    @PostMapping("/create/slot")
    public void createSlot(@RequestBody Slot slot){
        slotService.createSlot(slot);
    }
    
    @DeleteMapping("/delete/pulled-apart/{id}")
    public void deletePulledApart(@PathVariable Long id){
        pulledApartService.deletePulledApart(id);
        
        List<Slot> slots = slotService.getSlot();   
        for (int i=0;i<slots.size();i++){
            if (slots.get(i).getPulledApartId() == id) deleteSlot(slots.get(i).getId());
        }
    }
    
    @DeleteMapping("/delete/slot/{id}")
    public void deleteSlot(@PathVariable Long id){
        slotService.deleteSlot(id);
    }

    
}
