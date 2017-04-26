package com.company.inputOutput;
import com.company.MapStates;
import com.company.interfaces.IParse;
import com.company.interfaces.IReport;
import com.company.parsers.ParseSentiment;
import com.company.parsers.ParseState;
import com.company.parsers.ParseTweet;
import com.company.reports.Report1;
import com.company.reports.Report2;
import com.company.reports.Report3;
import com.company.stringClasses.Sentiment;
import com.company.stringClasses.State;
import com.company.stringClasses.Tweet;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.company.inputOutput.Output.outSentiments;
import static com.company.inputOutput.Output.outStates;
import static com.company.inputOutput.Output.outTweets;
import static com.company.reports.Report2.tweetsTime;

/**
 * Created by lych- on 21.02.2017.
 */
public class InputFile  {
    public static void input(int startLine, int endLine, String fileName,boolean numberOfReport) throws ParseException, java.text.ParseException {
        BufferedReader in;
        startLine--;
        int index1 = 0, index2 = 0;
        int a = 0;
        String s;
        String s2 = "";
        IParse<List<Tweet>> tweet = new ParseTweet();
        IParse<List<Sentiment>> sentiment = new ParseSentiment();
        IParse<List<State>> state = new ParseState();
        IReport<List<State>> stateReport=new Report3();
        IReport<List<Sentiment>> sentimentReport=new Report2();
        IReport<List<Tweet>> tweetReport=new Report1();
        try {
            in = new BufferedReader(new FileReader(fileName));
            while ((s = in.readLine()) != null) {

                if (fileName.contains("states")) {
                    List<State> states = new ArrayList<>();
                    states = state.parse(s);
                    if (states != null) {
                        outStates(states, startLine, endLine);
                        if(numberOfReport) {
                            stateReport.report(states);
                        }
                        MapStates mapStates=new MapStates(states);

                    }
                    break;
                }
                if (index1 == startLine) {
                    if (index2 < endLine) {

                        s2 += s + "\n";
                        index2++;


                    } else break;
                } else {
                    index1++;
                }
            }
            in.close();
            if (fileName.contains("all_tweets")) {
                List<Tweet> tweets = new ArrayList<>();
                tweets = tweet.parse(s2);
                if (tweets != null) {
                    outTweets(tweets);
                    if(numberOfReport) {
                        tweetReport.report(tweets);
                    }
                    tweetsTime(tweets);
                }
            }
            if (fileName.contains("sentiments")) {
                List<Sentiment> sentiments = new ArrayList<>();
                sentiments = sentiment.parse(s2);
                if (sentiments != null) {
                    outSentiments(sentiments);
                    if(numberOfReport) {
                        sentimentReport.report(sentiments);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }


    }
}
