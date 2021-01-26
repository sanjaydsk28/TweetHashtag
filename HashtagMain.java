import java.util.Scanner;

public class HashtagMain {

    public static void main(String[] args) {
        char runLoop;
        do {
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter next tweet:");
            Tweet tweet = new Tweet(sc.nextLine());
            tweet.processHashtag();

            System.out.println("Enter y to continue or q to quit");
            runLoop = sc.next().charAt(0);
        } while (runLoop == 'y');

        Tweet.printHashTags();
    }
}
