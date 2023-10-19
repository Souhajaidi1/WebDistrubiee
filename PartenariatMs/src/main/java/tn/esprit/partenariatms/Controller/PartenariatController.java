package tn.esprit.partenariatms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.partenariatms.Entity.Evaluation;
import tn.esprit.partenariatms.Entity.Partenariat;
import tn.esprit.partenariatms.Service.PartenariatService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/partenariats")
public class PartenariatController {

    @Autowired
    private PartenariatService partenariatService;


    @PostMapping("/CreeP")
    public ResponseEntity<?> créerPartenariat(@RequestBody Partenariat partenariat) {
        if (partenariatService.validerPartenariat(partenariat)) {
            Partenariat nouveauPartenariat = partenariatService.créerPartenariat(partenariat);
            return new ResponseEntity<>(nouveauPartenariat, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Le partenariat n'est pas valide", HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/expirés")
    public List<Partenariat> obtenirPartenariatsExpirés() {
        return partenariatService.obtenirPartenariatsExpirés();
    }

    @PostMapping("/SupprimerP/{id}")
    public void supprimerPartenariat(@PathVariable Long id) {
        partenariatService.supprimerPartenariat(id);
    }

    @GetMapping("/GETall")
    public List<Partenariat> obtenirTousLesPartenariats() {
        return partenariatService.obtenirTousLesPartenariats();
    }

    @GetMapping("/{id}")
    public Partenariat obtenirPartenariatParId(@PathVariable Long id) {
        return partenariatService.obtenirPartenariatParId(id);
    }

    @PutMapping("/{id}/promouvoir")
    public void promouvoirPartenariat(@PathVariable Long id) {
        partenariatService.promouvoirPartenariat(id);
    }
    @PostMapping("/partenariats/{partenariatId}/evaluations")
    public Partenariat ajouterEvaluation(@PathVariable Long partenariatId, @RequestBody Evaluation evaluation) {
        return partenariatService.ajouterEvaluation(partenariatId, evaluation.getNote(), evaluation.getCommentaire());
    }

    @GetMapping("/partenariats/{partenariatId}/evaluations")
    public List<Evaluation> obtenirEvaluationsDuPartenariat(@PathVariable Long partenariatId) {
        return partenariatService.obtenirEvaluationsDuPartenariat(partenariatId);
    }

    @GetMapping("/partenariats/{partenariatId}/noteMoyenne")
    public double calculerNoteMoyenneDuPartenariat(@PathVariable Long partenariatId) {
        return partenariatService.calculerNoteMoyenneDuPartenariat(partenariatId);
    }

    @Scheduled(fixedDelay = 1000) // Exécution fréquente pour vérifier les partenariats
    public void verifierPartenariatsExpirés() {
        List<Partenariat> partenariats = partenariatService.obtenirTousLesPartenariats();
        Date dateActuelle = new Date();

        for (Partenariat partenariat : partenariats) {
            if (partenariat.getDateExpiration() != null && partenariat.getDateExpiration().before(dateActuelle)) {
                // La date d'expiration du partenariat est atteinte, supprimez-le
                partenariatService.supprimerPartenariat(partenariat.getId());
            }
        }
    }

}
