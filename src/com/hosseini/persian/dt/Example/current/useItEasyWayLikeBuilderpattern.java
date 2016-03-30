package com.hosseini.persian.dt.Example.current;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Iface.CallBack;

/**
 * Created by abbas on 3/30/16.
 */
public class useItEasyWayLikeBuilderpattern implements CallBack {

    public static  void main(String[] strings){


        new useItEasyWayLikeBuilderpattern().date();
    }

    public void date(){

        PersianDT
                .Instance()
                .Current("Current date is {DATE} .")
                .Separator("|")
                .CallBack(this)
                .WithMonthName();

        System.out.println();

        PersianDT
                .Instance()
                .Current("Today {DATE} in Iran.")
                .Separator("#")
                .CallBack(new CallBack() {
                    @Override
                    public void onReceive(String date) {
                        //Another way to use CallBacks
                        System.out.println(date);
                    }
                })
                .WithDigit();

        System.out.println();

        //if you use java8 you may like this more kind of callbacks

        PersianDT
                .Instance()
                .Current("Wendsday equle to {DATE} in Persian.")
                .Separator("/")
                 //use methiod reference
                 //for example System.out::println
                .CallBack(System.out::println)
                .WithDayName();

        System.out.println();

        PersianDT
                .Instance()
                .Current("Current persian date in your device is {DATE} witout year.")
                .Separator("`")
                .CallBack(this)
                .WithoutYear();


    }

    @Override
    public void onReceive(String date) {
        System.out.println(date);
    }
}
