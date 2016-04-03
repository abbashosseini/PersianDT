package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.Collections.Days;
import com.hosseini.persian.dt.PersianDate.Collections.Months;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by abbas on 4/3/16.
 */
public class GenerateTest {

    private final static String MARKDOWN = "{DATE}";


    @Test
    public void testGetFulldateinDigits() throws Exception {

        //Today
        String DATE = "2016-04-03 10:31:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 1 15");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 15);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 1);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Jan.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Sun.getDay());

        //2 days later
        //Today
        DATE = "2016-04-05 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 1 17");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 17);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 1);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Jan.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Tue.getDay());


        //month ago
        DATE = "2016-03-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1394 12 13");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 13);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 12);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1394);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Dec.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Thu.getDay());


        //one month later
        DATE = "2016-05-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 2 14");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 14);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 2);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Feb.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Tue.getDay());

    }

    @Test
    public void testGetWithMonthName() throws Exception {



    }

    @Test
    public void testGetWithMonthDigit() throws Exception {

    }

    @Test
    public void testGetMonthAndDay() throws Exception {

    }

    @Test
    public void testGetDayName() throws Exception {

    }

    @Test
    public void testGetDayDigit() throws Exception {

    }

    @Test
    public void testGetYear() throws Exception {

    }
}