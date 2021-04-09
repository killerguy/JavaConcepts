package com.mukul.utility;

import org.junit.Test;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RowMapperTest {
    private final String stringValue = "string";

    @Test
    public void test_row_mapper() throws Exception {
        //given
        ResultSet mockResultSet = mock(ResultSet.class);
        ResultSetMetaData resultSetMetaData = mock(ResultSetMetaData.class);
        when(mockResultSet.getMetaData()).thenReturn(resultSetMetaData);
        when(resultSetMetaData.getColumnCount()).thenReturn(1);
        when(JdbcUtils.lookupColumnName(resultSetMetaData, 1)).thenReturn(stringValue);
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(stringValue);
        when(mockResultSet.getString(stringValue)).thenReturn(stringValue);
        StringRowMapper stringRowMapper = new StringRowMapper();

        //then
        assertEquals(stringRowMapper.mapRow(mockResultSet, 1),stringValue);
    }

    @Test
    public void test_row_mapper_using_safe_results() throws Exception {
        //given
        ResultSet mockResultSet = mock(ResultSet.class);
        ResultSetMetaData resultSetMetaData = mock(ResultSetMetaData.class);
        when(mockResultSet.getMetaData()).thenReturn(resultSetMetaData);
        when(resultSetMetaData.getColumnCount()).thenReturn(1);
        when(JdbcUtils.lookupColumnName(resultSetMetaData, 1)).thenReturn(stringValue);
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(stringValue);
        when(mockResultSet.getString(stringValue)).thenReturn(stringValue);
        StringRowMapper stringRowMapper = new StringRowMapper();
        SafeResultSet srs = new SafeResultSet(mockResultSet, 1);

        //then
        assertEquals(stringRowMapper.mapRow(srs, 1), stringValue);
    }

    public class StringRowMapper extends RowMapper<String> {
        @Override
        public String mapRow(SafeResultSet safeResultSet, int i) {
            return safeResultSet.getString(stringValue);
        }

        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            return super.mapRow(resultSet, i);
        }
    }

}
