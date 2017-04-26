package com.company.inputOutput;

import com.company.stringClasses.Sentiment;
import com.company.stringClasses.State;
import com.company.stringClasses.Tweet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
    public static void outStates(List<State> states,int startLine,int endLine)
    {
        for(int i=startLine;i<startLine+endLine;i++)
        {
          State state=new State();
        state=states.get(i);
        System.out.println(state.toString());
        }
    }
    public  static void outTweets(List<Tweet> tweets)
    {
        for(int i=0;i<tweets.size();i++)
        {
            Tweet tweet=new Tweet();
            tweet=tweets.get(i);
            System.out.println(tweet.toString());
        }
    }
    public static void outSentiments(List<Sentiment> sentiments)
    {
        for(int i=0;i<sentiments.size();i++)
        {
            Sentiment sentiment=new Sentiment();
            sentiment=sentiments.get(i);
            System.out.println(sentiment.toString());
        }
    }
    public  static  void outMarkSentiments(double mark) throws IOException {
        FileWriter writer=new FileWriter("Report2.txt",true);
        writer.append("\n").append(Double.toString(mark));
        writer.flush();
    }

}
