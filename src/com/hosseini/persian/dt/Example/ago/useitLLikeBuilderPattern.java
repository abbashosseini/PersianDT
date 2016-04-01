package com.hosseini.persian.dt.Example.ago;

import com.hosseini.persian.dt.PersianDT;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by abbas on 3/30/16.
 */
public class useitLLikeBuilderPattern {

    public static void main(String[] strings) {

        String format = "2016-01-11 00:00:00";

        //Lambda
        PersianDT
                .Instance()
                .Ago(format, "{DATE}")
                .CallBack(date -> System.out.println(date))
                .parse();


        //method refr3nce
        PersianDT
                .Instance()
                .Ago(format, "{DATE}")
                .CallBack(System.out::println)
                .parse();

    }
}
