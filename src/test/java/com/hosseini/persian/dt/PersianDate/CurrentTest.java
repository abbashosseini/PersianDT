//package com.hosseini.persian.dt.PersianDate;
//
//import com.hosseini.persian.dt.PersianDT;
//import com.hosseini.persian.dt.PersianDate.enumCollections.Days;
//import com.hosseini.persian.dt.PersianDate.enumCollections.Months;
//import junit.framework.TestCase;
//import org.junit.Assert;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by abbas on 4/7/16.
// */
//public class CurrentTest extends TestCase {
//
//    //since is deprcate now i don;t add more test for this class
//
//    private final static String MARKDOWN = "{DATE}";
//
//    public void testDigitAndLetters() throws Exception {
//
//        Current current = Assert.assertEquals(PersianDT.Instance().Current(new Date(), MARKDOWN);
//
//        current.Separator("-").DigitAndLetters(), String.format("%d-%s-%d", Cur, Months.Farvardin.getMonthAsString(), 1395));
//        Assert.assertEquals(PersianDT.Instance().Current(new Date(),MARKDOWN).monthName(), Months.Farvardin.getMonthAsString());
//        Assert.assertEquals(PersianDT.Instance().Current(new Date(),MARKDOWN).dayName(), Days.Fri.getDay());
//        Assert.assertEquals(PersianDT.Instance().Current(new Date(),MARKDOWN).monthDigit(), 1);
//        Assert.assertEquals(PersianDT.Instance().Current(new Date(),MARKDOWN).Year(), 1395);
//        Assert.assertEquals(PersianDT.Instance().Current(new Date(),MARKDOWN).Day(), 20);
//
//
//        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date2 = s.parse("2016-08-10 12:00:56");
//
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).DigitAndLetters(), String.format("%d %s %d", 22, Months.Farvardin.getMonthAsString(), 1395));
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).monthName(), Months.Farvardin.getMonthAsString());
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).dayName(), Days.Sun.getDay());
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).Separator("~").Day(), 22);
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).monthDigit(), 1);
//        Assert.assertEquals(PersianDT.Instance().Current(date2, MARKDOWN).Year(), 1395);
//
////
////        //month ago
////        DATE = "2016-03-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1394 12 13");
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 13);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 12);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1394);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Esfand.getMonthAsString());
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Thu.getDay());
////
////
////        //one month later
////        DATE = "2016-05-03 10:31:00"; //۱۳۹۵ ۱ ۱۵
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getWithFullDateInDigits(), "1395 2 14");
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayDigit(), 14);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthDigit(), 2);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getYear(), 1395);
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getJustMonthName(), Months.Ordibehesht.getMonthAsString());
////        Assert.assertEquals(PersianDT.Instance().generate(DATE, MARKDOWN).getDayName(), Days.Tue.getDay());
//
//
//    }
//
//    public void testFullDigit() throws Exception {
//
//    }
//
//    public void testDay() throws Exception {
//
//    }
//
//    public void testDayName() throws Exception {
//
//    }
//
//    public void testMonthName() throws Exception {
//
//    }
//
//    public void testMonthDigit() throws Exception {
//
//    }
//
//    public void testYear() throws Exception {
//
//    }
//
//    public void testMonthAndDay() throws Exception {
//
//    }
//}