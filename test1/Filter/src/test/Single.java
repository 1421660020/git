package test;

/**
 * @Author Administrator
 * @Date 2021/12/10 16:08
 * @Version 1.0
 */
public class Single {
    private static Single single = new Single();
    private static Single single1 = null;

    public static Single getSingle() {
        return single;
    }

    public static Single getInstance() {

        if (single1 == null) {
            single1 = new Single();
        }
        return single1;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int i1 = 0;
                while (i1 < 100) {
                    System.out.println(Thread.currentThread().getName() + ": " + getInstance());
                    i1++;
                }
            }).start();
        }
    }
}
