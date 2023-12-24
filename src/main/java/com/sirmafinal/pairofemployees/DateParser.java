package com.sirmafinal.pairofemployees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static LocalDate parseDate(String dateString) {

        String[] formats = {
                "yyyy-MM-dd",
                "MM/dd/yyyy",
                "dd-MM-yyyy",
                "dd/MM/yyyy",
                "yyyy/MM/dd",
                "dd.MM.yyyy г."
        };

        for (String format : formats) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                return LocalDate.parse(dateString, formatter);
            } catch (Exception e) {

            }
        }

        throw new IllegalArgumentException("Unable to parse date: " + dateString);
    }
}
