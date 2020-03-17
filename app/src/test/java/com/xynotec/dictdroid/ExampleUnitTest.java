package com.xynotec.dictdroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        timeConversion("07:00:59PM");
    }

    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        String fmt = s.substring(8, 10);
        String time = s.substring(0, 8);
        String minsec = time.substring(2, 8);
        if (fmt.compareTo("AM") == 0)
        {
            String hourStr = s.substring(0, 2);
            int hour = Integer.valueOf(hourStr);
            if (hour == 12)
                return String.format("00%s", minsec);
            return time;
        }
        else
        {
            String hourStr = s.substring(0, 2);
            int hour = Integer.valueOf(hourStr);

            if (hour == 12)
                return String.format("12%s", minsec);
            else {
                hour += 12;
                return String.format("%d%s", hour, minsec);
            }

        }

    }
}