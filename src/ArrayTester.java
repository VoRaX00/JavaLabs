import java.util.*;

public class ArrayTester {
    public static int[] getColumn(int [][]arr2d, int c) {
        int [] result = new int[arr2d[0].length];
        for (int i = 0; i < arr2d[0].length; i++) {
            result[i] = arr2d[i][c];
        }
        return result;
    }

    public static boolean hasAllValues(int []arr1, int []arr2) {
        if (arr1.length != arr2.length)
            return false;

        for(int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j] && i != j) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsDuplicates(int []arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                return false;
            } else {
                map.put(j, true);
            }
        }
        return true;
    }

    public static boolean isLatin(int [][] square) {
        if (containsDuplicates(square[0]))
            return false;

        for(int i = 1; i < square.length; i++) {
            if(!hasAllValues(square[0], square[i]) || !hasAllValues(square[0], getColumn(square, i-1))) {
                return false;
            }
        }

        return hasAllValues(square[0], getColumn(square, square[0].length - 1));
    }
}
