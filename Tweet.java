import java.util.*;

public class Tweet {
    String tweetTxt;
    // Capacity set to 10
    static int capacity = 10;


    Tweet(String tweet) {
        this.tweetTxt = tweet;
    }

    public  void processHashtag() {
        String hashtagStr = this.getHashtag();
        System.out.println("Extracted hashtag: " + hashtagStr);

        // Input into hashtag
        if (Hashtag.hashtags.size() == 0 || Hashtag.hashtags.get(hashtagStr) == null) {
            Hashtag.hashtags.put(hashtagStr, 1);
        } else {
            Integer count = Hashtag.hashtags.get(hashtagStr);
            Hashtag.hashtags.put(hashtagStr, count + 1);
        }
    }

    // Extracting hashtag from given text
    private String getHashtag() {
        int hashtagIndex = tweetTxt.indexOf('#');
        StringBuilder stringBuilder = new StringBuilder();

        while (++hashtagIndex < tweetTxt.length() &&  tweetTxt.charAt(hashtagIndex) != ' ') {
            stringBuilder.append(tweetTxt.charAt(hashtagIndex));
        }

        return stringBuilder.toString();
    }

    public static void printHashTags() {
        System.out.println("Below are top trending hashtags:");
        HashMap<String, Integer> finalHashTags = Hashtag.sortByCount(capacity);
        for (String name: finalHashTags.keySet()){
            String key = name.toString();
            System.out.println(key);
        }
    }

}
