package lk.ijse.dep.pos.repository.custom;

import lk.ijse.dep.pos.entity.OrderDetail;
import lk.ijse.dep.pos.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,OrderDetailPK> {
}
