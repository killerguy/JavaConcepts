package com.mukul.utility.mapper.examples;

import com.mukul.utility.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface EmployeeMapper extends MapperBase<EmployeeEntity,EmployeeModel> {

}
