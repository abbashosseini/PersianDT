package Example.current;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Generate;

import java.util.Date;

/**
 * Created by abbas on 3/30/16.
 */
public class CustomYourdate {

    public static void main(String[] strings) {

        new CustomYourdate().date();
    }

    public void date() {

        Generate current = PersianDT
                .Instance()
                .generate(new Date(), "{DATE}")
                .Separator("-");

        System.out.println(
                String.format(
                        "%s/%s/%s",
                        current.getYear(),
                        //return Month as int
                        current.getJustMonthDigit(),
                        current.getDayDigit()
                )
        );

        System.out.println(
                String.format(
                        "%s-%s-%s",
                        current.getYear(),
                        //return Month as String
                        current.getDayName(),
                        current.getJustMonthDigit())
                );


        System.out.println(
                String.format(
                        "%s-%s-%s -> %s",
                        current.getYear(),
                        //return Month as String
                        current.getJustMonthDigit(),
                        current.getDayDigit(),
                        current.getDayName()
                )
        );

        System.out.println(
                current.getWithMonthName()
        );

        System.out.println(
                current.getWithFullDateInDigits()
        );

        System.out.println(
                current.getMonthAndDay()
        );

    }

}
