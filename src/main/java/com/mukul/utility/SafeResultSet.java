package com.mukul.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ColumnMapRowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SafeResultSet {

    private Map<String, Object> resultMap;
    private static final Logger logger = LoggerFactory.getLogger(SafeResultSet.class);

    public SafeResultSet(ResultSet rs, int rowNum) {
        this.resultMap = getResultMap(rs, rowNum);
    }

    public Map<String, Object> getResultMap(ResultSet rs, int rowNum) {
        try {
            return new ColumnMapRowMapper().mapRow(rs, rowNum);
        } catch (SQLException exception) {
            logger.warn("Error occurred while mapping rows from database for {} with row number {}", rs, rowNum, exception);
        }
        return new HashMap<>();
    }

    public String getString(String columnName) {
        return resultMap.get(columnName) != null ? (String) resultMap.get(columnName) : null;
    }

    public String getNullSafeTrimmedString(String columnName) {
        return resultMap.get(columnName) != null ? resultMap.get(columnName).toString().trim() : null;
    }

    public int getInt(String columnName) {
        Object value = resultMap.get(columnName);
        boolean notEmpty = value != null;
        return notEmpty ? Integer.parseInt(value.toString()) : 0;
    }

    public Long getLong(String columnName) {
        return resultMap.get(columnName) != null ? (Long) resultMap.get(columnName) : 0;
    }

    public double getDouble(String columnName) {
        return resultMap.get(columnName) != null ? (Double) resultMap.get(columnName) : 0d;
    }

    public Date getDateFromTimestamp(String columnName) {
        if (resultMap.get(columnName) == null) return null;
        Date date = new Date();
        try {
            date.setTime(((Timestamp) resultMap.get(columnName)).getTime());
        } catch (ClassCastException e) {
            logger.warn("Error occurred while fetching date from timestamp for columnName {}", columnName, e);
            return null;
        }
        return date;
    }

    public Date getDate(String columnName) {
        return resultMap.get(columnName) != null ? (Date) resultMap.get(columnName) : null;
    }

    public double getDoubleFromBigDecimal(String columnName) {
        return resultMap.get(columnName) != null ? ((BigDecimal) resultMap.get(columnName)).doubleValue() : 0d;
    }

    public boolean getBooleanFromInt(String columnName) {
        int result = resultMap.get(columnName) != null ? Integer.parseInt(resultMap.get(columnName).toString()) : 1;
        return result == 1;
    }

    public boolean getBooleanFromIntWithDefaultFalse(String columnName) {
        return resultMap.get(columnName) != null && Integer.parseInt(resultMap.get(columnName).toString()) == 1;
    }
}
