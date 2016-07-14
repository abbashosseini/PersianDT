package com.hosseini.persian.dt.PersianDate;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/**
 * CallBack Pattern
 * <p>
 * this CallBack Here can you access it from subClasses
 * no need to create one any more nedd it use it
 * </p>
 */

public final class DateHolder{

    private final AtomicReference<Date> generateDate = new AtomicReference<>();

    DateHolder(final String d){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        final Date dateContainDateObject = dateFormat.parse(d, new ParsePosition(0));
        this.generateDate.set(dateContainDateObject);
    }

    public Date getGenerateDate(){
        return this.generateDate.get();
    }

}
