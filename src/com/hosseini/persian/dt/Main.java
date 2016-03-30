package com.hosseini.persian.dt;

import com.hosseini.persian.dt.PersianDate.Iface.CallBack;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main implements CallBack {

    public static void main(String[] args) {

        new Main().date();
    }

    public void date(){

        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        PersianDT
                .Instance()
                .generate("2015-13-09 00:00:00", "date is {DATE} !")
                .CallBack(this)
                .Separator(",")
                .generateWithoutYear();

//        PersianDT
//                .Instance()
//                .Current("date is {DATE} !")
//                .Separator(" ")
//                .CallBack(this)
//                .WithoutYear();

    }

    @Override
    public void onReceive(String date) {
        System.out.println(date);
    }
}
