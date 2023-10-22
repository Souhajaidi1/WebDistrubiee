package tn.esprit.prestationdeservice.msprestation.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.prestationdeservice.msprestation.models.Status;

import javax.validation.constraints.PastOrPresent;
import java.util.Date;

@Getter
@Setter
public class ServiceOrderDTO {
    private Status status;

    @PastOrPresent(message = "Order date must be in the past or present")
    private Date orderDate;
}
