package Sort;

/**
 * @Author Administrator
 * @Date 2021/8/30 13:24
 * @Version 1.0
 */
public enum EnumTest {
    personFirst("张三",17),
    personSecond("李四",18),
    personThird("王五",19);

    private String name;
    private int age;

    @Override
    public String toString() {

        return "EnumTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    EnumTest(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
