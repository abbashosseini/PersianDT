package Example.generate;

import com.hosseini.persian.dt.PersianDT;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by abbas on 3/30/16.
 */
public class useitLikeBuilderpattern {

    static int day;
    static int year;
    static int month;

    public static void main(String[] s) {

        // in java 8
        /*
        * if you wanna use method refrence like System.out::println
        * no need implment callback or create anonymous Callbacks Objects
        * */
        int random = new Random().nextInt(49);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);

        //Lambda
        PersianDT
                .Instance()
                .generate(new Date(), "{DATE}")
                .CallBack(date -> System.out.println(date))
                .Separator("_")
                .generateFullDate();

        random = new Random().nextInt(49);
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());
        //method reference
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(System.out::println)
                .Separator("--")
                .generateWithMonthName();

        random = new Random().nextInt(500);
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE, random);
        format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime());

        ////use for other JDK version
        PersianDT
                .Instance()
                .generate(format, "{DATE}")
                .CallBack(date -> System.out.println(date))
                .Separator(" | ")
                .generateWithMonthName();


    }

}

