package com.company.reports;
import com.company.interfaces.IReport;
import com.company.stringClasses.Coordinates;
import com.company.stringClasses.Sentiment;
import com.company.stringClasses.Tweet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.company.inputOutput.Output.outMarkSentiments;

/**
 * Shows an emotional evaluation of tweets
 */
public class Report2 implements IReport<List<Sentiment>> {
    public static double mark=0;
    public static void tweetsTime(List<Tweet> tweetList) throws ParseException, IOException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String startDate="2010-08-28 19:02:27";
        String endDate="2012-08-28 19:35:44";
        Date firstDate=format.parse(startDate);
        Date secondDate=format.parse(endDate);
        FileWriter writer=new FileWriter("Report2.txt",true);
        FileWriter writer1=new FileWriter("Report3.txt",true);
        for(int i=0;i<tweetList.size();i++) {
           Tweet tweets = tweetList.get(i);
            Date tweetDate = tweets.getDate();
                if (tweetDate.after(firstDate) && tweetDate.before(secondDate)) {
                    String string = tweets.getTweet();
                    Coordinates coordinates=new Coordinates();
                    coordinates=tweets.getCoordinates();
                    writer.append(string).append('\n');
                    writer1.append(coordinates.getLongitude()).append(" ").append(coordinates.getLatitude()).append('\n');
                    writer.flush();
                    writer1.flush();
                }
            }

    }
    @Override
    public void report (List<Sentiment>allSentiments) throws IOException {
        double value=0;
       BufferedReader reader=new BufferedReader(new FileReader("Report2.txt"));
        String str;
        try {
            while ((str = reader.readLine()) != null) {
                for (int i = 0; i <allSentiments.size(); i++) {
                    Sentiment sentiment=new Sentiment();
                    sentiment=allSentiments.get(i);
                    String phrase=sentiment.getPhrase();
                    if (str.contains(phrase)) {
                        value += sentiment.getMark();
                    }
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
        mark=value;
       outMarkSentiments(mark);
    }
}
