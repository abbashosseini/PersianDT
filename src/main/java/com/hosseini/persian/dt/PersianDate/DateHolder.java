package com.hosseini.persian.dt.PersianDate;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * CallBack Pattern
 * <p>
 * this CallBack Here can you access it from subClasses
 * no need to create one any more nedd it use it
 * </p>
 */

public final class DateHolder{

    private final Date generateDate;

    DateHolder(String d){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        generateDate = dateFormat.parse(d, new ParsePosition(0));
    }

    public Date getGenerateDate(){
        return new Date(this.generateDate.getTime());
    }

}
