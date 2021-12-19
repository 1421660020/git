package pojo;

/**
 * @Author Administrator
 * @Date 2021/12/9 8:09
 * @Version 1.0
 */
public class Person {
    Integer id;
    String name;

    public Person() {
    }

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
