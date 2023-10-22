package tn.esprit.prestationdeservice.msprestation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tn.esprit.prestationdeservice.msprestation.models.PrestationDeService;
import tn.esprit.prestationdeservice.msprestation.repositories.PrestationDeServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PrestationService {

    @Autowired
    private PrestationDeServiceRepository prestationDeServiceRepository;


    public List<PrestationDeService> getAllPrestations() {
        return prestationDeServiceRepository.findAll();
    }

    public Optional<PrestationDeService> getPrestationById(Long id) {
        return prestationDeServiceRepository.findById(id);
    }

    public PrestationDeService createPrestation(PrestationDeService prestation) {
        return prestationDeServiceRepository.save(prestation);
    }

    public PrestationDeService updatePrestation(Long id, PrestationDeService updatedPrestation) {
        Optional<PrestationDeService> existingPrestation = prestationDeServiceRepository.findById(id);
        if (existingPrestation.isPresent()) {
            PrestationDeService prestation = existingPrestation.get();
            prestation.setType(updatedPrestation.getType());
            prestation.setDescription(updatedPrestation.getDescription());
            prestation.setTarification(updatedPrestation.getTarification());
            return prestationDeServiceRepository.save(prestation);
        }
        return null;
    }

    public void deletePrestation(Long id) {
        prestationDeServiceRepository.deleteById(id);
    }

    public List<PrestationDeService> searchPrestations(String type, Double minTarification, Double maxTarification) {
        // Implement your search logic here
        // You can use the repository to query the database

        if (type != null && minTarification != null && maxTarification != null) {
            // Search by type and tarification range
            return prestationDeServiceRepository.findByTypeAndTarificationBetween(type, minTarification, maxTarification);
        } else if (type != null && minTarification != null) {
            // Search by type and minimum tarification
            return prestationDeServiceRepository.findByTypeAndTarificationGreaterThanEqual(type, minTarification);
        } else if (type != null && maxTarification != null) {
            // Search by type and maximum tarification
            return prestationDeServiceRepository.findByTypeAndTarificationLessThanEqual(type, maxTarification);
        } else if (type != null) {
            // Search by type only
            return prestationDeServiceRepository.findByType(type);
        } else if (minTarification != null && maxTarification != null) {
            // Search by tarification range only
            return prestationDeServiceRepository.findByTarificationBetween(minTarification, maxTarification);
        } else if (minTarification != null) {
            // Search by minimum tarification only
            return prestationDeServiceRepository.findByTarificationGreaterThanEqual(minTarification);
        } else if (maxTarification != null) {
            // Search by maximum tarification only
            return prestationDeServiceRepository.findByTarificationLessThanEqual(maxTarification);
        } else if (type != null) {
            // Search by type only
            return prestationDeServiceRepository.findByTypeContaining(type); // Modify this line
        } else {
            // No search parameters provided, return all prestations
            return prestationDeServiceRepository.findAll();
        }
    }

    public Page<PrestationDeService> getPagedPrestations(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize); // Page numbers are 0-based
        return prestationDeServiceRepository.findAll(pageable);
    }
}
