package tn.esprit.msserviceorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.msserviceorder.models.ServiceOrder;
import tn.esprit.msserviceorder.models.Status;

import java.util.Date;
import java.util.List;

@Repository
public interface ServiceOrderRepository extends JpaRepository<ServiceOrder, Long> {
    List<ServiceOrder> findByOrderDate(Date orderDate);
    List<ServiceOrder> findByStatus(Status status);
}
