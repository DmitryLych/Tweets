package com.company;

import com.company.inputOutput.InputFile;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
     int startLineTweets=Integer.parseInt(args[0]);
     int endLineTweets=Integer.parseInt(args[1]);
     int startLineSent=Integer.parseInt(args[2]);
     int endLineSent=Integer.parseInt(args[3]);
     int startLineState=Integer.parseInt(args[4]);
     int endLineState=Integer.parseInt(args[5]);
     int numberOfReport=Integer.parseInt(args[6]);
     boolean firstReport=false;
     boolean secondReport=false;
     boolean thirdReport=false;
     if(numberOfReport==1) firstReport=true;
     else if(numberOfReport==2)secondReport=true;
     else if(numberOfReport==3)thirdReport=true;
     InputFile in=new InputFile();
        try {
        in.input(startLineTweets,endLineTweets,"E:\\trends\\trends\\trends\\data\\all_tweets.txt",firstReport);
        in.input(startLineSent,endLineSent,"E:\\trends\\trends\\trends\\data\\sentiments.csv",secondReport);
        in.input(startLineState,endLineState,"E:\\trends\\trends\\trends\\data\\states.json",thirdReport);
        } catch (ParseException e) {
        e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

    }
}
