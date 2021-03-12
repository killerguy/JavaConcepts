package com.mukul.utility;

import java.util.Optional;
import org.apache.commons.lang.StringUtils;

public class StringUtility {

    public static String getActualOrDefaultValue(String input,String defaultValue) {
        return Optional.ofNullable(input).filter(StringUtils::isNotEmpty).orElse(defaultValue);
    }

    public static boolean isEmpty(String str) {
        return Optional.ofNullable(str).map(i -> i.length()==0).orElse(false);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

}
