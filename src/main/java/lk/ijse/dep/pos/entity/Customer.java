package lk.ijse.dep.pos.entity;

import lombok.*;

import javax.persistence.*;

//@NamedNativeQuery(name = "Customer.getCustomersViaNamedQuery", query = "SELECT address FROM Customer WHERE address like 'G%'")
//@NamedQuery(name="Customer.getCustomersViaNamedNativeQuery",query = "SELECT c.address FROM Customer AS c WHERE c.address like 'G%'")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements SuperEntity {
    @Id
    private String id;
    private String name;
    private String address;
}
