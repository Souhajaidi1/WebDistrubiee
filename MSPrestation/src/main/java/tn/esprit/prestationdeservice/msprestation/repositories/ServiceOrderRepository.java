package tn.esprit.prestationdeservice.msprestation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.prestationdeservice.msprestation.models.ServiceOrder;
import tn.esprit.prestationdeservice.msprestation.models.Status;

import java.util.Date;
import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> findByOrderDate(Date orderDate);
    List<ServiceOrder> findByStatus(Status status);
}
