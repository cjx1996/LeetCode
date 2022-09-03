package Test;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @ClassName DataFormat
 * @Description
 * @Author cjx
 * @Date 2022/8/20 20:52
 * @Version 1.0
 */
public class DataFormat {
    /**
     * 结果不精准，原因在于double类型本身就是不精准的
     */
    @Test
    public void test1() {
        DecimalFormat dfScale2 = new DecimalFormat("0.00");

        System.out.println("dfScale2.getRoundingMode()=" + dfScale2.getRoundingMode());

        System.out.println("dfScale2.format(1.125D)=" + dfScale2.format(1.125D));
        System.out.println("dfScale2.format(1.135D)=" + dfScale2.format(1.135D));
        System.out.println("dfScale2.format(1.145D)=" + dfScale2.format(1.145D));
        System.out.println("dfScale2.format(1.225D)=" + dfScale2.format(1.225D));
        System.out.println("dfScale2.format(1.235D)=" + dfScale2.format(1.235D));
        System.out.println("dfScale2.format(1.245D)=" + dfScale2.format(1.245D));

        System.out.println();

        System.out.println("dfScale2.format(2.125D)=" + dfScale2.format(2.125));
        System.out.println("dfScale2.format(2.135D)=" + dfScale2.format(2.135));
        System.out.println("dfScale2.format(2.145D)=" + dfScale2.format(2.145));

        System.out.println("dfScale2.format(2.225D)=" + dfScale2.format(2.225));
        System.out.println("dfScale2.format(2.235D)=" + dfScale2.format(2.235));
        System.out.println("dfScale2.format(2.245D)=" + dfScale2.format(2.245));
        System.out.println();
        System.out.println("BigdfScale2.format(2.125D)=" + dfScale2.format(new BigDecimal("2.125")));
        System.out.println("BigdfScale2.format(2.135D)=" + dfScale2.format(new BigDecimal("2.135")));
        System.out.println("BigdfScale2.format(2.145D)=" + dfScale2.format(new BigDecimal("2.145")));

        System.out.println("BigdfScale2.format(2.225D)=" + dfScale2.format(new BigDecimal("2.225")));
        System.out.println("BigdfScale2.format(2.235D)=" + dfScale2.format(new BigDecimal("2.235")));
        System.out.println("BigdfScale2.format(2.245D)=" + dfScale2.format(new BigDecimal("2.245")));


        System.out.println();

        System.out.println("dfScale2.format(3.125D)=" + dfScale2.format(3.125D));
        System.out.println("dfScale2.format(3.135D)=" + dfScale2.format(3.135D));
        System.out.println("dfScale2.format(3.145D)=" + dfScale2.format(3.145D));
        System.out.println("dfScale2.format(3.225D)=" + dfScale2.format(3.225D));
        System.out.println("dfScale2.format(3.235D)=" + dfScale2.format(3.235D));
        System.out.println("dfScale2.format(3.245D)=" + dfScale2.format(3.245D));

        System.out.println();

        System.out.println("dfScale2.format(4.125D)=" + dfScale2.format(4.125D));
        System.out.println("dfScale2.format(4.135D)=" + dfScale2.format(4.135D));
        System.out.println("dfScale2.format(4.145D)=" + dfScale2.format(4.145D));

        System.out.println("dfScale2.format(4.225D)=" + dfScale2.format(4.225D));
        System.out.println("dfScale2.format(4.235D)=" + dfScale2.format(4.235D));
        System.out.println("dfScale2.format(4.245D)=" + dfScale2.format(4.245D));
    }


}
