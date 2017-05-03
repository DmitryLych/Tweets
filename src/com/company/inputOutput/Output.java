package com.company.inputOutput;

import com.company.stringClasses.Sentiment;
import com.company.stringClasses.State;
import com.company.stringClasses.Tweet;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {
    public static void outStates(List<State> states,int startLine,int endLine) throws IOException {
        FileWriter out=new FileWriter("States.txt");
        for(int i=startLine;i<startLine+endLine;i++)
        {
          State state=new State();
        state=states.get(i);
        out.append(state.toString()+"\n");
        out.flush();
        }
        out.close();
    }
    public  static void outTweets(List<Tweet> tweets) throws IOException {
        FileWriter out=new FileWriter("Tweets.txt");
        for(int i=0;i<tweets.size();i++)
        {
            Tweet tweet=new Tweet();
            tweet=tweets.get(i);
            out.append(tweet.toString()+"\n");
            out.flush();
        }
        out.close();
    }
    public static void outSentiments(List<Sentiment> sentiments) throws IOException {
       FileWriter out=new FileWriter("Sentiments.txt");
        for(int i=0;i<sentiments.size();i++)
        {
            Sentiment sentiment=new Sentiment();
            sentiment=sentiments.get(i);
            out.append(sentiment.toString()+"\n");
            out.flush();
        }
        out.close();
    }
    public  static  void outMarkSentiments(double mark) throws IOException {
        FileWriter writer=new FileWriter("Report2.txt",true);
        writer.append("\n").append(Double.toString(mark));
        writer.flush();
    }

}
