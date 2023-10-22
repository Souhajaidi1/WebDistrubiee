package tn.esprit.prestationdeservice.msprestation.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.prestationdeservice.msprestation.dto.EnumValidator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // Updated to orderId

    @NotNull(message = "Order date cannot be null")
    @PastOrPresent(message = "Order date must be in the past or present")
    private Date orderDate;

    @EnumValidator(enumClass = Status.class, message = "Invalid status value")
    private Status status;
}
