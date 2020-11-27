package lk.ijse.dep.pos.business.custom.impl;

import lk.ijse.dep.pos.business.custom.OrderBO;
import lk.ijse.dep.pos.dto.OrderDTO;
import lk.ijse.dep.pos.dto.OrderDetailDTO;
import lk.ijse.dep.pos.entity.Item;
import lk.ijse.dep.pos.entity.Order;
import lk.ijse.dep.pos.entity.OrderDetail;
import lk.ijse.dep.pos.repository.custom.CustomerRepository;
import lk.ijse.dep.pos.repository.custom.ItemRepository;
import lk.ijse.dep.pos.repository.custom.OrderDetailRepository;
import lk.ijse.dep.pos.repository.custom.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OrderBOImpl implements OrderBO {
    //    @Autowired
//    private QueryDAO queryDAO;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public String getNewOrderId() throws Exception {

        String lastOrderId = null;

        lastOrderId = orderRepository.getFirstLastOrderIdByOrderByIdDesc().getId();
        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }

    }

    @Override
    public List<OrderDTO> searchOrder() throws Exception {
        return null;
    }

//
//    public List<OrderTM> searchOrder() throws Exception {
//        List<CustomEntity> searchOrders = queryDAO.searchOrder();
//        List<OrderTM> allOrders = new ArrayList<>();
//        for (CustomEntity searchOrder : searchOrders) {
//            allOrders.add(new OrderTM(searchOrder.getOrderId(), searchOrder.getOrderDate(),
//                    searchOrder.getCustomerName()
//                    , searchOrder.getCustomerId(), searchOrder.getTotal()));
//        }
//        return allOrders;
//    }

    public void placeOrder(OrderDTO order, List<OrderDetailDTO> orderDetails) throws Exception {
//        String id = customerRepository.findById(order.getCustomerId()).get().getId();
//        orderRepository.save(new OrderDTO(order.getId(), order.getDate(), customerRepository.findById(order.getCustomerId()).get()));
        orderRepository.save(new Order(order.getId(), Date.valueOf(order.getDate()), customerRepository.findById(order.getCustomerId()).get()));

        for (OrderDetailDTO orderDetail : orderDetails) {
            orderDetailRepository.save(new OrderDetail(order.getId(), orderDetail.getCode(), orderDetail.getQty(), BigDecimal.valueOf(orderDetail.getUnitPrice().doubleValue())
            ));

            Object i = itemRepository.findById(orderDetail.getCode()).get();
            Item item = (Item) i;
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            itemRepository.save(item);

        }
    }

    @Override
    public OrderDTO getOrder(String id) {
        Order order = orderRepository.findById(id).get();
        return new OrderDTO(order.getId(), order.getDate().toString(), order.getCustomer().getId());
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> all = orderRepository.findAll();
        List<OrderDTO> orders = new ArrayList<>();
        for (Order order : all) {
            orders.add(new OrderDTO(order.getId(), order.getDate().toString(), order.getCustomer().getId()));
        }
        return orders;
    }
}
