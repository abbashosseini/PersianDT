package com.hosseini.persian.dt.PersianDate;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Copyright (C) 2015 Abbashosseini
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

final class CCalender {

    /*There are 3 parameters for a CAS operation: (Compare and Swap (Atomic))

    1. A memory location V where value has to be replaced
    2. Old value A which was read by thread last time
    3. New value B which should be written over V*/

    private final AtomicInteger date  = new AtomicInteger();
    private final AtomicInteger month = new AtomicInteger();
    private final AtomicInteger year  = new AtomicInteger();

    //Thread Confinement
    private final ThreadLocal<Date> holder = new ThreadLocal<>();
    private final ThreadLocal<Calendar> calendar = new ThreadLocal<>();


    /**
     * Constructs a new CCalendar.
     */
    public CCalender() {
        this(new Date());
    }

    protected CCalender(Date date) {

        /*
        * protect the mutable reference by defensive-copies
        * */

        holder.set(new Date(date.getTime()));
        this.calendar.set(Calendar.getInstance());
        CalendarCalc(holder.get());


    }

    /**
     * Getter for property 'date'.
     *
     * @return Value for property 'date'.
     */
    protected AtomicInteger getDate() {
        return date;
    }

    /**+
     * @return AtomicInteger
     */
    public AtomicInteger getMonth() {
        return month;
    }

    /**+
     * @return AtomicInteger
     */
    public AtomicInteger getYear() {
        return year;
    }

    /**
     * Setter for property 'date'.
     *
     * @param date Value to set for property 'date'.
     */

    protected void setDate(int date) {
        this.date.set(date);
    }

    private void CalendarCalc(Date d) {

        holder.set(d);

        calendar.get().setTime(holder.get());

        int ld;
        int miladiYear = calendar.get().get(Calendar.YEAR);
        int miladiMonth = calendar.get().get(Calendar.MONTH) + 1;
        int miladiDate = calendar.get().get(Calendar.DAY_OF_MONTH);

        int[] buf1 = new int[12];
        int[] buf2 = new int[12];

        buf1[0] = 0;
        buf1[1] = 31;
        buf1[2] = 59;
        buf1[3] = 90;
        buf1[4] = 120;
        buf1[5] = 151;
        buf1[6] = 181;
        buf1[7] = 212;
        buf1[8] = 243;
        buf1[9] = 273;
        buf1[10] = 304;
        buf1[11] = 334;

        buf2[0] = 0;
        buf2[1] = 31;
        buf2[2] = 60;
        buf2[3] = 91;
        buf2[4] = 121;
        buf2[5] = 152;
        buf2[6] = 182;
        buf2[7] = 213;
        buf2[8] = 244;
        buf2[9] = 274;
        buf2[10] = 305;
        buf2[11] = 335;

        if ((miladiYear % 4) != 0) {
            date.set(buf1[miladiMonth - 1] + miladiDate);

            if (date.get() > 79) {
                date.set(date.get() - 79);
                if (date.get() <= 186) {
                    switch (date.get() % 31) {
                        case 0:
                            month.set(date.get() / 31);
                            date.set(31);
                            break;
                        default:
                            month.set((date.get() / 31) + 1);
                            date.set(date.get() % 31);
                            break;
                    }
                    year.set(miladiYear - 621);
                } else {
                    date.set(date.get() - 186);

                    switch (date.get() % 30) {
                        case 0:
                            month.set((date.get() / 30) + 6);
                            date.set(30);
                            break;
                        default:
                            month.set((date.get() / 30) + 7);
                            date.set(date.get() % 30);
                            break;
                    }
                    year.set(miladiYear - 621);
                }
            } else {
                if ((miladiYear > 1996) && (miladiYear % 4) == 1) {
                    ld = 11;
                } else {
                    ld = 10;
                }
                date.set(date.get() + ld);

                switch (date.get() % 30) {
                    case 0:
                        month.set((date.get() / 30) + 9);
                        date.set(30);
                        break;
                    default:
                        month.set((date.get() / 30) + 10);
                        date.set(date.get() % 30);
                        break;
                }
                year.set(miladiYear - 622);
            }
        } else {
            date.set(buf2[miladiMonth - 1] + miladiDate);;

            if (miladiYear >= 1996) {
                ld = 79;
            } else {
                ld = 80;
            }
            if (date.get() > ld) {
                date.set(date.get() - ld);

                if (date.get() <= 186) {
                    switch (date.get() % 31) {
                        case 0:
                            month.set(date.get() / 31);
                            date.set(31);
                            break;
                        default:
                            month.set((date.get() / 31) + 1);
                            date.set(date.get() % 31);
                            break;
                    }
                    year.set(miladiYear - 621);
                } else {
                    date.set(date.get() - 186);

                    switch (date.get() % 30) {
                        case 0:
                            month.set ((date.get() / 30) + 6);
                            date.set(30);
                            break;
                        default:
                            month.set ((date.get() / 30) + 7);
                            date.set(date.get() % 30);
                            break;
                    }
                    year.set(miladiYear - 621);
                }
            } else {
                date.set(date.get() + 10);

                switch (date.get() % 30) {
                    case 0:
                        month.set((date.get() / 30) + 9);
                        date.set(30);
                        break;
                    default:
                        month.set((date.get() / 30) + 10);
                        date.set(date.get() % 30);
                        break;
                }
                year.set(miladiYear - 622);
            }

        }
    }

}