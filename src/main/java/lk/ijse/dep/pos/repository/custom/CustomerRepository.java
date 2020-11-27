package lk.ijse.dep.pos.repository.custom;

import lk.ijse.dep.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer getFirstLastCustomerIdByOrderByIdDesc() throws Exception;
//    List<Customer> findAllCustomersByOrderByName() throws Exception;
//    List<Customer> getAllCustomersByAddressStartingWith(char letter) throws Exception;
//    int countCustomerCountByAddressStartingWithAndNameStartingWith(char letter1, char letter2) throws Exception;
//    @Query(value = "SELECT * FROM Customer WHERE name LIKE'%?1'",nativeQuery = true)
//    List<Customer> getAllCustomersWithName(char letter) throws Exception;
//    @Query(value="SELECT c FROM Customer c WHERE name LIKE '%?1'",nativeQuery = true)
//    List<Customer> getAllCustomersWithName2(char letter) throws Exception;
//
//    List<String> getCustomersViaNamedQuery() throws Exception;
}
