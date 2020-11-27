package lk.ijse.dep.pos.business.custom;

import lk.ijse.dep.pos.business.SuperBO;
import lk.ijse.dep.pos.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {
    public String getNewItemCode() throws Exception;
    public List<ItemDTO> getAllItems() throws Exception;
    public void saveItem(String code, String description, int qtyOnHand, double unitPrice) throws Exception;
    public void deleteItem(String itemCode) throws Exception;
    public void updateItem(String description, int qtyOnHand, double unitPrice, String itemCode) throws Exception;
    ItemDTO getItem(String code);
    boolean itemExist(String code);
}
