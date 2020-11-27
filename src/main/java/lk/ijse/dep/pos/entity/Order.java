package lk.ijse.dep.pos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@ToString
@Table(name="`Order`")
@NoArgsConstructor
@Getter
public class Order implements SuperEntity {
    @Id
    private String id;
    private Date date;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "customerId",referencedColumnName = "id" ,nullable = false) //nullable false (because of the total participation)
    private Customer customer;
    @OneToMany(mappedBy = "order",cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}) //Bi-directional
    private List<OrderDetail> orderDetailList;

    public Order(String id, Date date, Customer customer, List<OrderDetail> orderDetailList) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetail.setOrder(this);
        }
        this.orderDetailList = orderDetailList;
    }

    public Order(String id, Date date, Customer customer) {
        this.id = id;
        this.date = date;
        this.customer = customer;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        for (OrderDetail orderDetail : orderDetailList) {
            orderDetail.setOrder(this);
        }
        this.orderDetailList = orderDetailList;
    }

    public void addOrderDetailList(OrderDetail orderDetail) {
        orderDetail.setOrder(this);
        this.getOrderDetailList().add(orderDetail);
    }
}
