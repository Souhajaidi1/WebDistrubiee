package com.example.reclamation.controller;

import com.example.reclamation.model.Reclamation;
import com.example.reclamation.service.ReclamationService;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reclamation")
public class ReclamationController {
    @Autowired
    ReclamationService reclamationService;
    @PostMapping
    public Reclamation createReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.createReclamation(reclamation);
    }
    @GetMapping("/{idReclamation}")
    public Reclamation getReclamationById(@PathVariable Long idReclamation){
        return reclamationService.getReclamationById(idReclamation);
    }
    @GetMapping
    public List<Reclamation> getAllReclamation(){
        return reclamationService.getAllReclamation();
    }
    @PutMapping("/{idReclamation}")
    public Reclamation updateReclamation (@PathVariable Long idReclamation,
                                          @RequestBody Reclamation reclamation){
        return reclamationService.updateReclamation(idReclamation,reclamation);
    }
    @DeleteMapping("/{idReclamation}")
    public void deleteReclamation(@PathVariable Long idReclamation) {
        reclamationService.deleteReclamation(idReclamation);
    }
    @PostMapping("/sendCoupon/{idReclamation}")
    public ResponseEntity<Object> sendCouponByEmail(@PathVariable Long idReclamation) {
        try {
            reclamationService.sendCouponToReclamer(idReclamation);
        }
        catch(NotFoundException e) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok("Coupon sent successfully");
    }
}
