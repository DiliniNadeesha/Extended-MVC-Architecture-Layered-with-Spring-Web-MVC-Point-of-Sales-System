package lk.ijse.dep.pos.business.custom;

import lk.ijse.dep.pos.business.SuperBO;
import lk.ijse.dep.pos.dto.OrderDTO;
import lk.ijse.dep.pos.dto.OrderDetailDTO;

import java.util.List;

public interface OrderBO extends SuperBO {
    public String getNewOrderId() throws Exception;
    public List<OrderDTO> searchOrder() throws Exception;
    public void placeOrder(OrderDTO order, List<OrderDetailDTO> orderDetails) throws Exception;
    OrderDTO getOrder(String id);
    List<OrderDTO> getAllOrders();
}
