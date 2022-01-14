package com.mukul.utility.mapper;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@Component
public class MapperHelper {

    public LocalDateTime getLocalDate(OffsetDateTime offsetDateTime) {
        return offsetDateTime.toLocalDateTime().atZone(ZoneOffset.UTC).withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
    }
}
