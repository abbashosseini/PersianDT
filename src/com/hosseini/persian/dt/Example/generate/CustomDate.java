package com.hosseini.persian.dt.Example.generate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Generate;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abbas on 3/30/16.
 */
public class CustomDate {

    public static void main(String[] s){

        Calendar cal= Calendar.getInstance();
        cal.add(Calendar.DATE, 7);

        String format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());

        Generate generate = PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .Separator("->");

        System.out.println(generate.getCalendar());
        System.out.println(generate.getDayDigit());
        System.out.println(generate.getDayName());
        System.out.println(generate.getMonthAndDay());
        System.out.println(generate.getWithMonthDigit());
        System.out.println(generate.getWithMonthName());

        // all you can see i seperate alll too one by one you custom your dates .

    }
}
