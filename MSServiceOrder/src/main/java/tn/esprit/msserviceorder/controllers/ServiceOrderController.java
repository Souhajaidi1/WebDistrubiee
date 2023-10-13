package tn.esprit.msserviceorder.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.msserviceorder.dto.ServiceOrderDTO;
import tn.esprit.msserviceorder.models.ServiceOrder;
import tn.esprit.msserviceorder.models.Status;
import tn.esprit.msserviceorder.services.EmailService;
import tn.esprit.msserviceorder.services.NotificationService;
import tn.esprit.msserviceorder.services.ServiceOrderService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private NotificationService notificationService;



    @GetMapping("/list-serviceorder")
    public List<ServiceOrder> getAllServiceOrders() {
        return serviceOrderService.getAllServiceOrders();
    }

    @GetMapping("/OneService/{id}")
    public ServiceOrder getServiceOrderById(@PathVariable Long id) {
        return serviceOrderService.getServiceOrderById(id);
    }

    @PostMapping("/send-test-email")
    public ResponseEntity<String> sendTestEmail() {
        try {
            emailService.sendEmail("amine.snoussi@esprit.tn", "Notification API", "Messaged Successfully!");
            return ResponseEntity.ok("Test email sent successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send test email: " + e.getMessage());
        }
    }


    @PostMapping("/add-serviceorder")
    public ResponseEntity<ServiceOrder> createServiceOrder(@Valid @RequestBody ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder createdServiceOrder = serviceOrderService.createServiceOrder(serviceOrderDTO);
        notificationService.sendNewServiceOrderNotification(createdServiceOrder);
        return new ResponseEntity<>(createdServiceOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update-serviceorder/{id}")
    public ServiceOrder updateServiceOrder(@PathVariable Long id, @Valid @RequestBody ServiceOrderDTO serviceOrderDTO) {
        return serviceOrderService.updateServiceOrder(id, serviceOrderDTO);
    }

    @DeleteMapping("/delete-serviceorder/{id}")
    public ResponseEntity<Void> deleteServiceOrder(@PathVariable Long id) {
        serviceOrderService.deleteServiceOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ServiceOrdersByOrderDate")
    public List<ServiceOrder> getServiceOrdersByOrderDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date orderDate) {
        return serviceOrderService.getServiceOrdersByOrderDate(orderDate);
    }

    @GetMapping("/ServiceOrdersByStatus")
    public List<ServiceOrder> getServiceOrdersByStatus(@RequestParam Status status) {
        return serviceOrderService.getServiceOrdersByStatus(status);
    }


}
