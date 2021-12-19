package Sort;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @Date 2021/11/14 1:27
 * @Version 1.0
 */
public class DrawCard {
    @Test
    public BigDecimal test(int num) {
       // num=num+2;
        if (num < 0 || num > 90) throw new RuntimeException("你输入的数据不合法");
        BigDecimal probability = new BigDecimal(1);
        BigDecimal temp = new BigDecimal(0.006);
        for (int i = 1; i <= num; i++) {
            if (i != num) {
                if (i < 74) {
                    probability = probability.multiply(new BigDecimal(1).subtract(temp));

                } else {
                    temp = new BigDecimal(i - 73).multiply(new BigDecimal(0.06).add(new BigDecimal(0.006)));
                    probability = probability.multiply(new BigDecimal(1).subtract(temp));
                }
            } else {
                if (i < 74) {
                    System.out.println(probability);
                    probability = probability.multiply(temp);

                } else {
                    temp = new BigDecimal(i - 73).multiply(new BigDecimal(0.06).add(new BigDecimal(0.006)));
                    probability = probability.multiply(temp);

                }
            }

        }

        System.out.println("出现这种情况的概率："+probability);
        return temp;
}

    public static void main(String[] args) {
        DrawCard d = new DrawCard();
        System.out.println("出货时的抽卡概率："+d.test(81));
    }


}
