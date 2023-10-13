package tn.esprit.msserviceorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.msserviceorder.models.ServiceOrder;

@Service
public class NotificationService {

    @Value("${notification.email.from}")
    private String fromEmail;

    @Autowired
    private EmailService emailService;

    public void sendNewServiceOrderNotification(ServiceOrder serviceOrder) {
        String to = "amine.snoussi@esprit.tn"; // Replace with the recipient's email address
        String subject = "New Service Order Created";
        String text = "A new service order with ID " + serviceOrder.getOrderId() + " has been created.";
        emailService.sendEmail(to, subject, text);
    }
}

