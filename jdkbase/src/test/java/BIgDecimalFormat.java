import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description
 * @Author wangkun
 * @Date 2024/8/8
 */
public class BIgDecimalFormat {

    @Test
    public  void test(){
        DecimalFormat decimalFormat2 = new DecimalFormat("0");
        System.out.println(decimalFormat2.format(new BigDecimal("1")));
        System.out.println(decimalFormat2.format(new BigDecimal("1.01")));
        System.out.println(decimalFormat2.format(new BigDecimal("2.1")));
        System.out.println(decimalFormat2.format(new BigDecimal("0.02")));
        System.out.println(decimalFormat2.format(new BigDecimal("10")));

    }
}
