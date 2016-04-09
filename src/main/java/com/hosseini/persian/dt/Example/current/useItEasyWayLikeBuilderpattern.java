package com.hosseini.persian.dt.Example.current;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

import java.util.Date;

/**
 * Created by abbas on 3/30/16.
 */
public class useItEasyWayLikeBuilderpattern implements CallBack {

    public static void main(String[] strings) {


        new useItEasyWayLikeBuilderpattern().date();
    }

    public void date() {


        //Today id 1395/1/21
        PersianDT
                .Instance()
                .generate(new Date(), "{DATE}")
                .CallBack(System.out::println)
                .Separator("/")
                .generateWithMonthName();


        System.out.println();

        //if you use java8 you may like this more kind of callbacks

        PersianDT
                .Instance()
                .generate(new Date(),"Wendsday equle to {DATE} in Persian.")
                .Separator("/")
                        //use methiod reference
                        //for example System.out::println
                .CallBack(System.out::println)
                .generateWithMonthName();

        System.out.println();

        PersianDT
                .Instance()
                .generate(new Date(),"Current persian date in your device is {DATE} witout year.")
                .CallBack(this)
                .generateWithoutYear();


    }

    @Override
    public void onReceive(String date) {
        System.out.println(date);
    }
}
