package com.hosseini.persian.dt.Example.generate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Generate;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by abbas on 3/30/16.
 */
public class CustomDate {

    public static void main(String[] s) {


        String format = format(Calendar.DATE, -7);

        // dot it separately
        Generate generate = PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .Separator("->");

        System.out.println(generate.getWithFullDateInDigits());
        System.out.println(generate.getDayDigit());
        System.out.println(generate.getDayName());
        System.out.println(generate.getMonthAndDay());
        System.out.println(generate.getJustMonthDigit());
        System.out.println(generate.getWithMonthName());


        //defualt format (one time)

        format = format(Calendar.MONTH, -1);
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(System.out::println)
                .Separator("/")
                .generateWithMonthName();

        // all you can see i seperate alll too one by one you custom your dates .

    }

    public static String format(int format, int minus){
        Calendar cal = Calendar.getInstance();
        cal.add(format, minus);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
    }
}
