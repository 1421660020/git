package test;

import org.junit.Test;

/**
 * @Author Administrator
 * @Date 2021/8/21 12:13
 * @Version 1.0
 */
abstract  class test  {
    protected  int abc;
    @Test
    public void tes1t(){
        Class s=ProxyPattern.class;
        System.out.println(s.getPackage());
    }
    protected  void testSub() {
        System.out.println("superClass");

    }
    protected   void tes1tSub() {
        System.out.println("superClass");

    }
}
//被代理类
public class ProxyPattern  extends  test implements ProxyInt{

    @Override
    protected void testSub()   {
        System.out.println("subClass");

    }

    @Override
    public void comeFromCity()   {
        testSub();
        System.out.println("************");
        super.testSub();
        System.out.println("我来自江西省");
    }
    @Test
    public void proxyTest(){
        try{
        new Proxy(new ProxyPattern()).who();}
        catch(RuntimeException e){
            System.out.println(e.getMessage());}
    }
}
//代理类
class Proxy implements ProxyInt{

    private ProxyInt pi;
    Proxy(ProxyInt pi){this.pi=pi;}
    @Override
    public void comeFromCity()  {
        System.out.println("我来自江西省");
        System.out.println("1111");
    }
    public void who(){
        System.out.println("我是中国人");
        pi.comeFromCity();
    }
}
