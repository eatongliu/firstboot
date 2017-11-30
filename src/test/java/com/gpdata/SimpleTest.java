package com.gpdata;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuyutong on 2017/10/30.
 */
public class SimpleTest {

    @Test
    public void test1() {
        int type = 0;
        double loanAmount = 100000.00;
        int totalDays = 365;
        int day = 10;
        double rate = 0.00045;

        double groupDay = (double) totalDays / (double) day;
        int periods = (int) Math.ceil(groupDay);

        Map<Integer, Object> rateMap = new HashMap<>();
        Map<Integer, Object> accountMap = new HashMap<>();
        Map<Integer, Object> repayMap = new HashMap<>();

        double total = 0.00;
        double amount = loanAmount;
        for (int i = 0; i < periods; i++) {
            if (type == 1) {
                day = getDaysOfMonth(i + 1);
                groupDay = 12;
            }
            accountMap.put(i, amount);
            if (amount <= 0) break;
            double rateVal = (amount * rate) * day;
            total += rateVal;
            double repay = 100000.00 / groupDay;
            amount = amount - repay;
            rateMap.put(i, rateVal);
            repayMap.put(i, rateVal + repay);
        }
        System.out.println(total);
    }

    public static int getDaysOfMonth(int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, i - 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    @Test
    public void test2() {
        System.out.println(15 >> 1);
    }

    @Test
    public void testCard() {
        double price = 5.0;
        double sum = 0.0;
        for (int i = 0; i < 44; i++) {
            double temp = price;
            if (sum > 150) {
                System.out.println("额度超过150，次数为：" + (i+1));
                temp = price * 0.5;
            }else if (sum > 100) {
                System.out.println("额度超过100，次数为：" + (i+1));
                temp = price * 0.8;
            }
            sum += temp;
        }
        System.out.println("每月花费为：" + sum);
    }
}
