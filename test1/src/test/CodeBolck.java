package test;

/**
 * @Author Administrator
 * @Date 2021/8/ @Version 1.0
 */
class CodeBase {
    CodeBase() {
        System.out.println("我是父类的构造方法");

    }

    static {
        System.out.println("我是父类的静态代码块");
    }

    {
        System.out.println("我是父类的非静态代码块");
    }

}

public class CodeBolck extends CodeBase {

    CodeBolck() {
        System.out.println("我是子类的构造方法");
    }

    static {
        System.out.println("我是子类的静态代码块");
    }

    {
        System.out.println("我是子类的非静态代码块");
    }

    static void changeIntger(Integer i, Float f) {
        i += 1;
        f += 1;
    }

    public static void main(String args[]) {
        System.out.println("我是main方法");
        Integer i = 0;
        Float f = 0.0f;
        changeIntger(i,f);
        System.out.println(i+"\t"+f);
        new CodeBolck();
        System.out.println("********************");
        new CodeBolck();
    }
}
