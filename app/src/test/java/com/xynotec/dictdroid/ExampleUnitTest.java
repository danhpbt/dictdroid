package com.xynotec.dictdroid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        //timeConversion("07:00:59PM");
        int[] apples = {2, 3, -4};
        int[] oranges = {3, -2, -4};
        countApplesAndOranges(7, 10, 4, 12, apples, oranges);
    }


    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int numA = apples.length;
        int countA = 0;
        for(int i = 0; i < numA; i++)
        {
            if ((a + apples[i] >= s) && (a + apples[i] <= t))
                countA ++;
        }

        int num0 = oranges.length;
        int countO = 0;
        for(int i = 0; i < num0; i++)
        {
            if ((b + oranges[i] >= s) && (b + oranges[i] <= t))
                countO ++;
        }

        System.out.println(countA);
        System.out.println(countO);
    }


    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here

        List<Integer> result = new ArrayList<>();
        int length = grades.size();
        for(int i = 0; i < length; i++)
        {
            int val = grades.get(i).intValue();

            if (val >= 38)
            {
                int mod5 = val % 5;
                if (mod5 >= 3)
                    val = (val/5)*5 + 5;
            }

            result.add(Integer.valueOf(val));
        }

        return result;
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