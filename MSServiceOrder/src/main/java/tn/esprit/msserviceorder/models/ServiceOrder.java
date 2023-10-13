package tn.esprit.msserviceorder.models;

import lombok.*;
import tn.esprit.msserviceorder.dto.EnumValidator;

import javax.persistence.*;
import javax.validation.constraints.*;
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
