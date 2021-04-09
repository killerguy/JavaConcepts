package com.mukul.utility;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class RowMapper<T> implements org.springframework.jdbc.core.RowMapper<T> {
    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(new SafeResultSet(resultSet, i), i);
    }

    abstract public T mapRow(SafeResultSet safeResultSet, int i) throws SQLException;
}
