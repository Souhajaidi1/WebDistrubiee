package com.example.reclamation.service;

import com.example.reclamation.model.Reclamation;
import com.example.reclamation.repository.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReclamationServiceIMP implements ReclamationService{
    @Autowired
    ReclamationRepository reclamationRepository;
    @Override
    public Reclamation createReclamation(Reclamation reclamation){
        return reclamationRepository.save(reclamation);
    }
    @Override
    public Reclamation getReclamationById(Long idReclamation) {
        Optional<Reclamation> optionalAnalytics = reclamationRepository.findById(idReclamation);
        return optionalAnalytics.orElse(null);
    }

    @Override
    public List<Reclamation> getAllReclamation() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation updateReclamation(Long idReclamation, Reclamation reclamation) {
        if (reclamationRepository.existsById(idReclamation)) {
            reclamation.setId(idReclamation);
            return reclamationRepository.save(reclamation);
        }
        return null;
    }

    @Override
    public void deleteReclamation(Long idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }

}
