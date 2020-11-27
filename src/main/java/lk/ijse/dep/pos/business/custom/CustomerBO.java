package lk.ijse.dep.pos.business.custom;

import lk.ijse.dep.pos.business.SuperBO;
import lk.ijse.dep.pos.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    public String getNewCustomerId() throws Exception;
    public List<CustomerDTO> getAllCustomers() throws Exception;
    public void saveCustomer(String id, String name, String address) throws Exception;
    public void deleteCustomer(String customerId) throws Exception;
    public void updateCustomer(String name, String address, String customerId) throws Exception;
    CustomerDTO getCustomer(String id) throws Exception;
    boolean customerExist(String id) ;
}
