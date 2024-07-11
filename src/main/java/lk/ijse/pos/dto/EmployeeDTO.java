package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class EmployeeDTO {
    private String empid;
    private String name;
    private double salary;
    private  int contact;
}
