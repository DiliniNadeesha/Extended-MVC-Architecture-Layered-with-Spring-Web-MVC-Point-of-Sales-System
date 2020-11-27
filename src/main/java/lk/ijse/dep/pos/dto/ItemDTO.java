package lk.ijse.dep.pos.dto;

import lombok.*;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Setter@NoArgsConstructor@Getter@AllArgsConstructor@ToString
public class ItemDTO {
    @Pattern(regexp = "I\\{3}")
    private String code;
    private String description;
    private int qtyOnHand;
    private BigDecimal unitPrice;
}
