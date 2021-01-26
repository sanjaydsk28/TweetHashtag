import java.util.*;

public class Hashtag {
    int count;
    String hashtag;
    public  static  HashMap<String, Integer> hashtags = new HashMap<>();

    Hashtag(String hashtag, int count) {
        this.hashtag = hashtag;
        this.count = count;
    }

    public static  HashMap<String, Integer> sortByCount(int capacity)
    {
        // list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hashtags.entrySet());

        // Sort the list
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        if (list.size() > capacity) list = list.subList(0, capacity);

        // Data from sorted list to hashmap
        HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }
        return sortedMap;
    }
}
