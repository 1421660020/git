package test;

/**
 * @Author Administrator
 * @Date 2021/8/19 6:10
 * @Version 1.0
 */
public class Sinleton {
    private Sinleton() {
    }

    /**
     * 饿汉模式
     */
    private static Sinleton sinleton=new Sinleton();
    public static Sinleton instance(){
        return sinleton;
    }
    /**
     * 懒汉模式
     */
/*    private static Sinleton sinleton = null;

    public static Sinleton instance() {
        if (sinleton == null) {
            sinleton = new Sinleton();
        }
        return sinleton;
    }*/


}
