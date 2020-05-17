package com.example.mobileapp;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class RegistrationDate {
    private Calendar calendar = new GregorianCalendar();

    public String myDate() {
        String myThisDate = "";
        String[] monthNames = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        myThisDate = thisDay() + " " + monthNames[thisMonth()] + " " + thisYear();
        return myThisDate;
    }

    private Integer thisYear() {
        return calendar.get(Calendar.YEAR);
    }

    private Integer thisMonth() {
        return calendar.get(Calendar.MONTH);
    }

    private Integer thisDay() {
        return calendar.get(Calendar.DATE);
    }
}
