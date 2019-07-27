package utility;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommonFactorTest {

    private  CommonFactor commonFactor;
    private  int[] numbers;

    @BeforeAll
    public void setUp(){
        commonFactor = new CommonFactor();
        numbers = new int[]{15,40,60,10};

    }

    /**
     * Test the method which Find the highest common factor
     * (https://en.wikipedia.org/wiki/Greatest_common_divisor) for a given array of integers
     */
    @Test
    void highestCommonFactor() {
        int highest = commonFactor.highestCommonFactor(numbers);
        System.out.println(highest);
        assertEquals(5,highest);
    }

    @Test
    void getHighestFactor() {
        int highest = commonFactor.getHighestFactor(60,80);
        System.out.println(highest);
        assertEquals(20,highest);

    }
}