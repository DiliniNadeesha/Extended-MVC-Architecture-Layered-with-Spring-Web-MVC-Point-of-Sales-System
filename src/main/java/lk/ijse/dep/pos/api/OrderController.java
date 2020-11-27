package lk.ijse.dep.pos.api;

import lk.ijse.dep.pos.business.custom.OrderBO;
import lk.ijse.dep.pos.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderBO orderBO;

    @GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderBO.getAllOrders();
    }
}
