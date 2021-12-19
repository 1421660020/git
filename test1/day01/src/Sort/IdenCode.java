package Sort;

import org.junit.Test;
import test.ProxyPattern;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @Author Administrator
 * @Date 2021/9/5 22:40
 * @Version 1.0
 */
public class IdenCode {
    public static void main(String[] args) throws Exception {
       /* long startTime = System.currentTimeMillis();
        getFile(1);

        long endTime = System.currentTimeMillis();
        System.out.println("方式一所花时间: " + (endTime - startTime));
        long startTime1 = System.currentTimeMillis();
        getFile(2);
        long endTime1 = System.currentTimeMillis();
        System.out.println("方式二所花时间: " + (endTime1 - startTime1));*/
       /* System.out.println(getCode(4));
        String s = getCode(4);

      *//*  fx<String> a = new fx<>();
        a.info("abc");*//*
        HashMap<Integer, Integer> m = new HashMap<>();
        File f2=new File("");

        for (String s1 : f2.list()) {
            System.out.println(s1);
        }

        m.put(1, 123);
        m.put(3, 223);

        m.put(2, 1323);
        Properties p = new Properties();
        File f=new File("day01/src/test.properties");
        InputStream i = new FileInputStream(f);
        p.load(i);
        System.out.println("name= " + p.getProperty("name") + "\t" + "sex= " + p.getProperty("sex"));*/

        //    getFile();
        //   getGraphic();
        //  System.out.println(m.values());

    }

    /*static void getGraphic() throws IOException {
        InputStream i = new FileInputStream("name.txt");
        BufferedImage b=new BufferedImage();
        byte[] b = new byte[1024];
        int i1=i.read(b);
        while (i1 != -1){
            System.out.println((char)i1);
            i1=i.read(b);
        }

    }*/

    static void getFile(int status) throws IOException {
        InputStream i = new FileInputStream("C:\\Users\\Administrator\\Desktop\\note\\常用命令&基本类型.txt");
        InputStreamReader fo = new InputStreamReader(i);
        Reader r = new FileReader("C:\\Users\\Administrator\\Desktop\\note\\常用命令&基本类型.txt");
        BufferedReader bi = null;
        if (status == 1) {
            bi = new BufferedReader(fo);
        } else if (status == 2) {
            bi = new BufferedReader(r);


        }
        String s;
        Set<Character> set = new HashSet<>();

        while ((s = bi.readLine()) != null) {
            System.out.println(s);
            if ("\n".equals(s))
                set.add(s.charAt(0));

        }
        for (Object o : set) {
            System.out.println(o);
        }


    }

    static String getCode(int num) {
        String code = "";
        Set codeSet = new HashSet();
        List codeList = new ArrayList();
        String codeOrign = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //  String codeOrign = "2134";
        //   System.out.println(codeOrign.length());
        char[] codeOrig = codeOrign.toCharArray();
        //    System.out.println(codeOrig.length);
        //Set接口实现
       /* while (codeSet.size() < num) {
            int index = (int) (Math.random() * codeOrig.length);

            codeSet.add(codeOrig[index]);
        }*/
        //List接口实现
        while (codeList.size() < num) {
            int index = (int) (Math.random() * codeOrig.length);
            if (!codeList.contains(codeOrig[index])) {
                codeList.add(codeOrig[index]);
            }
        }
        for (Object i : codeList) {
            code += i;
        }
        return code;
    }

    @Test
    public void test() throws Exception {
        Class p = ProxyPattern.class;
        //Class p=Person.class;
        //  Constructor c = ;

        //     c.setAccessible(true);
        //     Person per = (Person)p.getDeclaredConstructor(String.class, char.class, int.class).newInstance("张三",'男',19);

        //   Field f = p.getDeclaredField("serialVersionUID");
        Method m = p.getSuperclass().getDeclaredMethod("tes1tSub");
        System.out.println(m);
        System.out.println(p.getSuperclass().getDeclaredField("abc"));
//        for(Method d:declaredMethods){
//            System.out.println(d.getName());
//        }
        //f.setAccessible(true);


        //  f.set(per,12);
        // System.out.println(f.get(per) + "\n" + per);
    }

    @Test
    public void test1() throws IOException, ClassNotFoundException {
        /*double i = 0;

        while (true) {
            if ((4692 + i) >= 0.585 * (8079 +i)) {
                System.out.println(i);
                break;
            }
            i++;
        }

        System.out.println((4692 + 83.0) / (8079 + 83));*/
        Properties p=new Properties();
        try {
            //  p.load(new FileInputStream("./day01/src/test.properties"));
            p.load(IdenCode.class.getClassLoader().getResourceAsStream("test.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(p.getProperty("name"));

    }

}
