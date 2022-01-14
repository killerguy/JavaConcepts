package com.mukul.utility.mapper.examples;

import lombok.NonNull;

public class EmployeeMapperMain {

    private static EmployeeMapper employeeMapper ;

    public static void main(String[] args) {


        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .id(1L)
                .employeeName("First Employee")
                .build();

        EmployeeModel employeeModel = employeeMapper.entityToModel(employeeEntity);

        System.out.println(employeeModel.toString());

    }
}
