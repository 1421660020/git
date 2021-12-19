package Sort;


import org.junit.Test;

import java.io.Serializable;


/**
 * @Author Administrator
 * @Date 2021/8/30 6:38
 * @Version 1.0
 */

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = -6849794454667710L;
    private String name;
    private char sex;
    private int age;

    public int getAge() {
        return age;
    }

    public Person() {
    }

    private Person(Object... o) {
        switch (o.length) {
            case 3:
                this.age = (int) o[2];
            case 2:
                this.sex = (char) o[1];
            case 1:
                this.name = (String) o[0];
        }
    }

    Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    @Test
    public void test1() {
        System.out.println(new Person("王五",'男'));

       /* Instant instant = Instant.now();
        System.out.println(instant);
        EnumTest e = EnumTest.valueOf("personFirst");
        System.out.println(e);
        ExecutorService e3 = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor e4 = (ThreadPoolExecutor) e3;
        e4.execute(() -> System.out.println("拉拉啦"));
*/

        //  System.out.println(new Person("abc", '男', 12).compareTo(new test.CodeBase());
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge())
            return -1;
        else return 0;
    }
}
