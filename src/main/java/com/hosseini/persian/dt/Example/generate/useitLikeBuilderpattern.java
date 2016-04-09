package com.hosseini.persian.dt.Example.generate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by abbas on 3/30/16.
 */
public class useitLikeBuilderpattern {

    public static void main(String[] s) {

        // in java 8
        /*
        * if you wanna use method refrence like System.out::println
        * no need implment callback or create anonymous Callbacks Objects
        * */
        int random = new Random().nextInt(12);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());

        //Lambda
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(date -> System.out.println(date))
                .Separator("_")
                .generateFullDate();


        //method reference
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(System.out::println)
                .Separator("--")
                .generateWithMonthName();


        ////use for other JDK version
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(new CallBack() {
                    @Override
                    public void onReceive(String date) {
                        System.out.println(date);
                    }
                })
                .Separator(" | ")
                .generateWithMonthName();


    }

}
