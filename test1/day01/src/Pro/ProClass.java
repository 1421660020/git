package Pro;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2021/9/13 6:35
 * @Version 1.0
 */
public class ProClass {
    interface Human {
        char getSex();

        String getName(String name);
    }

    class Man implements Human {

        @Override
        public char getSex() {
            return '男';
        }

        @Override
        public String getName(String name) {
            return name;
        }
    }

    static class ProxyFactory {
        public static Object newInstance(Object o) {
            MyInva m = new MyInva();
            m.bind(o);
            return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(), m);
        }

    }

    public void info() {
        System.out.println("*************");
    }

    static class MyInva implements InvocationHandler {
        Object object;

        public void bind(Object object) {
            this.object = object;
        }


        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            ProClass p = new ProClass();
            p.info();
            Object returnValue = method.invoke(object, args);
            p.info();
            return returnValue;
        }
    }

    @Test
    public void test() {
        System.out.println(Stream.of("张三", "李四", "王五").count());
        ArrayList<Integer> a=new ArrayList<>();
        Stream.generate(()->(int)(Math.random()*9)+1).limit(10).forEach(a::add);
        a.forEach(System.out::println);
        BiPredicate<String,String> b=String::equals;
        System.out.println(b.test("abc", "abs"));
        a.stream().reduce(Integer::sum);

    /*    List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        List<Integer> l1 = filter(l, integer -> !(integer > 3));
        System.out.println(l1);*/
        Man m = new Man();
        Human hm = (Human) ProxyFactory.newInstance(m);
        String s = hm.getName("张三");
        System.out.println(s);
        System.out.println(hm.getSex());

    }
    @Test
    public void test1(){
        Instant i=Instant.parse("2020-09-29T13:57:18.090Z");
        LocalDateTime l=LocalDateTime.now();
        System.out.println(l);
        l=LocalDateTime.parse("2020-01-01 13:00:01",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(l);
        System.out.println(i);

    }

    public List<Integer> filter(List<Integer> orignlist, Predicate<Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : orignlist) {
            if (p.test(i))
                newList.add(i);
        }
        return newList;
    }
}
