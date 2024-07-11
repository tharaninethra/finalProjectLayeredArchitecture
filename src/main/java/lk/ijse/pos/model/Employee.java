package lk.ijse.pos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data

public class Employee {
    private String empid;
    private String name;
    private double salary;
    private  int contact;
}
