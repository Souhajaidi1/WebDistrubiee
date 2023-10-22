package tn.esprit.prestationdeservice.msprestation.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.prestationdeservice.msprestation.models.PrestationDeService;
import tn.esprit.prestationdeservice.msprestation.services.PrestationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestations")
public class PrestationDeServiceController {

    @Autowired
    private PrestationService prestationService;

    @GetMapping("/AllPrestations")
    public List<PrestationDeService> getAllPrestations() {
        return prestationService.getAllPrestations();
    }

    @GetMapping("/AllPrestationsPagination")
    public Page<PrestationDeService> getAllPrestations(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "2") int pageSize) {
        return prestationService.getPagedPrestations(page, pageSize);
    }

    @GetMapping("/one-prestation/{id}")
    public ResponseEntity<PrestationDeService> getPrestationById(@PathVariable Long id) {
        Optional<PrestationDeService> prestation = prestationService.getPrestationById(id);
        return prestation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add-prestation")
    public ResponseEntity<PrestationDeService> createPrestation(@RequestBody PrestationDeService prestation) {
        PrestationDeService createdPrestation = prestationService.createPrestation(prestation);
        return new ResponseEntity<>(createdPrestation, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PrestationDeService> updatePrestation(@PathVariable Long id,
                                                                @RequestBody PrestationDeService updatedPrestation) {
        PrestationDeService updated = prestationService.updatePrestation(id, updatedPrestation);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrestation(@PathVariable Long id) {
        prestationService.deletePrestation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<PrestationDeService> searchPrestations(
            @RequestParam(name = "type", required = false) String type,
            @RequestParam(name = "minTarification", required = false) Double minTarification,
            @RequestParam(name = "maxTarification", required = false) Double maxTarification) {
        return prestationService.searchPrestations(type, minTarification, maxTarification);
    }


}
