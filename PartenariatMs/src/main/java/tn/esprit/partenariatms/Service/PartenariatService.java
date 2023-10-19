package tn.esprit.partenariatms.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.partenariatms.Entity.Evaluation;
import tn.esprit.partenariatms.Entity.Partenariat;
import tn.esprit.partenariatms.Repository.EvaluationRepository;
import tn.esprit.partenariatms.Repository.PatrenariatRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartenariatService {
   @Autowired
   private PatrenariatRepository partenariatRepository ;
   @Autowired
   private EvaluationRepository evaluationRepository ;


    public Partenariat créerPartenariat(Partenariat partenariat) {
        return partenariatRepository.save(partenariat);
    }
    public boolean validerPartenariat(Partenariat partenariat) {
        // Récupérer la liste des partenariats existants
        List<Partenariat> partenariatsExistants = partenariatRepository.findAll();

        // Vérifier si le nom du partenariat est déjà utilisé
        for (Partenariat existingPartenariat : partenariatsExistants) {
            if (existingPartenariat.getNom().equals(partenariat.getNom())) {
                // Le nom du partenariat n'est pas unique, donc la validation échoue
                return false;
            }
        }

        // Le nom du partenariat est unique, la validation réussit
        return true;
    }

    public void nettoyerPartenariatsExpirés() {
        // Récupérer la date actuelle
        Date dateActuelle = new Date();

        // Calculer la date il y a une semaine
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateActuelle);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date dateUneSemaineAvant = calendar.getTime();

        // Récupérer les partenariats expirés avant une semaine
        List<Partenariat> partenariatsExpirés = partenariatRepository.obtenirPartenariatsExpirés();

        // Supprimer les partenariats expirés avant une semaine
        for (Partenariat partenariat : partenariatsExpirés) {
            if (partenariat.getDateExpiration().before(dateUneSemaineAvant)) {
                supprimerPartenariat(partenariat.getId());
            }
        }
    }
    public void supprimerPartenariat(Long id) {
        partenariatRepository.deleteById(id);
    }

    public List<Partenariat> obtenirPartenariatsExpirés() {
        // Récupérer la date actuelle
        Date dateActuelle = new Date();

        // Récupérer tous les partenariats depuis la base de données
        List<Partenariat> tousLesPartenariats = partenariatRepository.findAll();

        // Filtrer les partenariats expirés
        List<Partenariat> partenariatsExpirés = tousLesPartenariats.stream()
                .filter(partenariat -> partenariat.getDateExpiration() != null && partenariat.getDateExpiration().before(dateActuelle))
                .collect(Collectors.toList());

        return partenariatsExpirés;
    }


    public List<Partenariat> obtenirTousLesPartenariats() {
        return partenariatRepository.findAll();
    }

    public Partenariat obtenirPartenariatParId(Long id) {
        return partenariatRepository.findById(id).orElse(null);
    }

    public void promouvoirPartenariat(Long id) {
        Partenariat partenariat = partenariatRepository.findById(id).orElse(null);
        if (partenariat != null) {
            partenariat.setActif(true);
            partenariatRepository.save(partenariat);
        }
    }

    public Partenariat ajouterEvaluation(Long partenariatId, int note, String commentaire) {
        Partenariat partenariat = obtenirPartenariatParId(partenariatId);
        if (partenariat != null) {
            Evaluation evaluation = new Evaluation();
            evaluation.setPartenariatId(partenariatId);
            evaluation.setNote(note);
            evaluation.setCommentaire(commentaire);

            if (partenariat.getEvaluations() == null) {
                partenariat.setEvaluations(new ArrayList<>());
            }
            partenariat.getEvaluations().add(evaluation);

            partenariatRepository.save(partenariat);
        }
        return partenariat;
    }

    public List<Evaluation> obtenirEvaluationsDuPartenariat(Long partenariatId) {
        Partenariat partenariat = obtenirPartenariatParId(partenariatId);
        if (partenariat != null && partenariat.getEvaluations() != null) {
            return partenariat.getEvaluations();
        }
        return new ArrayList<>();
    }

    public double calculerNoteMoyenneDuPartenariat(Long partenariatId) {
        List<Evaluation> evaluations = obtenirEvaluationsDuPartenariat(partenariatId);
        if (evaluations.isEmpty()) {
            return 0.0; // Aucune évaluation
        }
        double sommeDesNotes = evaluations.stream().mapToDouble(Evaluation::getNote).sum();
        return sommeDesNotes / evaluations.size();
    }




}