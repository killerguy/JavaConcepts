package com.mukul.utility.mapper.examples;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeEntity {

private Long id;
private String employeeName;

}
