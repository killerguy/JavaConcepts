package com.mukul.utility;

import com.mukul.date.DateExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.support.JdbcUtils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SafeResultSetTest {

    private static final String COLUMN_NAME = "column_name";
    private static final String INVALID_COLUMN = "invalidColumn";
    private static final double DELTA = 0.00;
    private final String SOME_STRING = "string";
    private ResultSet mockResultSet;

    @Before
    public void setup() throws SQLException {
        mockResultSet = mock(ResultSet.class);
        ResultSetMetaData mockResultSetMetaData = mock(ResultSetMetaData.class);

        when(mockResultSet.getMetaData()).thenReturn(mockResultSetMetaData);
        when(mockResultSetMetaData.getColumnCount()).thenReturn(1);
        when(JdbcUtils.lookupColumnName(mockResultSetMetaData, 1)).thenReturn(COLUMN_NAME);
    }

    @Test
    public void getIntWhenValidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(1);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        int safeResultSetInt = safeResultSet.getInt(COLUMN_NAME);

        assertEquals(1, safeResultSetInt);
    }

    @Test
    public void getIntWhenInvalidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(1);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        int safeResultSetInt = safeResultSet.getInt(INVALID_COLUMN);

        assertEquals(0, safeResultSetInt);
    }

    @Test
    public void getStringWhenValidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(SOME_STRING);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        String safeResultSetString = safeResultSet.getString(COLUMN_NAME);

        assertEquals(SOME_STRING, safeResultSetString);
    }

    @Test
    public void getStringWhenInvalidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(SOME_STRING);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        String safeResultSetString = safeResultSet.getString(INVALID_COLUMN);

        assertNull(safeResultSetString);
    }

    @Test
    public void getTrimmedStringWhenValidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(SOME_STRING);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        String safeResultSetString = safeResultSet.getNullSafeTrimmedString(COLUMN_NAME);

        assertEquals(SOME_STRING, safeResultSetString);
    }

    @Test
    public void getTrimmedStringWhenInvalidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(SOME_STRING);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        String safeResultSetString = safeResultSet.getNullSafeTrimmedString(INVALID_COLUMN);

        assertNull(safeResultSetString);
    }

    @Test
    public void getDoubleWhenValidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(1d);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        double safeResultSetDouble = safeResultSet.getDouble(COLUMN_NAME);

        assertEquals(1d, safeResultSetDouble, DELTA);
    }

    @Test
    public void getDoubleWhenInvalidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(1d);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        double safeResultSetDouble = safeResultSet.getDouble(INVALID_COLUMN);

        assertEquals(0d, safeResultSetDouble, DELTA);
    }

    @Test
    public void getDateFromTimestampWhenValidColumn() throws SQLException {
        long timeInMillis = DateExample.getToday().getTimeInMillis();
        Timestamp timestamp = new Timestamp(timeInMillis);
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(timestamp);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        Date safeResultSetDate = safeResultSet.getDateFromTimestamp(COLUMN_NAME);

        assertEquals(timeInMillis, safeResultSetDate.getTime());
    }

    @Test
    public void getDateFromTimestampWhenValidColumnAndNull() throws SQLException {
        long timeInMillis = DateExample.getToday().getTimeInMillis();
        Timestamp timestamp = new Timestamp(timeInMillis);
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(timestamp);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        Date safeResultSetDate = safeResultSet.getDateFromTimestamp(INVALID_COLUMN);

        assertNull(safeResultSetDate);
    }

    @Test
    public void getDateFromTimestampWhenInvalidColumn() throws SQLException {
        long timeInMillis = DateExample.getToday().getTimeInMillis();
        Timestamp timestamp = new Timestamp(timeInMillis);
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(timestamp);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        Date safeResultSetDate = safeResultSet.getDateFromTimestamp(INVALID_COLUMN);

        assertNull(safeResultSetDate);
    }

    @Test
    public void getDoubleValueFromBigDecimalWhenValidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(new BigDecimal(1));
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        double safeResultSetDouble = safeResultSet.getDoubleFromBigDecimal(COLUMN_NAME);

        assertEquals(1d, safeResultSetDouble, DELTA);
    }

    @Test
    public void getDoubleValueFromBigDecimalWhenInvalidColumn() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(new BigDecimal(1));
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        double safeResultSetDouble = safeResultSet.getDoubleFromBigDecimal(INVALID_COLUMN);

        assertEquals(0d, safeResultSetDouble, DELTA);
    }

    @Test
    public void getDateValueWhenValidColumn() throws SQLException {
        Date today = new Date();
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(today);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        Date safeResultSetDate = safeResultSet.getDate(COLUMN_NAME);

        assertEquals(today, safeResultSetDate);
    }

    @Test
    public void getDateValueWhenInvalidColumn() throws SQLException {
        Date today = new Date();
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(today);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        Date safeResultSetDate = safeResultSet.getDate(INVALID_COLUMN);

        assertNull(safeResultSetDate);
    }

    @Test
    public void getBooleanFromIntReturnsTrueWhenInvalidColumn() {
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);
        boolean safeResultSetBoolean = safeResultSet.getBooleanFromInt(INVALID_COLUMN);
        assertTrue(safeResultSetBoolean);
    }

    @Test
    public void getBoolFromIntReturnsTrueWhenColumnValueIs1() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(1);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        boolean safeResultSetBoolean = safeResultSet.getBooleanFromInt(COLUMN_NAME);

        assertTrue(safeResultSetBoolean);
    }

    @Test
    public void getBoolFromIntReturnsFalseWhenColumnValueIs0() throws SQLException {
        when(JdbcUtils.getResultSetValue(mockResultSet, 1)).thenReturn(0);
        SafeResultSet safeResultSet = new SafeResultSet(mockResultSet, 1);

        boolean safeResultSetBoolean = safeResultSet.getBooleanFromInt(COLUMN_NAME);

        assertFalse(safeResultSetBoolean);
    }
}
