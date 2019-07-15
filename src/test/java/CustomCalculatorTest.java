
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator; //원본 클래스의 인스턴스 생성

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(3323,2282);
        System.out.println("result :: " + result);
        assertThat(result, is(5605)); //원동욱
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        System.out.println("result :: " + result);
        assertThat(result, is(13)); //원동욱
        assertFalse(result == 12); //원동욱
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        System.out.println("result :: " + result);
        assertThat(result, is(45)); //원동욱
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        System.out.println("result :: " + result);
        assertThat(result, is(5)); //원동욱
    }
}