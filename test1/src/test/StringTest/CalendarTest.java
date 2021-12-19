package test.StringTest;

import java.util.Calendar;

/**
 * @Author Administrator
 * @Date 2021/8/28 10:31
 * @Version 1.0
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        //System.out.println(c.getClass());
        System.out.println(c.get(Calendar.YEAR) + "年" + (1+c.get(Calendar.MONTH)) + "月" + c.get(Calendar.DAY_OF_MONTH) + "日");

    }

}
