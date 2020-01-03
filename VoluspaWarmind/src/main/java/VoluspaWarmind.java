import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.io.*;
import java.nio.charset.Charset;

public class VoluspaWarmind {
    public static void main(String[] args) {
        tweetLines();
    }

    private static void tweetLines(){
        String line;
        try{
            try(
                InputStream fis = new FileInputStream("E:\\cherkaoui_ismail\\VoluspaWarmind\\src\\main\\resources\\anthology.txt");
                InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
                BufferedReader br = new BufferedReader(isr);
                ){
                    while((line = br.readLine()) !=null){
                        sendTweet(line);
                        System.out.println(line);
                        try{
                            Thread.sleep(60000);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }

             }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void sendTweet(String line){
        Twitter twitter= TwitterFactory.getSingleton();
        Status status;
        try{
            status = twitter.updateStatus(line);
            System.out.println(status);
        } catch (TwitterException e){
            e.printStackTrace();
        }
    }

}
