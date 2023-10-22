package tn.esprit.prestationdeservice.msprestation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.prestationdeservice.msprestation.dto.ServiceOrderDTO;
import tn.esprit.prestationdeservice.msprestation.exceptions.ResourceNotFoundException;
import tn.esprit.prestationdeservice.msprestation.models.ServiceOrder;
import tn.esprit.prestationdeservice.msprestation.models.Status;
import tn.esprit.prestationdeservice.msprestation.repositories.ServiceOrderRepository;
import tn.esprit.prestationdeservice.msprestation.util.EntityDtoUtil;

import java.util.Date;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private NotificationService notificationService;

    public List<ServiceOrder> getAllServiceOrders() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder getServiceOrderById(Long id) {
        return serviceOrderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service Order not found with id " + id));
    }

    public ServiceOrder createServiceOrder(ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder serviceOrder = EntityDtoUtil.convertToEntity(serviceOrderDTO, ServiceOrder.class);
        ServiceOrder createdServiceOrder = serviceOrderRepository.save(serviceOrder);
        notificationService.sendNewServiceOrderNotification(createdServiceOrder);
        return createdServiceOrder;
    }

    public ServiceOrder updateServiceOrder(Long id, ServiceOrderDTO serviceOrderDTO) {
        ServiceOrder existingServiceOrder = getServiceOrderById(id);
        EntityDtoUtil.updateEntity(serviceOrderDTO, existingServiceOrder);
        return serviceOrderRepository.save(existingServiceOrder);
    }

    public void deleteServiceOrder(Long id) {
        ServiceOrder existingServiceOrder = getServiceOrderById(id);
        serviceOrderRepository.delete(existingServiceOrder);
    }

    public List<ServiceOrder> getServiceOrdersByOrderDate(Date orderDate) {
        return serviceOrderRepository.findByOrderDate(orderDate);
    }

    public List<ServiceOrder> getServiceOrdersByStatus(Status status) {
        return serviceOrderRepository.findByStatus(status);
    }


}
