package com.mukul.utility.mapper;

import lombok.experimental.UtilityClass;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;

@MapperConfig(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
uses = MapperHelper.class)
@UtilityClass
public class DefaultMapperConfig {
}
