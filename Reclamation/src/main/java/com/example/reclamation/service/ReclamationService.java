package com.example.reclamation.service;

import com.example.reclamation.model.Reclamation;

import java.util.List;

public interface ReclamationService {
    Reclamation createReclamation(Reclamation reclamation);

    Reclamation getReclamationById(Long idReclamation);

    List<Reclamation> getAllReclamation();

    Reclamation updateReclamation(Long idReclamation, Reclamation reclamation);

    void deleteReclamation(Long idReclamation);


    void sendCouponToReclamer(Long id);
}
