package md.practice.projects.dentalclinicmanagement.helper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;

@Component
public class ConvertDataTypes {
    public LocalDate toLocalDate(String dateString) {
        LocalDate date;
        int dd = Integer.parseInt(dateString.substring(0, 2));
        int mm = Integer.parseInt(dateString.substring(2, 4));
        int yyy = Integer.parseInt(dateString.substring(4));


        int year;
        if (yyy < 100) {
            year = 2000 + yyy;
        } else if (yyy >= 1000) {
            year = yyy;
        } else {
            year = 1000 + yyy;
        }

        try {
            date = LocalDate.of(year, mm, dd);
        } catch (DateTimeException e) {
            throw new DateTimeException("Invalid date format");
        }
        return date;
    }

    public Long toLong(String s) {
        return Long.parseLong(s);
    }

}
