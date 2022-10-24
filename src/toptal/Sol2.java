package toptal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sol2 {
    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 3};
        System.out.println(solution(A, 2));
    }

    public static int solution(int[] A, int S) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//
//        for (int i = 0; i < A.length; i++) {
//            map.put(i, A[i]);
//        }
//        int index = 0;
//        for (int i = 0; i < map.size(); i++) {
//            for (int j = i; j < map.size(); j++) {
//
//            }
//            if(map.get(i) == S){
//                count++;
//            }
//        }

//        int chunk = A.length;
//        for (int h = 0; h < chunk; h++) {
//            for (int i = 0; i < A.length; i += chunk) {
//                System.out.println(Arrays.toString(Arrays.copyOfRange(A, i, Math.min(A.length, i + h))));
//            }
//        }


        for (int j = 1; j < A.length; j++) {
            for (int i = 0; i < splitArray(A, 2).length; i++) {
                System.out.println(Arrays.toString(splitArray(A, j)[i]));
            }
        }


        return 0;
    }

    public static int[][] splitArray(int[] arrayToSplit, int chunkSize){
        if(chunkSize<=0){
            return null;  // just in case :)
        }
        // first we have to check if the array can be split in multiple
        // arrays of equal 'chunk' size
        int rest = arrayToSplit.length % chunkSize;  // if rest>0 then our last array will have less elements than the others
        // then we check in how many arrays we can split our input array
        int chunks = arrayToSplit.length / chunkSize + (rest > 0 ? 1 : 0); // we may have to add an additional array for the 'rest'
        // now we know how many arrays we need and create our result array
        int[][] arrays = new int[chunks][];
        // we create our resulting arrays by copying the corresponding
        // part from the input array. If we have a rest (rest>0), then
        // the last array will have less elements than the others. This
        // needs to be handled separately, so we iterate 1 times less.
        for(int i = 0; i < (rest > 0 ? chunks - 1 : chunks); i++){
            // this copies 'chunk' times 'chunkSize' elements into a new array
            arrays[i] = Arrays.copyOfRange(arrayToSplit, i * chunkSize, i * chunkSize + chunkSize);
        }
        if(rest > 0){ // only when we have a rest
            // we copy the remaining elements into the last chunk
            arrays[chunks - 1] = Arrays.copyOfRange(arrayToSplit, (chunks - 1) * chunkSize, (chunks - 1) * chunkSize + rest);
        }
        return arrays; // that's it
    }

    public static int getIndexOfNumber(String s) {
        Pattern pattern = Pattern.compile("^\\D*(\\d)");
        Matcher matcher = pattern.matcher(s);
        matcher.find();
        return matcher.start(1);
    }

    public static String extractInt(String str) {
        str = str.replaceAll("[^0-9]", " ");
        str = str.replaceAll(" +", " ");
        if (str.equals(""))
            return "-1";
        return str;
    }
}
