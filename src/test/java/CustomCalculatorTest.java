
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        assertTrue(result==25); //이안규
        assertThat(result, is(25));                                //최지원
        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        assertFalse(result == 12); //이안규
        assertThat(result, equalTo(13));                        //최지원
        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        assertTrue(result == 45); //이안규
        assertSame(result, 45);                                   //최지원
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test(expected = ArithmeticException.class)                                 //최지원
    public void divide() {
        customCalculator = new CustomCalculator()
        int result = customCalculator.divide(25,5);
        assertThat(result,is(5)); //이안규
        result = customCalculator.divide(25,0);                             //최지원
        System.out.println("result :: " + result);
    }
}