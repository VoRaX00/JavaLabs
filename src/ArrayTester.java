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

    }

    public static boolean isLatin(int [][] square) {
        int [] numbers;
        for(int i = 0; i < square.length; i++) {
            for(int j = 0; j < square[0].length; j++) {

            }
        }
    }
}
