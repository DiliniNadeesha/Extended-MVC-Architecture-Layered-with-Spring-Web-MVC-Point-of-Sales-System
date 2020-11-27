package lk.ijse.dep.pos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailPK implements Serializable {
    private String orderId;
    private String itemCode;


}
