package com.dateparser.hosseini.persiantime.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Class for human-readable, pretty date formatting
 * @author Abbas
 */
public class AgoTime {
    private Date date;

    public AgoTime(Date date) {
        this.date = date;
    }

    public static AgoTime getDate(String yourDate) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        Date temp = format.parse(yourDate);

        return new AgoTime(temp);

    }

    public String tostring() {


        long	current = System.currentTimeMillis(),
                timestamp = this.date.getTime(),
                diff = (current - timestamp)/1000;


        int	amount = 0;
        String	what = "";


        if(diff > 31536000) {
            amount = (int)(diff/31536000);
            what = "سال";
        }
        else if(diff > 2592000) {
            amount = (int)(diff/2592000);
            what = "ماه";

        }
        else if(diff > 604800) {
            amount = (int)(diff/604800);
            what = "هفته";

        }
        else if(diff > 86400) {
            amount = (int)(diff/86400);
            what = "روز";
        }
        else if(diff > 3600) {
            amount = (int)(diff/3600);
            what = "ساعت";
        }
        else if(diff > 60) {
            amount = (int)(diff/60);
            what = "دقیقه";
        }
        else {
            amount = (int)(diff);
            return amount + " ثانیه پیش";
        }

        if(amount == 1) {
            if(what.equals("روز")) {
                return "دیروز";
            }
            else if(what.equals("هفته") || what.equals("ماه") || what.equals("سال")) {
                return what+ " پیش " ;

            }
        }

        return amount + " " + what + " پیش ";
    }
}