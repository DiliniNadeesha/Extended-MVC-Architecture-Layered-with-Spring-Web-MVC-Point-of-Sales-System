package lk.ijse.dep.pos.repository.custom;

import lk.ijse.dep.pos.entity.CustomEntity;
import lk.ijse.dep.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {
    Item getFirstLastItemCodeByOrderByCodeDesc() throws Exception;
//    List<Item> getAllItemsByUnitPriceGreaterThan(BigDecimal price) throws Exception;
//    List<Item> getAllItemsByQtyOnHandLessThanAndUnitPriceGreaterThan(int quantity, BigDecimal price) throws Exception;
//    @Query(value = "SELECT * FROM Item WHERE qtyOnHand<50",nativeQuery = true) //native sql
//    List<Item> findAllItemsLessThan50() throws Exception;
//    @Query(value = "SELECT i FROM Item i WHERE qtyOnHand<40",nativeQuery = false) //JPQl
//    List<Item> findItemsLessThan40() throws Exception;
//    @Query(value = "SELECT description FROM Item WHERE unitPrice > '%?1'",nativeQuery = true) // positional parameters normal way
//    List<String> getAllItemDescriptions(BigDecimal price) throws Exception;
//
//    //Using @param
////    @Query(value = "SELECT description FROM Item i WHERE i.unitPrice > :abc",nativeQuery = true) //positional parameters spel way
////    List<String> getAllItemDescriptions(@Param("abc") BigDecimal price) throws Exception;
//
//    //Using SPel
////    @Query(value = "SELECT description FROM Item i WHERE i.unitPrice > :#{#abc}",nativeQuery = true) //positional parameters spel way
////    List<String> getAllItemDescriptions(@Param("abc") BigDecimal price) throws Exception;
//
////    @Query(value = "SELECT description FROM Item i WHERE i.unitPrice > :#{T(lk.ijse.dep.pos.util.DEPUtil).getQtyOnHand()}",nativeQuery = true)
////    List<String> getItems() throws Exception;
//
//    List<Item> getItemsViaNamedQuery(int qty, String description) throws Exception;
////    List<Object[]> getItemsViaNamedQuery2(int qty, String description) throws Exception;
//    List<Item> getItemsViaNamedNativeQuery(@Param("qty") int qty,@Param("des") String des) throws Exception;
//    List<Object[]> getItemsViaNamedQuery2(int qty, String description) throws Exception;
//    List<CustomEntity> getItemsViaNamedQuery3(int qty, String description) throws Exception;
}
