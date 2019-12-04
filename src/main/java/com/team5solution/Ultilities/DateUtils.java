package com.team5solution.Ultilities;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class DateUtils {


    public static void main(String[] args) {
        System.out.println(new DateUtils().getNow());
    }

    public Date getNow() {
        long millis = System.currentTimeMillis();
        return new Date(millis);
    }


}
