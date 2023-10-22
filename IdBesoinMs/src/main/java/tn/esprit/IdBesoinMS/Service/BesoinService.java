package tn.esprit.IdBesoinMS.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.esprit.IdBesoinMS.Entity.Besoin;
import tn.esprit.IdBesoinMS.Exception.BesoinUpdateException;
import tn.esprit.IdBesoinMS.Repository.BesoinRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BesoinService {
    @Autowired
    private BesoinRepository besoinRepository; // Injectez le repository pour accéder aux besoins en base de données

    public List<Besoin> getAllBesoins() {
        return besoinRepository.findAll();
    }

    public Besoin createBesoin(Besoin besoin) {
        // Implémentez la logique pour créer un besoin
        besoin.setDateSoumission(new Date());
        besoin.setStatut(Besoin.Statut.EN_ATTENTE);
        return besoinRepository.save(besoin);
    }
    public Besoin getBesoinById(Long id) {
        Optional<Besoin> besoin = besoinRepository.findById(id);
        if (((Optional<?>) besoin).isPresent()) {
            return besoin.get(); // Retourne le Besoin si trouvé
        } else {
            return null ;
        }
    }

    public Besoin updateBesoin(Long id, Besoin besoin) {
        // Recherchez d'abord le besoin existant par son ID
        Optional<Besoin> existingBesoin = besoinRepository.findById(id);

        if (existingBesoin.isPresent()) {
            Besoin savedBesoin = existingBesoin.get();
            // Mettez à jour les propriétés du besoin existant avec les nouvelles valeurs fournies
            savedBesoin.setDescription(besoin.getDescription());
            savedBesoin.setStatut(besoin.getStatut());

            // Enregistrez la mise à jour dans la base de données en utilisant le référentiel
            besoinRepository.save(savedBesoin);

            return savedBesoin; // Renvoie le besoin mis à jour
        } else {
            throw new BesoinUpdateException("le besoin est modifier  : " + id);
        }}

        public String getDashboardData () {
            List<Besoin> besoins = new ArrayList<>();

            // Utilisez les valeurs de l'énumération pour compter les besoins par statut
            int enAttenteCount = besoinRepository.countByStatut(Besoin.Statut.EN_ATTENTE);
            int approuveCount = besoinRepository.countByStatut(Besoin.Statut.APPROUVE);
            int rejeteCount = besoinRepository.countByStatut(Besoin.Statut.REJETE);

            String dashboardInfo = "Liste des besoins en attente : " + enAttenteCount + "\n" +
                    "Liste des besoins Approuvés : " + approuveCount + "\n" +
                    "Liste des besoins rejetés : " + rejeteCount;

            return dashboardInfo;

        }

    public List<Besoin> searchBesoins(String motCle) {
        if (motCle != null && !motCle.isEmpty()) {
            // Vous pouvez utiliser une méthode de recherche globale sur tous les attributs.
            return besoinRepository.findBesoinsByMotCle(motCle);
        } else {
            // Si le mot-clé n'est pas spécifié, retournez tous les besoins.
            return besoinRepository.findAll();
        }
    }
    public void deleteBesoin(Long id) {
        besoinRepository.deleteById(id);
    }
    public Page<Besoin> getBesoinsPaged(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("dateSoumission").descending());
        return besoinRepository.findAll(pageable);
    }
}
