package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.enumCollections.Days;
import com.hosseini.persian.dt.PersianDate.enumCollections.Months;
import org.junit.Assert;
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
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Sun.getDay());

        //2 days later
        //Today
        DATE = "2016-04-05 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 1 17");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 17);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 1);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Tue.getDay());


        //month ago
        DATE = "2016-03-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1394 12 13");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 13);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 12);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1394);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Esfand.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Thu.getDay());


        //one month later
        DATE = "2016-05-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 2 14");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 14);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 2);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Ordibehesht.getMonthAsString());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Tue.getDay());

    }

    @Test
    public void testGetWithMonthName() throws Exception {

        String DATE = "2016-04-04 10:31:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithMonthName(), "1395 فروردین 16");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 16);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());


        DATE = "2015-04-02 10:31:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithMonthName(), "1394 فروردین 13");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 13);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 1);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1394);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());


        DATE = "2010-08-01 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithMonthName(), "1389 مرداد 10");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 10);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 5);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1389);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Mordad.getMonthAsString());


    }

    @Test
    public void testGetMonthAndDay() throws Exception {

        String DATE = "2010-08-01 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getMonthAndDay(), "مرداد 10");
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 10);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 5);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Mordad.getMonthAsString());

        DATE = "2016-04-07 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getMonthAndDay(), String.format("%s %d", Months.Farvardin.getMonthAsString(), 19));
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 19);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), Months.Farvardin.getMonthAsInt());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());

        DATE = "2016-03-26 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getMonthAndDay(), String.format("%s %d", Months.Farvardin.getMonthAsString(), 7));
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 7);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), Months.Farvardin.getMonthAsInt());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Farvardin.getMonthAsString());

        DATE = "2011-11-16 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getMonthAndDay(), String.format("%s %d", Months.Aban.getMonthAsString(), 25));
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 25);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), Months.Aban.getMonthAsInt());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Aban.getMonthAsString());

        DATE = "2008-08-08 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getMonthAndDay(), String.format("%s %d", Months.Mordad.getMonthAsString(), 18));
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 18);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), Months.Mordad.getMonthAsInt());
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Mordad.getMonthAsString());
    }

    @Test
    public void testGetDayName() throws Exception {

        String DATE = "2016-03-26 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 7);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Sat.getDay());


        DATE = "2011-11-16 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 25);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Wed.getDay());

        DATE = "2008-08-08 00:00:00";
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 18);
        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Fri.getDay());

    }

    @Test
    public void testGetDayDigit() throws Exception {

    }

    @Test
    public void testGetYear() throws Exception {

    }
}