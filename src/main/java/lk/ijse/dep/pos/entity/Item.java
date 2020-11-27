package lk.ijse.dep.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@NamedQuery(name="Item.getItemsViaNamedQuery",query="SELECT i FROM Item i WHERE i.qtyOnHand >:qty AND i.description LIKE CONCAT(:des,'%') ")
//@NamedNativeQuery(name="Item.getItemsViaNamedNativeQuery", query="SELECT * FROM Item i WHERE i.qtyOnHand >?1 AND i.description LIKE CONCAT(?2,'%')")
//@NamedQuery(name="Item.getItemsViaNamedQuery2",query="SELECT i.code AS code, i.description AS description FROM Item i WHERE i.qtyOnHand >:qty AND i.description LIKE CONCAT(:des,'%') ")
//@NamedQuery(name="Item.getItemsViaNamedQuery3",query="SELECT i FROM Item i WHERE i.qtyOnHand >?1 AND i.description LIKE CONCAT(?2,'%') ")

public class Item implements SuperEntity {
    @Id
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;
}
