package tn.esprit.IdBesoinMS.Controller;


import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.IdBesoinMS.Exception.BesoinUpdateException;
import tn.esprit.IdBesoinMS.Entity.Besoin;
import tn.esprit.IdBesoinMS.Service.BesoinService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Besoin")
public class BesoinController {

  @Autowired
    BesoinService besoinService;

    @GetMapping("/all")
    public List<Besoin> getBesoins() {
        return besoinService.getAllBesoins();
    }

    @GetMapping("/{id}")
    public Besoin getBesoin(@PathVariable Long id) {
        return besoinService.getBesoinById(id);
    }

    @PostMapping("/createB")
    public Besoin createBesoin(@RequestBody Besoin besoin) {
        return besoinService.createBesoin(besoin);
    }

    @PutMapping("/{id}")
    public Besoin updateBesoin(@PathVariable Long id, @RequestBody Besoin besoin) {
        return besoinService.updateBesoin(id, besoin);
    }

    @DeleteMapping("/{id}")
    public void deleteBesoin(@PathVariable Long id) {
        besoinService.deleteBesoin(id);
    }

    @ExceptionHandler(BesoinUpdateException.class)
    public ResponseEntity<String> handleBesoinUpdateException(BesoinUpdateException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/data")
    public String getDashboardData() {
        return besoinService.getDashboardData();
    }
    @GetMapping("/searchbesoins")
    public List<Besoin> searchBesoins(
            @RequestParam(name = "motCle", required = false) String motCle) {
        // Appelez la méthode du service pour effectuer la recherche
        return besoinService.searchBesoins( motCle);
    }
    @GetMapping("/paged")
    public ResponseEntity<Page<Besoin>> getBesoinsPaged(@RequestParam int page, @RequestParam int size) {
        Page<Besoin> besoins = besoinService.getBesoinsPaged(page, size);
        return new ResponseEntity<>(besoins, HttpStatus.OK);
    }
}
