package lk.ijse.dep.pos.repository.custom;

import lk.ijse.dep.pos.entity.CustomEntity2;
import lk.ijse.dep.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order getFirstLastOrderIdByOrderByIdDesc() throws Exception;
//    @Query(value="SELECT o.id AS orderId, o.date AS orderDate, c.id AS customerId, c.name AS customerName, SUM(od.unitPrice * od.qty) AS orderTotal FROM Order o INNER JOIN o.orderDetailList od INNER JOIN o.customer c GROUP BY o.id")
//    List<CustomEntity2> getAllOrders() throws Exception;
}

