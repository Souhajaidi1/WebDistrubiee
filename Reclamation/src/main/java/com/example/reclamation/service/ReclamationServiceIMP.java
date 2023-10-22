package com.example.reclamation.service;

import com.example.reclamation.model.Reclamation;
import com.example.reclamation.model.User;
import com.example.reclamation.repository.ReclamationRepository;
import com.example.reclamation.repository.UserRepository;
import jakarta.ws.rs.NotFoundException;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.lang.module.Configuration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;



@Service
public class ReclamationServiceIMP implements ReclamationService{
    @Autowired
    ReclamationRepository reclamationRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;


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
        reclamation.setIdReclamation(idReclamation);
        return reclamationRepository.save(reclamation);
    }


    @Override
    public void deleteReclamation(Long idReclamation) {
        reclamationRepository.deleteById(idReclamation);
    }


    public void sendCouponToReclamer(Long idReclamation) {
        // Find the Reclamation by its ID
        Reclamation reclamation = reclamationRepository.findById(idReclamation)
                .orElseThrow(() -> new NotFoundException("Reclamation not found with id " + idReclamation));

        // Generate a random coupon code
        String couponCode = generateCouponCode();

        // Send the coupon to the user(s) associated with the reclamation by email
        for (User user : reclamation.getUsers()) {
            sendCouponByEmail(user.getEmail(), couponCode);
        }
    }

    private void sendCouponByEmail(String to, String couponCode) {
        String message = "Congratulations, you have received a discount coupon: " + couponCode;
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Discount Coupon");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }

    private String generateCouponCode() {
        // Generate a random 8-character coupon code
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 8;
        Random random = new Random();
        StringBuilder couponCode = new StringBuilder();
        for (int i = 0; i < length; i++) {
            couponCode.append(characters.charAt(random.nextInt(characters.length())));
        }
        return couponCode.toString();
    }

}
