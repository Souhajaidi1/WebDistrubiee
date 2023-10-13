package tn.esprit.msserviceorder.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.msserviceorder.models.Status;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class ServiceOrderDTO {
    private Status status;

    @PastOrPresent(message = "Order date must be in the past or present")
    private Date orderDate;
}
