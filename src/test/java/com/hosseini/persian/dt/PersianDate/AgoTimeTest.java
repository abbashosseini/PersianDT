package com.hosseini.persian.dt.PersianDate;

import com.hosseini.persian.dt.PersianDT;
import com.hosseini.persian.dt.PersianDate.enumCollections.AgoFomat;
import junit.framework.TestCase;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by abbas on 4/9/16.
 */
public class AgoTimeTest extends TestCase {

    public String getdateFrompass(int days){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        //back to 24 hour ago
        cal.add(Calendar.DATE, days);
        //minus one hour to 25%24 == 1 day ago (YesTerDay)
        cal.add(Calendar.HOUR, -1);
        //minus to keep hour format correct
        cal.add(Calendar.MINUTE, -1);
        return dateFormat.format(cal.getTime());

    }

    public void testFormat() throws Exception {


        String yesterday = PersianDT.Instance().Ago(getdateFrompass(-1), "{DATE}").format();
        Assert.assertEquals(yesterday, String.format("%s", AgoTime.YESTERDAY));

        String twoDayAgo = PersianDT.Instance().Ago(getdateFrompass(-2), "{DATE}").format();
        Assert.assertEquals(twoDayAgo, String.format("%d %s %s", 2, AgoFomat.day.getFormatname(), AgoTime.Extenion));

        String oneMonthAgo = PersianDT.Instance().Ago(getdateFrompass(-31), "{DATE}").format();
        Assert.assertEquals(oneMonthAgo, String.format("%d %s %s", 1, AgoFomat.month.getFormatname(), AgoTime.Extenion));

        String oneYearAgo = PersianDT.Instance().Ago(getdateFrompass(-365), "{DATE}").format();
        Assert.assertEquals(oneYearAgo, String.format("%d %s %s", 1, AgoFomat.year.getFormatname(), AgoTime.Extenion));

        String hour = PersianDT.Instance().Ago(getdateFrompass(0), "{DATE}").format();
        Assert.assertEquals(hour, String.format("%d %s %s", 1, AgoFomat.hour.getFormatname(), AgoTime.Extenion ));




    }
}