package com.mukul.date;

import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.time.DateUtils.truncate;

public class DateExample {

    public static final String YYYY_MM_DD = "yyyy/MM/dd";
    public static final String REPORTS_FORMAT = "MM/dd/yyyy";
    public static final String DATABASE_SIMPLE_FORMAT = "yyyy-MM-dd";
    public static final String PRETTY_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String ISO_FORMAT_UTC = "yyyy-MM-dd'T'HH:mmZ";
    public static final double DAYS_PER_MONTH = 30.4167;
    public static final int CUTOFF_DAYS = 15;
    private static final int MILLISECONDS = 1000;
    public static final long MILLISECONDS_IN_MINUTE = 60 * (long) MILLISECONDS;
    private static final Pattern DATETIME_JSON_PATTERN = Pattern.compile("^/Date\\(((\\+|-)?\\d+)((\\+|-)\\d{4})?\\)/");

    public static void main(String[] argv) throws ParseException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        DateExample dateExample = new DateExample();

        System.out.println("Date From String: " + getDateFromString());
        System.out.println("Date From String as Parameter : " + dateExample.getDateFromString("25-05-2015 10:20:56"));
        System.out.println("Date From separate String: " + getDate(2016, 07, 01));
        System.out.println("Calender From Date: " + getCalendarFromDate(date).getTime());
        System.out.println("Date from calender : " + getDateFromCalender(calendar));
        System.out.println("Get Time is Seconds : " + getTimeInSeconds(date));
        System.out.println("Add Minutes to Time : " + addMinutesToNow(5));
        System.out.println("Add Weeks to CurrentDate : " + addWeeksToDate(date, 1));
        System.out.println("Add Months to CurrentDate : " + addMonthsToToday(1));
        System.out.println("Add Days to CurrentDate : " + addDaysToToday(1));
        System.out.println("Add Years to CurrentDate : " + addYearsToToday(2));
        System.out.println("Add Years to PreviousDate : " + addYearsToYesterday(2));
        System.out.println("Reset Date : " + resetTime(date));
        System.out.println("Months Until End Date : " + monthsUntilEndDate(addYearsToToday(3)));
        System.out.println("Months Between Dates : " + monthsBetweenDates(addYearsToToday(3), date));
        System.out.println("Start Before End And Not The Same Day : " + isStartBeforeEndAndNotTheSameDay(date, date));
        System.out.println("Current Day is Today : " + isTodayOrFuture(date));
        System.out.println("Current Day is Tomorrow : " + isTomorrowOrFuture(date));
        System.out.println("Different Days : " + isDifferentDays(Arrays.asList(date, date)));
        System.out.println("Get Yesterday's TimeStamp : " + getYesterdayTimestamp());
        System.out.println("Get Today in Simple Format : " + dateExample.getTodayInSimpleFormat());
        System.out.println("Get Today in Simple Database Format : " + dateExample.getTodayInSimpleDatabaseFormat());
        System.out.println("Get Today in Simple Report Format : " + dateExample.getTodayInReportsFormat());
        System.out.println("Get Today in Detailed Format : " + dateExample.getNowInDetailedFormat());
        System.out.println("Get Today in UTC in ISO Format : " + dateExample.getTodayAsUtcInIsoFormat());
        System.out.println("Is First Date After Second Date : " + dateExample.isFirstDateAfterSecondDate(new Date(), getDate(2016, 07, 01)));
        System.out.println("Get year from Date : " + dateExample.getYear(new Date()));
        System.out.println("Get Add to Calender : " + dateExample.addHoursTo(calendar, 25).getTime());
        System.out.println("Parse Data Date String : " + dateExample.parseDataDateString("01071987"));
    }

    public static Date getDateFromString() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String dateInString = "25-05-2015 10:20:56";
        return sdf.parse(dateInString);
    }

    private static Date getDateFromCalender(Calendar calendar) {
        return calendar.getTime();
    }

    private static Date addMonthsToDate(Date startDate, int monthsToAdd) {
        Calendar clock = getCalendarFromDate(startDate);
        clock.add(Calendar.MONTH, monthsToAdd);
        return clock.getTime();
    }

    public static Date addMonthsToToday(int months) {
        return addMonthsToDate(getCurrentTimestamp(), months);
    }

    public static Date addDaysToToday(int daysToAddToToday) {
        return addDaysToDate(getToday().getTime(), daysToAddToToday);
    }

    public static Date addDaysToDate(Date startDate, int daysToAdd) {
        Calendar clock = getCalendarFromDate(startDate);
        clock.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return clock.getTime();
    }

    public static Date addYearsToDate(Date startDate, int yearsToAdd) {
        Calendar calendarFromDate = getCalendarFromDate(startDate);
        calendarFromDate.add(Calendar.YEAR, yearsToAdd);
        return calendarFromDate.getTime();
    }

    public static Date addYearsToToday(int yearsToAdd) {
        return addYearsToDate(getTodaysDate(), yearsToAdd);
    }

    public static Date addYearsToYesterday(int yearsToAdd) {
        return addYearsToDate(getYesterday(), yearsToAdd);
    }

    public static Date resetTime(Date date) {
        return truncate(date, Calendar.DATE);
    }

    public static int daysBetweenTodayAnd(Date endDate) {
        return daysBetweenDates(getTodaysDate(), endDate);
    }

    public static int daysBetweenDates(Date startDate, Date endDate) {
        Calendar startCalendar = truncateTimeFromDate(startDate);
        Calendar endCalendar = truncateTimeFromDate(endDate);
        DateTime dateTimeStart = new DateTime(startCalendar);
        DateTime dateTimeEnd = new DateTime(endCalendar);

        return Days.daysBetween(dateTimeStart, dateTimeEnd).getDays();
    }

    public static int monthsUntilEndDate(Date endDate) {
        int daysRemaining = Math.abs(daysBetweenTodayAnd(endDate));
        return calculateMonthsRemaining(daysRemaining);
    }

    public static int monthsBetweenDates(Date startDate, Date endDate) {
        int daysRemaining = Math.abs(daysBetweenDates(startDate, endDate));
        return calculateMonthsRemaining(daysRemaining);
    }

    public static int calculateMonthsRemaining(int daysRemaining) {
        int averageMonthsRemaining = (int) (daysRemaining / DAYS_PER_MONTH);
        return (daysRemaining % DAYS_PER_MONTH > CUTOFF_DAYS) ? ++averageMonthsRemaining : averageMonthsRemaining;
    }

    public String format(Date date, String pattern) {
        if (date == null) return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static boolean isStartBeforeEndAndNotTheSameDay(Date startDate, Date endDate) {
        return startDate.before(endDate) && daysBetweenDates(startDate, endDate) != 0;
    }

    public static boolean isTodayOrFuture(Date date) {
        return DateUtils.isSameDay(date, getToday().getTime()) || date.compareTo(getToday().getTime()) > 0;
    }

    public static boolean isTomorrowOrFuture(Date date) {
        return date.compareTo(getToday().getTime()) > 0 && !DateUtils.isSameDay(date, getToday().getTime());
    }


    public static boolean isSameDay(Date startDate, Date endDate) {
        if (startDate == null && endDate == null) {
            return true;
        } else if (startDate != null && endDate != null) {
            return daysBetweenDates(startDate, endDate) == 0;
        }
        return false;
    }

    public static boolean isDifferentDays(List<Date> dates) {
        if (!dates.isEmpty()) {
            Date firstDate = dates.get(0);
            for (Date date : dates) {
                if (!isSameDay(firstDate, date)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Date addWeeksToDate(Date startDate, int weekToAdd) {
        Calendar clock = getCalendarFromDate(startDate);
        clock.add(Calendar.WEEK_OF_YEAR, weekToAdd);
        return clock.getTime();
    }

    public static Date addMinutesToNow(int numberOfMinutes) {
        return new Date(getToday().getTimeInMillis() + (numberOfMinutes * MILLISECONDS_IN_MINUTE));
    }

    private static Calendar calendar(Date dateToCompareWith) {
        Calendar calendarToCompareWith = Calendar.getInstance();
        calendarToCompareWith.setTime(dateToCompareWith);
        return calendarToCompareWith;
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(getToday().getTime().getTime());
    }

    public static Timestamp getYesterdayTimestamp() {
        return new Timestamp(getYesterday().getTime());
    }

    public static Date getDate(int year, int month, int day) {
        return getCalendar(year, month - 1, day).getTime();
    }

    public static Calendar getCalendar(int year, int month, int day) {
        Calendar target = getToday();
        target.set(year, month, day, 0, 0);
        target.set(Calendar.SECOND, 0);
        target.set(Calendar.MILLISECOND, 0);
        return target;
    }

    public static long getTimeInSeconds(Date date) {
        return date.getTime() / MILLISECONDS;
    }

    public static Calendar getToday() {
        return Calendar.getInstance();
    }

    public static Date getYesterday() {
        return addDaysToDate(getToday().getTime(), -1);
    }

    public String getTodayInSimpleFormat() {
        return getSimpleFormat(getToday().getTime());
    }

    public String getTodayInSimpleDatabaseFormat() {
        return getSimpleDatabaseFormat(getToday().getTime());
    }

    public String getTodayInReportsFormat() {
        return getReportsFormat(getToday().getTime());
    }

    public String getNowInDetailedFormat() {
        return format(new Date(), PRETTY_FORMAT);
    }

    public String getSimpleFormat(Date date) {
        return format(date, YYYY_MM_DD);
    }

    public String getSimpleDatabaseFormat(Date date) {
        return format(date, DATABASE_SIMPLE_FORMAT);
    }

    public String getReportsFormat(Date date) {
        return format(date, REPORTS_FORMAT);
    }

    public static Calendar getCalendarFromDate(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        return calendar;
    }

    public Date getDateFromString(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATABASE_SIMPLE_FORMAT);
        Date convertedDate = null;
        if (date != null) {
            try {
                convertedDate = formatter.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return convertedDate;
    }

    public Date parseDataDateString(String value) {
        if (value != null) {
            Matcher matcher = DATETIME_JSON_PATTERN.matcher(value);

            if (matcher.matches()) {
                String ticksString = matcher.group(1);
                return new Date(Long.parseLong(ticksString));
            }
        }
        return null;
    }

    public static Date getTodaysDate() {
        return getToday().getTime();
    }

    public String getDateAsUtcInIsoFormat(Date date) {
        if (date == null)
            return "";
        return format(date, ISO_FORMAT_UTC);
    }

    public String getTodayAsUtcInIsoFormat() {
        return getDateAsUtcInIsoFormat(getTodaysDate());
    }

    public Date getDateFromString(String dateAsString, String format) throws ParseException {
        return new SimpleDateFormat(format).parse(dateAsString);
    }

    public int getYear(Date date) {
        return date == null ? 0 : Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
    }

    public static Calendar truncateTimeFromDate(Date date) {
        Calendar calendar = calendar(date);
        calendar.set(Calendar.HOUR_OF_DAY, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 00);
        return calendar;
    }

    public boolean isFirstDateAfterSecondDate(Date firstDate, Date secondDate) {
        return truncateTimeFromDate(firstDate).after(truncateTimeFromDate(secondDate));
    }

    public static boolean isValidDate(String dateToValidate, String dateFormat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);

        try {
            simpleDateFormat.parse(dateToValidate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public int hoursBetweenDates(Date startDate, Date endDate) {
        DateTime dateTimeStart = new DateTime(startDate);
        DateTime dateTimeEnd = new DateTime(endDate);

        return Hours.hoursBetween(dateTimeStart, dateTimeEnd).getHours();
    }

    public Calendar addHoursTo(Calendar calendar, int noOfHours) {
        Calendar newDate = calendar;
        newDate.add(Calendar.HOUR, noOfHours);
        return newDate;
    }

    public Calendar formatDateForBatchJob(String runDate) throws ParseException {
        if (StringUtils.isEmpty(runDate)) {
            return Calendar.getInstance();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATABASE_SIMPLE_FORMAT, Locale.ENGLISH);
        return getCalendarFromDate(dateFormat.parse(runDate));
    }


}
