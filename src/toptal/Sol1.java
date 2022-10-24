package toptal;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sol1 {
    public static void main(String[] args) {
        String [] T = new String[]{"test1", "test22", "test2a" , "test2b"};
        String [] R = new String[]{"OK", "sdf", "adsf" , "adf"};
        System.out.println(solution(T, R));
    }

    public static int solution(String[] T, String[] R) {
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < T.length; i++) {
            int numIndex = getIndexOfNumber(T[i]);
            String testName = T[i].substring(0, numIndex) + extractInt(T[i]);
            if(!map.containsKey(testName)){
                map.put(testName, R[i]);
            }else if(map.get(testName).equalsIgnoreCase("OK")){
                map.put(testName, R[i]);
            }
            if(map.containsKey(testName) && map.get(testName).equalsIgnoreCase("OK")){
                map.put(testName, R[i]);
            }


        }
        int passed = 0;
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            if(stringStringEntry.getValue().equalsIgnoreCase("ok")){
                passed++;
            }
        }
        return passed * 100 / map.size();
    }

    public static int getIndexOfNumber(String s){
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
