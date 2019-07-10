import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class UpperCaseCounterTest {

    private UpperCaseCounter upperCaseCounter = new UpperCaseCounter();

    @Test //new Method (1)
    public void given2Strings_whenEqual_thenCorrect() {
        String a = "foo";
        String b = "FOO";
        assertThat(a, equalToIgnoringCase(b));
    }

    @Test //new Method (2)
    public void given2Strings() {
        String a = "foo";
        String b = "FOO";
        assertThat(a,is(b));
    }

    @Test //new Method(3)
    public void getNumberOfLowerCaseCharacterInString_return_4(){
        String str1 = "ABCdefGHI";
        String str2 = "ABCDEFGHIJ";
        String str3 = "abcdefghij";

        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str2)-
                upperCaseCounter.getNumberOfUpperCaseCharactersInString(str1);
        int test_result =upperCaseCounter.getNumberOfUpperCaseCharactersInString(str3);
        assertTrue(test_result == 0);
        System.out.println("test_result :: " + test_result);
        //System.out.println("result :: " + result);

    }

    @Test//new Method(4)
    public void givenArray_allLowerCase_result_0() {
        int result=0;
        String[] array = {"One", "Two","THREE"};
        for(int i=0;i<array.length;i++){
            array[i] =  array[i].toLowerCase();
            result =+ upperCaseCounter.getNumberOfUpperCaseCharactersInString(array[i]);
        }

        assertThat(result, is(0));
        System.out.println("result :: " + result);
    }

    @Test(expected = ArithmeticException.class) //new Method(5)
    public void shouldThrowExceptionWhenGetZero() {
        new Integer(4/0);
    }




    //null을 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_null_input(){
        String str = null;

//        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
    }

    //반겂울 전달했을 때 0을 리턴하는지에 대한 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_0_for_empty_input() {
        String str = "";

//        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
    }

    //대문자들이 포함된 문자열을 전달했을 때 카운팅된 숫자와 맞는지 검증하는 테스트 작성
    @Test
    public void getNumberOfUpperCaseCharactersInString_return_10_for_ABCDEFGHIJ() {
        String str = "ABCDEFGHIJ";

        int numberOfUpperCaseCharactersInString = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);

        //assertTrue로 맞는 테스트 코드 작성
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
    }

    //대소문자가 섞여 있을 때 정확히 카운팅 되는 지에 대한 테스트 코드 작성
    @Test
    public void getNumberOfUpperCaseCharacterInString_return_6_for_ABCdefGHI(){
        String str = "ABCdefGHI";
        int result = upperCaseCounter.getNumberOfUpperCaseCharactersInString(str);
        //assertTrue로 맞는 테스트 코드 작성
        //assertFalse로 틀리는 값을 넣어 테스트 작성
        //assertThat 단정문을 사용해서 True인 테스트 코드 작성
        System.out.println("result :: " + result);
    }

    //잘못된 값을 참조했을 때 IndexOutOfBoundsException Exception이 발생하는지 테스트 코드 작성
    @Test
    public void shouldThrowExceptionWhenGetZeroIndex() {
        new ArrayList<Object>().get(0);
    }

    //해당 메소드가 제한된 시간내에 실행되는지에 대한 테스트 코드 작성 : timeout 사용
    //두번째로 해당 메소드는 테스트 하지 않도록 어노테이션 추가 적용 해봅니다. Ignore
    @Test
    public void testShouldRunInLimitedTime() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("제한된 시간 내에 수행되면 테스트 Passed!");
    }
}
