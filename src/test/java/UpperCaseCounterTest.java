import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;
        int numberOfUpperCaseCharactersInstring = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertThat(numberOfUpperCaseCharactersInstring, is(0));                     //최지원
        assertThat(numberOfUpperCaseCharactersInString,is(0)); //이안규

    //반겂울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";
        int numberOfUpperCaseChartersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        assertThat(numberOfUpperCaseChartersInString,is(0)); //이안규
        assertThat(numberOfUpperCaseCharactersInString, equalTo(0));               //최지원
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";
        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(numberOfUpperCaseCharactersInString==10);  //이안규
        assertThat(numberOfUpperCaseCharactersInString, allOf(greaterThan(9),lessThan(11))); //최지원
        assertThat(numberOfUpperCaseCharactersInString, is(equalTo(10)));
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        assertTrue(result == 6); //이안규
        assertThat(result, is(6));              //최지원
        System.out.println("result :: " + result);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    //@Test(expected = IndexOutOfBoundsException.class) //***********이안규********
    @Test(expected = IndexOutOfBoundsException.class)       //최지원
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(2); //이안규
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    //@Test(timeout = 100000) // ********이안규********
    @Test(timeout = 5000)            //최지원
    public void testShouldRunInLimitedTime() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
    }
}
