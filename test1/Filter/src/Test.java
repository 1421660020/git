import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pojo.Person;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2021/12/9 6:45
 * @Version 1.0
 */
public class Test {
    @org.junit.Test
    public void test() {
        Gson gson = new Gson();
        Person person = new Person(1, "张三");
        String person_json = gson.toJson(person);
        System.out.println(gson.fromJson(person_json, Person.class));
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person);
        Map<Integer, Person> m = new HashMap<>();
        m.put(1, person);
        m.put(2, person);

        List<Person> l = gson.fromJson(gson.toJson(list), new TypeToken<List<Person>>() {
        }.getType());
        Iterator<Person> i = l.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        Map<Integer, Person> p = gson.fromJson(gson.toJson(m), new TypeToken<Map<Integer, Person>>() {
        }.getType());

        Iterator<Map.Entry<Integer,Person>> i1 = p.entrySet().iterator();
        while (i1.hasNext()) {
            System.out.println(i1.next());
        }
    }

    public static void main(String[] args) {
        Producter producter1=new Producter();
        producter1.setThreadName("1");
        Producter producter2=new Producter();
        producter2.setThreadName("2");
        Producter producter3=new Producter();
        producter1.setThreadName("3");
        Consumer consumer1=new Consumer();
        consumer1.setThreadName("1");
        Consumer consumer2=new Consumer();
        consumer2.setThreadName("2");
        producter1.start();
        producter2.start();
        producter3.start();
        consumer1.start();
        consumer2.start();
//        ThreadPoolExecutor threadPoolExecutor;
//
//        ExecutorService es = Executors.newFixedThreadPool(10);
//        threadPoolExecutor = (ThreadPoolExecutor) es;
//        for (int i = 0; i < 20; i++) {
//            es.execute(new Runnable() {
//                @Override
//                public void run() {
//                   wThread.currentThread().getName());
//                }
//            });
//        }


    }
}
