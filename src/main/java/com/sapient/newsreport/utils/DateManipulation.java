package com.sapient.newsreport.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateManipulation {
    public static LocalDate dateRange(String interval)
    {
    // Current Date
    LocalDate currentDate = LocalDate.now();
        System.out.println("Current Date: "+currentDate);
        LocalDate toDate=null;
    // Date one year ago
        if(interval.equals("years")) {
            toDate = currentDate.minus(1, ChronoUnit.YEARS);
            System.out.println("Date last year: " + toDate);
        }
    // Date one month ago
        if(interval.equals("months")) {
            toDate = currentDate.minus(1, ChronoUnit.MONTHS);
            System.out.println("Date last month: " + toDate);
        }
    // Date one day ago
        if(interval.equals("days")) {
            toDate = currentDate.minus(1, ChronoUnit.DAYS);
            System.out.println("Date yesterday: " + toDate);
        }
        return toDate;
}
}

