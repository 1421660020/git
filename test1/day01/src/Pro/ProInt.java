package Pro;


import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author Administrator
 * @Date 2021/9/13 6:49
 * @Version 1.0
 */

public interface ProInt {
    Function<String, Integer> f = (i) -> Integer.parseInt(i + 2);

    default void method1() {
        System.out.println("method1()");
        System.out.println(f.apply("12"));
    }

    static void method2() {
        System.out.println("method2()");
    }
}

class ProInter implements ProInt {

    public static void main(String[] args) {
        new ProInter().method1();
        ProInt.method2();
        Comparator<Integer> c = Integer::compare;
        System.out.println(c.compare(121, 23));
        Consumer<String> s = System.out::println;
        s.accept("拉萨大四的哈斯u的话");
        Integer[] a = {1, 2, 3, 4, 5};
        Predicate<Integer[]> p = (integers) -> {
            for (Integer i : a) {
                if (i > 3) return true;
            }
             return false;
        };
        System.out.println(p.test(a));

    }


}
