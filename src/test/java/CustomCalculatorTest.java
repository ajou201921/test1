
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CustomCalculatorTest {

    private CustomCalculator customCalculator;

    //더하기 테스트 작성
    @Test
    public void add() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.add(10,15);
        //assertThat(result,is(5)); //틀렷다고 나옴 답은 25이기 때문임.
        //assertThat(result,is(25)); // 답이 25이기 때문에 맞은것,
        assertTrue(result==25); // 답이 25이기때문에 true임.

        /* 이곳에 테스트 코드를 작성하세요. */
        //assertTrue(result == 5);
        //assertThat(result,is(5));
        System.out.println("result :: " + result);
    }

    //빼기 테스트 작성
    @Test
    public void subtract() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.subtract(23,10);
        //assertThat(result,is(3)); //틀렷다고 나옴 답은 13이기 때문임.
        //assertThat(result,is(13)); // 답이 13이기 때문에 맞은것,
        assertTrue(result==13); // 답이 13이기때문에 true임.
        //assertFalse(result==13); // 답이 13이라서 오류가 뜸 조건이 false가 되어야함.
        /* 이곳에 테스트 코드를 작성하세요. */
        //assertTrue(result == 13);
        //assertThat(result,is(5));
        System.out.println("result :: " + result);
    }

    //곱하기 테스트 작성
    @Test
    public void multiply() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.multiply(5,9);
        //assertThat(result,is(3)); //틀렷다고 나옴 답은 45이기 때문임.
        //assertThat(result,is(45)); // 답이 45이기 때문에 맞은것,
        assertTrue(result==45); // 답이 45이기때문에 true임.
        //assertFalse(result==45); // 답이 45이라서 오류가 뜸 조건이 false가 되어야함.
        /* 이곳에 테스트 코드를 작성하세요. */
        //assertTrue(result == 45);
        //assertThat(result,is(45));
        System.out.println("result :: " + result);
    }

    //나누기 테스트 작성
    @Test
    public void divide() {
        customCalculator = new CustomCalculator();
        int result = customCalculator.divide(25,5);
        //assertThat(result,is(1)); //틀렷다고 나옴 답은 5이기 때문임.
        //assertThat(result,is(5)); // 답이 5이기 때문에 맞은것,
        assertTrue(result==5); // 답이 5이기때문에 true임.
        //assertFalse(result==5); // 답이 5이라서 오류가 뜸 조건이 false가 되어야함.
        /* 이곳에 테스트 코드를 작성하세요. */
        assertTrue(result==5);
        //assertThat(result,is(5));
        System.out.println("result :: " + result);
    }
}