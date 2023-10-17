package com.example.reclamation.controller;

import com.example.reclamation.model.Reclamation;
import com.example.reclamation.service.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
