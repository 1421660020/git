package test.StringTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author Administrator
 * @Date 2021/8/28 9:44
 * @Version 1.0
 */
public class SimpleDate {


    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = s.parse("2021-8-23");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int day = (int) ((System.currentTimeMillis() - d.getTime()) / (1000 * 60 * 60 * 24) + 1);
        System.out.println(day);
        int temp = day / 5;
        int fish = 0;
        int wang = 0;
        switch (day % 5) {
            case 1:
                fish = temp * 3 + 1;
                wang = temp * 2;
                break;
            case 2:
                fish = temp * 3 + 2;
                wang = temp * 2;
                break;
            case 3:
                fish = temp * 3 + 3;
                wang = temp * 2;
                break;
            case 4:
                fish = temp * 3 + 3;
                wang = temp * 2 + 1;
                break;
            case 0:
                fish = temp * 3;
                wang = temp * 2;
                break;
        }
        System.out.println("打鱼天数: " + fish + "\t晒网天数: " + wang);

    }
    @Test
    public void testI(){
        int i1=900;
        Integer i2= 900;
        Character c1='a';
        final String s="a";
         String s1=s+"b";
        String s3="ab";

        LocalDateTime d=LocalDateTime.now();
       d= d.withHour(23);
       // LocalDateTime  d1=LocalDateTime.of(2020,10,10,10,01,1);
       // LocalDateTime  d2= d.minusHours(1);
        Character c2='a';
        DateTimeFormatter d2=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime z= ZonedDateTime.now();
        //Date d3=new Date(d.get());

        LocalDateTime d1=LocalDateTime.parse("2020-01-01T13:00:00");
        LocalDate d3=LocalDate.parse("2017-01-01");
      //  d1=LocalDateTime.now();
      //  System.out.println(d1.atZone(ZoneId.of("ACT",new HashMap<>())));
        //   LocalTime d3=LocalTime.of(12,1,1);
       // d1.f;
        System.out.println(d3);
    }
}
