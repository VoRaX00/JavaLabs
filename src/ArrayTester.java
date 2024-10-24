import java.util.*;

public class ArrayTester {
    public static int[] getColumn(int [][]arr2d, int c) {
        int [] result = new int[arr2d[c].length];
        for (int i = 0; i < arr2d[0].length; i++) {
            result[i] = arr2d[c][i];
        }
        return result;
    }

    public static boolean hasAllValues(int []arr1, int []arr2) {
        for(int i = 0; i < arr1.length; i++) {
            boolean found = false;
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
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
        return false;
    }

    public static boolean isLatin(int [][] square) {
        int [] numbers = square[0];
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < square.length; i++) {
            for(int j = 0; j < square[i].length; j++) {
                if (!Arrays.asList(Arrays.stream(numbers).boxed().toArray()).contains(square[i][j])) {
                    return false;
                } else {
                    if(map.containsKey(square[i][j])) {
                        Set<Integer> s = map.get(square[i][j]);
                        if(s.contains(j)) {
                            return false;
                        } else {
                            s.add(j);
                            map.put(square[i][j], s);
                        }
                    } else {
                        Set<Integer> set = new HashSet<Integer>();
                        set.add(square[i][j]);
                        map.put(square[i][j], set);
                    }
                }
            }
        }
        return true;
    }
}
