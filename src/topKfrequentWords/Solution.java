package topKfrequentWords;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String [] args){
        String [] words = new String[]{"i","love","leetcode","i","love","coding"};
        //String [] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        System.out.println(topKFrequent(words, 4));
        System.out.println(topKFrequent2(words, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Item> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            Item item;
            if(map.containsKey(words[i])){
                item = map.get(words[i]);
                item.setFrequency(item.getFrequency() + 1);
            }else{
                item = new Item(words[i], 1);
            }
            map.put(words[i], item);
        }


        List<Item> items = new ArrayList<>(map.values());
        Collections.sort(items, Comparator.comparing(Item::getFrequency, Comparator.reverseOrder()).thenComparing(Item::getWord));

        return items.subList(0, k).stream().map(Item::getWord).collect(Collectors.toList());
    }

    public static List<String> topKFrequent2(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else{
                map.put(words[i], 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<HashMap.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                return res == 0 ? o1.getKey().compareTo(o2.getKey()) : res;
//                if (o1.getValue() < o2.getValue()){
//                    return 1;
//                }else if (o1.getValue() > o2.getValue()){
//                    return -1;
//                }else {
//                    return o1.getKey().compareTo(o2.getKey());
//                }
            }
        });

        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            pq.add(stringIntegerEntry);
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }

        return res;
    }

    public static class Item{
        private String word;
        private int frequency;

        public Item(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "word='" + word + '\'' +
                    ", frequency=" + frequency +
                    '}';
        }
    }
}
