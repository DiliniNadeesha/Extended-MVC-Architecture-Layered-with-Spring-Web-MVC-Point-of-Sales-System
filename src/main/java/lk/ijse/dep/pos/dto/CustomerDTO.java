package lk.ijse.dep.pos.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    @Pattern(regexp = "C\\d{3}")
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}
