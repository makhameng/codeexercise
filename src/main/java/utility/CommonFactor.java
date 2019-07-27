package utility;

import java.util.Arrays;

public class CommonFactor {

    public int highestCommonFactor(int[] numbers) {
    if(numbers.length <= 1){
        return  numbers.length == 1 ? numbers[0] : 0;
    }

    int midPoint = numbers.length / 2;
    int lower = highestCommonFactor(Arrays.copyOfRange(numbers,0 , midPoint));
    int upper = highestCommonFactor(Arrays.copyOfRange(numbers,midPoint, numbers.length ));

        return getHighestFactor(lower, upper);
    }

    public int getHighestFactor(int j, int i){
        int limit = i >= j ? j : i;
        int count = 1;
        int highestCommonFactor = 1;

        while (count <= limit){
            if(j % count == 0 && i % count == 0){
                highestCommonFactor = count > highestCommonFactor && count > 1 ? count : highestCommonFactor;
            }
            count++;
        }

        return  highestCommonFactor;
    }
}
