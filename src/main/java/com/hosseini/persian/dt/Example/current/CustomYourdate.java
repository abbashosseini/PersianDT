package com.hosseini.persian.dt.Example.current;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Current;

/**
 * Created by abbas on 3/30/16.
 */
public class CustomYourdate {

    public static void main(String[] strings) {

        new CustomYourdate().date();
    }

    public void date() {

        Current current = PersianDT
                .Instance()
                .Current("{DATE}")
                .Separator("-");

        System.out.println(
                String.format(
                        "%s/%s/%s",
                        current.Year(),
                        //return Month as int
                        current.monthDigit(),
                        current.Day()
                )
        );

        System.out.println(
                String.format(
                        "%s-%s-%s",
                        current.Year(),
                        //return Month as String
                        current.Day(),
                        current.monthName()
                )
        );


        System.out.println(
                String.format(
                        "%s-%s-%s -> %s",
                        current.Year(),
                        //return Month as String
                        current.monthName(),
                        current.Day(),
                        current.dayName()

                )
        );

        System.out.println(
                current.DigitAndLetters()
        );

        System.out.println(
                current.fullDigit()
        );

        System.out.println(
                current.MonthAndDay()
        );

    }

}
