package com.hosseini.persian.dt.Example.ago;

import com.hosseini.persian.dt.PersianDT;

/**
 * Created by abbas on 3/30/16.
 */
public class useitLLikeBuilderPattern {

    public static void main(String[] strings) {

        String format = "2016-04-04 14:15:00";

        //Lambda
        PersianDT
                .Instance()
                .Ago(format, "{DATE}")
                .CallBack(date -> System.out.println(date))
                .parse();

        format = "2015-01-11 00:00:00";


        //method refr3nce
        PersianDT
                .Instance()
                .Ago(format, "{DATE}")
                .CallBack(System.out::println)
                .parse();

        format = "2015-11-11 04:00:00";
        String Custom = PersianDT.Instance().Ago(format, "{DATE}").format();
        System.out.println(Custom);
    }
}
