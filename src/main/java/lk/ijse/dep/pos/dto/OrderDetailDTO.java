package lk.ijse.dep.pos.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@ToString
public class OrderDetailDTO {
    private String code;
    private int qty;
    private BigDecimal unitPrice;
}
