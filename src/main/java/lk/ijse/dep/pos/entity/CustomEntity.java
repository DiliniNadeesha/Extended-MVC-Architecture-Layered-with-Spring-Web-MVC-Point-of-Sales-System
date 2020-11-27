package lk.ijse.dep.pos.entity;

import org.springframework.beans.factory.annotation.Value;

public interface CustomEntity {   //projection DTO
    //code
    @Value("#{target.code}")
    String getCode();
    //description
    @Value("#{target.description}")
    String getDescription();
}
