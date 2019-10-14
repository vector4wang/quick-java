package com.feature.learn.ojcp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author vector
 * @date: 2019/10/14 0014 10:54
 */
public class DateFormatTest {
    public static void main(String[] args) {
        LocalDate date1= LocalDate.now();
        LocalDate date2= LocalDate.of(2014, 6, 20);
        LocalDate date3= LocalDate.parse("2014-06-20", DateTimeFormatter.ISO_DATE);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
        System.out.println("date3 = " + date3);

        /**
         * date1 = 2019-10-14
         * date2 = 2014-06-20
         * date3 = 2014-06-20
         */

        /**
         * LocalDate只表示一个日期，而不是一个DateTime。
         * 因此，“HH：mm：ss”在格式化LocalDate时没有意义。假设您想要表示日期和时间，请改用LocalDateTime。
         */
        String date = LocalDate.parse("2014-05-04").format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(date);
    }
}
