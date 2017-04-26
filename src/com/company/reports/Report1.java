package com.company.reports;

import com.company.interfaces.IReport;
import com.company.stringClasses.Tweet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Shows tweets with a given hashtag
 */
public class Report1 implements IReport<List<Tweet>>{
    @Override
    public void report(List<Tweet>tweetList) throws IOException {
        String hashTag="#oomf";
        FileWriter writer=new FileWriter("Report1.txt",true);
        Tweet twet=new Tweet();
        for (int i = 0; i < tweetList.size(); i++) {
            twet=tweetList.get(i);
            String []array=twet.getTweet().split(" ");
            for(int j=0;j<array.length;j++) {
                if (array[j].equals(hashTag)) {
                    writer.append('\n').append(twet.toString());
                    writer.flush();
                    break;
                }
            }
        }
    }
}
