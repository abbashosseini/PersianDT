package com.hosseini.persian.dt.Example.ago;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by abbas on 3/30/16.
 */
public class useitLLikeBuilderPattern {

    public static void main(String[] strings){

        int random = new Random().nextInt(20);
        Calendar cal= Calendar.getInstance();
        cal.roll(Calendar.DATE, random);

        String format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());

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
